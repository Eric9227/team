package team.community.controller.loginAndRegister;

import team.community.controller.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author TAN00XU
 */
@WebServlet("/loginPage")
public class LoginPageServlet extends BaseServlet {
    @Override
    protected void execute() {

            System.out.println("经过loginPage的servlet");
            forward("user/login/login.jsp");
//            request.getRequestDispatcher("/WEB-INF/user/login/login.jsp").forward(request,response);

    }
}
