package com.mycompany.oop;

import java.util.Date;

public class SlotBooking {
    private String speaker;
    private Slot slot;
    private Payment payment;
    private static int numOfBooking = 0;
    
    public SlotBooking(String speaker, Slot slot, Payment payment){
        this.speaker = speaker;
        this.slot = slot;
        this.payment = payment;
        numOfBooking++;
    }
    public String getSpeaker(){
        return speaker;
    }
    public String getVenue(){
        return slot.getVenue();
    }
    public String getDesc(){
        return slot.getDesc();
    }
    public String getStartTime(){
        return slot.getStartTime();
    }
    public String getEndTime(){
        return slot.getEndTime();
    }
    public String getSlotDate(){
        return slot.getSlotDate();
    }
    public int getSeatNo(){
        return slot.getSeatNo();
    }
    public double getPrice(){
        return slot.getPrice();
    }
    public Slot getSlot() {
        return slot;
    }
    public String getMethod(){
        return payment.getMethod();
    }
    public double getTotal(){
        return payment.getTotal();
    }
    public Date getDate(){
        return payment.getDate();
    }
    
    public static int getNumOfBooking(){
        return numOfBooking;
    }
    
    public String toString() {
        return String.format
                ( "\n=====================================================" 
                + "\nVenue: %s"               
                + "\nTime: %s - %s"            
                + "\t\t\tDate: %s"
                + "\nNumber of Seat: %d"
                + "\t\t\tPrice: RM%.2f"
                + "\nPayment Method: %s"
                + "\nSpeaker: %s"
                + "\n=====================================================" ,
                slot.getVenue(), slot.getStartTime(), slot.getEndTime(), slot.getSlotDate(), slot.getSeatNo(), slot.getPrice(), payment.getMethod(), speaker);
        }
}

