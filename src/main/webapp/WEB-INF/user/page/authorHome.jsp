<%@ page import="team.community.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>用户主页</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/assets/layui/css/layui.css">
  <link rel="stylesheet" href="/assets/css/global.css">
</head>
<body style="margin-top: 65px;">

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


<div class="fly-home fly-panel" >
  <img src="<%=user.getAvatar()%>" alt="<%=user.getUsername()%>">
  <%
    if(user.getVip()>0){
  %>
  <i class="iconfont icon-renzheng" title="七组社区认证"></i>
  <%
    }
  %>
  <h1>
    <%=user.getUsername()%>
    <%--<i class="iconfont icon-nan"></i>
    <i class="iconfont icon-nv"></i>--%>
    <%
      if(user.getVip()>0){
    %>
    <i class="layui-badge fly-badge-vip">VIP<%=user.getVip()%></i>
    <%
      }
    %>
  </h1>



</div>


<div class="fly-footer">
  <p>
   七组的社区
  </p>
</div>

<script src="/assets/layui/layui.js"></script>
<script>
layui.cache.page = 'user';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '../../assets/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '../../assets/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>

</body>
</html>