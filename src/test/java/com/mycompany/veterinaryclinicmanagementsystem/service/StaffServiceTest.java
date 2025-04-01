package com.mycompany.veterinaryclinicmanagementsystem.service;

import com.mycompany.veterinaryclinicmanagementsystem.dao.StaffDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StaffServiceTest {
    
    private StaffDAO staffDAO;
    private StaffService staffService;

    @BeforeEach
    void setUp() {
        staffDAO = mock(StaffDAO.class);
        staffService = new StaffService(staffDAO);
    }

    @Test
    void registerStaff_Success() {
        Staff staff = new Staff();
        staff.setName("Dr. Smith");

        staffService.registerStaff(staff);
        verify(staffDAO, times(1)).registerStaff(staff);
    }

    @Test
    void authenticateStaff_ValidCredentials_ReturnsStaff() {
        Staff staff = new Staff();
        staff.setEmail("doctor@example.com");
        staff.setPassword("securepass");

        when(staffDAO.authenticate("doctor@example.com", "securepass")).thenReturn(staff);
        
        Staff result = staffService.authenticateStaff("doctor@example.com", "securepass");
        assertNotNull(result);
        assertEquals("doctor@example.com", result.getEmail());
    }
    
}
