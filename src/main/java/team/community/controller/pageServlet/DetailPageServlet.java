package team.community.controller.pageServlet;

import cn.hutool.core.bean.BeanUtil;
import team.community.bean.Message;
import team.community.bean.MessageBoard;
import team.community.bean.User;
import team.community.controller.BaseServlet;
import team.community.controller.message.MyMessageQueryServlet;
import team.community.dao.query.MessageBoardQuery;
import team.community.dao.query.ThisMessageQuery;
import team.community.dao.query.UserQuery;

import javax.servlet.annotation.WebServlet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/detailPage")
public class DetailPageServlet extends BaseServlet {
    @Override
    protected void execute() {
        String author = request.getParameter("author");
        String addTime = request.getParameter("addTime");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(addTime,dtf);

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


        forward("user/page/detail.jsp?account="+author +"&addTime="+addTime);
    }
}
