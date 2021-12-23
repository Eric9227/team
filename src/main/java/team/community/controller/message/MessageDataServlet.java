package team.community.controller.message;


import cn.hutool.core.bean.BeanUtil;
import lombok.SneakyThrows;
import team.community.bean.Message;
import team.community.controller.BaseServlet;
import team.community.dao.query.MessageQuery;
import team.community.response.Resp;
import team.community.util.JdbcUtil;

import javax.servlet.annotation.WebServlet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 所有文章的信息
 * @author TAN00XU
 */
@WebServlet("/MessageData.json")
public class MessageDataServlet extends BaseServlet {
    JdbcUtil jdbcUtil = new JdbcUtil();

    @SneakyThrows
    @Override
    protected void execute() {



        /*List<Map> mapLimap = new ArrayList<>(messages.size());
        for (Message message : messages) {
            LocalDateTime dateTime = message.getAddTime();
            String format = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String, Object> beanToMap = BeanUtil.beanToMap(message);
            beanToMap.put("addTime",format);

            mapLimap.add(beanToMap);
        }*/
        List<Message> messages = MessageQuery.getAllMessage();

        List<Map> mapList = parseTime(messages, "addTime");
        System.out.println("查到的信息：" + mapList);

        //响应数据
        request.setAttribute("messages",mapList);

        // 请求转发
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
    }
}
