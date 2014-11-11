<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014-11-11
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="${pageContext.request.contextPath}/js/cinema/jquery-1.11.1.min.js"></script>
</head>
<body>
<script type="text/javascript">
    $(document).ready(function () {
        $.post("/app/movie/showCinemaList.do?time="+new Date().getTime(), {space : "湛江市"}, function(data){
            alert(data);
        })
    });
</script>
</body>
</html>
