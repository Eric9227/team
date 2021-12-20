package team.community.service.impl;


import team.community.bean.User;
import team.community.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    JdbcUtil jdbcUtil =new JdbcUtil();

    /**
     * 登录验证
     * @param account
     * @param password
     * @return
     */
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
        User user = userDao.getUserByAccount(account);
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
    public boolean insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    /**
     * 执行单条删除
     * @param id int id
     * @return boolean
     */
    @Override
    public boolean delete(int id) {
        return userDao.delete(id);
    }

    /**
     * 执行多条删除
     * @param ids Integer[] ids
     * @return boolean
     */
    @Override
    public boolean delete(Integer[] ids){
        for (Integer id : ids) {
            boolean delete = userDao.delete(id);
            if (!delete) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String resetPassword(int id, String password) {
        return null;
    }

    @Override
    public List<User> queryList(UserQuery userQuery,Page page) {
        return userDao.selectList(userQuery,page);
    }

    @Override
    public Integer count() {
        return userDao.count();
    }


}
