package com.mycompany.oop;

public class Speaker extends User {
    public Speaker(String id, String password, String name, String contactInfo) {
        super(id, password, name, "Speaker", contactInfo);
    }
    
    
    public String getSpeaker(){
     
        return super.getid();
    }
    // Add specific methods or overrides for Speaker users here
}