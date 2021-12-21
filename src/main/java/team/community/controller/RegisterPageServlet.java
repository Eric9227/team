package team.community.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/registerPage")
public class RegisterPageServlet extends BaseServlet {
    @Override
    void execute() {
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
