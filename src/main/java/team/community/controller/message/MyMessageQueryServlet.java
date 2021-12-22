package team.community.controller.message;

import team.community.bean.Message;
import team.community.bean.User;
import team.community.controller.BaseServlet;
import team.community.dao.query.MyMessageByAccount;

import javax.servlet.annotation.WebServlet;
import java.util.List;


/**
 * 发布的内容
 * @author TAN00XU
 */
@WebServlet("/user/myMessage.json")
public class MyMessageQueryServlet extends BaseServlet {

    @Override
    protected void execute() {
        User user = (User) request.getSession().getAttribute("user");
        List<Message> messages = MyMessageByAccount.getMessageByAccount(user.getAccount());
        responseJSON(messages);
    }

}
