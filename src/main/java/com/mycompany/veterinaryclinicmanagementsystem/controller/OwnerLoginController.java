package com.mycompany.veterinaryclinicmanagementsystem.controller;

import com.mycompany.veterinaryclinicmanagementsystem.dao.OwnerDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Owner;
import com.mycompany.veterinaryclinicmanagementsystem.util.DatabaseConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/owner-login")
public class OwnerLoginController extends HttpServlet {
    private OwnerDAO ownerDAO;

    @Override
    public void init() throws ServletException {
        Connection connection = DatabaseConnection.getConnection();
        ownerDAO = new OwnerDAO(connection);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String nic = request.getParameter("nic");

        try {
            Owner owner = ownerDAO.getOwnerByNameAndNIC(name, nic);
            if (owner != null) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedOwner", owner);
                response.sendRedirect("owner-dashboard.jsp");
            } else {
                request.setAttribute("errorMessage", "Invalid name or NIC.");
                request.getRequestDispatcher("owner-login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("owner-login.jsp");
        }
    }
}
