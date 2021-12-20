package team.community.dao.Impl;


import team.community.bean.User;
import team.community.dao.UserDao;

public class UserDaoImpl implements UserDao {


    @Override
    public User getUserByAccount(String account) {
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
    public boolean delete(int[] ids) {
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
