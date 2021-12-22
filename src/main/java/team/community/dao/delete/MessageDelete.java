package team.community.dao.delete;


import team.community.bean.Message;
import team.community.util.JdbcUtil;

import java.time.LocalDateTime;

/**
 * @author TAN00XU
 */
public class MessageDelete {

    private static JdbcUtil jdbcUtil = new JdbcUtil();

    /**
     * 文章删除
     * @param account 作者账号
     * @param addTime 文章发布时间
     * @return Boolean
     */
    public static Boolean delete(String account, LocalDateTime addTime){
        String sql = "delete from message where account = ? and add_time =?";

        return jdbcUtil.executeSql(sql, account ,addTime);
    }

    public static void main(String[] args) {


    }
}
