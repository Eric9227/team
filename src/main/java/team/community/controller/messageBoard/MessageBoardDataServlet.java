package team.community.controller.messageBoard;

import team.community.bean.MessageBoard;
import team.community.controller.BaseServlet;
import team.community.dao.query.MessageBoardQuery;
import team.community.queryData.DetailsQuery;
import team.community.response.Resp;

import javax.servlet.annotation.WebServlet;
import java.util.List;

/**
 * @author TAN00XU
 */
@WebServlet("/MessageBoardData.json")
public class MessageBoardDataServlet extends BaseServlet {
    @Override
    protected void execute() {
        DetailsQuery detailsQuery = parseParameter(DetailsQuery.class);
        System.out.println("前台取到的数据：" + detailsQuery);

        List<MessageBoard> messageBoards =
                MessageBoardQuery.getMessageBoard(detailsQuery.getAccount(), detailsQuery.getAuthorAddTime());
        System.out.println("查到的信息：" + messageBoards);
        //响应数据
        responseJSON(Resp.ok("获取到数据", messageBoards));
    }
}
