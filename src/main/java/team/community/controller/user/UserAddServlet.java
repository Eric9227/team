package team.community.controller.user;

import team.community.bean.User;
import team.community.controller.BaseServlet;
import team.community.dao.add.UserAdd;

import javax.servlet.annotation.WebServlet;

/**
 * @author TAN00XU
 */
@WebServlet("/user/userAdd")
public class UserAddServlet extends BaseServlet {
    @Override
    protected void execute() {
        System.out.println("经过了注册的servlet");
        User user = parseParameter(User.class);
        System.out.println("注册-前台取到的数据：" + user);

        /*Boolean isOk = */UserAdd.insert(user);
     /*   if (isOk) {
            responseJSON("注册成功");
        }else {
            responseJSON("注册失败");
        }*/

        forward("user/login/login.jsp");

    }
}
