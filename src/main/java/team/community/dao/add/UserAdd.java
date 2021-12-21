package team.community.dao.add;


import team.community.bean.User;
import team.community.util.JdbcUtil;

/**
 * @author TAN00XU
 */
public class UserAdd {

    private static JdbcUtil jdbcUtil = new JdbcUtil();

    public static Boolean insert(User user){
        String sql = "insert into user(account, username, password) value(?,?,?)";

        return jdbcUtil.executeSql(sql, user.getAccount(), user.getUsername(), user.getPassword());
    }

    public static void main(String[] args) {
        User user = new User();
        user.setAccount("clq");
        user.setUsername("clqclqclq");
        user.setPassword("123456");
        UserAdd.insert(user);
    }


}
