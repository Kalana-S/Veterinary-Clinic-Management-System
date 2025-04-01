package com.mycompany.veterinaryclinicmanagementsystem.service;

import com.mycompany.veterinaryclinicmanagementsystem.dao.OwnerDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OwnerServiceTest {
    
    private OwnerDAO ownerDAO;
    private OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerDAO = mock(OwnerDAO.class);
        ownerService = new OwnerService(ownerDAO);
    }

    @Test
    void registerOwner_Success() throws Exception {
        Owner owner = new Owner();
        owner.setName("John Doe");

        ownerService.registerOwner(owner);
        verify(ownerDAO, times(1)).addOwner(owner);
    }

    @Test
    void listOwners_ReturnsOwners() throws Exception {
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        when(ownerDAO.getAllOwners()).thenReturn(Arrays.asList(owner1, owner2));

        List<Owner> owners = ownerService.listOwners();
        assertEquals(2, owners.size());
    }
    
}
