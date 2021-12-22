package team.community.controller.messageBoard;


import team.community.bean.MessageBoard;
import team.community.controller.BaseServlet;
import team.community.dao.add.MessageBoardAdd;

import javax.servlet.annotation.WebServlet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author TAN00XU
 */
@WebServlet("/user/messageBoardAdd")
public class MessageBoardAddServlet extends BaseServlet {
    @Override
    protected void execute() {
        System.out.println("经过了messageBoardAdd的servlet");
        MessageBoard messageBoard = new MessageBoard();

        messageBoard.setAccount(request.getParameter("account"));

        String authorAddTime = request.getParameter("authorAddTime");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(authorAddTime,df);
        messageBoard.setAuthorAddTime(ldt);

        messageBoard.setLeaveWord(request.getParameter("leaveWord"));

        messageBoard.setLeaveWordAccount(request.getParameter("leaveWordAccount"));


        System.out.println("文章-前台取到的数据：" + messageBoard);

        Boolean isOk = MessageBoardAdd.insert(messageBoard);
        if (isOk) {
            responseJSON("留言成功");
        }else {
            responseJSON("留言失败");
        }

    }
}
