package team.community.controller;


import team.community.bean.Message;
import team.community.dao.query.MessageQuery;
import team.community.response.Resp;

import javax.servlet.annotation.WebServlet;
import java.util.List;

/**
 * @author TAN00XU
 */
@WebServlet("/MessageData.json")
public class MessageDataServlet extends BaseServlet {

    @Override
    protected void execute() {

        List<Message> messages = MessageQuery.getAllMessage();
        System.out.println("查到的信息：" + messages);

        //响应数据
        responseJSON(Resp.ok("获取到数据", messages));
    }
}
