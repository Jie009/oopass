package com.mycompany.oop;

import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

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
    
    public String getDesc(){
     
        return desc;
    }
    public Date getStartDate(){
        
        return startDate;
    }
    
    public Date getEndDate(){
     
        return endDate;
    }
    
    
    public Time getStartTime(){
        
        return startTime;
    }
    
    public Time getEndTime(){
        
        return endTime;
    }
    
    public String getLocation(){
        
        return location;
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
    
    public double getPrice(){
        
        return price;
    }  
    
    public String output() {
        return String.format
                ( "\n=====================================================" 
                + "\nID: %s"                             
                + "\nLocation: %s"                             
                + "\nStart Time: %s"            
                + "\nEnd Time: %s"            
                + "\nStart Date: %s"
                + "\nEnd Date: %s"
                + "\nPrice: RM%.2f"
                + "\nSpeaker: %s"
                + "\n=====================================================" ,
                getID(), getLocation(), getStartTime(), getEndTime(), getStartDate(), 
                getEndDate(), getPrice(), "speaker");
    }   
    
}
