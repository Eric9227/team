package team.community.dao;


import team.community.bean.User;

import java.util.List;

public interface UserDao {
    /**
     * 账户查询
     * @param account
     * @return
     */
    User getUserByAccount(String account);


    /**
     * 用户添加
     */
    boolean insert(User user);

    /**
     * 用户修改
     */
    boolean update(User user);

    /**
     * 用户删除（单条、批量）
     */
    boolean delete(int id);
    boolean delete(int[] ids);

    /**
     * 重置密码
     */
    String resetPassword(int id, String password);

    /**
     * 统计数据条数
     * @return Integer
     */
    Integer count();
}
