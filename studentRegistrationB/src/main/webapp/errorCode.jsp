<%--
  Created by IntelliJ IDEA.
  User: Aye Kyaw Min
  Date: 9/19/2023
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error message</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<div class="errorMessage">
<br>
<br>
<jsp:useBean id="errorMessage" scope="request" type="java.lang.String"/>
<h2>${errorMessage}</h2>
<br>
<br>
<br>
<div class="inner"><button type="submit" onClick="back();" >Back</button></div>
</div>
<script>
    function back(){

        window.history.back();
    }

</script>
</body>
</html>
