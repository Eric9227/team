package team.community.dao.add;


import team.community.bean.Message;
import team.community.bean.User;
import team.community.util.JdbcUtil;

import java.time.LocalDateTime;

public class MessageAdd {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    public static Boolean insert(Message message){
        String sql = "insert into message(account, add_time, special_column, title, content, reward ) value(?,?,?,?,?,?)";
        LocalDateTime nowTime = LocalDateTime.now();
        message.setAddTime(nowTime);
        return jdbcUtil.executeSql(sql, message.getAccount(), message.getAddTime(), message.getSpecialColumn(), message.getTitle(), message.getTitle(), message.getContent(),message.getReward());
    }

    public static void main(String[] args) {

    }

}
