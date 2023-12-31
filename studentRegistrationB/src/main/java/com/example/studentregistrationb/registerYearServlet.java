package com.example.studentregistrationb;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "registerYearServlet", value = "/registerYearServlet")
public class registerYearServlet extends HttpServlet {

    @EJB
    registerYearBean ryBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String year = request.getParameter("year");

        List<Map<String, String>> myBar5 = ryBean.getMyBar5(year);

        if (!myBar5.isEmpty()) {
            // Set the studentList attribute in the request
            request.setAttribute("myBar5", myBar5);
            // Forward the request to the studentsList.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/myBar5.jsp");
            dispatcher.forward(request, response);
        } else {
            String errorMessage = "Data is not available for this year. Please enter 2020 or 2021 or 2022.";
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/errorCode.jsp");
            dispatcher.forward(request, response);
        }
    }
    }

