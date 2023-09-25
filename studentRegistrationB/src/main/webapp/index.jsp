<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Our Dreams University</title>
    <style><%@include file="/WEB-INF/css/signin.css"%></style>


        <meta name="viewport" content="width=device-width, initial-scale=1">





    </head>
<body>
<div class="container1">
    <div class="div1">
        <img src="uni3.png">
    </div>
    <div class="div2">
        <h2 style="color:white; font-family:Arial, Helvetica, sans-serif">OurDreams University</h2>
    </div>
    <div class="div3">
        <button id="loginButton" onclick="toggleLoginForm();">Log in</button>
    </div>
    <div class="div4">
        <button id="registerButton" onclick="toggleRegisterForm();">Register</button>
    </div>
</div>


<div class="container3">
    <img src="uni4.png">
    <div class="centered" style="animation-name: goDown;
        animation-duration: 3s;"><h2>Education is the Key for OurDreams come true...</h2>
        <form id="pas" action="userCheckServlet" method="post" style="display: none;">

            <h2>Log In</h2>

            <br><br>

            <label for="EMAIL">UserEmail</label>
            <input type="email" id="EMAIL" name="EMAIL" autocomplete="off" required autofocus><br><br>
            <br>
            <label for="PASSWORD">Password</label>
            <input type="password" id="PASSWORD" name="PASSWORD" autocomplete="off" required><br><br>
            <br><br><br><br>
            <button type="submit">Login</button>



        </form>


        <form id="reg" action="registerServlet" method="post" style="display: none;">

            <h2>Register</h2>

            <br><br>

            <label for="EMAIL">UserEmail</label>
            <input type="email" id="EMAIL2" name="EMAIL2" autocomplete="off" required autofocus><br><br>
            <br>
            <label for="PASSWORD">Password</label>
            <input type="password" id="PASSWORD2" name="PASSWORD2" autocomplete="off" required><br><br>
            <br><br><br><br>
            <button type="submit">Register</button>



        </form>        </div>
</div>

<div class="footer">
    <p>Author: NyanMinThant &copy;<br>
        <i>ourdreams.com</i></p>
</div>


</div>

<script>
    // Function to show or hide the login form
    function toggleLoginForm() {
        const loginForm = document.getElementById("pas");
        const registerForm2 = document.getElementById("reg");

        // Toggle the display property of the login form
        if (loginForm.style.display === "block") {
            loginForm.style.display = "none";
        } else {
            loginForm.style.display = "block";
        }

        if (registerForm2.style.display === "block") {
            registerForm2.style.display = "none";
        }
    }

</script>
<script>
    function toggleRegisterForm() {
        const registerForm = document.getElementById("reg");
        const loginForm2 = document.getElementById("pas");

        // Toggle the display property of the login form
        if (registerForm.style.display === "block") {
            registerForm.style.display = "none";
        } else {
            registerForm.style.display = "block";
        }

        if (loginForm2.style.display === "block") {
            loginForm2.style.display = "none";
        }


    }

</script>

<script>
    // Define a function to be executed when a click event occurs
    function handleClick(event) {
        // Check if the clicked element or its parent is the login or register button
        const target = event.target;
        const registerButton = document.getElementById("registerButton");
        const loginButton = document.getElementById("loginButton");
            const input1 = document.getElementById("EMAIL");
        const input2 = document.getElementById("EMAIL2");
        const input3 = document.getElementById("PASSWORD");
        const input4 = document.getElementById("PASSWORD2");

        if (target === registerButton || target === loginButton || target === input1 || target === input2 || target === input3 || target === input4) {
            return; // Do nothing if the click was on the buttons
        }

        // Your script code here
        const registerForm3 = document.getElementById("reg");
        const loginForm3 = document.getElementById("pas");
        registerForm3.style.display = "none";
        loginForm3.style.display = "none";
    }

    // Attach a click event listener to the document
    document.addEventListener("click", handleClick);
</script>












</body>
</html>


