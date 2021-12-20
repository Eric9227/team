package team.community.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author TAN00XU
 */
@WebServlet("/loginPage")
public class LoginPageServlet extends BaseServlet{
    @Override
    void execute() {
        try {
            System.out.println("经过loginPage的servlet");
            request.getRequestDispatcher("/WEB-INF/user/login/login.jsp").forward(request,response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
