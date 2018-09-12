<%@ page contentType="text/html; charset=utf-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>regResult</title>

    <script src="../static/jquery-1-11-3-min.js"></script>
    <script src="../static/layer/layer.js"></script>

    <link href="../static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" >regResult</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <a href="<%=request.getContextPath()%>/jsp/login.jsp">login</a>
        </ul>
    </div>
</nav>
<div class="container">
    <% String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
    %>
    <%
        if (password.equals(password2)) {
            out.println("<div class='alert alert-success' role='alert'>注册成功</div>");
            out.println("<ul class='list-group'>");
            out.println("<li class='list-group-item'>用户名：" + loginName + "</li>");
            out.println("<li class='list-group-item'>密码：" + password + "</li>");
            out.println("</ul>");
        } else {
            out.println("<div class='alert alert-danger' role='alert'>两次密码输入不一致，请重新输入</div>");
        }
    %>
    <!-- <%=loginName %>
    <%=password %>
    <%=password2 %> -->
</div>