package team.community.controller;

import team.community.bean.User;
import team.community.dao.add.UserAdd;

public class UserAddServlet extends BaseServlet{
    @Override
    void execute() {
        User user = parseParameter(User.class);
        System.out.println("注册-前台取到的数据：" + user);

        Boolean isOk = UserAdd.insert(user);
        if (isOk) {
            responseJSON("注册成功");
        }else {
            responseJSON("注册成功");
        }

    }
}
