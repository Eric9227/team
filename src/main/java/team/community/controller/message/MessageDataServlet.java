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
 * @author TAN00XU
 */
@WebServlet("/MessageData.json")
public class MessageDataServlet extends BaseServlet {
    JdbcUtil jdbcUtil = new JdbcUtil();

    @SneakyThrows
    @Override
    protected void execute() {
/*

        List<Message> messages = MessageQuery.getAllMessage();
        System.out.println("查到的信息：" + messages);

        //响应数据
        responseJSON(Resp.ok("获取到数据", messages));

*/

        List<Message> messages = MessageQuery.getAllMessage();

        /*List<Map> mapLimap = new ArrayList<>(messages.size());
        for (Message message : messages) {
            LocalDateTime dateTime = message.getAddTime();
            String format = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Map<String, Object> beanToMap = BeanUtil.beanToMap(message);
            beanToMap.put("addTime",format);

            mapLimap.add(beanToMap);
        }*/
        List<Map> mapList = parseTime(messages, "addTime");
        System.out.println("查到的信息：" + mapList);

        //响应数据
        request.setAttribute("messages",mapList);

        // 请求转发
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request,response);
    }
}
