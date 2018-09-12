<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>loginResult</title>

    <script src="../static/jquery-1-11-3-min.js"></script>
    <script src="../static/layer/layer.js"></script>

    <link href="../static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">loginResult</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <a href="../index.html">登陆成功后可进入index</a>
        </ul>
    </div>
</nav>
<div class="container">
    <% String loginResult = request.getParameter("loginResult");
    %>
    <%
        if (null != loginResult && !Objects.equals("", loginResult) && Objects.equals("0000", loginResult)) {
            out.println("<div class='alert alert-success' role='alert'>登陆成功</div>");
        } else if (null != loginResult && !Objects.equals("", loginResult) && Objects.equals("0001", loginResult)) {
            out.println("<div class='alert alert-danger' role='alert'>用户名或者密码错误</div>");
        } else {
            out.println("<div class='alert alert-danger' role='alert'>登录时出现异常</div>");
        }
    %>
</div>