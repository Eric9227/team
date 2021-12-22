<%@ page import="team.community.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>发布文章</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="../assets/layui/css/layui.css">
  <link rel="stylesheet" href="../assets/css/global.css">
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

<div class="layui-container fly-marginTop">
  <div class="fly-panel" pad20 style="padding-top: 5px;">
    <!--<div class="fly-none">没有权限</div>-->
    <div class="layui-form layui-form-pane">
      <div class="layui-tab layui-tab-brief" lay-filter="user">
        <ul class="layui-tab-title">
          <li class="layui-this">发表新帖<!-- 编辑帖子 --></li>
        </ul>
        <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
          <div class="layui-tab-item layui-show">

            <form action="/user/messageAdd" method="post">

                <div class="layui-col-md9">
                  <label for="L_title" class="layui-form-label">标题</label>
                  <div class="layui-input-block">
                    <input type="text" id="L_title" name="title" required lay-verify="required" autocomplete="off" class="layui-input">
                    <!-- <input type="hidden" name="id" value="{{d.edit.id}}"> -->
                  </div>
                </div>

              <div class="layui-form-item layui-form-text">
                <div class="layui-input-block">
                  <textarea id="L_content" name="content" required lay-verify="required" placeholder="详细描述" class="layui-textarea fly-editor" style="height: 260px;"></textarea>
                </div>
              </div>

              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">悬赏飞吻</label>
                  <div class="layui-input-inline" style="width: 190px;">
                    <select name="reward">
                      <option value="20">20</option>
                      <option value="30">30</option>
                      <option value="50">50</option>
                      <option value="60">60</option>
                      <option value="80">80</option>
                    </select>
                  </div>
                  <div class="layui-form-mid layui-word-aux">发表后无法更改飞吻</div>
                </div>
              </div>

              <div class="layui-form-item">
                <button class="layui-btn" lay-filter="*" lay-submit>立即发布</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="fly-footer">
  <p>
    七组的项目
  </p>
</div>

<script src="./assets/layui/layui.js"></script>
<script type="text/javascript">
  function toLoginOut(){
    var result = confirm("确定要退出吗？");
    if(result){
      location.href="/toLoginOut";
    }
  }
</script>

<script>
layui.config({
  version: "3.0.0"
  ,base: './assets/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>



</body>
</html>