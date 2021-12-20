package team.community.dao.select;


import team.community.bean.User;
import team.community.util.JdbcUtil;

import java.util.List;

public class UserSelect {
    private JdbcUtil jdbcUtil = new JdbcUtil();

    public User getUserByAccount(String account) {
        //编写SQL
        String sql = "select * from user where account = ?";
        //执行SQL
        List<User> users = jdbcUtil.executeQuery(sql, User.class, account);
        //对结果进行处理
        if(users == null || users.size() <= 0){
            return null;
        }
        return users.get(0);
    }
}
