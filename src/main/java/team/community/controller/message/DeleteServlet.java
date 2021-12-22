package team.community.controller.message;

import lombok.SneakyThrows;
import team.community.bean.User;
import team.community.controller.BaseServlet;
import team.community.dao.delete.MessageDelete;

import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author TAN00XU
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends BaseServlet {

    @SneakyThrows
    @Override
    protected void execute() {
        String author = request.getParameter("author");
        String addTime = request.getParameter("addTime");

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(addTime,df);

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        if(Objects.equals(author, ((User) request.getSession().getAttribute("user")).getAccount())){
            if(MessageDelete.delete(author,ldt)){
                writer.println("""
                    <script>
                    alert("删除成功")
                    location.href="/index.html";
                    </script>
                    """);
            }else {
                writer.println("""
                    <script>
                    alert("删除失败")
                    location.href="/index.html";
                    </script>
                    """);
            }


        }else {
            writer.println("""
                    <script>
                    alert("无权限删除")
                    location.href="/index.html";
                    </script>
                    """);
        }
    }
}
