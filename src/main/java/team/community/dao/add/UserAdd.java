package team.community.dao.add;

import team.community.bean.User;
import team.community.controller.BaseServlet;
import team.community.response.Resp;
import team.community.util.JdbcUtil;

import javax.servlet.annotation.WebServlet;
@WebServlet("/user/add")
public class UserAdd extends BaseServlet {
    JdbcUtil jdbcUtil = new JdbcUtil();

        @Override
        protected void execute() {
            // 接收参数
            User user = parseParameter(User.class);
            //写入数据库
            String sql = "insert into user (getAccount,password)values(?,?)";

            jdbcUtil.executeQuery(sql,User.class,user.getAccount(),user.getPassword());


        }

}
