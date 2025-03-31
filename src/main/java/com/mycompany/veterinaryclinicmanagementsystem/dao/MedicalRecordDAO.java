package com.mycompany.veterinaryclinicmanagementsystem.dao;

import com.mycompany.veterinaryclinicmanagementsystem.model.MedicalRecord;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MedicalRecordDAO {
    
    private Connection connection;

    public MedicalRecordDAO(Connection connection) {
        this.connection = connection;
    }

    public void saveMedicalRecord(MedicalRecord record) throws Exception {
        String sql = "INSERT INTO medical_records (resource_allocation_id, appointment_id, staff_id, owner_id, pet_id, facility, equipment, procedure_date, procedure_type) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, record.getResourceAllocationId());
            stmt.setInt(2, record.getAppointmentId());
            stmt.setInt(3, record.getStaffId());
            stmt.setInt(4, record.getOwnerId());
            stmt.setInt(5, record.getPetId());
            stmt.setString(6, record.getFacility());
            stmt.setString(7, record.getEquipment());
            stmt.setDate(8, record.getProcedureDate());
            stmt.setString(9, record.getProcedureType());
            stmt.executeUpdate();
        }
    }
    
    public List<MedicalRecord> getAllMedicalRecords() {
        List<MedicalRecord> medicalRecords = new ArrayList<>();
        String sql = "SELECT * FROM medical_records";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                MedicalRecord record = new MedicalRecord(
                    resultSet.getInt("resource_allocation_id"),
                    resultSet.getInt("appointment_id"),
                    resultSet.getInt("staff_id"),
                    resultSet.getInt("owner_id"),
                    resultSet.getInt("pet_id"),
                    resultSet.getString("facility"),
                    resultSet.getString("equipment"),
                    resultSet.getDate("procedure_date"),
                    resultSet.getString("procedure_type")
                );
                medicalRecords.add(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicalRecords;
    }
    
    public List<MedicalRecord> getAllMedicalRecordsWithDetails() {
        List<MedicalRecord> records = new ArrayList<>();
        String sql = "SELECT mr.*, p.name AS pet_name, o.name AS owner_name, o.contactNumber AS owner_contact_no, o.nic AS owner_nic, s.name AS staff_name, s.role AS staff_type " +
                     "FROM medical_records mr " +
                     "JOIN pets p ON mr.pet_id = p.id " +
                     "JOIN owners o ON mr.owner_id = o.id " +
                     "JOIN staff s ON mr.staff_id = s.id";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                records.add(new MedicalRecord(
                    rs.getInt("id"),
                    rs.getInt("resource_allocation_id"),
                    rs.getInt("appointment_id"),
                    rs.getInt("staff_id"),
                    rs.getInt("owner_id"),
                    rs.getInt("pet_id"),
                    rs.getString("pet_name"),
                    rs.getString("owner_name"),
                    rs.getString("owner_contact_no"),
                    rs.getString("owner_nic"),
                    rs.getString("staff_name"),
                    rs.getString("staff_type"),
                    rs.getString("facility"),
                    rs.getString("equipment"),
                    rs.getDate("procedure_date"),
                    rs.getString("procedure_type")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }
     
}
