<%--
  Created by IntelliJ IDEA.
  User: doper
  Date: 1/8/22
  Time: 7:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 新 Bootstrap5 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css">
    <!--  popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="https://cdn.staticfile.org/popper.js/2.9.3/umd/popper.min.js"></script>
    <!-- 最新的 Bootstrap5 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 col">
            <h1>
                <small>增加书籍</small>
            </h1>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/admin/book/updateBook">
        <input value="${book.bookID}" name="bookID" hidden>

        <div class="form-group">
            <label>名称</label>
            <input type="text" class="form-control" name="bookName" placeholder="请输入名称" value="${book.bookName}" required>
        </div>
        <div class="form-group">
            <label>数量</label>
            <input type="text" class="form-control" name="bookCounts" placeholder="请输入数量" value="${book.bookCounts}" required>
        </div>
        <div>
            <label>详情</label>
            <input type="text" class="form-control" name="detail" placeholder="请输入详情" value="${book.detail}">
        </div>
        <div class="justify-content-center row">
            <input class="btn btn-primary col-1" type="submit" value="submit">
        </div>
    </form>
</div>

</body>
</html>
