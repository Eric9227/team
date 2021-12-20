package team.community.service;


import team.community.bean.User;

import java.util.List;

/**
 * @author TAN00XU
 */
public interface UserService {
    User login(String account, String password);

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
    boolean delete(Integer[] ids);

    /**
     * 重置密码
     * @param id
     * @param password
     * @return
     */
    String resetPassword(int id, String password);


    /**
     * 统计数据条数
     * @return Integer
     */
    Integer count();
}
