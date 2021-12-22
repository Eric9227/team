package team.community.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import team.community.util.StrUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 这个类是所有的servlet类的基类
 * @author TAN00XU
 */
public abstract class BaseServlet extends HttpServlet {

    public static final String POST = "post";
    public static final String GET = "get";

    //请求方式,默认post
    public static String requestType = POST;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行GET方法");
        requestType = GET;
        initObject(request,response);
        execute();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行POST方法");
        requestType = POST;
        initObject(request,response);
        execute();
    }

    protected abstract void execute();

    /**
     * 获取页面提供的数据
     * @param tClass
     * @param <T>
     * @return
     */
    protected <T> T parseParameter(Class<T> tClass){
        T object = null;
        try {
            //创建一个该类型的空对象
            //调用空的构造函数创建对象，必须提供一个无参的构造函数
            object = tClass.newInstance();
            //要求对象的属性名与页面中的表单name保持一致
            //获取到该对象中的所有的属性
            Field[] fields = tClass.getDeclaredFields();
            for (Field field : fields) {
                //获取到页面的数据
                String parameter = request.getParameter(field.getName());
                if(parameter == null || "".equals(parameter)){
                    continue;
                }
                //调用对象的set方法给对象进行赋值
                Method method = tClass.getDeclaredMethod("set" + StrUtil.getMethodName(field.getName()), field.getType());
                //instanceof判断是否为同一个类型
                if(Integer.class == field.getType()){
                    method.invoke(object, Integer.parseInt(parameter));
                    continue;
                }
                //调用该方法
                method.invoke(object, parameter);
            }
            return object;

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }


    protected List<Map> parseTime(List objectList, String... fieldName){
        List<Map> mapList = new ArrayList<>(objectList.size());
        // 将列表中对象的时间字段(具体是哪个字段)转换为字符串
        for (Object obj : objectList) {
            Class<?> objClass = obj.getClass();

            Map<String, Object> map = BeanUtil.beanToMap(obj);

            for (String field : fieldName) {
                try {
                    Method method = objClass.getDeclaredMethod("get" + StrUtil.getMethodName(field));

                    LocalDateTime dateTime = (LocalDateTime)method.invoke(obj);
                    String result = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    map.put(field,result);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            //
            mapList.add(map);

        }
        return mapList;
    }



/*

    protected List<Map> responseObject(Object obj){
        Map<String, Object> map = BeanUtil.beanToMap(obj);
        // 处理日期类型
        Class<?> aClass = obj.getClass();
        // 获取当前类的所有字段
        for (Field field : aClass.getDeclaredFields()) {
            // 找到日期类型字段
            if(field.getType() == LocalDateTime.class){
                try {
                    // 获取该字段的get方法
                    Method method = aClass.getDeclaredMethod(StrUtil.getMethodName("get" + field.getName()));
                    // 调用get方法获取到数据，并且强转成日期类型对线 日期类型 LocalDateTime
                    LocalDateTime value = (LocalDateTime)method.invoke(obj);
                    // 将日期对象格式化为字符串
                    String format = value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    // 将格式化的字符串覆盖到原字段上
                    map.put(field.getName() ,format);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;

    }
*/



    private void initObject(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }


    /**
     * 用来对AJAX进行响应
     * 将对象转换为JSON字符串，将字符串进行输出、响应
     * @param obj
     */
    protected void responseJSON(Object obj){
        response.setContentType("application/json");

        try {
            PrintWriter writer = response.getWriter();

            String jsonString = JSONObject.toJSONString(obj);

            writer.write(jsonString);

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 请求转发
     * @param htmlPath
     */
    protected void forward(String htmlPath){
        try {
            request.getRequestDispatcher("/WEB-INF/"+htmlPath).forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
