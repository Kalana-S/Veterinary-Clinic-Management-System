package com.mycompany.veterinaryclinicmanagementsystem.dao;

import com.mycompany.veterinaryclinicmanagementsystem.model.ResourceAllocation;
import com.mycompany.veterinaryclinicmanagementsystem.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResourceAllocationDAO {
    
    private Connection connection;

    public ResourceAllocationDAO(Connection connection) {
        this.connection = connection;
    }

    public void allocateResource(ResourceAllocation allocation) throws Exception {
        String sql = "INSERT INTO resource_allocations (appointment_id, staff_id, owner_id, pet_id, facility, equipment) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, allocation.getAppointmentId());
            stmt.setInt(2, allocation.getStaffId());
            stmt.setInt(3, allocation.getOwnerId());
            stmt.setInt(4, allocation.getPetId());
            stmt.setString(5, allocation.getFacility());
            stmt.setString(6, allocation.getEquipment());
            stmt.executeUpdate();
        }
    }

    public List<ResourceAllocation> getAllAllocations() throws Exception {
        List<ResourceAllocation> allocations = new ArrayList<>();
        String sql = "SELECT * FROM resource_allocations";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                allocations.add(new ResourceAllocation(
                        rs.getInt("id"),
                        rs.getInt("appointment_id"),
                        rs.getInt("staff_id"),
                        rs.getInt("owner_id"),
                        rs.getInt("pet_id"),
                        rs.getString("facility"),
                        rs.getString("equipment")
                ));
            }
        }
        return allocations;
    }
    
    //-------Medical Records-------
    public List<ResourceAllocation> getAllResourceAllocations() throws SQLException {
        List<ResourceAllocation> allocations = new ArrayList<>();
        String sql = "SELECT * FROM resource_allocations";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                allocations.add(new ResourceAllocation(
                        rs.getInt("id"),
                        rs.getInt("appointment_id"),
                        rs.getInt("staff_id"),
                        rs.getInt("owner_id"),
                        rs.getInt("pet_id"),
                        rs.getString("facility"),
                        rs.getString("equipment")
                ));
            }
        }
        return allocations;
    }

    public ResourceAllocation getResourceAllocationById(int id) throws SQLException {
        String sql = "SELECT * FROM resource_allocations WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ResourceAllocation(
                    rs.getInt("id"),
                    rs.getInt("appointment_id"),
                    rs.getInt("staff_id"),
                    rs.getInt("owner_id"),
                    rs.getInt("pet_id"),
                    rs.getString("facility"),
                    rs.getString("equipment")
                );
            }
        }
        return null;
    }

}
