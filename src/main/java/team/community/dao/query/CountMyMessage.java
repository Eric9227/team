package team.community.dao.query;

import team.community.util.JdbcUtil;

import java.sql.SQLException;

/**
 * 取到用户发布的文章数量
 * @author TAN00XU
 */
public class CountMyMessage {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    /**
     * 获取到用户发布的文章数量
     * @param account 用户账号
     * @return
     */
    public static int getCountMyMessage(String account) {

        try {
            int count = jdbcUtil.countMyMessage(account);
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
