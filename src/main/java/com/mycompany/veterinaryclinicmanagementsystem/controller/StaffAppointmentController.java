package com.mycompany.veterinaryclinicmanagementsystem.controller;

import com.mycompany.veterinaryclinicmanagementsystem.dao.AppointmentDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Appointment;
import com.mycompany.veterinaryclinicmanagementsystem.service.AppointmentService;
import com.mycompany.veterinaryclinicmanagementsystem.util.DatabaseConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/staff-appointments")
public class StaffAppointmentController extends HttpServlet {
    private AppointmentService appointmentService;

    @Override
    public void init() throws ServletException {
        Connection connection = DatabaseConnection.getConnection();
        appointmentService = new AppointmentService(new AppointmentDAO(connection));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Appointment> appointments = appointmentService.listAppointments();
            request.setAttribute("appointments", appointments);
            request.getRequestDispatcher("staff-appointments.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("staff-dashboard.jsp?error=Could not load appointments");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));

        try {
            if ("update".equals(action)) {
                String status = request.getParameter("status");
                appointmentService.updateAppointmentStatus(appointmentId, status);
            } else if ("delete".equals(action)) {
                appointmentService.deleteAppointment(appointmentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("staff-appointments");
    }
}
