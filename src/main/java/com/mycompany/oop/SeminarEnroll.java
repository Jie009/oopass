/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class SeminarEnroll {
    
    private Attendee attendee;
    private Seminar seminar;
    private ArrayList<SeminarEnroll> enrollList;
    private Date enrolledDate;
    private Time enrolledTime;
    
    public SeminarEnroll(Attendee attendee, Seminar seminar){
        
        this.attendee = attendee;
        this.seminar = seminar;
        this.enrollList = new ArrayList<>();

        seminar.associateSeminar(this);
        attendee.associateAttendee(this);
             
    }
    
    public void deleteSeminarEnroll(){
        
        enrollList.clear();
    }
    
    public void addSeminarEnroll(SeminarEnroll enrolls){
        
        enrollList.add(enrolls);
    }
    
    public ArrayList<SeminarEnroll> getEnrollList(){
        
        return enrollList;
    }

    
    public String toString(){
        
        return attendee.toString() + "-" + seminar.toString();
    }
    
    public Time getStartTime(){
        
        return seminar.getStartTime();
    }
    
    public Time getEndTime(){
        
        return seminar.getEndTime();
    }
    
    public Time getTime(){
        
        return enrolledTime;
    }
    
    public Date getDate(){
        
        return enrolledDate;
    }
    
    public String getID(){
        
        return seminar.getID();
    }
    
    public String getAttendeeID(){
        
        return attendee.toString();
    }
    
    public void setNumOfSeminar(int NumOfSeminar){
        
        attendee.setNumOfSeminar(NumOfSeminar);
    }
    
    public int getNumOfSeminar(){
        
        return attendee.getNumOfSeminar();
    }

    
}
