<%--
  Created by IntelliJ IDEA.
  User: Dekuanzr
  Date: 2022/5/3
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <!--WEB-INF是安全目录，不允许被浏览器访问-->
    <%--${pageContext.request.contextPath}动态的获取当前的项目路径 默认采用的是Get请求--%>
    <%--获取基本数据类型的请求参数--%>
    <a HREF="${pageContext.request.contextPath}/user/simpleParam?id=1&userName=lx">
        基本数据类型
    </a>

    <%--获取对象类型的请求参数--%>
    <form action="${pageContext.request.contextPath}/user/pojoParam" method="post">
        编号：<input type="text" name="id"><br>
        用户名：<input type="text" name="userName"><br>
        <input type="submit" value="对象类型参数">
    </form>

    <%--获取数组类型的请求参数--%>
    <form action="${pageContext.request.contextPath}/user/arrayParam" method="post">
        编号：<input type="checkbox" name="ids" value="1">1<br>
        <input type="checkbox" name="ids" value="2">2<br>
        <input type="checkbox" name="ids" value="3">3<br>
        <input type="checkbox" name="ids" value="4">4<br>

        <input type="submit" value="数组类型参数">
    </form>

    <%--获取复杂类型的请求参数--%>
    <form action="${pageContext.request.contextPath}/user/queryParam" method="post">
        搜索关键字：
        <input type="text" name="keyword"><br>

        User对象
        <input type="text" name="user.id" placeholder="编号">
        <input type="text" name="user.userName" placeholder="姓名"><br>

        List集合<br>
        第一个元素
        <input type="text" name="userList[0].id" placeholder="编号">
        <input type="text" name="userList[0].userName" placeholder="姓名">
        第二个元素
        <input type="text" name="userList[1].id" placeholder="编号">
        <input type="text" name="userList[1].userName" placeholder="姓名"><br>

        Map集合<br>
        第一个元素
        <input type="text" name="userMap['u1'].id" placeholder="编号">
        <input type="text" name="userMap['u1'].userName" placeholder="姓名">
        第二个元素
        <input type="text" name="userMap['u2'].id" placeholder="编号">
        <input type="text" name="userMap['u2'].userName" placeholder="姓名"><br>
        <input type="submit" value="复杂数据类型参数">
    </form>

    <%--自定义类型转换器--%>
    <form action="${pageContext.request.contextPath}/user/converterParam" method="post">
        生日：<input type="text" name="birthday"><br>
        <input type="submit" value="自定义类型转换器">
    </form>

    <%--
        @RequestParam注解的演示
    --%>
    <a href="${pageContext.request.contextPath}/user/findByPage?pageNo=2">
        分页查询
    </a>

    <%--引入js--%>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
</body>

</html>
