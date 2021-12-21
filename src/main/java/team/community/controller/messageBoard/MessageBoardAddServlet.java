package team.community.controller.messageBoard;


import team.community.bean.MessageBoard;
import team.community.controller.BaseServlet;
import team.community.dao.add.MessageBoardAdd;

import javax.servlet.annotation.WebServlet;

/**
 * @author TAN00XU
 */
@WebServlet("/user/messageBoardAdd")
public class MessageBoardAddServlet extends BaseServlet {
    @Override
    protected void execute() {
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
