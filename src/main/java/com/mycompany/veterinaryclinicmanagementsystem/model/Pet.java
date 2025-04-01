package com.mycompany.veterinaryclinicmanagementsystem.model;


public class Pet {
    
    private int id;
    private String name;
    private int age;
    private String type;
    private int ownerId;

    public Pet() {}

    public Pet(int id, String name, int age, String type, int ownerId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
        this.ownerId = ownerId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }
    
}
