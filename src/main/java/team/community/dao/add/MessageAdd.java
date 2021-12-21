package team.community.dao.add;


import team.community.bean.Message;
import team.community.util.JdbcUtil;

import java.time.LocalDateTime;

/**
 * @author TAN00XU
 */
public class MessageAdd {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    /**
     * 发布文章
     * @param message message类
     * @return Boolean
     */
    public static Boolean insert(Message message){
        String sql = "insert into message(account, add_time, special_column, title, content, reward ) value(?,?,?,?,?,?)";
        LocalDateTime nowTime = LocalDateTime.now();
        message.setAddTime(nowTime);
        return jdbcUtil.executeSql(sql, message.getAccount(), message.getAddTime(), message.getSpecialColumn(), message.getTitle(), message.getContent(),message.getReward());
    }

    public static void main(String[] args) {
        Message message = new Message();
        message.setAccount("jyy");
        message.setSpecialColumn("565454");
        message.setTitle("title");
        message.setContent("内容");
        message.setReward(66);
        MessageAdd.insert(message);
    }

}
