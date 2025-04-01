package com.mycompany.veterinaryclinicmanagementsystem.service;

import com.mycompany.veterinaryclinicmanagementsystem.dao.PetDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PetServiceTest {
    
    private PetDAO petDAO;
    private PetService petService;

    @BeforeEach
    void setUp() {
        petDAO = mock(PetDAO.class);
        petService = new PetService(petDAO);
    }

    @Test
    void registerPet_Success() throws Exception {
        Pet pet = new Pet();
        pet.setName("Buddy");

        petService.registerPet(pet);
        verify(petDAO, times(1)).addPet(pet);
    }

    @Test
    void getPetsByOwner_ReturnsPetList() throws Exception {
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();
        when(petDAO.getPetsByOwner(1)).thenReturn(Arrays.asList(pet1, pet2));

        List<Pet> pets = petService.getPetsByOwner(1);
        assertEquals(2, pets.size());
    }
    
}
