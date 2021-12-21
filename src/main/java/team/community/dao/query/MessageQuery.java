package team.community.dao.query;

import team.community.bean.Message;
import team.community.util.JdbcUtil;

import java.util.List;

/**
 * @author TAN00XU
 */
public class MessageQuery {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    public static List<Message> getAllMessage() {
        String sql = "select * from message";
        List<Message> messages = jdbcUtil.executeQuery(sql, Message.class);

        return messages;
    }

    public static void main(String[] args) {
        System.out.println(MessageQuery.getAllMessage());
    }
}
