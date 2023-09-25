package com.example.studentregistrationb;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "failedStudentServlet", value = "/failedStudentServlet")
public class failedStudentServlet extends HttpServlet {
    @EJB
    failedStudentBean fsBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String year = request.getParameter("year");




        int myBar9 = fsBean.getMybar9(year);

        if (myBar9>=0) {
            request.setAttribute("myBar9", myBar9);
            // Forward the request to the studentsList.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/myBar9.jsp");
            dispatcher.forward(request, response);
        } else {


            String errorMessage = "Data is not available for this year. Please enter 2020 or 2021 or 2022.";
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/errorCode.jsp");
            dispatcher.forward(request, response);
        }
    }
}