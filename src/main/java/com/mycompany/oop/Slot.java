package com.mycompany.oop;


public class Slot{
    private String venue;
    private String desc;
    private String startTime;
    private String endTime;
    private String slotDate;
    private int seatNo;
    private double price;
    
    public Slot(){
        venue = "Hello World";
        desc = "Hello World";
        startTime = "12:00pm";
        endTime = "1:00pm";
        seatNo = 0;
        price = 0.00;
    }
    
    public Slot(String venue, String desc, String startTime, String endTime, String slotDate, int seatNo, double price){
        this.venue = venue;
        this.desc = desc;
        this.startTime = startTime;
        this.endTime = endTime;
        this.slotDate = slotDate;
        this.seatNo = seatNo; 
        this.price = price;
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
                + "\t\t\tDate: %s"
                + "\nNumber of Seat: %d"
                + "\t\t\tPrice: RM%.2f"
                + "\n=====================================================\n", 
                venue, desc, startTime, endTime, slotDate, seatNo, price);
    }
}
