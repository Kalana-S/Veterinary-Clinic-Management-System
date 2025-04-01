package com.mycompany.veterinaryclinicmanagementsystem.service;

import com.mycompany.veterinaryclinicmanagementsystem.dao.MedicalRecordDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.MedicalRecord;
import java.sql.Connection;
import java.util.List;

public class MedicalRecordService {
    
    MedicalRecordDAO medicalRecordDAO;

    public MedicalRecordService(Connection connection) {
        this.medicalRecordDAO = new MedicalRecordDAO(connection);
    }

    public void addMedicalRecord(MedicalRecord record) throws Exception {
        medicalRecordDAO.saveMedicalRecord(record);
    }
    
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordDAO.getAllMedicalRecords();
    }
    
    public List<MedicalRecord> getAllMedicalRecordsWithDetails() {
        return medicalRecordDAO.getAllMedicalRecordsWithDetails();
    }
   
}
