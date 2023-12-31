
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Enrollment Per Course</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
</head>
<body>
<h2>Our Dreams University</h2>
<h3>Total Registered Students for Each Year</h3>
<div class="tableFHead">
    <table>
        <thead>
        <tr>
            <th>Academic Year</th>
            <th>Total Students</th>
        </tr>
        </thead>
        <jsp:useBean id="myBar5" scope="request" type="java.util.List"/>
        <c:forEach var="myBarE" items="${myBar5}">
            <tr>
                <td>${myBarE.academicYear}</td>
                <td>${myBarE.totalStudents}</td>
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
