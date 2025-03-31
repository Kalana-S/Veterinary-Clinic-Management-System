package com.mycompany.veterinaryclinicmanagementsystem.dao;

import com.mycompany.veterinaryclinicmanagementsystem.model.Pet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    
     private Connection connection;

    public PetDAO(Connection connection) {
        this.connection = connection;
    }

    public void addPet(Pet pet) throws Exception {
        String sql = "INSERT INTO pets (name, age, type, owner_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pet.getName());
            stmt.setInt(2, pet.getAge());
            stmt.setString(3, pet.getType());
            stmt.setInt(4, pet.getOwnerId());
            stmt.executeUpdate();
        }
    }

    public List<Pet> getPetsByOwner(int ownerId) throws Exception {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE owner_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ownerId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pets.add(new Pet(rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
                            rs.getString("type"), rs.getInt("owner_id")));
                }
            }
        }
        return pets;
    }
    
}
