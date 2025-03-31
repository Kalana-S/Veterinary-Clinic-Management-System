package com.mycompany.veterinaryclinicmanagementsystem.controller;

import com.mycompany.veterinaryclinicmanagementsystem.dao.AppointmentDAO;
import com.mycompany.veterinaryclinicmanagementsystem.dao.ResourceAllocationDAO;
import com.mycompany.veterinaryclinicmanagementsystem.dao.StaffDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Appointment;
import com.mycompany.veterinaryclinicmanagementsystem.model.ResourceAllocation;
import com.mycompany.veterinaryclinicmanagementsystem.model.Staff;
import com.mycompany.veterinaryclinicmanagementsystem.service.ResourceAllocationService;
import com.mycompany.veterinaryclinicmanagementsystem.util.DatabaseConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/resource-allocation")
public class ResourceAllocationController extends HttpServlet {
    private ResourceAllocationService resourceAllocationService;
    private AppointmentDAO appointmentDAO;
    private StaffDAO staffDAO;

    @Override
    public void init() throws ServletException {
        Connection connection = DatabaseConnection.getConnection();
        resourceAllocationService = new ResourceAllocationService(new ResourceAllocationDAO(connection));
        appointmentDAO = new AppointmentDAO(connection);
        staffDAO = new StaffDAO(connection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Appointment> scheduledAppointments = appointmentDAO.getScheduledAppointments();
            List<Staff> staffList = staffDAO.getAllStaff();
            request.setAttribute("appointments", scheduledAppointments);
            request.setAttribute("staffList", staffList);
            request.getRequestDispatcher("resource-allocation.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
            int staffId = Integer.parseInt(request.getParameter("staffId"));
            int ownerId = Integer.parseInt(request.getParameter("ownerId"));
            int petId = Integer.parseInt(request.getParameter("petId"));
            String facility = request.getParameter("facility");
            String equipment = request.getParameter("equipment");

            ResourceAllocation allocation = new ResourceAllocation(0, appointmentId, staffId, ownerId, petId, facility, equipment);
            resourceAllocationService.allocateResource(allocation);

            response.sendRedirect("resource-allocation");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
