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

@WebServlet(name = "enrollPerCourseServlet", value = "/enrollPerCourseServlet")
public class enrollPerCourseServlet extends HttpServlet {

    @EJB
    enrollPerCourseBean epcBean;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Map<String, String>> myBar1 = epcBean.getMyBar1();

        if (!myBar1.isEmpty()) {
            // Set the studentList attribute in the request
            request.setAttribute("myBar1", myBar1);
            // Forward the request to the studentsList.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/myBar1.jsp");
            dispatcher.forward(request, response);
        } else {


            String we = "Wrong Email";

            request.setAttribute("wrongEmailStudent", we);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/wrongEmailStudent.jsp");
            dispatcher.forward(request, response);
        }
    }

    }

