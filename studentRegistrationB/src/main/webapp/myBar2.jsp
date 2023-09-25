
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
<h3>Pass Students for Each Module</h3>
<div class="tableFHead">
    <table>
        <thead>
        <tr>
            <th>Module Name</th>
            <th>Students Pass</th>
        </tr>
        </thead>
        <jsp:useBean id="myBar2" scope="request" type="java.util.List"/>
        <c:forEach var="myBarB" items="${myBar2}">
            <tr>
                <td>${myBarB.moduleName}</td>
                <td>${myBarB.pass}</td>
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
