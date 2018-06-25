<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页</title>
</head>
<body>
<h2>Hello World!</h2>
登录
<form action="/shiro/shirologin" method="post">
    <p>用户名: <input type="text" name="username" /></p>
    <p>密码: <input type="password" name="password" /></p>
    <input type="submit" value="Submit" />
</form>
<br>
<h3>选择题录入</h3>
<line></line>

<li><a href="/shiro/form_action">form_action</a></li>
<li><a href="/shiro/returnString">returnString</a></li>
<li><a href="/shiro/form_action1">form_action1</a></li>

</body>
</html>
