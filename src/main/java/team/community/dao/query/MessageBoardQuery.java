package team.community.dao.query;

import team.community.bean.Message;
import team.community.bean.MessageBoard;
import team.community.util.JdbcUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author TAN00XU
 */
public class MessageBoardQuery {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    public static List<MessageBoard> getMessageBoard(String account, LocalDateTime authorAddTime){
        String sql = "select * from message_board where account = ? and author_add_time = ?";
        List<MessageBoard> messageBoards = jdbcUtil.executeQuery(sql, MessageBoard.class,account,authorAddTime);

        return messageBoards;
    }

    public static void main(String[] args) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        /*LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);*/
        LocalDateTime ldt = LocalDateTime.parse("2021-12-20 17:39:28",df);
//        System.out.println("LocalDateTime转成String类型的时间："+localTime);
        System.out.println("String类型的时间转成LocalDateTime："+ldt);


        System.out.println(MessageBoardQuery.getMessageBoard("tx", ldt));
    }
}
