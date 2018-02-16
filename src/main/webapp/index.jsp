<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>首页</title>
</head>
<body>
<h2>Hello World!</h2>

<form action="form_action" method="get">
    <p>First name: <input type="text" name="fname" /></p>
    <p>Last name: <input type="text" name="lname" /></p>
    <input type="submit" value="Submit" />
</form>
<br>
<h3>选择题录入</h3>
<line></line>
<form action="form_action1" method="get">
    <p>题目: <input type="text" name="title" /></p>
    <p>内容: <input type="text" name="subject" /></p>

    <%--<p>是否多选: <input type="text" name="ismult" /></p>--%>
    <p>分析: <input type="text" name="analysis" /></p>

    <input type="submit" value="Submit" />
</form>
</body>
</html>
