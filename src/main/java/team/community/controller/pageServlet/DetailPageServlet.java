package team.community.controller.pageServlet;

import team.community.controller.BaseServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/detailPage")
public class DetailPageServlet extends BaseServlet {
    @Override
    protected void execute() {
        String author = request.getParameter("author");
        String addTime = request.getParameter("addTime");

        forward("user/page/detail.jsp?account="+author +"&addTime="+addTime);
    }
}
