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
        return String.format("\nVenue: %s"
                + "\nStart time: %s"
                + "\nEnd time: %s"
                + "\nNumber of Seat: %d"
                + "\nPrice: RM%.2f"
                + "\nPayment Method: %s"
                + "\nSpeaker: %s",
                slot.getVenue(), slot.getStartTime(), slot.getEndTime(), slot.getSeatNo(), slot.getPrice(), payment.getMethod(), speaker);
        }
}

