package team.community.dao.query;

import team.community.bean.Message;
import team.community.util.JdbcUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author TAN00XU
 */
public class ThisMessageQuery {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    /**
     * 获取到当前选择的文章
     * @param author 作者账号
     * @param addTime 作者的发布时间
     * @return Message
     */
    public static Message getThisMessage(String author, LocalDateTime addTime) {
        String sql = "select * from message where account = ? and add_time = ?";
        List<Message> messages = jdbcUtil.executeQuery(sql, Message.class,author,addTime);
        return messages.get(0);
    }

    public static void main(String[] args) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse("2021-12-20 17:39:28",df);
        Message message = ThisMessageQuery.getThisMessage("tx", ldt);
        System.out.println(message);
    }
}
