package team.community.dao.add;

import team.community.bean.Message;
import team.community.controller.BaseServlet;
import team.community.util.StrUtil;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;


public class MessageAdd extends BaseServlet {
    public static void messageAdd(String sql){
        sql="insert into leaveWord VALUES ?";
        List<MessageAdd> messagesAdd = jdbcUtil.executeQuery(sql, MessageAdd.class);
        return messageAdd;
    }

    @Override
    protected void execute() {

    }
}
