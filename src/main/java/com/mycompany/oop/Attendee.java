package com.mycompany.oop;

import java.util.ArrayList;

public class Attendee {
    
    private ArrayList<SeminarEnroll> enrollList;
    private int numOfSeminar;
    private String attendeeID;
    private String seminarID;
    private Payment payment;
    
    public Attendee(ArrayList<SeminarEnroll> enrollList, int numOfSeminar, String attendeeID, String seminarID, Payment payment){
        
        this.enrollList = enrollList;
        this.attendeeID = attendeeID;
        this.numOfSeminar = numOfSeminar;
        this.seminarID = seminarID;
        this.payment = payment;
    }
    
    public void setNumOfSeminar(int numOfSeminar){
        
        this.numOfSeminar = numOfSeminar;
    }
    
    public int getNumOfSeminar(){
        
        return numOfSeminar;
    }
    
    public void setEnrollList(ArrayList<SeminarEnroll> enrollList){
        
        this.enrollList = enrollList;
    }
    
    public ArrayList<SeminarEnroll> getEnrollList(){
        
        return enrollList;
    }    
    
    public void associateAttendee(SeminarEnroll attendee){
        
        enrollList.add(attendee);
    }
    
    public String toString(){
        
        return attendeeID;
    }
    
    public String getSeminarID(){
     
        return seminarID;
    }   
    
    public double getTotal(){
     
        return payment.getTotal();
    }
    
    public String getMethod(){
     
        return payment.getMethod();
    } 
    
}
