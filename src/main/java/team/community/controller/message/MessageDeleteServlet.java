package team.community.controller.message;

import team.community.controller.BaseServlet;
import team.community.dao.delete.MessageDelete;

import javax.servlet.annotation.WebServlet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *文章删除
 * @author TAN00XU
 */
@WebServlet("/user/messageDelete")
public class MessageDeleteServlet extends BaseServlet {
    @Override
    protected void execute() {
        String account = request.getParameter("account");
        String addTime = request.getParameter("addTime");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(addTime,df);
        MessageDelete.delete(account, ldt);

    }
}
