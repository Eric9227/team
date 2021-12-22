package team.community.controller.pageServlet;

import team.community.controller.BaseServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/messageAdd")
public class MessageAddPageServlet extends BaseServlet {
    @Override
    protected void execute() {
        forward("user/page/messageAdd.jsp");
    }
}
