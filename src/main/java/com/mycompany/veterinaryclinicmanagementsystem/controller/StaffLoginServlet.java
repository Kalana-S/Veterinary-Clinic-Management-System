package com.mycompany.veterinaryclinicmanagementsystem.controller;

import com.mycompany.veterinaryclinicmanagementsystem.dao.StaffDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Staff;
import com.mycompany.veterinaryclinicmanagementsystem.util.DatabaseConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/staff-login")
public class StaffLoginServlet extends HttpServlet {
    private StaffDAO staffDAO;

    @Override
    public void init() {
        Connection connection = DatabaseConnection.getConnection();
        staffDAO = new StaffDAO(connection);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Staff staff = staffDAO.authenticate(email, password);
        if (staff != null) {
            HttpSession session = request.getSession();
            session.setAttribute("staff", staff);
            response.sendRedirect("staff-dashboard.jsp");
        } else {
            response.sendRedirect("staff-login.jsp?error=Invalid credentials");
        }
    }
}

