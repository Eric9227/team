package team.community.controller.loginAndRegister;

import team.community.controller.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author TAN00XU
 */
@WebServlet("/registerPage")
public class RegisterPageServlet extends BaseServlet {
    @Override
    protected void execute() {
        try {
            System.out.println("经过registerPage的servlet");
            request.getRequestDispatcher("/WEB-INF/user/login/register.jsp").forward(request,response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
