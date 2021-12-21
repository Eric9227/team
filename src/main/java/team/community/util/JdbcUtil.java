package team.community.util;

import team.community.annotation.FieldName;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * @author TAN00XU
 */
public class JdbcUtil {

    /**
     * 连接数据库参数
     */
    private static String driverName;
    private static String url;
    private static String userName;
    private static String password;

    /**
     * 连接数据库对象
     */
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;


    //jdbc链接数据库的步骤
    static {//静态代码块  随着类的加载而加载 并且只加载一次
        try {
            //加载到文件内容
            InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //创建解析文件的工具类
            Properties properties = new Properties();
            //使用工具类解析配置文件
            properties.load(inputStream);

            //取到值
            driverName = properties.getProperty("driverName");
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");

            //加载驱动
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("配置文件加载失败");
        }
    }

    /**
     * 获取连接
     */
    private void getConnection(){
        try {
            //通过驱动管理器获取连接
            connection= DriverManager.getConnection(url,userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接失败");
        }
    }


    /**
     * preparedStatement预编译通道
     * @param sql sql语句
     */
    private void createPreparedStatement(String sql) {
        getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("创建预编译通道失败");
        }
    }

    /**
     * preparedStatement执行sql操作（增、删、改）
     * @param sql sql语句
     * @param params Object...
     * @return boolean
     */
    public boolean executeSql(String sql, Object...params){//...可变参数，一个或多个
        createPreparedStatement(sql);
        bindParams(params);
        try {
            int i = preparedStatement.executeUpdate();
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * preparedStatement执行查询操作
     * @param sql
     * @param params
     * @return
     */
    public  <T> List<T> /*ResultSet*/ executeQuery(String sql, Class<T> typeClass, Object ... params){
        createPreparedStatement(sql);
        //绑定参数
        bindParams(params);
        try {
            resultSet = preparedStatement.executeQuery();
            return parseResultSet(resultSet, typeClass);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("预编译通道执行查询失败");
        }
        return null;
    }

    /**
     * 给preparedStatement预编译通道绑定参数
     * @param params
     */
    private void bindParams(Object[] params){
        if(params == null){
            return;
        }
        try {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            System.out.println("编译后的preparedStatement通道sql语法"+preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("绑定参数失败");
        }
    }



    /**
     * 创建statement普通通道
     */
    private void createStatement(){
        getConnection();
        //通过连接创建通道
        try {
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("创建通道失败");
        }
    }

    /**
     * statement执行sql语句（增、删、改）
     * @param sql
     * @return
     */
    public boolean executeSql(String sql) {
        createStatement();
        try {
            return statement.executeUpdate(sql)>0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("执行SQl异常");
        }
        return false;
    }


    /**
     * statement执行查询操作
     * @param sql
     * @param typeClass
     * @return
     */
    public <T> List<T> executeQuery(String sql, Class<T> typeClass) {
        createStatement();
        //获取类的名称 保证类名与数据库的表名
//        String tableName = typeClass.getSimpleName();

        //sql语句由用户去编写
        try {
            resultSet = statement.executeQuery(sql);
            return parseResultSet(resultSet, typeClass);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("执行查询语句异常");
        }finally {
            closeConnection();
        }
        //返回空列表
        return Collections.emptyList();
    }

    /**
     * 处理查询到的数据
     * @param resultSet
     * @param typeClass
     * @return
     */
    private <T> List<T> parseResultSet(ResultSet resultSet,Class<T> typeClass){
        //获取到所有的字段，获取所有的set，get方法
        Field[] fields = typeClass.getDeclaredFields();
        //数据集合
        List<T> objectList = new ArrayList<T>();
        try {
            //获取数据库中的数据
            while (resultSet.next()) {
                //单条数据
                T object = typeClass.newInstance();
                //获取一条数据
                for (Field field : fields) {
                    //获取该字段的注解
                    FieldName fieldName = field.getAnnotation(FieldName.class);
                    //判断是否有注解
                    String sqlFieldName = fieldName !=null ? fieldName.value() : field.getName();
                    Object filedValue = resultSet.getObject(sqlFieldName);

                    //将数据写入
                    Method setMethod = typeClass.getDeclaredMethod(
                            "set" + StrUtil.getMethodName(field.getName()), field.getType());
                    //调用set方法
                    setMethod.invoke(object, filedValue);
                    System.out.println(object);
                }
//                SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                objectList.add(object);
            }
        }catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("SQL执行出错");
        }
        return objectList;
    }



    /**
     * 关闭连接，以释放资源
     */
    private void closeConnection(){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int executeCount(String sql){
        createStatement();

        try {
            resultSet = statement.executeQuery(sql);

            if(resultSet.next()){
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
