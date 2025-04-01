package com.mycompany.veterinaryclinicmanagementsystem.controller;

import com.mycompany.veterinaryclinicmanagementsystem.dao.AppointmentDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Appointment;
import com.mycompany.veterinaryclinicmanagementsystem.model.Owner;
import com.mycompany.veterinaryclinicmanagementsystem.service.AppointmentService;
import com.mycompany.veterinaryclinicmanagementsystem.util.DatabaseConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/appointments")
public class AppointmentController extends HttpServlet {
    private AppointmentService appointmentService;

    @Override
    public void init() throws ServletException {
        Connection connection = DatabaseConnection.getConnection();
        appointmentService = new AppointmentService(new AppointmentDAO(connection));
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Owner loggedOwner = (Owner) request.getSession().getAttribute("loggedOwner");
            if (loggedOwner == null) {
                response.sendRedirect("owner-login.jsp");
                return;
            }

            List<Appointment> appointments = appointmentService.getAppointmentsByOwnerId(loggedOwner.getId());
            request.setAttribute("appointments", appointments);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("appointments", null);
        }
        request.getRequestDispatcher("appointments.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ownerId = Integer.parseInt(request.getParameter("ownerId"));
        int petId = Integer.parseInt(request.getParameter("petId"));
        String serviceDescription = request.getParameter("serviceDescription");

        try {
            Date appointmentDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("appointmentDate"));
            Appointment appointment = new Appointment(0, ownerId, petId, appointmentDate, serviceDescription, "Scheduled");
            appointmentService.bookAppointment(appointment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("appointments");
    }
}
