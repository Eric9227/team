package team.community.response;


import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class Resp {

    /**
     * 状态码
     */
    private int code;

    /**
     * 描述信息
     */
    private String msg;

    /**
     * 数据
     */
    private Object data;

    /**
     * 数据条数
     */
    private  int count;

    /**
     * 代表成功的请求
     */
    public static Resp ok(int code, String msg, Object data, int count) {
        Resp r = new Resp();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        r.setCount(count);
        return r;
    }
    public static Resp ok(String msg, Object data) {
        return ok(200, msg, data, 0);
    }
    public static Resp ok(String msg) {
        return ok(msg,null);
    }


    /**
     * 代表失败的请求
     */
    public static Resp no(int code, String msg){
        Resp r = new Resp();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
    public static Resp no(String msg){
        return no(500,msg);
    }

    //禁止用户创建该对象
    private Resp(){}

    public String toJSONString() {
        return JSONObject.toJSONString(this);
    }

}
