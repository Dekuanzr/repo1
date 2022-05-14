<%--
  Created by IntelliJ IDEA.
  User: Dekuanzr
  Date: 2022/5/4
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>

<%--    ajax异步交互--%>
    <button id="btn1">ajax异步交互</button>

    <script>
        $("#btn1").click(function() {

            let url='${pageContext.request.contextPath}/user/ajaxRequest';
            let data='[{"id":1,"userName":"lx"},{"id":2,"userName":"lx1"}]';

            $.ajax({
                type:'post',
                url:url,
                data:data,
                contentType:'application/json;charset=utf-8',
                success:function (resp) {
                    alert(JSON.stringify(resp))
                }
            })
        })
    </script>
</body>
</html>
