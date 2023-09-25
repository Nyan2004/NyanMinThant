
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
<h3>Total Enrollment Per Course 2022-2020</h3>
<div class="tableFHead">
    <table>
        <thead>
        <tr>
            <th>Course Id</th>
            <th>Total Enrollment</th>
        </tr>
        </thead>
        <jsp:useBean id="myBar1" scope="request" type="java.util.List"/>
        <c:forEach var="myBar" items="${myBar1}">
            <tr>
                <td>${myBar.courseId}</td>
                <td>${myBar.totalEnrollment}</td>
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
