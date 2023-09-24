/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop;

import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author User
 */
public class Seminar {
    
    private String id;
    private String desc;
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;
    private double price;
    private String location;
    private Speaker speaker;
    private ArrayList<SeminarEnroll> enrollList;
    
    
    public Seminar(String id, String desc, Date startDate, Date endDate, Time startTime, Time endTime, double price, String location, ArrayList<SeminarEnroll> enrollList){ 
         
        this.id = id;
        this.desc = desc;
        this.startDate = startDate;
        this.endDate = endDate; 
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.location = location;
        this.enrollList = enrollList;
        
    }
    
    public void setID(String id){
        
        this.id = id;
    }
    
    public String getID(){
        
        return id;
    }
    
    public void setStartTime(Time startTime){
        
        this.startTime = startTime;
    }
    
    
    
    
    public Time getStartTime(){
        
        return startTime;
    }
    
    public Time getEndTime(){
        
        return endTime;
    }

    public void setEnrollList(ArrayList<SeminarEnroll> enrollList){
        
        this.enrollList = enrollList;
    }
    
    public ArrayList<SeminarEnroll> getEnrollList(){
        
        return enrollList;
    }       
    
    public void associateSeminar(SeminarEnroll seminar){
        
        enrollList.add(seminar);
    }
    
    @Override
    public String toString(){
        
        return id;
    }
    
    /*
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seminar Details\n");
        sb.append("--------------------\n");
        sb.append("Title: ").append(SeminarTitle).append("\n");
        sb.append("Start Date: ").append(startDate).append("\n");
        sb.append("End Date: ").append(endDate).append("\n");
        sb.append("Start Time: ").append(startTime).append("\n");
        sb.append("End Time: ").append(endTime).append("\n");
        sb.append("Price: ").append(price).append("\n");
        sb.append("Location: ").append(location).append("\n");
        sb.append("--------------------");

        return sb.toString();
    }
    */
}
