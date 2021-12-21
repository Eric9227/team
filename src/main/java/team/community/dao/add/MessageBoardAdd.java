package team.community.dao.add;

import team.community.bean.MessageBoard;
import team.community.util.JdbcUtil;

import java.time.LocalDateTime;

public class MessageBoardAdd {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    /**
     * 发布留言
     * @param messageBoard MessageBoard类
     * @return Boolean
     */
    public static Boolean insert(MessageBoard messageBoard){
        String sql = "insert into message(account, author_add_time, leave_word, leave_word_account, add_time ) value(?,?,?,?,?)";
        LocalDateTime nowTime = LocalDateTime.now();
        messageBoard.setAddTime(nowTime);
        return jdbcUtil.executeSql(sql, messageBoard.getAccount(),messageBoard.getAuthorAddTime(),messageBoard.getLeaveWord(),messageBoard.getLeaveWordAccount(),messageBoard.getAddTime());
    }
}
