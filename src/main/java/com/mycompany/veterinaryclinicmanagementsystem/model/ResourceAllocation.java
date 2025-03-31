package com.mycompany.veterinaryclinicmanagementsystem.model;

public class ResourceAllocation {
    
    private int id;
    private int appointmentId;
    private int staffId;
    private int ownerId;
    private int petId;
    private String facility;
    private String equipment;

    public ResourceAllocation() {}

    public ResourceAllocation(int id, int appointmentId, int staffId, int ownerId, int petId, String facility, String equipment) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.staffId = staffId;
        this.ownerId = ownerId;
        this.petId = petId;
        this.facility = facility;
        this.equipment = equipment; 
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

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
}
