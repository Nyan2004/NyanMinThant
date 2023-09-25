package com.example.studentregistrationb;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "passedStudentServlet", value = "/passedStudentServlet")
public class passedStudentServlet extends HttpServlet {
    @EJB
    passedStudentBean psBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String year = request.getParameter("year");

        int myBar11 = psBean.getMybar11(year);

        if (myBar11>=0) {
            request.setAttribute("myBar11", myBar11);
            // Forward the request to the studentsList.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/myBar11.jsp");
            dispatcher.forward(request, response);
        } else {


            String errorMessage = "Data is not available for this year. Please enter 2020 or 2021 or 2022.";
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/errorCode.jsp");
            dispatcher.forward(request, response);
        }
    }
}