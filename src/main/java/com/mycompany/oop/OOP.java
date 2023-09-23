package com.mycompany.oop;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.text.SimpleDateFormat;

public class OOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SlotBooking[] sb = new SlotBooking[100];
        Slot[] slot = new Slot[50];
        Payment[] payment = new Payment[100];
        String speaker = "John Smith";
        List<Slot> availableSlots = new ArrayList<>();        
        
        availableSlots.add(new Slot("SMK Bunga", "Secondary school hall", "8:00am", "12:00pm", "13/10/2023", 400, 350));
        availableSlots.add(new Slot("Dewan Kulia", "Taman Kulia hall", "10:00am", "5:00pm", "20/10/2023", 250, 275));
        availableSlots.add(new Slot("Dataran Murni", "Indoor hall", "8:00am", "3:00pm", "10/10/2023", 500, 600));
        availableSlots.add(new Slot("SMK Kawi", "Secondary school hall", "8:00am", "11:00am", "30/10/2023", 200, 150));
        availableSlots.add(new Slot("Dewan Wangsa Maju", "Wangsa Maju hall", "3:00pm", "7:00pm", "26/10/2023", 200, 220));
        
        SlotBooking slotBooking = new SlotBooking(speaker, null, null);

//        EventBooking eb = new EventBooking();
        
        slotBooking.eventBooking(scanner, speaker, sb, payment, availableSlots);
//        eb.eventBooking(scanner, speaker, sb, payment, availableSlots);
        System.out.println("Quit ");
    }

    public static void clScr(){
        for (int i = 0; i < 40; i++) {
            System.out.println(); 
        }
    }
}
