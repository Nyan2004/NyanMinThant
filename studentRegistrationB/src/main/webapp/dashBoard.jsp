
<jsp:useBean id="ageDistributionList" scope="request" type="java.util.ArrayList"/>
<jsp:useBean id="totalEnrollmentCount" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="totalTeacherCount" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="totalModuleCount" scope="request" type="java.lang.Integer"/>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <title>OurDreams University</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 550px}

        /* Set gray background color and 100% height */
        .sidenav {
            background-color: #f1f1f1;
            height: 100%;
        }

        /* On small screens, set height to 'auto' for the grid */
        @media screen and (max-width: 767px) {
            .row.content {height: auto;}
        }
    </style>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<nav class="navbar navbar-inverse visible-xs">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>

    </div>
</nav>

<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-3 sidenav hidden-xs">
            <h2>OurDreams University</h2>

            <ul class="nav nav-pills nav-stacked">
                <li class="active"><button>Dashboard</button></li>
                <li> <form id="pas" action="enrollPerCourseServlet" method="post">
                    <div class="bar"><button type="submit" style="background-color: #2c3e50;">Total Students Enrolled Per Course</button></div></form></li>
                <li> <form id="pas1" action="passModuleServlet" method="post">
                    <div class="bar"><button type="submit">Total Students Pass In Each Module</button></div></form></li>
                <li> <form id="pas2" action="failModuleServlet" method="post">
                    <div class="bar"><button type="submit" style="background-color: #2c3e50;">Total Students Fail For Each Module</button></div></form></li>
                <li> <form id="pas3" action="studentLecturerServlet" method="post">
                    <div class="bar"><button type="submit">Total Students for Each Lecturer</button></div></form></li>
                <li> <form id="pas4" action="registerYearServlet" method="post">
                    <div class="bar"><button type="submit" style="background-color: #2c3e50;">Total Students Registered In each Year</button></div></form></li>
                <li> <form id="pas5" action="availCourseServlet" method="post">
                    <div class="bar"><button type="submit">Available Courses and Their Modules</button></div></form></li>
                <li> <form id="pas6" action="availModuleServlet" method="post">
                    <div class="bar"><button type="submit" style="background-color: #2c3e50;">Top 5 Most enrolled Modules and Lecturers</button></div></form></li>
                <li> <form id="pas7" action="lecturerListServlet" method="post">
                    <div class="bar"><button type="submit">Lecturers and Their Modules</button></div></form></li>
                <li> <form id="pas8" action="totalStudentServlet" method="post">
                    <div class="bar"><button type="submit" style="background-color: #2c3e50;">Total Students On Campus</button></div></form></li>
                <li> <form id="pas10" action="incomeServlet" method="post">
                    <div class="bar"><button type="submit" style="background-color: #2c3e50;">Total Income for Year 2020</button></div></form></li>

            </ul><br>
        </div>
        <br>

        <div class="col-sm-9">
            <div class="well">
                <h4>Dashboard</h4>
                <p>Welcome to OurDreams University</p>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="well">
                        <h4>Age Distribution</h4>
                        <canvas id="mAgeDistributionChart"></canvas>

                    </div>
                </div>

                <div class="col-sm-4">
                    <div class="well">
                        <h4>Students vs Cities</h4>
                        <canvas id="cityCount"></canvas>

                    </div>
                </div>

                <div class="col-sm-4">
                    <div class="well">
                        <h4>Total Modules</h4>
                        <p>${totalModuleCount}</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="well">
                        <h4>Total Teachers</h4>
                        <p>${totalTeacherCount}</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="well">
                        <h4>Total Enrollments</h4>
                        <p>${totalEnrollmentCount}</p>
                    </div>
                </div>
            </div>

        </div>



    </div>
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
                    'rgb(0,36,255)',

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
                    'rgba(0,151,255,0.5)',
                    'rgba(255,180,0,0.5)',
                    'rgba(0,252,255,0.5)',
                    'rgba(178,0,255,0.5)',
                    'rgba(0,89,12,0.5)',
                    'rgba(255,0,0,0.5)',
                    'rgba(255,94,0,0.5)',
                    // Add more colors as needed
                ],
                borderColor: [
                    'rgb(0,36,255)',
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


<div class="footer">

        <p><i>OurDreams.com<br><br>
            Author: Nyan Min Thant</i></p>

</div>
</body>
</html>
