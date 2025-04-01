package com.mycompany.veterinaryclinicmanagementsystem.model;

import java.util.Date;

public class Appointment {
    private int id;
    private int ownerId;
    private int petId;
    private Date appointmentDate;
    private String serviceDescription;
    private String status; 

    public Appointment() {}

    public Appointment(int id, int ownerId, int petId, Date appointmentDate, String serviceDescription, String status) {
        this.id = id;
        this.ownerId = ownerId;
        this.petId = petId;
        this.appointmentDate = appointmentDate;
        this.serviceDescription = serviceDescription;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }

    public int getPetId() { return petId; }
    public void setPetId(int petId) { this.petId = petId; }

    public Date getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(Date appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getServiceDescription() { return serviceDescription; }
    public void setServiceDescription(String serviceDescription) { this.serviceDescription = serviceDescription; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
