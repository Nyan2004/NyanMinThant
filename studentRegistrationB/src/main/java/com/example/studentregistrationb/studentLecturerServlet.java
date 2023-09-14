package com.example.studentregistrationb;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "studentLecturerServlet", value = "/studentLecturerServlet")
public class studentLecturerServlet extends HttpServlet {

    @EJB
    studentLecturerBean slBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        List<Map<String, String>> myBar4 = slBean.getMyBar4();

        if (!myBar4.isEmpty()) {
            // Set the studentList attribute in the request
            request.setAttribute("myBar4", myBar4);
            // Forward the request to the studentsList.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/myBar4.jsp");
            dispatcher.forward(request, response);
        } else {


            String we = "Wrong Email";

            request.setAttribute("wrongEmailStudent", we);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/wrongEmailStudent.jsp");
            dispatcher.forward(request, response);
        }
    }
    }

