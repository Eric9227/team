package team.community.controller.messageBoard;

import team.community.controller.BaseServlet;
import team.community.dao.delete.MessageBoardDelete;
import team.community.dao.delete.MessageDelete;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * 留言删除
 * @author TAN00XU
 */
public class MessageDeleteServlet extends BaseServlet {
    @Override
    protected void execute() {
        String account = request.getParameter("account");
        String addTime = request.getParameter("addTime");
        String leaveWordAccount = request.getParameter("leaveWordAccount");
        String leaveAddTime = request.getParameter("leaveAddTime");

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt1 = LocalDateTime.parse(addTime,df);
        LocalDateTime ldt2 = LocalDateTime.parse(leaveAddTime,df);

        MessageBoardDelete.delete(account, ldt1, leaveWordAccount, ldt2);
    }
}
