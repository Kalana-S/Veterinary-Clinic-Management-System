package com.mycompany.veterinaryclinicmanagementsystem.service;

import com.mycompany.veterinaryclinicmanagementsystem.dao.StaffDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Staff;

public class StaffService {
    
    private StaffDAO staffDAO;

    public StaffService(StaffDAO staffDAO) {
        this.staffDAO = staffDAO;
    }

    public void registerStaff(Staff staff) {
        staffDAO.registerStaff(staff);
    }

    public Staff authenticateStaff(String email, String password) {
        return staffDAO.authenticate(email, password);
    }
    
}
