<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="team.community.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="team.community.dao.query.UserQuery" %>
<%@ page import="java.sql.SQLOutput" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>七组的社区</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../assets/layui/css/layui.css">
    <link rel="stylesheet" href="../assets/css/global.css">
    <style>
        .layui-col-md8 {
            position: relative;
            left: 200px;
        }
    </style>
</head>
<body>

<div class="fly-header layui-bg-black">
    <div class="layui-container">
        <a class="fly-logo" href="/">
            <img src="../assets/images/logo.png" alt="layui">
        </a>

        <ul class="layui-nav fly-nav-user">
            <%
                User user = null;
                user = (User) session.getAttribute("user");
                if (user == null) {
            %>


            <!-- 未登入的状态 -->
            <li class="layui-nav-item">
                <a class="iconfont icon-touxiang layui-hide-xs" href="user/login.html"></a>
            </li>
            <li class="layui-nav-item">
                <a href="/loginPage">登入</a>
            </li>
            <li class="layui-nav-item">
                <a href="/registerPage">注册</a>
            </li>
            <%
            } else {
            %>
            <!-- 登入后的状态 -->

            <li class="layui-nav-item">
                <a class="fly-nav-avatar" href="javascript:;">
                    <cite class="layui-hide-xs"><%=user.getUsername()%>
                    </cite>

                    <%
                        if (user.getVip() > 0) {
                    %>
                    <i class="layui-badge fly-badge-vip layui-hide-xs">VIP<%=user.getVip()%>
                    </i>
                    <%
                        }
                    %>

                    <img src="<%=user.getAvatar()%>">
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="/home"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a>
                    </dd>
                    <hr style="margin: 5px 0;">
                    <dd><a style="text-align: center;" onclick="toLoginOut()">退出</a></dd>
                </dl>
            </li>
            <%
                }
            %>

        </ul>
    </div>
</div>

<div class="fly-panel fly-column">
    <div class="layui-container">
        <ul class="layui-clear">
            <li class="layui-hide-xs layui-this"><a href="/">首页</a></li>

            <!-- 用户登入后显示 -->
            <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><a href="user/index.html">我发表的贴</a></li>
            </li>
        </ul>

        <div class="fly-column-right layui-hide-xs">
<%--            <span class="fly-search"><i class="layui-icon"></i></span>--%>
            <a href="/messageAdd" class="layui-btn">发表新帖</a>
        </div>
        <div class="layui-hide-sm layui-show-xs-block"
             style="margin-top: -10px; padding-bottom: 10px; text-align: center;">
            <a href="/messageAdd" class="layui-btn">发表新帖</a>
        </div>
    </div>
</div>

<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8">


            <div class="fly-panel" style="margin-bottom: 0;">

                <div class="fly-panel-title fly-filter">
                    <a href="" class="layui-this">文章</a>
                    <span class="fly-mid"></span>

          </span>
                </div>
                <ul class="fly-list">
                    <%
                        List list = (List) request.getAttribute("messages");
                        for (int i = 0; i < list.size(); i++) {
                            Map map = (Map)list.get(i);
                            User author = UserQuery.getUserByAccount((String) map.get("account"));
                    %>

                    <li>
                        <a href="/detailPage?author=<%=author.getAccount()%>&addTime=<%=map.get("addTime")%>" class="fly-avatar">
                            <img src="<%=author.getAvatar()%>"
                                 alt="<%=map.get("account")%>">
                        </a>
                        <h2>
                            <a class="layui-badge">标题</a>
                            <a href="/detailPage?author=<%=author.getAccount()%>&addTime=<%=map.get("addTime")%>"><%=map.get("title")%></a>
                        </h2>
                        <div class="fly-list-info">
                            <a href="/detailPage?author=<%=author.getAccount()%>&addTime=<%=map.get("addTime")%>" link>
                                <cite><%=map.get("account")%></cite>
                                <%
                                    if(author.getVip()>0){
                                %>
                                <i class="layui-badge fly-badge-vip">VIP<%=author.getVip()%></i>
                                <%
                                    }
                                %>
                            </a>
                            <span><%=map.get("addTime")%></span>

                            <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> <%=map.get("reward")%></span>
                            <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> 66</span>
                        </div>
                        <div class="fly-list-badge">
                            <!--
                            <span class="layui-badge layui-bg-black">置顶</span>
                            <span class="layui-badge layui-bg-red">精帖</span>
                            -->
                        </div>
                    </li>
                    <%
                        }
                    %>


                </ul>
            </div>
        </div>
    </div>

    <script src="../assets/layui/layui.js"></script>

    <script type="text/javascript">
        function toLoginOut(){
            var result = confirm("确定要退出吗？");
            if(result){
                location.href="/toLoginOut";
            }
        }
    </script>

    <script>
        layui.cache.page = '';
        layui.cache.user = {
            username: '游客'
            , uid: -1
            , avatar: './assets/images/avatar/00.jpg'
            , experience: 83
            , sex: '男'
        };
        layui.config({
            version: "3.0.0"
            , base: './assets/mods/' //这里实际使用时，建议改成绝对路径
        }).extend({
            fly: 'index'
        }).use('fly');
    </script>


    <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cspan id='cnzz_stat_icon_30088308'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "w.cnzz.com/c.php%3Fid%3D30088308' type='text/javascript'%3E%3C/script%3E"));</script>


</div>
</body>
</html>
