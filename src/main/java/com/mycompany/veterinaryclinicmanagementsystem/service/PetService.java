package com.mycompany.veterinaryclinicmanagementsystem.service;

import com.mycompany.veterinaryclinicmanagementsystem.dao.PetDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Pet;
import java.util.List;

public class PetService {
    
    private PetDAO petDAO;

    public PetService(PetDAO petDAO) {
        this.petDAO = petDAO;
    }

    public void registerPet(Pet pet) throws Exception {
        petDAO.addPet(pet);
    }

    public List<Pet> getPetsByOwner(int ownerId) throws Exception {
        return petDAO.getPetsByOwner(ownerId);
    }
    
}
