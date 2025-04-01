package com.mycompany.veterinaryclinicmanagementsystem.controller;

import com.mycompany.veterinaryclinicmanagementsystem.dao.ResourceAllocationDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.MedicalRecord;
import com.mycompany.veterinaryclinicmanagementsystem.model.ResourceAllocation;
import com.mycompany.veterinaryclinicmanagementsystem.service.MedicalRecordService;
import com.mycompany.veterinaryclinicmanagementsystem.util.DatabaseConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

@WebServlet("/MedicalRecordController")
public class MedicalRecordController extends HttpServlet {
    
    private ResourceAllocationDAO resourceAllocationDAO;
    
    @Override
    public void init() throws ServletException {
        try {
            Connection connection = DatabaseConnection.getConnection();
            resourceAllocationDAO = new ResourceAllocationDAO(connection);
        } catch (Exception e) {
            throw new ServletException("Database connection error", e);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection connection = DatabaseConnection.getConnection();
            ResourceAllocationDAO resourceAllocationDAO = new ResourceAllocationDAO(connection);
            MedicalRecordService medicalRecordService = new MedicalRecordService(connection);

            List<ResourceAllocation> allocations = resourceAllocationDAO.getAllAllocations();
            List<MedicalRecord> existingRecords = medicalRecordService.getAllMedicalRecords();
            List<MedicalRecord> medicalRecordsWithDetails = medicalRecordService.getAllMedicalRecordsWithDetails();

            request.setAttribute("allocations", allocations);
            request.setAttribute("existingRecords", existingRecords);
            request.setAttribute("medicalRecordsWithDetails", medicalRecordsWithDetails);

            request.getRequestDispatcher("medical-record.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("medical-record.jsp?error=Database%20error.");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            MedicalRecordService medicalRecordService = new MedicalRecordService(DatabaseConnection.getConnection());

            String resourceAllocationIdStr = request.getParameter("resource_allocation_id");
            if (resourceAllocationIdStr == null || resourceAllocationIdStr.isEmpty()) {
                response.sendRedirect("medical-record.jsp?error=Please%20select%20a%20resource%20allocation.");
                return;
            }

            int resourceAllocationId = Integer.parseInt(resourceAllocationIdStr);
            ResourceAllocation allocation = resourceAllocationDAO.getResourceAllocationById(resourceAllocationId);
            if (allocation == null) {
                response.sendRedirect("medical-record.jsp?error=Invalid%20resource%20allocation.");
                return;
            }

            MedicalRecord record = new MedicalRecord(
                resourceAllocationId,
                allocation.getAppointmentId(),
                allocation.getStaffId(),
                allocation.getOwnerId(),
                allocation.getPetId(),
                allocation.getFacility(),
                allocation.getEquipment(),
                Date.valueOf(request.getParameter("procedure_date")),
                request.getParameter("procedure_type")
            );

            medicalRecordService.addMedicalRecord(record);
            response.sendRedirect("MedicalRecordController?success=Record%20saved%20successfully");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("medical-record.jsp?error=An%20error%20occurred.");
        }
    }
}
