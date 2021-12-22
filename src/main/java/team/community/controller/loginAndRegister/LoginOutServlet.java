package team.community.controller.loginAndRegister;

import lombok.SneakyThrows;
import team.community.controller.BaseServlet;

import javax.servlet.annotation.WebServlet;

/**
 * @author TAN00XU
 */
@WebServlet("/toLoginOut")
public class LoginOutServlet extends BaseServlet {
    @SneakyThrows
    @Override
    protected void execute() {
        System.out.println("经过清空Session的servlet");
        request.getSession().invalidate();

        response.sendRedirect("/index.html");
    }
}
