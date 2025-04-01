package com.mycompany.veterinaryclinicmanagementsystem.model;

import java.sql.Date;

public class MedicalRecord {
    
    private int id;
    private int resourceAllocationId;
    private int appointmentId;
    private int staffId;
    private int ownerId;
    private int petId;
    private String facility;
    private String equipment;
    private Date procedureDate;
    private String procedureType;
    private String petName;
    private String ownerName;
    private String ownerContactNo;
    private String ownerNIC;
    private String staffName;
    private String staffType;

    public MedicalRecord() {}

    public MedicalRecord(int resourceAllocationId, int appointmentId, int staffId, int ownerId, int petId, String facility, String equipment, Date procedureDate, String procedureType) {
        this.resourceAllocationId = resourceAllocationId;
        this.appointmentId = appointmentId;
        this.staffId = staffId;
        this.ownerId = ownerId;
        this.petId = petId;
        this.facility = facility;
        this.equipment = equipment;
        this.procedureDate = procedureDate;
        this.procedureType = procedureType;
    }
    
    public MedicalRecord(int id, int resourceAllocationId, int appointmentId, int staffId, int ownerId, int petId, String petName, String ownerName, String ownerContactNo, String ownerNIC, String staffName, String staffType, String facility, String equipment, Date procedureDate, String procedureType) {
        this.id = id;
        this.resourceAllocationId = resourceAllocationId;
        this.appointmentId = appointmentId;
        this.staffId = staffId;
        this.ownerId = ownerId;
        this.petId = petId;
        this.petName = petName;
        this.ownerName = ownerName;
        this.ownerContactNo = ownerContactNo;
        this.ownerNIC = ownerNIC;
        this.staffName = staffName;
        this.staffType = staffType;
        this.facility = facility;
        this.equipment = equipment;
        this.procedureDate = procedureDate;
        this.procedureType = procedureType;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getResourceAllocationId() { return resourceAllocationId; }
    public void setResourceAllocationId(int resourceAllocationId) { this.resourceAllocationId = resourceAllocationId; }

    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public int getStaffId() { return staffId; }
    public void setStaffId(int staffId) { this.staffId = staffId; }

    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }

    public int getPetId() { return petId; }
    public void setPetId(int petId) { this.petId = petId; }

    public String getFacility() { return facility; }
    public void setFacility(String facility) { this.facility = facility; }

    public String getEquipment() { return equipment; }
    public void setEquipment(String equipment) { this.equipment = equipment; }

    public Date getProcedureDate() { return procedureDate; }
    public void setProcedureDate(Date procedureDate) { this.procedureDate = procedureDate; }

    public String getProcedureType() { return procedureType; }
    public void setProcedureType(String procedureType) { this.procedureType = procedureType; }
    
    public String getPetName() { return petName; }
    public void setPetName(String petName) { this.petName = petName; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getOwnerContactNo() { return ownerContactNo; }
    public void setOwnerContactNo(String ownerContactNo) { this.ownerContactNo = ownerContactNo; }

    public String getOwnerNIC() { return ownerNIC; }
    public void setOwnerNIC(String ownerNIC) { this.ownerNIC = ownerNIC; }

    public String getStaffName() { return staffName; }
    public void setStaffName(String staffName) { this.staffName = staffName; }

    public String getStaffType() { return staffType; }
    public void setStaffType(String staffType) { this.staffType = staffType; }

}
