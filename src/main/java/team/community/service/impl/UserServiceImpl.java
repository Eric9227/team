package team.community.service.impl;


import team.community.bean.User;
import team.community.dao.select.UserSelect;
import team.community.service.UserService;
import team.community.util.JdbcUtil;

public class UserServiceImpl implements UserService {
    JdbcUtil jdbcUtil =new JdbcUtil();

    @Override
    public User login(String account, String password) {
        //验证参数是否正确
        if (account == null || "".equals(account)) {
            return null;
        }
        if (password == null || "".equals(password)) {
            return null;
        }
        //调用数据访问层获取数据或修改数据
        User user = UserSelect.getUserByAccount(account);

        if (user == null) {
            System.out.println("账号不存在");
            return null;
        }
        if (!user.getPassword().equals(password)){
            System.out.println("密码错误");
            return null;
        }
        //返回用户数据
        return user;
    }

    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(Integer[] ids) {
        return false;
    }

    @Override
    public String resetPassword(int id, String password) {
        return null;
    }

    @Override
    public Integer count() {
        return null;
    }
}
