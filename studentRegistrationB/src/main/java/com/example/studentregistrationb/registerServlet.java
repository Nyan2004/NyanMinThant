package com.example.studentregistrationb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.ejb.EJB;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class registerServlet extends HttpServlet {
    @EJB
    registerBean registerBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


//Get new student's information from register form
String index="index";
        String email = request.getParameter("EMAIL2");
        String password = request.getParameter("PASSWORD2");


        // Save the student to the database
        registerBean.createUser(email, password);




        // Set the studentList attribute in the request
        request.setAttribute("index", index);

        // Forward the request to the studentsList.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }
}
