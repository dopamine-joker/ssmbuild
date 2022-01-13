<%--
  Created by IntelliJ IDEA.
  User: doper
  Date: 1/8/22
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <!-- 新 Bootstrap5 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css">
    <!--  popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="https://cdn.staticfile.org/popper.js/2.9.3/umd/popper.min.js"></script>
    <!-- 最新的 Bootstrap5 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>

    <script>
        $(function () {
            $("#loginBtn").click(function () {
                $.post({
                    url: "${pageContext.request.contextPath}/user/login",
                    data: {
                        "name": $("#userName").val(),
                        "pwd": $("#password").val(),
                    },
                    success: function (data) {
                        console.log(data);
                        if(data.code === 200) {
                            $("#loginMsg").css("color", "green");
                        } else if(data.code === 400) {
                            $("#loginMsg").css("color", "red");
                        }
                        $("#loginMsg").html(data.msg);
                    },
                    error: function (err) {
                        alert("err!" + err);
                        console.log(err);
                    }
                })
            });
        });

    </script>

</head>
<body>
<h1><a href="${pageContext.request.contextPath}/book/allBook">查询所有书籍</a></h1>
<div>
    <div class="form-group">
        <label>用户名</label>
        <input type="text" class="form-control" id="userName" name="userName" placeholder="帐号" required>
    </div>
    <div class="form-group">
        <label>密码</label>
        <input type="text" class="form-control" id="password" name="userPwd" placeholder="密码" required>
    </div>
    <button class="btn btn-primary" id="loginBtn">登陆</button>
    <span id="loginMsg"></span>
</div>
</body>
</html>
