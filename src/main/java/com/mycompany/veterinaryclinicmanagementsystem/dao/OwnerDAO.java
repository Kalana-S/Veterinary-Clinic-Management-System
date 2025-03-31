package com.mycompany.veterinaryclinicmanagementsystem.dao;

import com.mycompany.veterinaryclinicmanagementsystem.model.Owner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO {
    
    private Connection connection;

    public OwnerDAO(Connection connection) {
        this.connection = connection;
    }

    public void addOwner(Owner owner) throws Exception {
        String sql = "INSERT INTO owners (name, contactNumber, nic) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, owner.getName());
            stmt.setString(2, owner.getContactNumber());
            stmt.setString(3, owner.getNic());
            stmt.executeUpdate();
        }
    }

    public List<Owner> getAllOwners() throws Exception {
        List<Owner> owners = new ArrayList<>();
        String sql = "SELECT * FROM owners";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Owner owner = new Owner(rs.getInt("id"), rs.getString("name"), rs.getString("contactNumber"), rs.getString("nic"));
                System.out.println("Fetched Owner: " + owner.getName());  // Debugging line
                owners.add(owner);
            }
        }
        return owners;
    }

    public Owner getOwnerByNameAndNIC(String name, String nic) throws Exception {
        String sql = "SELECT * FROM owners WHERE name = ? AND nic = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, nic);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Owner(rs.getInt("id"), rs.getString("name"), rs.getString("contactNumber"), rs.getString("nic"));
                }
            }
        }
        return null; 
    }

}
