package com.example.studentregistrationb;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "availCourseServlet", value = "/availCourseServlet")
public class availCourseServlet extends HttpServlet {

    @EJB
    availCourseBean acBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String, String>> myBar6 = acBean.getMyBar6();

        if (!myBar6.isEmpty()) {
            // Set the studentList attribute in the request
            request.setAttribute("myBar6", myBar6);
            // Forward the request to the studentsList.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/myBar6.jsp");
            dispatcher.forward(request, response);
        } else {


            String we = "Wrong Email";

            request.setAttribute("wrongEmailStudent", we);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/wrongEmailStudent.jsp");
            dispatcher.forward(request, response);
        }
    }
    }

