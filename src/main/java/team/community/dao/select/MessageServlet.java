package team.community.dao.select;

import team.community.bean.Message;
import team.community.util.JdbcUtil;

import java.util.List;

public class MessageServlet {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    public static List<Message> getAllMessage() {

        String sql = "select * from message";
        List<Message> messages = jdbcUtil.executeQuery(sql, Message.class);
        return messages;
    }
}
