package com.example.studentregistrationb;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "passModuleServlet", value = "/passModuleServlet")
public class passModuleServlet extends HttpServlet {

    @EJB
    passModuleBean pmBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String, String>> myBar2 = pmBean.getMyBar2();

        if (!myBar2.isEmpty()) {
            // Set the studentList attribute in the request
            request.setAttribute("myBar2", myBar2);
            // Forward the request to the studentsList.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/myBar2.jsp");
            dispatcher.forward(request, response);
        } else {


            String we = "Wrong Email";

            request.setAttribute("wrongEmailStudent", we);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/wrongEmailStudent.jsp");
            dispatcher.forward(request, response);
        }
    }
    }

