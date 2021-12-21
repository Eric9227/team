package team.community.controller.user;

import team.community.bean.User;
import team.community.controller.BaseServlet;
import team.community.dao.add.UserAdd;

import javax.servlet.annotation.WebServlet;

@WebServlet("/user/userAdd")
public class UserAddServlet extends BaseServlet {
    @Override
    protected void execute() {
        User user = parseParameter(User.class);
        System.out.println("注册-前台取到的数据：" + user);

        Boolean isOk = UserAdd.insert(user);
        if (isOk) {
            responseJSON("注册成功");
        }else {
            responseJSON("注册失败");
        }

    }
}
