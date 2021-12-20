package team.community.controller;


import team.community.bean.Message;
import team.community.dao.select.MessageServlet;
import team.community.response.Resp;

import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet("/user/data.json")
public class MessageDataServlet extends BaseServlet {

    @Override
    protected void execute() {
/*
        //接收搜索条件 UserQuery
        UserQuery userQuery = parseParameter(UserQuery.class);

        //接收分页的数据
        Page page =parseParameter(Page.class);

        Integer count = userService.count();

        //查询数据 从业务层获取数据
        List<User> list = userService.queryList(userQuery,page);
        System.out.println("查到的data：" +list);

        //作出响应 将业务层返回的数据，封装成JSON的字符
        responseJSON(Resp.ok(0, "查询成功", list, count));*/

        List<Message> messages = MessageServlet.getAllMessage();
        System.out.println("查到的信息：" + messages);

        //响应数据
        responseJSON(Resp.ok("获取到数据", messages));
    }
}
