package team.community.controller.messageBoard;

import cn.hutool.core.bean.BeanUtil;
import lombok.SneakyThrows;
import team.community.bean.Message;
import team.community.bean.MessageBoard;
import team.community.bean.User;
import team.community.controller.BaseServlet;
import team.community.dao.delete.MessageBoardDelete;
import team.community.dao.delete.MessageDelete;
import team.community.dao.query.MessageBoardQuery;
import team.community.dao.query.ThisMessageQuery;
import team.community.dao.query.UserQuery;

import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * 留言删除
 * @author TAN00XU
 */
@WebServlet("/messageBoardDelete")
public class MessageBoardDeleteServlet extends BaseServlet {
    @SneakyThrows
    @Override
    protected void execute() {
        //文章作者
        String author = request.getParameter("author");
        //文章发布时间
        String addTime = request.getParameter("addTime");
        //留言人的账号
        String leaveWordAccount = request.getParameter("leaveWordAccount");
        //留言的时间
        String leaveAddTime = request.getParameter("leaveAddTime");

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        //文章发布时间
        LocalDateTime ldt1 = LocalDateTime.parse(addTime,df);
        //留言的时间
        LocalDateTime ldt2 = LocalDateTime.parse(leaveAddTime,df);

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();


        //当前文章的信息
        Message thisMessage = ThisMessageQuery.getThisMessage(author, ldt1);

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
        List<MessageBoard> messageBoards = MessageBoardQuery.getMessageBoard(author, ldt1);
        //处理时间字段
        List<Map> mapList = parseTime(messageBoards, "authorAddTime","leaveAddTime");
        request.setAttribute("messageBoards",mapList);



        if(Objects.equals(author, ((User) request.getSession().getAttribute("user")).getAccount())
                || Objects.equals(leaveWordAccount,((User) request.getSession().getAttribute("user")).getAccount())){
            if(MessageBoardDelete.delete(author,ldt1,leaveWordAccount,ldt2)){
                writer.println("""
                    <script>
                    alert("删除成功")
                    """);
                writer.println("location.href='/detailPage?author="+author+"&addTime="+addTime+"'");
                writer.println("</script>");
            }else {
                writer.println("""
                    <script>
                    alert("删除失败")
                    """);
                writer.println("location.href='/detailPage?author="+author+"&addTime="+addTime+"'");
                writer.println("</script>");
            }
        }else {
            writer.println("""
                    <script>
                    alert("无权限删除")
                    """);
            writer.println("location.href='/detailPage?author="+author+"&addTime="+addTime+"'");
            writer.println("</script>");
        }


    }
}
