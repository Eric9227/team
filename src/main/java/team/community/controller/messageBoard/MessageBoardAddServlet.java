package team.community.controller.messageBoard;


import cn.hutool.core.bean.BeanUtil;
import team.community.bean.Message;
import team.community.bean.MessageBoard;
import team.community.bean.User;
import team.community.controller.BaseServlet;
import team.community.dao.add.MessageBoardAdd;
import team.community.dao.query.MessageBoardQuery;
import team.community.dao.query.ThisMessageQuery;
import team.community.dao.query.UserQuery;

import javax.servlet.annotation.WebServlet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @author TAN00XU
 */
@WebServlet("/user/messageBoardAdd")
public class MessageBoardAddServlet extends BaseServlet {
    @Override
    protected void execute() {
        System.out.println("经过了messageBoardAdd的servlet");


        System.out.println("作者："+request.getParameter("author"));
        System.out.println("发布时间："+request.getParameter("authorAddTime"));
        System.out.println("留言："+request.getParameter("leaveWord"));

        System.out.println("留言者："+request.getParameter("leaveWordAccount"));



        MessageBoard messageBoard = new MessageBoard();

        String author = request.getParameter("author");
        String addTime = request.getParameter("authorAddTime");

        messageBoard.setAccount(request.getParameter("author"));

        String authorAddTime = request.getParameter("authorAddTime");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(authorAddTime,df);
        System.out.println("处理后的时间："+ldt);
        messageBoard.setAuthorAddTime(ldt);


        messageBoard.setLeaveWord(request.getParameter("leaveWord"));

        messageBoard.setLeaveWordAccount(request.getParameter("leaveWordAccount"));

        System.out.println("留言-前台取到的数据：" + messageBoard);

        /*Boolean isOk = */MessageBoardAdd.insert(messageBoard);
        /*if (isOk) {
            responseJSON("留言成功");
        }else {
            responseJSON("留言失败");
        }*/


        //当前文章的信息
        Message thisMessage = ThisMessageQuery.getThisMessage(author, ldt);

        //对时间进行处理
        LocalDateTime dateTime = thisMessage.getAddTime();
        String format = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = BeanUtil.beanToMap(thisMessage);
        map.put("addTime",format);

        request.setAttribute("thisMessage",map);

        //作者信息
        User thisAuthor = UserQuery.getUserByAccount(author);
        request.setAttribute("thisAuthor",thisAuthor);

        //当前文章的留言信息
        List<MessageBoard> messageBoards = MessageBoardQuery.getMessageBoard(author, ldt);
        request.setAttribute("messageBoards",messageBoards);


        forward("user/page/detail.jsp");


    }
}
