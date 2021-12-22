package team.community.controller.messageBoard;


import cn.hutool.core.bean.BeanUtil;
import lombok.SneakyThrows;
import team.community.bean.Message;
import team.community.bean.MessageBoard;
import team.community.bean.User;
import team.community.controller.BaseServlet;
import team.community.dao.add.MessageBoardAdd;
import team.community.dao.query.MessageBoardQuery;
import team.community.dao.query.ThisMessageQuery;
import team.community.dao.query.UserQuery;

import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @author TAN00XU
 */
@WebServlet("/user/messageBoardAdd")
public class MessageBoardAddServlet extends BaseServlet {
    @SneakyThrows
    @Override
    protected void execute() {
        System.out.println("经过了messageBoardAdd的servlet");

        MessageBoard messageBoard = new MessageBoard();

        String author = request.getParameter("author");
        String addTime = request.getParameter("authorAddTime");

        messageBoard.setAccount(request.getParameter("author"));

        String authorAddTime = request.getParameter("authorAddTime");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(authorAddTime,df);
        messageBoard.setAuthorAddTime(ldt);


        messageBoard.setLeaveWord(request.getParameter("leaveWord"));

        messageBoard.setLeaveWordAccount(request.getParameter("leaveWordAccount"));

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        if(MessageBoardAdd.insert(messageBoard)){
            writer.println("""
                    <script>
                    alert("发布成功")
                    """);
            writer.println("location.href='/detailPage?author="+author+"&addTime="+addTime+"'");
            writer.println("</script>");
        }else {
            writer.println("""
                    <script>
                    alert("发布失败")
                    """);
            writer.println("location.href='/detailPage?author="+author+"&addTime="+addTime+"'");
            writer.println("</script>");
        }


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
        //处理时间字段
        List<Map> mapList = parseTime(messageBoards, "authorAddTime","leaveAddTime");
        request.setAttribute("messageBoards",mapList);


//        forward("user/page/detail.jsp");
//        request.getRequestDispatcher("/WEB-INF/user/page/detail.jsp").forward(request,response);


    }
}
