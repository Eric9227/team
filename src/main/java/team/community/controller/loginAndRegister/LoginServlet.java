package team.community.controller.loginAndRegister;

import com.wf.captcha.utils.CaptchaUtil;
import team.community.bean.User;
import team.community.controller.BaseServlet;
import team.community.response.Resp;
import team.community.service.UserService;
import team.community.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;


@WebServlet("/login")
public class LoginServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void execute() {
        System.out.println("LoginServlet");
        //判断验证码是否正确
        if (!CaptchaUtil.ver(request.getParameter("code"), request)) {
            CaptchaUtil.clear(request);
            responseJSON(Resp.no("验证码不正确"));
            return;
        }
        //获取页面中提供的数据
        User params = parseParameter(User.class);
        System.out.println("页面来的数据"+params.getAccount());

        //调用业务层完成功能
        User user = userService.login(params.getAccount(), params.getPassword());
        System.out.println("用户数据：" + user);

        //根据业务层的结果，作出不同结果
        if (user == null) {
            //账号或者密码有误
            System.out.println("账号或密码有误");

            //响应
            responseJSON(Resp.no("账号或密码有误"));
        } else {
            //登录成功
            System.out.println("登录成功");

            //登录成功，储存当前用户信息到Session中
            request.getSession().setAttribute("user", user);
            //响应
            responseJSON(Resp.ok("登录成功"));
        }
    }
}
