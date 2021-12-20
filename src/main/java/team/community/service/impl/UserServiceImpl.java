package team.community.service.impl;


import team.community.bean.User;
import team.community.service.UserService;
import team.community.util.JdbcUtil;

public class UserServiceImpl implements UserService {
    JdbcUtil jdbcUtil =new JdbcUtil();

    @Override
    public User login(String account, String password) {
        return null;
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
