package team.community.controller.pageServlet;

import team.community.controller.BaseServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/detailPage")
public class DetailPageServlet extends BaseServlet {
    @Override
    protected void execute() {
        forward("user/page/detail.jsp");
    }
}
