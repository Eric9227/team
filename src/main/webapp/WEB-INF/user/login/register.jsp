<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <title>注册</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <link rel="stylesheet" href="/assets/layui/css/layui.css">
  <link rel="stylesheet" href="/assets/css/global.css">
<link id="layuicss-layer" rel="stylesheet" href="../../../assets/ZHUCE/ZHUC_files/layer.css" media="all"></head>
<body>

<div class="fly-header layui-bg-black">
  <div class="layui-container">
    <a class="fly-logo" href="file:///C:/">
      <img src="../../../assets/ZHUCE/ZHUC_files/logo.png" alt="layui">
    </a>
    <ul class="layui-nav fly-nav layui-hide-xs">
    <span class="layui-nav-bar" style="left: 56.5px; top: 55px; width: 0px; opacity: 0;"></span></ul>
    
    <ul class="layui-nav fly-nav-user">
      <li class="layui-nav-item">
        <a href="/loginPage">登入</a>
      </li>
    <span class="layui-nav-bar" style="left: 27px; top: 55px; width: 0px; opacity: 0;"></span></ul>
  </div>
</div>

<div class="layui-container fly-marginTop">
  <div class="fly-panel fly-panel-user" pad20="">
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title">
        <li class="layui-this">注册</li>
      </ul>
      <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <div class="layui-form layui-form-pane">

            <form action="/user/userAdd" method="post">
              <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">账号</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_email" name="account" required  autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">将会成为您唯一的登入名</div>
              </div>
              <div class="layui-form-item">
                <label for="L_username" class="layui-form-label" lay-verify="required" required>昵称</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_username" name="username" lay-verify="required" required autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="password" lay-verify="required" required autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
              </div>

              <%--<div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">确认密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repassPassword" required="" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>--%>

               <%--   <div class="layui-form-item">
                      <label for="L_vercode" class="layui-form-label">人类验证</label>
                      <div class="layui-input-inline">
                          <input type="text" id="L_vercode" name="vercode" required lay-verify="required" placeholder="请回答后面的问题" autocomplete="off" class="layui-input">
                      </div>
                      <div class="layui-form-mid">
                          <span style="color: #c00;">{{d.vercode}}</span>
                      </div>
                  </div>
--%>

              </div>
              <div class="layui-form-item">
                <button class="layui-btn" lay-filter="*" lay-submit="">立即注册</button>
              </div>
            </form>

          </div>
        </div>
      </div>
    </div>
  </div>

</div>



<script src="../../../assets/ZHUCE/ZHUC_files/layui.js.下载"></script>


<script>
layui.cache.page = 'user';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '../../res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '../../res/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>


<ul class="layui-fixbar"><li class="layui-icon" lay-type="bar1" style="background-color:#009688"></li><li class="layui-icon layui-fixbar-top" lay-type="top" style="background-color:#009688"></li></ul></body></html>