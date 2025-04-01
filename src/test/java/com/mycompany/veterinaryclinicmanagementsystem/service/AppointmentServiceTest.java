package com.mycompany.veterinaryclinicmanagementsystem.service;

import com.mycompany.veterinaryclinicmanagementsystem.dao.AppointmentDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AppointmentServiceTest {
    
     private AppointmentDAO appointmentDAO;
    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        appointmentDAO = mock(AppointmentDAO.class);
        appointmentService = new AppointmentService(appointmentDAO);
    }

    @Test
    void bookAppointment_Success() throws Exception {
        Appointment appointment = new Appointment();
        appointment.setStatus("Scheduled");

        appointmentService.bookAppointment(appointment);
        verify(appointmentDAO, times(1)).addAppointment(appointment);
        assertEquals("Scheduled", appointment.getStatus());
    }

    @Test
    void listAppointments_ReturnsList() throws Exception {
        Appointment appointment1 = new Appointment();
        Appointment appointment2 = new Appointment();
        when(appointmentDAO.getAppointments()).thenReturn(Arrays.asList(appointment1, appointment2));

        List<Appointment> appointments = appointmentService.listAppointments();
        assertEquals(2, appointments.size());
    }

    @Test
    void updateAppointmentStatus_Success() throws Exception {
        int appointmentId = 1;
        String newStatus = "Completed";

        appointmentService.updateAppointmentStatus(appointmentId, newStatus);
        verify(appointmentDAO, times(1)).updateAppointmentStatus(appointmentId, newStatus);
    }

    @Test
    void deleteAppointment_Success() throws Exception {
        int appointmentId = 1;

        appointmentService.deleteAppointment(appointmentId);
        verify(appointmentDAO, times(1)).deleteAppointment(appointmentId);
    }

    @Test
    void getScheduledAppointments_ReturnsList() throws Exception {
        Appointment appointment1 = new Appointment();
        Appointment appointment2 = new Appointment();
        when(appointmentDAO.getScheduledAppointments()).thenReturn(Arrays.asList(appointment1, appointment2));

        List<Appointment> appointments = appointmentService.getScheduledAppointments();
        assertEquals(2, appointments.size());
    }

    @Test
    void getAppointmentsByOwnerId_ReturnsList() throws Exception {
        int ownerId = 1;
        Appointment appointment1 = new Appointment();
        Appointment appointment2 = new Appointment();
        when(appointmentDAO.getAppointmentsByOwnerId(ownerId)).thenReturn(Arrays.asList(appointment1, appointment2));

        List<Appointment> appointments = appointmentService.getAppointmentsByOwnerId(ownerId);
        assertEquals(2, appointments.size());
    }
    
}
