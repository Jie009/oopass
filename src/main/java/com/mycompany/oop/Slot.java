package com.mycompany.oop;
public class Slot {
    private String venue;
    private String desc;
    private String startTime;
    private String endTime;
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
    
    public Slot(String venue, String desc, String startTime, String endTime, int seatNo, double price){
        this.venue = venue;
        this.desc = desc;
        this.startTime = startTime;
        this.endTime = endTime;
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
    public int getSeatNo(){
        return seatNo;
    }
    public double getPrice(){
        return price;
    }
    public String toString(){
        return String.format("\nVenue: %s"
                + "\nDescription: %s"
                + "\nStart time: %s"
                + "\nEnd time: %s"
                + "\nNumber of Seat: %d"
                + "\nPrice: RM%.2f", venue, desc, startTime, endTime, seatNo, price);
    }
}
