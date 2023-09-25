package com.mycompany.oop;

import java.util.ArrayList;

public class Attendee {
    
    private int numOfSeminar;
    private String attendeeID;
    private String seminarID;
    private Payment payment;
    
    private static int numOfAttendee = -1;
    
    public Attendee(String attendeeID, String seminarID, Payment payment){
        

        this.attendeeID = attendeeID;
        this.seminarID = seminarID;
        this.payment = payment;
        numOfAttendee++;
    }
    
    public void setNumOfSeminar(int numOfSeminar){
        
        this.numOfSeminar = numOfSeminar;
    }
    
    public int getNumOfSeminar(){
        
        return numOfSeminar;
    }
    
    public String getMethod(){
     
        return payment.getMethod();
    }
    
    public double getTotal(){
     
        return payment.getTotal();
    }
    
    public String toString(){
        
        return attendeeID;
    }
    
    public String getSeminarID(){
     
        return seminarID;
    }
    
    public String getID(){
        
        return attendeeID;
    }
    
    public static int getNumOfAttendee(){
        return numOfAttendee;
    }    
    
    
}