package team.community.controller.pageServlet;

import team.community.controller.BaseServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/home")
public class HomePageServlet extends BaseServlet {
    @Override
    protected void execute() {
        forward("user/page/home.jsp");
    }
}
