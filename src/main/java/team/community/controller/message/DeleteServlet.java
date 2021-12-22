package team.community.controller.message;

import team.community.controller.BaseServlet;

import javax.servlet.annotation.WebServlet;

/**
 * @author TAN00XU
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends BaseServlet {

    @Override
    protected void execute() {
        System.out.println("作者的信息："+request.getParameter("author"));
        System.out.println("发布时间："+request.getParameter("addTime"));
      /*  if(request.getParameter("account") == session.getAttribute("user").getAccount()){
            userService.delete(request.getParameter("account"),request.getParameter("add_time"));
        }*/
    }
}
