package com.mycompany.veterinaryclinicmanagementsystem.dao;

import com.mycompany.veterinaryclinicmanagementsystem.model.Appointment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    private Connection connection;

    public AppointmentDAO(Connection connection) {
        this.connection = connection;
    }

    public void addAppointment(Appointment appointment) throws Exception {
        String sql = "INSERT INTO appointments (owner_id, pet_id, appointment_date, service_description, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, appointment.getOwnerId());
            stmt.setInt(2, appointment.getPetId());
            stmt.setDate(3, new java.sql.Date(appointment.getAppointmentDate().getTime()));
            stmt.setString(4, appointment.getServiceDescription());
            stmt.setString(5, "Scheduled"); 
            stmt.executeUpdate();
        }
    }

    public List<Appointment> getAppointments() throws Exception {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments ORDER BY appointment_date DESC";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                appointments.add(new Appointment(
                        rs.getInt("id"),
                        rs.getInt("owner_id"),
                        rs.getInt("pet_id"),
                        rs.getDate("appointment_date"),
                        rs.getString("service_description"),
                        rs.getString("status")
                ));
            }
        }
        return appointments;
    }
    
    public void updateAppointmentStatus(int appointmentId, String status) throws Exception {
        String sql = "UPDATE appointments SET status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, appointmentId);
            stmt.executeUpdate();
        }
    }
    
    public void deleteAppointment(int appointmentId) throws Exception {
        String sql = "DELETE FROM appointments WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, appointmentId);
            stmt.executeUpdate();
        }
    }
    
    public List<Appointment> getScheduledAppointments() throws Exception {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE status = 'Scheduled' ORDER BY appointment_date ASC";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                appointments.add(new Appointment(
                        rs.getInt("id"),
                        rs.getInt("owner_id"),
                        rs.getInt("pet_id"),
                        rs.getDate("appointment_date"),
                        rs.getString("service_description"),
                        rs.getString("status")
                ));
            }
        }
        return appointments;
    }
    
    public List<Appointment> getAppointmentsByOwnerId(int ownerId) throws Exception {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE owner_id = ? ORDER BY appointment_date DESC";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ownerId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    appointments.add(new Appointment(
                            rs.getInt("id"),
                            rs.getInt("owner_id"),
                            rs.getInt("pet_id"),
                            rs.getDate("appointment_date"),
                            rs.getString("service_description"),
                            rs.getString("status")
                    ));
                }
            }
        }
        return appointments;
    }
   
}
