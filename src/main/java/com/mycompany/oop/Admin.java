package com.mycompany.oop;

public class Admin extends User {
    public Admin(String id, String password, String name, String contactInfo) {
        super(id, password, name, "Admin", contactInfo);
    }
}