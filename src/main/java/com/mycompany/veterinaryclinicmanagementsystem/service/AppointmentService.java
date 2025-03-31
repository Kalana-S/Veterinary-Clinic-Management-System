package com.mycompany.veterinaryclinicmanagementsystem.service;

import com.mycompany.veterinaryclinicmanagementsystem.dao.AppointmentDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Appointment;
import java.util.List;

public class AppointmentService {
    private AppointmentDAO appointmentDAO;

    public AppointmentService(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    public void bookAppointment(Appointment appointment) throws Exception {
        appointment.setStatus("Scheduled");
        appointmentDAO.addAppointment(appointment);
    }

    public List<Appointment> listAppointments() throws Exception {
        return appointmentDAO.getAppointments();
    }

    public void updateAppointmentStatus(int appointmentId, String status) throws Exception {
        appointmentDAO.updateAppointmentStatus(appointmentId, status);
    }

    public void deleteAppointment(int appointmentId) throws Exception {
        appointmentDAO.deleteAppointment(appointmentId);
    }
    
    public List<Appointment> getScheduledAppointments() throws Exception {
        return appointmentDAO.getScheduledAppointments();
    }
    
    public List<Appointment> getAppointmentsByOwnerId(int ownerId) throws Exception {
        return appointmentDAO.getAppointmentsByOwnerId(ownerId);
    }
 
}
