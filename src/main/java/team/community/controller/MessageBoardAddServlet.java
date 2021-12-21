package team.community.controller;


import team.community.bean.MessageBoard;
import team.community.dao.add.MessageBoardAdd;

import javax.servlet.annotation.WebServlet;

@WebServlet("/user/messageBoardAdd")
public class MessageBoardAddServlet extends BaseServlet{
    @Override
    void execute() {
        MessageBoard messageBoard = parseParameter(MessageBoard.class);
        System.out.println("文章-前台取到的数据：" + messageBoard);

        Boolean isOk = MessageBoardAdd.insert(messageBoard);
        if (isOk) {
            responseJSON("留言成功");
        }else {
            responseJSON("留言失败");
        }

    }
}
