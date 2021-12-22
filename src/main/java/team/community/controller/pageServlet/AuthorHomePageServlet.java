package team.community.controller.pageServlet;

import team.community.controller.BaseServlet;

import javax.servlet.annotation.WebServlet;

/**
 * @author TAN00XU
 */
@WebServlet("/authorHomePage")
public class AuthorHomePageServlet extends BaseServlet {
    @Override
    protected void execute() {
        String author = request.getParameter("author");
        forward("user/page/authorHome.jsp?thisAuthor="+author);
    }
}
