
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

        slot[0] = new Slot("S1","SMK Bunga", "Secondary school hall", "8:00am", "12:00pm", "13/10/2023", Date.valueOf("2023-10-13"), Date.valueOf("2023-10-14"), 400, 350);
        slot[1] = new Slot("S2","Dewan Kulia", "Taman Kulia hall", "10:00am", "5:00pm", "20/10/2023", Date.valueOf("2023-10-20"), Date.valueOf("2023-10-21"), 250, 275);
        slot[2] = new Slot("S3","Dataran Murni", "Indoor hall", "8:00am", "3:00pm", "10/10/2023", Date.valueOf("2023-10-10"), Date.valueOf("2023-10-11"), 500, 600);
        slot[3] = new Slot("S4","SMK Kawi", "Secondary school hall", "8:00am", "11:00am", "30/10/2023", Date.valueOf("2023-10-30"), Date.valueOf("2023-10-30"), 200, 150);
        slot[4] = new Slot("S5","Dewan Wangsa Maju", "Wangsa Maju hall", "3:00pm", "7:00pm", "26/10/2023", Date.valueOf("2023-10-26"), Date.valueOf("2023-10-27"), 200, 220);

        seminar[0] = new Seminar("S1", "", Date.valueOf("2023-10-21"), Date.valueOf("2023-10-22"), Time.valueOf("15:30:00"), Time.valueOf("17:30:00"), 200, "KL", new ArrayList<>());
        seminar[1] = new Seminar("S2", "", Date.valueOf("2023-10-21"), Date.valueOf("2023-10-22"), Time.valueOf("16:30:00"), Time.valueOf("18:30:00"), 200, "KL", new ArrayList<>());       
        

        
        clScr();
        while(bigLoop == true){
            
            do {
                
                System.out.println("Welcome to the Seminar Management System!");
                System.out.println("------------------------------------------");
                System.out.println("Menu:");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
                System.out.print("Please enter the number: ");
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

                for(int i=0; i<5; i++){

                    availableSlots.add(slot[i]);
                }   
                
                //Sample data for Report & Monitoring

                /*
                    payment[0] = new Payment("Credit card", 200);
                    payment[1] = new Payment("Online Banking", 200);

                    attendee[0] = new Attendee("A1", "S1", payment[0]);
                    attendee[1] = new Attendee("A2", "S2", payment[1]);
                    attendee[2] = new Attendee("A3", "S2", payment[2]);

                    seminarEnroll[0] = new SeminarEnroll(attendee[0], seminar[0]);
                    seminarEnroll[1] = new SeminarEnroll(attendee[1], seminar[1]);
                    seminarEnroll[2] = new SeminarEnroll(attendee[0], seminar[1]);


                    //change "test" to admin name
                    sb[0] = new SlotBooking("test", slot[0], payment[0]);
                    sb[1] = new SlotBooking("test", slot[0], payment[0]);

                */



                
                if(cat.equals("Admin")){
                    clScr();
                    System.out.println("Admin Menu");
                    System.out.println("---------------------");
                    System.out.println("1 - Monitor");
                    System.out.println("2 - Report");
                    System.out.println("0 - Logout"); 
                    System.out.println("---------------------");
                    System.out.print("Choose an option: ");
                    choice = scanner.nextInt();
                    userCont = false;
                    
                    userCont = contPage(choice, cat, admins, speakers, attendees, scanner, slot, seminar, sb, payment, attendee, seminarEnroll, availableSlots);
                    

                }else if(cat.equals("Speaker")){
                    clScr();
                    System.out.println("Speaker Menu");
                    System.out.println("---------------------");
                    System.out.println("1 - Slot Booking");
                    System.out.println("2 - Report");              
                    System.out.println("3 - Advertisement");                
                    System.out.println("0 - Logout");                
                    System.out.println("---------------------");
                    System.out.print("Choose an option: ");
                    choice = scanner.nextInt();
                    
                    userCont = false;
                    bigLoop = false;
                    userCont = contPage(choice, cat, admins, speakers, attendees, scanner, slot, seminar, sb, payment, attendee, seminarEnroll, availableSlots);
                    

                }else if(cat.equals("Attendee")){
                    
                    clScr();
                    System.out.println("Attendee Menu");
                    System.out.println("---------------------");
                    System.out.println("1 - Enroll Seminar");
                    System.out.println("2 - Logout");                
                    System.out.println("---------------------");
                    System.out.print("Choose an option: ");
                    choice = scanner.nextInt();
                    userCont = false;
                    
                    userCont = contPage(choice, cat, admins, speakers, attendees, scanner, slot, seminar, sb, payment, attendee, seminarEnroll, availableSlots);
                   

                }


            }         
        
        
        
        }
        

    }
    public static boolean contPage(int choice, String category, List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees, Scanner scanner,
        Slot[] slot, Seminar[] seminar, SlotBooking[] sb, Payment[] payment, Attendee[] attendee, SeminarEnroll[] seminarEnroll, List<Slot> availableSlots){
        boolean userCont = true;


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

                //If usercont false then exit
                if(monitorChoice != 0){

                    userCont = monitor.displayList(monitorChoice);           
                }
                

            }else if(choice == 2){

                int reportChoice = report.generateList(userStatus);
                if(reportChoice != 0){

                    userCont = report.generateReport(reportChoice, userStatus);             
                }


            }else if(choice == 0){

                System.out.println("Thank you. Goodbye!");
                System.out.println("\nPress any key to continue...");

                welcomePage(admins, speakers, attendees, scanner);


            }



        }

        else if(category.equals("Speaker")){

            int userStatus = 2;
            String speaker = Login.userId();
            //Booking
            if(choice == 1){
                SlotBooking slotBooking = new SlotBooking(speaker, null, null);

        //        EventBooking eb = new EventBooking();

                slotBooking.eventBooking(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees);
        //        eb.eventBooking(scanner, speaker, sb, payment, availableSlots);      
                System.out.println(slotBooking);

            //Report
            }else if(choice == 2){

                int reportChoice = report.generateList(userStatus);
                report.generateReport(reportChoice, userStatus);                

            //Advertisement
            }else if(choice == 3){

                ArrayList<Advertisement> advertisements = new ArrayList<Advertisement>();

                Date date;
                Time time;

                while (true) {
                    System.out.println("Advertisement Manager");
                    System.out.println("1. Create Advertisement");
                    System.out.println("2. View Advertisements");
                    System.out.println("3. Update Advertisement");
                    System.out.println("4. Delete Advertisement");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");

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
                        case 5:
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
                welcomePage(admins, speakers, attendees, scanner);   


            }           
            return false;
        }else if(category.equals("Attendee")){

            if(choice == 1){

                String attendeeid = Login.userId();
                SeminarEnroll seminarenroll = new SeminarEnroll(null, null);
                seminarenroll.enroll(attendeeid, attendee, seminarEnroll, seminar, payment);


            }else if(choice == 2){

                welcomePage(admins, speakers, attendees, scanner);    


            }



        }





        return userCont;

    }
}
