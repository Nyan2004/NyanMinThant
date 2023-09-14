<%--
  Created by IntelliJ IDEA.
  User: Aye Kyaw Min
  Date: 13/08/2023
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Modules</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        .row {background-color: navy;}
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
</head>
<body>



<div class="container-fluid">
    <div class="row content">
        <div class="col-sm-3 sidenav hidden-xs">
            <h2>Our Dreams University</h2>
            <ul class="nav nav-pills nav-stacked">
                <li ><a href="<c:url value='http://localhost:8080/studentRegistrationB-1.0-SNAPSHOT/dashBoard.jsp'/>">dashBoard</a></li>
                <li class="active"><a href="Modules.jsp">Modules</a></li>
                <div onclick="myfun()">
                <li>href="Teachers.jsp">Teachers</li>
        </div>
                <li><a href="dashBoard.jsp">Students</a></li>
                <li><a href="index.jsp">Logout</a></li>
            </ul><br>
        </div>
        <br>

        <div class="col-sm-9">
            <div class="well">
                <h4>Modules</h4>
                <p>Total 36 Modules.</p>
            </div>
            <div class="row">
                <div class="col-sm-3">
                    <div class="well">
                        <h4>Total Students</h4>
                        <p>1 Million</p>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="well">
                        <h4>Teachers</h4>
                        <p>100 Million</p>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="well">
                        <h4>New Admission</h4>
                        <p>10 Million</p>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="well">
                        <h4>Total Earning</h4>
                        <p>30%</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="well">
                        <p>Text</p>
                        <p>Text</p>
                        <p>Text</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="well">
                        <p>Text</p>
                        <p>Text</p>
                        <p>Text</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="well">
                        <p>Text</p>
                        <p>Text</p>
                        <p>Text</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-8">
                    <div class="well">
                        <p>Text</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="well">
                        <p>Text</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    function myfun() {

            window.history.back();
            window.close();

    }
</script>
</body>
</html>
