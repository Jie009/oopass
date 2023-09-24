/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop;

/**
 *
 * @author User
 */
public class Speaker extends User {
    
    
    private String[][] speakerList;
    
    public Speaker(String id, String password, String name, String contactInfo) {
        
        super(id, password, name, "Speaker", contactInfo);
        
    }

    public String[][] getSpeakerList(){
        
        return speakerList;
    }
    
    public void setSpeakerList(String[][] speakerList){
        
        this.speakerList = speakerList;
    }
    
    public String getID(){
        
        return super.getid();
    }
}
