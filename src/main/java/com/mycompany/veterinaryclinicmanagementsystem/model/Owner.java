package com.mycompany.veterinaryclinicmanagementsystem.model;

public class Owner {
    
    private int id;
    private String name;
    private String contactNumber;
    private String nic;

    public Owner() {}
    
    public Owner(int id, String name, String contactNumber, String nic) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.nic = nic;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getNic() { return nic; }
    public void setNic(String nic) { this.nic = nic; }
    
}
