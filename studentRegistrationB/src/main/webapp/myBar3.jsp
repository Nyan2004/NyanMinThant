
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Enrollment Per Course</title>
    <style><%@include file="/WEB-INF/css/signin.css"%></style>
    <script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
</head>
<body>
<h2>Our Dreams University</h2>
<h3>Fail Students for Each Module</h3>
<div class="tableFHead">
    <table>
        <thead>
        <tr>
            <th>Module Name</th>
            <th>Students Fail</th>
        </tr>
        </thead>
        <jsp:useBean id="myBar3" scope="request" type="java.util.List"/>
        <c:forEach var="myBarC" items="${myBar3}">
            <tr>
                <td>${myBarC.moduleName}</td>
                <td>${myBarC.fail}</td>
            </tr>
        </c:forEach>

    </table>
</div>
<br>
<button type="submit" onClick="back();">Back</button>

<script>
    function back(){
        window.history.back();
    }
</script>
</body>
</html>
