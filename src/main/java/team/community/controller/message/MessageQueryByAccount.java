package team.community.controller.message;

import team.community.bean.Message;
import team.community.bean.User;
import team.community.controller.BaseServlet;
import team.community.dao.query.MessageByAccount;

import javax.servlet.annotation.WebServlet;
import java.util.List;


/**
 * 发布的内容
 * @author TAN00XU
 */
@WebServlet("/user/myMessage.json")
public class MessageQueryByAccount extends BaseServlet {

    @Override
    protected void execute() {
        User user = (User) request.getSession().getAttribute("user");
        List<Message> messages = MessageByAccount.getMessageByAccount(user.getAccount());
        responseJSON(messages);
    }

}
