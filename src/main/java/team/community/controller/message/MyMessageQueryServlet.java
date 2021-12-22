package team.community.controller.message;

import team.community.bean.Message;
import team.community.bean.User;
import team.community.controller.BaseServlet;
import team.community.dao.query.MyMessageByAccount;

import javax.servlet.annotation.WebServlet;
import java.util.List;
import java.util.Map;


/**
 * 发布的内容
 * @author TAN00XU
 */
@WebServlet("/myMessage")
public class MyMessageQueryServlet extends BaseServlet {

    @Override
    protected void execute() {
        User user = (User) request.getSession().getAttribute("user");
        List<Message> messages = MyMessageByAccount.getMessageByAccount(user.getAccount());
        List<Map> mapList = parseTime(messages, "addTime");
        System.out.println(user.getUsername() + "发布的文章：" + mapList);

        //响应数据
        request.setAttribute("MyMessages", mapList);

        forward("user/page/myMessage.jsp");

    }
}
