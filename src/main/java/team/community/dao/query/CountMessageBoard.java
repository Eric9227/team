package team.community.dao.query;

import team.community.bean.Message;
import team.community.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author TAN00XU
 */
public class CountMessageBoard {
    private static JdbcUtil jdbcUtil = new JdbcUtil();


    public static int getCountMessageBoard(String account, String addTime) {

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(addTime,df);
        try {
            int count = jdbcUtil.countMessageBoard(account,ldt);
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
