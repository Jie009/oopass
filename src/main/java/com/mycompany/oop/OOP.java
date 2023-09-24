package com.mycompany.oop;
import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.text.SimpleDateFormat;

public class OOP {
    

    public static void main(String[] args) {

        // Create some sample users
        User admin = new User("test", "test", "Jason", "Admin", "admin@example.com");
        User speaker = new User("test2", "test2", "Jane", "Speaker", "speaker@example.com");
        User attendee = new User("test3", "test3", "Ali", "Attendee", "attendee@example.com");
        welcomePage wp = new welcomePage();
        // Add the sample users to the user list
        admin.updateUserList();
        speaker.updateUserList();
        attendee.updateUserList();
        
        wp.welcomePage(admin, speaker, attendee);
    }    
    

    public static void clScr(){
        for (int i = 0; i < 40; i++) {
            System.out.println(); 
        }
    }
    
        
    // Menu screen for speaker
    public static boolean menu(int choice, String category, User user){
        

        Seminar[] seminar = new Seminar[100];
        SlotBooking[] sb = new SlotBooking[100];
        Payment[] payment = new Payment[100];
        Attendee[] attendee = new Attendee[100];
        SeminarEnroll[] seminarEnroll = new SeminarEnroll[100];
        List<Slot> availableSlots = new ArrayList<>();        

        Slot[] slot = new Slot[100];
        
        slot[0] = new Slot("S1","SMK Bunga", "Secondary school hall", "8:00am", "12:00pm", "13/10/2023", Date.valueOf("2023-10-13"), Date.valueOf("2023-10-14"), 400, 350);
        slot[1] = new Slot("S2","Dewan Kulia", "Taman Kulia hall", "10:00am", "5:00pm", "20/10/2023", Date.valueOf("2023-10-20"), Date.valueOf("2023-10-21"), 250, 275);
        slot[2] = new Slot("S3","Dataran Murni", "Indoor hall", "8:00am", "3:00pm", "10/10/2023", Date.valueOf("2023-10-10"), Date.valueOf("2023-10-11"), 500, 600);
        slot[3] = new Slot("S4","SMK Kawi", "Secondary school hall", "8:00am", "11:00am", "30/10/2023", Date.valueOf("2023-10-30"), Date.valueOf("2023-10-30"), 200, 150);
        slot[4] = new Slot("S5","Dewan Wangsa Maju", "Wangsa Maju hall", "3:00pm", "7:00pm", "26/10/2023", Date.valueOf("2023-10-26"), Date.valueOf("2023-10-27"), 200, 220);
        
        for(int i=0; i<5; i++){
        
            availableSlots.add(slot[i]);
        }
        
        Monitoring monitor = new Monitoring(seminar, sb, seminarEnroll, slot);
        for(int i=0; i<seminarEnroll.length; i++){
            if(seminarEnroll[i] != null){
                
            //Adding seminarenrolls array to arraylist
            seminarEnroll[i].deleteSeminarEnroll();

            //Adding each main classseminarenroll array to seminarenroll arraylist
            seminarEnroll[i].addSeminarEnroll(seminarEnroll[i]); 

            //Getting seminarenroll arraylist and put it in monitor class
            monitor.addEnrollToMonitor(seminarEnroll[i].getEnrollList());
                
            }
        }   
        
        for(int i=0; i<sb.length; i++){
            
            if(sb[i] != null){
                
                sb[i].deleteSlotBooking();
                //Adding each main class slotbooking array to slotbooking arraylist
                sb[i].addSlotBooking(sb[i]);
                //Getting slotbooking arraylist to monitor
                monitor.addBookingToMonitor(sb[i].getBookingList());
                
            }
        }   
        
        
        Report report = new Report(seminar, sb, seminarEnroll, attendee);
        for(int i=0; i<seminarEnroll.length; i++){
                
            if(seminarEnroll[i] != null){
                
                seminarEnroll[i].deleteSeminarEnroll();
                seminarEnroll[i].addSeminarEnroll(seminarEnroll[i]);

                report.addToReport(seminarEnroll[i].getEnrollList());
                
            }
        }    
        
        
        
        if(category.equals("Admin")){
            
            int userStatus = 1;
            
            if(choice == 1){
                
                int monitorChoice = monitor.displayChoices();
                monitor.displayList(monitorChoice);           
                
            }else if(choice == 2){
                
                int reportChoice = report.generateList(userStatus);
                report.generateReport(reportChoice, userStatus);             
                
            }else if(choice == 3){
                
                System.out.println("Thank you. Goodbye!");
                System.exit(0);              
                
            }
            
        }else if(category.equals("Speaker")){
            
            Scanner scanner = new Scanner(System.in);
            int userStatus = 2;
            
            //Booking
            if(choice == 1){
                
                
                SlotBooking slotBooking = new SlotBooking(user.getid(), null, null);

        //        EventBooking eb = new EventBooking();

                slotBooking.eventBooking(scanner, user.getid(), sb, payment, availableSlots);
        //        eb.eventBooking(scanner, speaker, sb, payment, availableSlots);      
                
        
            //Report
            }else if(choice == 2){

                int reportChoice = report.generateList(userStatus);
                report.generateReport(reportChoice, userStatus);                
                
            //Advertisement
            }else if(choice == 3){

                
                
            //End
            }else if(choice == 4){
                 
                System.out.println("Thank you. Goodbye!");
                
            }           
            
        }else if(category.equals("Attendee")){
            
            if(choice == 1){
                
               
                
                
            }else if(choice == 2){
                 
                System.out.println("Thank you. Goodbye!");              
                
            }
                
            
                      
        }
        
        return false;
        
    }
    
    
}
