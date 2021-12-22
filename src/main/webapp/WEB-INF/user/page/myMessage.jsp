<%@ page import="team.community.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="team.community.dao.query.CountMyMessage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>用户中心</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/assets/layui/css/layui.css">
  <link rel="stylesheet" href="/assets/css/global.css">
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
          <dd><a href="/home"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
          <dd><a href="/myMessage"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>用户中心</a></dd>

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

<div class="layui-container fly-marginTop fly-user-main">
  <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
    <li class="layui-nav-item">
      <a href="/home">
        <i class="layui-icon">&#xe609;</i>
        我的主页
      </a>
    </li>
    <li class="layui-nav-item layui-this">
      <a href="index.html">
        <i class="layui-icon">&#xe612;</i>
        用户中心
      </a>
    </li>
  </ul>

  <div class="site-tree-mobile layui-hide">
    <i class="layui-icon">&#xe602;</i>
  </div>
  <div class="site-mobile-shade"></div>
  
  <div class="site-tree-mobile layui-hide">
    <i class="layui-icon">&#xe602;</i>
  </div>
  <div class="site-mobile-shade"></div>
  
  
  <div class="fly-panel fly-panel-user" pad20>

    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title" id="LAY_mine">
        <%
          int count =  CountMyMessage.getCountMyMessage(user.getAccount());
        %>
        <li data-type="mine-jie" lay-id="index" class="layui-this">我发的帖（<span><%=count%></span>）</li>
      </ul>
      <div class="layui-tab-content" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <ul class="mine-view jie-row">
            <%
              List list = (List) request.getAttribute("MyMessages");
              for (int i = 0; i < list.size(); i++) {
                Map myMessage = (Map)list.get(i);
            %>
            <li>
              <a class="jie-title" href="/detailPage?author=<%=myMessage.get("account")%>&addTime=<%=myMessage.get("addTime")%>" target="_blank"><%=myMessage.get("title")%></a>
              <i><%=myMessage.get("addTime")%></i>
            </li>
            <%
              }
            %>

          </ul>
          <div id="LAY_page"></div>
        </div>
        <div class="layui-tab-item">
          <ul class="mine-view jie-row">
            <li>
              <a class="jie-title" href="../jie/detail.html" target="_blank">基于 layui 的极简社区页面模版</a>
              <i>收藏于23小时前</i>  </li>
          </ul>
          <div id="LAY_page1"></div>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="fly-footer">
  <p>
    二班七组的社区
  </p>
</div>

<script src="/assets/layui/layui.js"></script>
<script type="text/javascript">
  function toLoginOut(){
    var result = confirm("确定要退出吗？");
    if(result){
      location.href="/toLoginOut";
    }
  }
</script>

<script>
layui.cache.page = 'user';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '/assets/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '/assets/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>

</body>
</html>