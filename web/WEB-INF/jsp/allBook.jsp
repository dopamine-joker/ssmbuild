<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>

    <script>
        $(function () {
            $("#searchBtn").click(function () {
                $.post({
                    url: "${pageContext.request.contextPath}/book/queryBook",
                    data: {"name": $("#searchInput").val()},
                    success: function (data) {
                        console.log(data);
                        var html = "";
                        for (let i = 0; i < data.length; i++) {
                            html += `
                                <tr>
                                    <td>\${data[i].bookID}</td>
                                    <td>\${data[i].bookName}</td>
                                    <td>\${data[i].bookCounts}</td>
                                    <td>\${data[i].detail}</td>
                                    <td>
                                        <a class="btn btn-info"
                                        href="/book/toUpdate?id=\${data[i].bookID}">修改</a>
                                    <a class="btn btn-danger"
                                        href="/book/deleteBook/\${data[i].bookID}">删除</a>
                                    </td>
                                </tr>
                            `;
                        }
                        $("#content").html(html);
                    },
                    error: function (err) {
                        console.log(err)
                    },
                })
            });
        });
    </script>

</head>
<body>
<div>
    <div class="row justify-content-center">
        <div class="col-9">
            <a class="btn btn-primary col-1" href="${pageContext.request.contextPath}/book/toAddBook">增加书籍</a>
            <%--        <div class="form-group">--%>
            <%--            <label for="searchInput">名称</label>--%>
            <input type="text" class="offset-8 col-2" id="searchInput" name="name" placeholder="搜索名称" required>
            <button class="float-end btn btn-info" id="searchBtn">搜索</button>
            <%--        </div>--%>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-9">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>id</th>
                    <th>书名</th>
                    <th>数量</th>
                    <th>详情</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="content">
                <c:forEach items="${list}" var="book">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                            <a class="btn btn-info"
                               href="${pageContext.request.contextPath}/book/toUpdate?id=${book.bookID}">修改</a>
                            <a class="btn btn-danger"
                               href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
