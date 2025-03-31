package com.mycompany.veterinaryclinicmanagementsystem.service;

import com.mycompany.veterinaryclinicmanagementsystem.dao.OwnerDAO;
import com.mycompany.veterinaryclinicmanagementsystem.model.Owner;
import java.util.List;

public class OwnerService {
    
    private OwnerDAO ownerDAO;

    public OwnerService(OwnerDAO ownerDAO) {
        this.ownerDAO = ownerDAO;
    }

    public void registerOwner(Owner owner) throws Exception {
        ownerDAO.addOwner(owner);
    }

    public List<Owner> listOwners() throws Exception {
        return ownerDAO.getAllOwners();
    }
    
}
