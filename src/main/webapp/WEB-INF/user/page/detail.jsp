<%@ page import="team.community.bean.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="team.community.bean.MessageBoard" %>
<%@ page import="team.community.dao.query.UserQuery" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>文章详情</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/assets/layui/css/layui.css">
  <link rel="stylesheet" href="/assets/css/global.css">
</head>

<style>
  .InputDisplay{
    display: none;
  }
</style>

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


<%
  Map thisMessage = (Map) request.getAttribute("thisMessage");
  User thisAuthor = (User) request.getAttribute("thisAuthor");
%>

<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md12 content detail">
      <div class="fly-panel detail-box">
        <h1><%=thisMessage.get("title")%></h1>
        <div class="fly-detail-info">

          <a href="/DeleteServlet?author=<%=thisAuthor.getAccount()%>&addTime=<%=thisMessage.get("addTime")%>"><span class="layui-badge layui-bg-black">删除</span></a>

          <span class="fly-list-nums">
            <a href="#comment"><i class="iconfont" title="回答">&#xe60c;</i> 66</a>
          </span>
        </div>
        <div class="detail-about">
          <a class="fly-avatar" <%--href="作者详情页"--%>>
            <img src="<%=thisAuthor.getAvatar()%>" alt="<%=thisAuthor.getUsername()%>>">
          </a>
          <div class="fly-detail-user">
            <a href="../user/home.html" class="fly-link">
              <cite><%=thisAuthor.getUsername()%></cite>
              <%
                if(thisAuthor.getVip()>0){
              %>
              <i class="layui-badge fly-badge-vip">VIP<%=thisAuthor.getVip()%></i>
              <%
                }
              %>
            </a>
            <span><%=thisMessage.get("addTime")%></span>
          </div>
          <div class="detail-hits" id="LAY_jieAdmin" data-id="123">
            <span style="padding-right: 10px; color: #FF7200">悬赏：<%=thisMessage.get("reward")%>飞吻</span>
          </div>
        </div>
        <div class="detail-body photos">
          <p>
           内容：<br>
            <%=thisMessage.get("content")%>
          </p>


        </div>
      </div>

      <div class="fly-panel detail-box" id="flyReply">
        <fieldset class="layui-elem-field layui-field-title" style="text-align: center;">
          <legend>回帖</legend>
        </fieldset>

        <%
          List list = (List) request.getAttribute("messageBoards");
          for (int i = 0; i < list.size(); i++) {
            MessageBoard messageBoard = (MessageBoard) list.get(i);
            User leaveUser = UserQuery.getUserByAccount(messageBoard.getLeaveWordAccount());
        %>

        <ul class="jieda" id="jieda" >
          <li data-id="111" class="jieda-daan">
            <a name="item-1111111111"></a>
            <div class="detail-about detail-about-reply">
              <a class="fly-avatar" href="">
                <img src="<%=leaveUser.getAvatar()%>" alt="<%=leaveUser.getUsername()%>">
              </a>

              <div class="fly-detail-user">
                <a href="" class="fly-link">
                  <cite><%=leaveUser.getUsername()%></cite>
                  <%
                    if(leaveUser.getVip()>0){
                  %>
                  <i class="layui-badge fly-badge-vip">VIP<%=leaveUser.getVip()%></i>
                  <%
                    }
                  %>
                </a>

                <%
                  if(leaveUser.getAccount().equals(thisAuthor.getAccount())){
                %>
                <span>(楼主)</span>
                <%
                  }
                %>
              </div>

              <div class="detail-hits">
                <span><%=messageBoard.getLeaveAddTime()%></span>
              </div>

<%--              <i class="iconfont icon-caina" title="最佳答案"></i>--%>
            </div>
            <div class="detail-body jieda-body photos">
              <p><%=messageBoard.getLeaveWord()%></p>
            </div>
            <div class="jieda-reply">

              <div class="jieda-admin">
                <span type="del">删除</span>
                <!-- <span class="jieda-accept" type="accept">采纳</span> -->
              </div>
            </div>
          </li>

          <!-- 无数据时 -->
          <!-- <li class="fly-none">消灭零回复</li> -->
        </ul>
        <%
          }
        %>

        <fieldset class="layui-elem-field layui-field-title" style="text-align: center;">
          <legend>发布回帖</legend>
        </fieldset>
        <div class="layui-form layui-form-pane">
          <form action="/user/messageBoardAdd" method="post">

            <input name="author" class="InputDisplay" value="<%=thisAuthor.getAccount()%>">
            <input name="authorAddTime" class="InputDisplay" value="<%=thisMessage.get("addTime")%>">
            <input name="leaveWordAccount" class="InputDisplay" value="<%=user.getAccount()%>">

            <div class="layui-form-item layui-form-text">
              <a name="comment"></a>
              <div class="layui-input-block">
                <textarea id="L_content" name="leaveWord" required lay-verify="required" placeholder="请输入内容"  class="layui-textarea fly-editor" style="height: 150px;"></textarea>
              </div>
            </div>
            <div class="layui-form-item">
              <input type="hidden" name="jid" value="123">
              <button class="layui-btn" lay-filter="*" lay-submit>提交回复</button>
            </div>
          </form>
        </div>
      </div>
    </div>

  </div>
</div>

<div class="fly-footer">
  <p>
   二班七组制作
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
  layui.cache.page = 'jie';
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
  }).use(['fly', 'face'], function(){
    var $ = layui.$
            ,fly = layui.fly;
    //如果你是采用模版自带的编辑器，你需要开启以下语句来解析。
    /*
    $('.detail-body').each(function(){
      var othis = $(this), html = othis.html();
      othis.html(fly.content(html));
    });
    */
  });
</script>


</body>
</html>