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

@WebServlet(name = "userCheckServlet", value = "/userCheckServlet")
public class userCheckServlet extends HttpServlet {

    @EJB
    userCheckBean ucBean;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String EMAIL = request.getParameter("EMAIL");
        String PASSWORD = request.getParameter("PASSWORD");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        // Retrieve the student details
        List<Map<String, String>> dashBoard = ucBean.getUser(EMAIL,PASSWORD);




        int totalModuleCount = ucBean.getTotalModuleCount();

        int totalTeacherCount = ucBean.getTotalTeacherCount();

        int totalEnrollmentCount = ucBean.getTotalEnrollmentCount();

        List<Map<String, String>> myBar12 = ucBean.getMyBar12();

        List<Map<String, String>> ageDistributionList = ucBean.getStudentAgeDistribution();

        if (!dashBoard.isEmpty()) {
            // Set the studentList attribute in the request
            request.setAttribute("dashBoard", dashBoard);
            request.setAttribute("totalModuleCount", totalModuleCount);
            request.setAttribute("totalTeacherCount", totalTeacherCount);
            request.setAttribute("totalEnrollmentCount", totalEnrollmentCount);
            request.setAttribute("myBar12", myBar12);
            request.setAttribute("ageDistributionList", ageDistributionList);
            // Forward the request to the studentsList.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/dashBoard.jsp");
            dispatcher.forward(request, response);
        } else {


            String we = "Wrong Email";

            request.setAttribute("wrongEmailStudent", we);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/wrongEmailStudent.jsp");
            dispatcher.forward(request, response);
        }
    }
}

