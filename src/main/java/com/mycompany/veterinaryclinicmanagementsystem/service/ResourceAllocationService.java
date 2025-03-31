package com.mycompany.veterinaryclinicmanagementsystem.service;

import com.mycompany.veterinaryclinicmanagementsystem.dao.ResourceAllocationDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.ResourceAllocation;
import java.util.List;

public class ResourceAllocationService {
    
    private ResourceAllocationDAO resourceAllocationDAO;

    public ResourceAllocationService(ResourceAllocationDAO resourceAllocationDAO) {
        this.resourceAllocationDAO = resourceAllocationDAO;
    }

    public void allocateResource(ResourceAllocation allocation) throws Exception {
        resourceAllocationDAO.allocateResource(allocation);
    }

    public List<ResourceAllocation> listAllocations() throws Exception {
        return resourceAllocationDAO.getAllAllocations();
    }
    
}
