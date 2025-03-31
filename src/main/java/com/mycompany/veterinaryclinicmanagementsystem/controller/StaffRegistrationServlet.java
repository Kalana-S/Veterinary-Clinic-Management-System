package com.mycompany.veterinaryclinicmanagementsystem.controller;

import com.mycompany.veterinaryclinicmanagementsystem.dao.StaffDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Staff;
import com.mycompany.veterinaryclinicmanagementsystem.util.DatabaseConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/staff-register")
public class StaffRegistrationServlet extends HttpServlet {
    private StaffDAO staffDAO;

    @Override
    public void init() {
        Connection connection = DatabaseConnection.getConnection();
        staffDAO = new StaffDAO(connection);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Staff staff = new Staff(0, name, email, password, role);
        staffDAO.registerStaff(staff);
        response.sendRedirect("staff-register.jsp");
    }
}

