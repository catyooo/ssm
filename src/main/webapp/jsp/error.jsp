<%@ page contentType="text/html; charset=utf-8" %>
<!doctype html>
<html>
<head>
    <title>error page</title>
    <script src="static/jquery-1-11-3-min.js"></script>
    <script src="static/layer/layer.js"></script>
</head>
<body>
<h2> ${error} </h2>

</body>
<script>
    layer.open({
        title: '在线调试'
        ,content: '可以填写任意的layer代码'
    });
</script>
</html>
