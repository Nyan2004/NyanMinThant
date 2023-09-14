<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Our Dreams University</title>
    <style><%@include file="/WEB-INF/css/signin.css"%></style>


        <meta name="viewport" content="width=device-width, initial-scale=1">


</head>
<body>

<h1>OurDreams University</h1>

<form id="pas" action="userCheckServlet" method="post">

<h2>Log In</h2>

    <br><br>
    <div class="container">
        <label for="EMAIL">UserEmail</label>
        <input type="email" id="EMAIL" name="EMAIL" autocomplete="off" required autofocus><br><br>
<br>
        <label for="PASSWORD">Password</label>
        <input type="password" id="PASSWORD" name="PASSWORD" autocomplete="off" required><br><br>
<br><br><br><br>
        <button type="submit">Login</button>

    </div>


</form>

</body>
</html>


