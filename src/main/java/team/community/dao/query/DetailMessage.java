package team.community.dao.query;

import team.community.bean.Message;
import team.community.util.JdbcUtil;

import java.time.LocalDateTime;
import java.util.List;

public class DetailMessage {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    /**
     * 根据账号查询发布的文章
     * @param account
     * @return
     */
    public static List<Message> getDetailMessage(String account, LocalDateTime addTime) {
        String sql = "select * from message where account = ? and add_time = ?";
        List<Message> messages = jdbcUtil.executeQuery(sql, Message.class, account, addTime);
        return messages;
    }
}
