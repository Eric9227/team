package team.community.dao.delete;

import team.community.util.JdbcUtil;

import java.time.LocalDateTime;

/**
 * 留言删除
 * @author TAN00XU
 */
public class MessageBoardDelete {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    /**
     * 留言删除
     * @param account 文章作者
     * @param AuthorAddTime 文章发布时间
     * @param leaveWordAccount 留言人的账号
     * @param leaveAddTime 留言的时间
     * @return Boolean
     */
    public static Boolean delete(String account, LocalDateTime AuthorAddTime, String leaveWordAccount, LocalDateTime leaveAddTime){
        String sql = "delete from message_board where account = ? and author_add_time =? and leave_word_account = ? and leave_add_time =?";

        return jdbcUtil.executeSql(sql, account ,AuthorAddTime,leaveWordAccount,leaveAddTime);
    }
}
