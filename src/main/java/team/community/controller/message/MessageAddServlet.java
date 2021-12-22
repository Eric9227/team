package team.community.controller.message;

import lombok.SneakyThrows;
import team.community.bean.Message;
import team.community.bean.User;
import team.community.controller.BaseServlet;
import team.community.dao.add.MessageAdd;

import javax.servlet.annotation.WebServlet;
import java.io.PrintWriter;

@WebServlet("/user/messageAdd")
public class MessageAddServlet extends BaseServlet {
    @SneakyThrows
    @Override
    protected void execute() {
        User user = (User) request.getSession().getAttribute("user");
        Message message = parseParameter(Message.class);
        message.setAccount(user.getAccount());
        System.out.println("文章-前台取到的数据：" + message);

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        if (MessageAdd.insert(message)) {
            System.out.println("发布成功");
            writer.println("""
                    <script>
                    alert("发布成功")
                    location.href="/index.html";
                    </script>
                    """);
        }else {
            writer.println("""
                    <script>
                    alert("发布失败")
                    location.href="/index.html";
                    </script>
                    """);
        }
//        request.getRequestDispatcher("/index.html").forward(request,response);

    }
}
