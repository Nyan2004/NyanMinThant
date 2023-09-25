
<jsp:useBean id="ageDistributionList" scope="request" type="java.util.ArrayList"/>
<jsp:useBean id="totalEnrollmentCount" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="totalTeacherCount" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="totalModuleCount" scope="request" type="java.lang.Integer"/>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OurDreams University</title>


    <script src="chart.js"></script>

    <style><%@include file="/WEB-INF/css/dashboard.css"%></style>

</head>
<body>

<div class="container1">
    <div class="div1">
        <img src="uni3.png">
    </div>
    <div class="div2">
        <h2 style="color:white; font-family:Arial, Helvetica, sans-serif">OurDreams University</h2>
    </div>

    <div class="div4">
        <button id="logoutButton" onclick="logout();" style="width: 95px;text-align:center;padding: 14px 20px; ">LogOut</button>
    </div>
</div>

<div class="container2">
    <div class="div5">
        <form id="pas" action="enrollPerCourseServlet" method="post">
            <div class="bar"><button type="submit" style="background-color: #d5eeee; color:black;">Total Students Enrolled Per Course</button></div></form>
    </div>
    <div class="div6">
        <form id="pas1" action="passModuleServlet" method="post">
            <div class="bar"><button type="submit">Total Students Pass In Each Module</button></div></form>
    </div>
    <div class="div7">
        <form id="pas2" action="failModuleServlet" method="post">
            <div class="bar"><button type="submit" style="background-color: #d5eeee;color:black;">Total Students Fail For Each Module</button></div></form>
    </div>
    <div class="div8">
        <form id="pas3" action="studentLecturerServlet" method="post">
            <div class="bar"><button type="submit">Total Students for Each Lecturer</button></div></form>
    </div>
    <div class="div9">
        <form id="pas4" action="registerYearServlet" method="post">
            <div class="bar">
                <button type="submit" style="background-color: #d5eeee;color:black;width:50%; float: left;width:200px;">Total Students Registered</button>
                <input type="text" name="year" placeholder="Year" style="width:29%;height:25px;top:16px;" required>
            </div>
        </form>
    </div>
    <div class="div10">
        <form id="pas5" action="availCourseServlet" method="post">
            <div class="bar"><button type="submit">Available Courses and Their Modules</button></div></form>
    </div>
    <div class="div11">
        <form id="pas6" action="availModuleServlet" method="post">
            <div class="bar"><button type="submit" style="background-color: #d5eeee;color:black;">Top 5 Most enrolled Modules and Lecturers</button></div></form>
    </div>
    <div class="div12">
        <form id="pas7" action="lecturerListServlet" method="post">
            <div class="bar"><button type="submit">Lecturers and Their Modules</button></div></form>
    </div>
    <div class="div13">
        <form id="pas8" action="failedStudentServlet" method="post">
            <div class="bar">
                <button type="submit" style="background-color: #d5eeee;color:black;width:50%; float: left;width:200px;">Total Students Fails</button>
                <input type="text" name="year" placeholder="Year" style="width:50%;width:29%;height:25px;top:7px;" required>
            </div>
        </form>
    </div>
    <div class="div14">
        <form id="pas10" action="passedStudentServlet" method="post">
            <div class="bar">
                <button type="submit" style="width:50%; float: left;width:200px;">Total Student Passed the Examination</button>
                <input type="text" name="year" placeholder="Year" style="width:50%;width:29%;height:25px;top:14px;" required>
            </div>
        </form>
    </div>
    <div class="div15"></div>
</div>

<div class="container3">
    <div class="div16a">
        <h4>Age Distribution</h4>
        <canvas id="mAgeDistributionChart" style="z-index: 1;"></canvas>
    </div>
    <div class="div16b">
        <h4>Students vs Cities</h4>
        <canvas id="cityCount"></canvas>
    </div>
    <div class="div17"></div>

</div>

<div class="container4">
    <div class="div18">
        <h4>Total Modules</h4>
        <p>${totalModuleCount}</p>
    </div>
    <div class="div19">
        <h4>Total Teachers</h4>
        <p>${totalTeacherCount}</p>
    </div>
    <div class="div20">
        <h4>Total Enrollments</h4>
        <p>${totalEnrollmentCount}</p>
    </div>


</div>
<div class="footer">
    <p>Author: NyanMinThant &copy;<br>
        <i>ourdreams.com</i></p>
</div>
<script>
    // Extract data from the list
    const keys = [];
    const values = [];
    <c:forEach var="ageDistribution" items="${ageDistributionList}">
    keys.push('${ageDistribution.ageGroup}');
    values.push(${ageDistribution.studentCount});
    </c:forEach>
    const ctx = document.getElementById('mAgeDistributionChart').getContext('2d');
    const ageDistributionChart = new Chart(ctx, {
        type: 'pie', // Change to the desired chart type (e.g., 'bar', 'line', 'pie')
        data: {
            labels: keys,
            datasets: [{
                label: 'Age Distribution',
                data: values,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.7)',
                    'rgba(54, 162, 235, 0.7)',
                    'rgba(255, 206, 86, 0.7)',
                    // Add more colors as needed
                ],
                borderColor: [
                    '#ffffff',

                    // Add more colors as needed
                ],
                borderWidth: 1
            }]
        },
        options: {
            // Customize chart options as needed
        }
    });
</script>

<script>
    // Extract data from the list
    const keys2 = [];
    const values2 = [];
    <jsp:useBean id="myBar12" scope="request" type="java.util.List"/>
    <c:forEach var="myBarJ" items="${myBar12}">
    keys2.push('${myBarJ.city}');
    values2.push(${myBarJ.count});
    </c:forEach>
    const ctx2 = document.getElementById('cityCount').getContext('2d');
    const cityCountChart = new Chart(ctx2, {
        type: 'pie', // Change to the desired chart type (e.g., 'bar', 'line', 'pie')
        data: {
            labels: keys2,
            datasets: [{
                label: 'Students',
                data: values2,
                backgroundColor: [
                    '#b4ff00',
                    '#588974',
                    '#271e23',
                    'rgba(0,252,255,0.5)',
                    '#d9c4b1',
                    '#a77f5c',
                    '#ffc600',
                    '#c03b2c',
                    // Add more colors as needed
                ],
                borderColor: [
                    '#ffffff',
                    // Add more colors as needed
                ],
                borderWidth: 1
            }]
        },
        options: {
            // Customize chart options as needed
        }
    });
</script>
<script>
    function logout(){
        window.history.back();
    }
</script>

</body>
</html>
