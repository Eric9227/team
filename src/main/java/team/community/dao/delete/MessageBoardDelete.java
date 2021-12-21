package team.community.dao.delete;

import team.community.util.JdbcUtil;

import java.time.LocalDateTime;

/**
 * @author TAN00XU
 */
public class MessageBoardDelete {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    public static Boolean delete(String account, LocalDateTime addTime, String leaveWordAccount, LocalDateTime leaveAddTime){
        String sql = "delete from message where account = ? and add_time =? and leave_word_account = ? and leave_add_time =?";

        return jdbcUtil.executeSql(sql, account ,addTime,leaveWordAccount,leaveAddTime);
    }
}
