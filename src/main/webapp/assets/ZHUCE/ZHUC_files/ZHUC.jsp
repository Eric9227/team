<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <title>注册</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <link rel="stylesheet" href="layui.css">
  <link rel="stylesheet" href="global.css">
<link id="layuicss-layer" rel="stylesheet" href="layer.css" media="all"></head>
<body>

<div class="fly-header layui-bg-black">
  <div class="layui-container">
    <a class="fly-logo" href="file:///C:/">
      <img src="logo.png" alt="layui">
    </a>
    <ul class="layui-nav fly-nav layui-hide-xs">
<%--      <li class="layui-nav-item layui-this">--%>
<%--        <a href="file:///C:/"><i class="iconfont icon-jiaoliu"></i>交流</a>--%>
<%--      </li>--%>
<%--      <li class="layui-nav-item">--%>
<%--        <a href="file:///C:/Users/yangchunjie/AppData/Local/Temp/360zip$Temp/360$6/fly-3.0/html/case/case.html"><i class="iconfont icon-iconmingxinganli"></i>案例</a>--%>
<%--      </li>--%>
<%--      <li class="layui-nav-item">--%>
<%--        <a href="http://www.layui.com/" target="_blank"><i class="iconfont icon-ui"></i>框架</a>--%>
<%--      </li>--%>
    <span class="layui-nav-bar" style="left: 56.5px; top: 55px; width: 0px; opacity: 0;"></span></ul>
    
    <ul class="layui-nav fly-nav-user">
      <li class="layui-nav-item">
        <a href="file:///C:/Users/yangchunjie/AppData/Local/Temp/360zip$Temp/360$6/fly-3.0/html/user/user/reg.html">登入</a>
      </li>
<%--      <li class="layui-nav-item layui-hide-xs">--%>
<%--        <a href="file:///C:/app/qq/" onclick="layer.msg(&#39;正在通过QQ登入&#39;, {icon:16, shade: 0.1, time:0})" title="QQ登入" class="iconfont icon-qq"></a>--%>
<%--      </li>--%>
<%--      <li class="layui-nav-item layui-hide-xs">--%>
<%--        <a href="file:///C:/app/weibo/" onclick="layer.msg(&#39;正在通过微博登入&#39;, {icon:16, shade: 0.1, time:0})" title="微博登入" class="iconfont icon-weibo"></a>--%>
<%--      </li>--%>
    <span class="layui-nav-bar" style="left: 27px; top: 55px; width: 0px; opacity: 0;"></span></ul>
  </div>
</div>

<div class="layui-container fly-marginTop">
  <div class="fly-panel fly-panel-user" pad20="">
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title">
<%--        <li><a href="file:///C:/Users/yangchunjie/AppData/Local/Temp/360zip$Temp/360$6/fly-3.0/html/user/login.html">登入</a></li>--%>
        <li class="layui-this">注册</li>
      </ul>
      <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <div class="layui-form layui-form-pane">
            <form method="post">
              <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">账号</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_email" name="email" required="" lay-verify="email" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">将会成为您唯一的登入名</div>
              </div>
              <div class="layui-form-item">
                <label for="L_username" class="layui-form-label">昵称</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_username" name="username" required="" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="pass" required="" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
              </div>
              <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">确认密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repass" required="" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>
<%--              <div class="layui-form-item">--%>
<%--                <label for="L_vercode" class="layui-form-label">人类验证</label>--%>
<%--                <div class="layui-input-inline">--%>
<%--                  <input type="text" id="L_vercode" name="vercode" required="" lay-verify="required" placeholder="请回答后面的问题" autocomplete="off" class="layui-input">--%>
<%--                </div>--%>
                <div class="layui-form-mid">
<%--                   <span style="color: #c00;">{{d.vercode}}</span>--%>
                </div>
              </div>
              <div class="layui-form-item">
                <button class="layui-btn" lay-filter="*" lay-submit="">立即注册</button>
              </div>
<%--              <div class="layui-form-item fly-form-app">--%>
<%--                <span>或者直接使用社交账号快捷注册</span>--%>
<%--                <a href="file:///C:/Users/yangchunjie/AppData/Local/Temp/360zip$Temp/360$6/fly-3.0/html/user/reg.html" onclick="layer.msg(&#39;正在通过QQ登入&#39;, {icon:16, shade: 0.1, time:0})" class="iconfont icon-qq" title="QQ登入"></a>--%>
<%--                <a href="file:///C:/Users/yangchunjie/AppData/Local/Temp/360zip$Temp/360$6/fly-3.0/html/user/reg.html" onclick="layer.msg(&#39;正在通过微博登入&#39;, {icon:16, shade: 0.1, time:0})" class="iconfont icon-weibo" title="微博登入"></a>--%>
<%--              </div>--%>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

</div>



<script src="layui.js.下载"></script>
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