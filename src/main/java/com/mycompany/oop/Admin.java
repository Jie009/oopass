package com.mycompany.oop;

//Polymorphism of user
public class Admin extends User {
    public Admin(String id, String password, String name, String contactInfo) {
        super(id, password, name, "Admin", contactInfo);
    }
}