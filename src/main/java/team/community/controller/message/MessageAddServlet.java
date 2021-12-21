package team.community.controller.message;

import team.community.bean.Message;
import team.community.controller.BaseServlet;
import team.community.dao.add.MessageAdd;

import javax.servlet.annotation.WebServlet;

@WebServlet("/user/messageAdd")
public class MessageAddServlet extends BaseServlet {
    @Override
    protected void execute() {
        Message message = parseParameter(Message.class);
        System.out.println("文章-前台取到的数据：" + message);

        Boolean isOk = MessageAdd.insert(message);
        if (isOk) {
            responseJSON("发布成功");
        }else {
            responseJSON("发布失败");
        }
    }
}
