package team.community.dao.query;

import team.community.bean.Message;
import team.community.util.JdbcUtil;

import java.util.List;

public class MyMessageByAccount {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    /**
     * 根据账号查询发布的文章
     * @param account 账号
     * @return
     */
    public static List<Message> getMessageByAccount(String account) {
        String sql = "select * from message where account = ?";
        List<Message> messages = jdbcUtil.executeQuery(sql, Message.class, account);
        return messages;
    }
}
