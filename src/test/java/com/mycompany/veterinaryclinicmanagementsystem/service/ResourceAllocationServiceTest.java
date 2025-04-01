package com.mycompany.veterinaryclinicmanagementsystem.service;

import com.mycompany.veterinaryclinicmanagementsystem.dao.ResourceAllocationDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.ResourceAllocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ResourceAllocationServiceTest {
    
    private ResourceAllocationDAO resourceAllocationDAO;
    private ResourceAllocationService resourceAllocationService;

    @BeforeEach
    void setUp() {
        resourceAllocationDAO = mock(ResourceAllocationDAO.class);
        resourceAllocationService = new ResourceAllocationService(resourceAllocationDAO);
    }

    @Test
    void allocateResource_Success() throws Exception {
        ResourceAllocation allocation = new ResourceAllocation();
        
        resourceAllocationService.allocateResource(allocation);
        verify(resourceAllocationDAO, times(1)).allocateResource(allocation);
    }

    @Test
    void listAllocations_ReturnsList() throws Exception {
        ResourceAllocation alloc1 = new ResourceAllocation();
        ResourceAllocation alloc2 = new ResourceAllocation();
        when(resourceAllocationDAO.getAllAllocations()).thenReturn(Arrays.asList(alloc1, alloc2));

        List<ResourceAllocation> allocations = resourceAllocationService.listAllocations();
        assertEquals(2, allocations.size());
    }
    
}
