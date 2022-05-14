<%--
  Created by IntelliJ IDEA.
  User: Dekuanzr
  Date: 2022/5/4
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        文件上传三要素
            1.表单的请求方式必须是：post
            2.表单的enctype属性是muptipart/form-data
            3.表单必须要有文件上传项
    --%>
    <form action="${pageContext.request.contextPath}/fileUpload" method="post" enctype="multipart/form-data">

        名称：<input type="text" name="userName"><br>
        文件：<input type="file" name="filePic"><br>
        <input type="submit" value="单文件上传">
    </form>

    <%--多文件上传--%>
    <form action="${pageContext.request.contextPath}/filesUpload" method="post" enctype="multipart/form-data">

        名称：<input type="text" name="userName"><br>
        文件1：<input type="file" name="filePic"><br>
        文件2：<input type="file" name="filePic"><br>
        <input type="submit" value="多文件上传">
    </form>
</body>
</html>
