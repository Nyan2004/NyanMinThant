
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
<h3>Total Failed Students</h3>
<div class="tableFHead">
  <table>
    <thead>
    <tr>
      <th>Total Failed Students</th>

    </tr>
    </thead>
    <jsp:useBean id="myBar9" scope="request" type="java.lang.Integer"/>

    <tr>
      <td>${myBar9}</td>

    </tr>


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
