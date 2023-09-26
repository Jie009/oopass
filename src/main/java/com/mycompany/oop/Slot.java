package com.mycompany.oop;

import java.sql.Date;

public class Slot{
    private String id;
    private String venue;
    private String desc;
    private String startTime;
    private String endTime;
    private String slotDate;
    private Date startDate;
    private Date endDate;
    private int seatNo;
    private double price;
    
    public Slot(){
        venue = "Hello World";
        desc = "Hello World";
        startTime = "12:00pm";
        endTime = "1:00pm";
        seatNo = 0;
        price = 0.00;
        startDate = Date.valueOf("");
        endDate = Date.valueOf("");
    
    }
    
    public Slot(String id, String venue, String desc, String startTime, String endTime, String slotDate, Date startDate, Date endDate, int seatNo, double price){
        this.id = id;
        this.venue = venue;
        this.desc = desc;
        this.startTime = startTime;
        this.endTime = endTime;
        this.slotDate = slotDate;
        this.seatNo = seatNo; 
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public void setSeatNo(int seatNo){
    
        this.seatNo = seatNo;
    }
    public void setVenue(String venue){
    
        this.venue = venue;
    }
    
    public void setDesc(String desc){
    
        this.desc = desc;
    }
    
    public void setPrice(double price){
        
        this.price = price;
    }
    
    public void setStartDate(Date startDate){
     
        this.startDate = startDate;
    }
    
    public void setEndDate(Date endDate){
     
        this.endDate = endDate;
    }
    
    public void setStartTime(String startTime){
     
        this.startTime = startTime;
    }
    
    public void setEndTime(String endTime){
     
        this.endTime = endTime;
    }  
     
    
    public String getID(){
        
        return id;
    }   
    
    public String getVenue(){
        return venue;
    }
    
    public String getDesc(){
        return desc;
    }
    public String getStartTime(){
        return startTime;
    }

    public String getEndTime(){
        return endTime;
    }
    
    public Date getStartDate(){
        
        return startDate;
    }
    public Date getEndDate(){
        
        return endDate;
    }
    
   public String getSlotDate(){
       return slotDate;
   }
    public int getSeatNo(){
        return seatNo;
    }
    public double getPrice(){
        return price;
    }
    public String toString(){
        return String.format
                ( "\n=====================================================" 
                + "\nVenue: %s"
                + "\nDescription: %s"
                + "\nTime: %s - %s"            
                + "\t\tDate: %s"
                + "\nNumber of Seat: %d"
                + "\t\t\tPrice: RM%.2f"
                + "\n=====================================================\n", 
                venue, desc, startTime, endTime, slotDate, seatNo, price);
    }
}
