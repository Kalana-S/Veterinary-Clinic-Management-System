package com.mycompany.veterinaryclinicmanagementsystem.controller;

import com.mycompany.veterinaryclinicmanagementsystem.dao.OwnerDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Owner;
import com.mycompany.veterinaryclinicmanagementsystem.service.OwnerService;
import com.mycompany.veterinaryclinicmanagementsystem.util.DatabaseConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/owners")
public class OwnerController extends HttpServlet {
    private OwnerService ownerService;

    @Override
    public void init() throws ServletException {
        Connection connection = DatabaseConnection.getConnection();
        ownerService = new OwnerService(new OwnerDAO(connection));
    }

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Owner> owners = ownerService.listOwners();
            request.setAttribute("owners", owners);
            request.getRequestDispatcher("owners.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String contactNumber = request.getParameter("contactNumber");
        String nic = request.getParameter("nic");

        Owner owner = new Owner(0, name, contactNumber, nic);
        try {
            ownerService.registerOwner(owner);
        } catch (Exception e) {
            e.printStackTrace();
        }
        doGet(request, response);
    }
   
}
