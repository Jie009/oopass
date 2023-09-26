
package com.mycompany.oop;

import static com.mycompany.oop.OOP.clScr;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class welcomePage {
    public static void welcomePage(List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees, Scanner scanner){ 
        boolean cont = true;
        boolean bigLoop = true;
        String category = "";
        clScr();
        
        
        Seminar[] seminar = new Seminar[100];
        SlotBooking[] sb = new SlotBooking[100];
        Payment[] payment = new Payment[100];
        Attendee[] attendee = new Attendee[100];
        SeminarEnroll[] seminarEnroll = new SeminarEnroll[100];
        List<Slot> availableSlots = new ArrayList<>();        

        Slot[] slot = new Slot[100];

        slot[0] = new Slot("S1","SMK Bunga", "Secondary school hall", "8:00:00", "12:00:00", "13/10/2023", Date.valueOf("2023-10-13"), Date.valueOf("2023-10-14"), 400, 350);
        slot[1] = new Slot("S2","Dewan Kulia", "Taman Kulia hall", "10:00:00", "17:00:00", "20/10/2023", Date.valueOf("2023-10-20"), Date.valueOf("2023-10-21"), 250, 275);
        slot[2] = new Slot("S3","Dataran Murni", "Indoor hall", "8:00:00", "15:00:00", "10/10/2023", Date.valueOf("2023-10-10"), Date.valueOf("2023-10-11"), 500, 600);
        slot[3] = new Slot("S4","SMK Kawi", "Secondary school hall", "8:00:00", "11:00:00", "30/10/2023", Date.valueOf("2023-10-30"), Date.valueOf("2023-10-30"), 200, 150);
        slot[4] = new Slot("S5","Dewan Wangsa Maju", "Wangsa Maju hall", "15:00:00", "19:00:00", "26/10/2023", Date.valueOf("2023-10-26"), Date.valueOf("2023-10-27"), 200, 220);

        //seminar[0] = new Seminar("S1", "", Date.valueOf("2023-10-21"), Date.valueOf("2023-10-22"), Time.valueOf("15:30:00"), Time.valueOf("17:30:00"), 200, "KL", new ArrayList<>());
        //seminar[1] = new Seminar("S2", "", Date.valueOf("2023-10-21"), Date.valueOf("2023-10-22"), Time.valueOf("16:30:00"), Time.valueOf("18:30:00"), 200, "KL", new ArrayList<>());       
        for(int i=0; i<5; i++){

            availableSlots.add(slot[i]);
        }   

        
        
        while(bigLoop == true){
            
            do {
                OOP.clScr();
                System.out.println("===================================================");
                System.out.println("      Welcome to the Seminar Management System");
                System.out.println("");
                System.out.println("1 - Login");
                System.out.println("2 - Register");
                System.out.println("");
                System.out.println("0 - EXIT");
                System.out.println("");
                System.out.println("===================================================");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        Login.showLoginOptions(admins, speakers, attendees, scanner) ;   
                        cont = false;
                        break;
                        

                    case 2:
                        // Call the Registration class
                        RegistrationProcess.RegistrationProcess(admins, speakers, attendees, scanner);
                        break;

                    case 3:
                        System.out.println("Thank you. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }          

            }while (cont == true);


            boolean userCont = true;
            int choice;
            
            String cat = Login.cat();
            
            while(userCont == true){
                
                Monitoring monitor = new Monitoring(attendee, seminar, sb, seminarEnroll, slot);
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
                

                
                //Sample data for Report & Monitoring

                payment[0] = new Payment("Credit card", 200);
                payment[1] = new Payment("Online Banking", 200);

                attendee[0] = new Attendee("at", "at", "Attendee User", "attendee@example.com", "S1", payment[0]);
                attendee[1] = new Attendee("at", "at", "Attendee User", "attendee@example.com", "S2", payment[1]);
                attendee[2] = new Attendee("at", "at", "Attendee User", "attendee@example.com", "S2", payment[2]);

                seminarEnroll[0] = new SeminarEnroll(attendee[0], seminar[0]);
                seminarEnroll[1] = new SeminarEnroll(attendee[1], seminar[1]);
                seminarEnroll[2] = new SeminarEnroll(attendee[0], seminar[1]);

                sb[0] = new SlotBooking("Speaker User", slot[0], payment[0]);
                sb[1] = new SlotBooking("Speaker User", slot[1], payment[1]);

                
                if(cat.equals("Admin")){
                    
                    OOP.clScr();
                    System.out.println("===================================================");
                    System.out.println("                    Admin Menu");
                    System.out.println("");
                    System.out.println("1 - Monitor");
                    System.out.println("2 - Report");
                    System.out.println("");
                    System.out.println("0 - EXIT");
                    System.out.println("");
                    System.out.println("===================================================");
                    System.out.print("Choose an option: ");
                    choice = scanner.nextInt();
                    int userStatus = 1;
                    if(choice == 1){
                
                    
                        int monitorChoice = monitor.displayChoices();

                        //If usercont false then exit
                        if(monitorChoice != 0){

                            userCont = monitor.displayList(monitorChoice);           

                        }

                    }else if(choice == 2){
                        String nameCompare = Login.userId();

                        int reportChoice = report.generateList(userStatus);
                        if(reportChoice != 0){

                            userCont = report.generateReport(reportChoice, userStatus, nameCompare);             
                        }


                    }else if(choice == 0){
                        
                        
                        System.out.println("Thank you. Goodbye!");
                        System.out.println("\nPress any key to continue...");

                        userCont = false; 

                    }
                
                    
                    

                }else if(cat.equals("Speaker")){
                    OOP.clScr();
                    System.out.println("===================================================");
                    System.out.println("                   Speaker Menu");
                    System.out.println("");
                    System.out.println("1 - Slot Booking");
                    System.out.println("2 - Report");
                    System.out.println("3 - Advertisement");
                    System.out.println("");
                    System.out.println("0 - EXIT");
                    System.out.println("");
                    System.out.println("===================================================");
                    System.out.print("Choose an option: ");
                    choice = scanner.nextInt();
                    
                    userCont = false;
                    
                    int userStatus = 2;
                    String speaker = Login.userId();
                    //Booking
                    if(choice == 1){
                        SlotBooking slotBooking = new SlotBooking(speaker, null, null);

                //        EventBooking eb = new EventBooking();

                        userCont = slotBooking.eventBooking(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
                //        eb.eventBooking(scanner, speaker, sb, payment, availableSlots);      


                    //Report
                    }else if(choice == 2){

                        String nameCompare = Login.userId();
                        int reportChoice = report.generateList(userStatus);
                        if(reportChoice != 0){

                            userCont = report.generateReport(reportChoice, userStatus, nameCompare);             
                        }               

                    //Advertisement
                    }else if(choice == 3){

                        ArrayList<Advertisement> advertisements = new ArrayList<Advertisement>();

                        Date date;
                        Time time;

                        while (true) {
                        OOP.clScr();
                        System.out.println("===================================================");
                        System.out.println("              Advertisement Management");
                        System.out.println("");
                        System.out.println("1 - Create Advertisement");
                        System.out.println("2 - View Advertisements");
                        System.out.println("3 - Update Advertisement");
                        System.out.println("4 - Delete Advertisement");
                        System.out.println("");
                        System.out.println("0 - EXIT");
                        System.out.println("");
                        System.out.println("===================================================");

                            int advChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            switch (advChoice) {
                                case 1:
                                    Advertisement.createAdvertisement(advertisements, scanner);
                                    break;
                                case 2:
                                    Advertisement.viewAdvertisements(advertisements);
                                    break;
                                case 3:
                                    Advertisement.updateAdvertisement(advertisements, scanner);
                                    break;
                                case 4:
                                    Advertisement.deleteAdvertisement(advertisements, scanner);
                                    break;
                                case 0:
                                    System.out.println("Goodbye!");
                                    System.exit(0);
                                default:
                                    System.out.println("Invalid choice. Try again.");
                            }
                        }              



                    //End
                    }else if(choice == 0){

                        System.out.println("Thank you. Goodbye!");
                        System.out.println("\nPress any key to continue...");
                        scanner.nextLine();
                        userCont = false; 


                    }         
                    /*
                    
                    PC0 IS NETWORK OF 192.168.10.0/24, THE DEFAULT GATEWAU PC0 IS .1
                   WAN USING 10.0 30.0
                    PC3-PC5 PC4 USING .4 AND USING GATEWAY OF .1
                    
                    REACHING DEFAULT GATEWAY OF 0.0.0.0
                    REMOTE CONNECTION SENDING PACKET REQUIRE 0.0.0.0 BROADCASTED HERE
                    IF CNANOT REACH DESTINATION THEN SEND TO 0.0.0.0, BUT MUST HAVE GATEWAY OF LAST RESORT WHICH IS 192.168.30.1
                    DISCARD PACKET IF GATEWAY OF LAST RESORT IS NOT MENTIONED
                    
                    S* IS STATIC DEFAULT GATEWAY
                    
                    PC0 FROM THE NETWORK OF 10.0 WANTS TO SEND A PACKET TO PC5 (INSERT ADDRESS)
                    PC0 FORWARD S2 AND S2 FORWARD TO R0
                    REACHING R0 IT WILL CALC WHAT IS THE NA TO GO TO S3
                    IF GOT GO TO THE IP BUT IF DUN HAVE DISCARD
                    BEFORE DECIDING TO DISCARD, IT WILL FORWARD TOT HE PACKET OF LAST RESORT TO REACH THE STATIC DEFUALT WHICH IS 0.000
                    
                    AFTER SENDING, IT WILL HOP TO R1. R1 WILL OPEN WILL OPEN ROUTING INFO TO CHECK IF GOT MATCHING INFO
                    
                    IF MATCH = R1 WILL SEND THE PACKET TO PC5 BY FORWARDING THE PACKET TO S2 THEN TO PC5 THAT IS CONNECTED VIA FASTETHERNET
                    
                    ROUTING TABLE ARE USED TO CHECK DIRECTLY CONNECTED AND LAST RESORT
                    
                    
                    
                    
                    
                    */

                }else if(cat.equals("Attendee")){
                    
                    OOP.clScr();
                    System.out.println("===================================================");
                    System.out.println("                    Attendee Menu");
                    System.out.println("");
                    System.out.println("1 - Enroll Seminar");
                    System.out.println("");
                    System.out.println("0 - EXIT");
                    System.out.println("");
                    System.out.println("===================================================");
                    System.out.print("Choose an option: ");
                    choice = scanner.nextInt();
                    userCont = false;
                    
                    if(choice == 1){

                        String attendeeid = Login.userId();
                        SeminarEnroll seminarenroll = new SeminarEnroll(null, null);
                        seminarenroll.enroll(attendeeid, attendee, seminarEnroll, seminar, payment);


                    }else if(choice == 0){

                        System.out.println("Thank you. Goodbye!");
                        System.out.println("\nPress any key to continue...");
                        scanner.nextLine();                       
                        userCont = false; 


                    }
                   

                }


            }         
        
        
        
        }
        

    }
}
