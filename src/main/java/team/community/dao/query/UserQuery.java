package team.community.dao.query;


import team.community.bean.User;
import team.community.util.JdbcUtil;

import java.util.List;

public class UserQuery {
    private static JdbcUtil jdbcUtil = new JdbcUtil();

    /**
     * 根据用户名查询用户
     * @param account 账号
     * @return User对象
     */
    public static User getUserByAccount(String account) {
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

    public static void main(String[] args) {
        System.out.println(UserQuery.getUserByAccount("tx"));
    }
}
