package com.mycompany.oop;

import static com.mycompany.oop.OOP.clScr;
import static com.mycompany.oop.welcomePage.welcomePage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class SlotBooking {
    private String speaker;
    private Slot slot;
    private Payment payment;

    private static int numOfBooking = 0;
    private ArrayList<SlotBooking> bookingList; //added
    
    private static Payment paymentClass = new Payment();
    
    public SlotBooking(String speaker, Slot slot, Payment payment){

        this.speaker = speaker;
        speaker = Login.userId();
        this.slot = slot;
        this.payment = payment;
        numOfBooking++;
        bookingList = new ArrayList<>();
    }
    
    public void setSeatNo(int seatNo){
        
        slot.setSeatNo(seatNo);
    }
    
    public String getID(){
     
        return slot.getID();
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
    
    public Date getStartDate(){
        
        return slot.getStartDate();
    }
    public Date getEndDate(){
        
        return slot.getEndDate();
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
    
    public void addSlotBooking(SlotBooking slotbooking){
        
        
        bookingList.add(slotbooking);
    }
    
    public void deleteSlotBooking(){
        
        bookingList.clear();
    }    
    
    public ArrayList<SlotBooking> getBookingList(){
        
        return bookingList;
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
    
    public static void eventBooking(Scanner scanner, String speaker, SlotBooking[] sb, Payment[] payment, List<Slot> availableSlots, List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees, Seminar[] seminar, Slot[] slot){
        
        while(true){
            clScr();
            System.out.println("\nEvent Booking");
            System.out.println("--------------");
            System.out.println("1. Slot available");
            System.out.println("2. Booking slot");
            System.out.println("3. Slot management");
            System.out.println("\n0. Quit");
            int choice = 0;       
            try{
                System.out.print("Your Choice: ");
                choice = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            
            if (choice == 1){
                bookingDetails(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
            }    

            else if (choice == 2){
                contBooking(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
            }

            else if (choice == 3){
                choiceBookingManagement(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
                break;
            }

            else if (choice == 0){
                
                welcomePage(admins, speakers, attendees, scanner);   
                break;
            }

            else
                System.out.println("Invalid choice. Please try again");               
        }
    }
    public static void bookingDetails(Scanner scanner, String speaker, SlotBooking[] sb, Payment[] payment, List<Slot> availableSlots, List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees, Seminar[] seminar, Slot[] slot){
        clScr();
        boolean continueBooking = true;
        Comparator<Slot> currentComparator = new SlotDateComparator();
        while(continueBooking){
            int choice5 = 0;
            System.out.println("Filter Options in Ascending:");
            System.out.println("-----------------------------");            
            System.out.println("1. Sort by Date");
            System.out.println("2. Sort by Price");
            System.out.println("3. Continue booking");
            System.out.println("\n0. Quit");

            try {
                System.out.print("Your Choice: ");
                choice5 = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (choice5 == 1){
                currentComparator = new SlotDateComparator();
            }
            else if (choice5 == 2){
                currentComparator = new SlotPriceComparator();
            }
            else if (choice5 == 3){
                contBooking(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
                continueBooking = false;
            }  
            else if (choice5 == 0){
                eventBooking(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
                continueBooking = false;
            }
            else{
                System.out.println("Invalid Choice. Please try again");
            }

            int choice3 =0;   
            if (choice5 == 1 || choice5 == 2) {
                clScr();
                availableSlots.sort(currentComparator);
                for (int i = 0; i < availableSlots.size(); i++) {
                    Slot slotToDisplay = availableSlots.get(i);
                    System.out.println((i + 1) + ". " + slotToDisplay.toString());
                }

                System.out.println("\n1. Continue booking");
                System.out.println("0. Quit");
                try{
                    System.out.print("Your Choice: ");
                    choice3 = scanner.nextInt();
                }
                catch (InputMismatchException e) {
                    scanner.nextLine();
                }
                if (choice3 == 1){
                    contBooking(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
                    continueBooking = false;
                }
                else if(choice3 == 0){
                    continueBooking = false;
                }
                else{
                    System.out.println("Invalid Choice. Please try again");
                }
            } 
        }
    } 
    
    public static void contBooking(Scanner scanner, String speaker, SlotBooking[] sb, Payment[] payment, List<Slot> availableSlots, List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees, Seminar[] seminar, Slot[] slot){
        clScr();
        boolean indicate = true;
        while(indicate){
            System.out.println("Event Booking");
            System.out.println("--------------");
            System.out.println("Which slots you prefer:");
            int numOfSlot = 0;

            for (int i = 0; i < availableSlots.size(); i++) {
                Slot slotToDisplay = availableSlots.get(i);
                System.out.println((i + 1) + ". " + slotToDisplay.getVenue());
                numOfSlot++;
            }

            int quit = numOfSlot + 1;
            System.out.println("\n0. Quit");
            int choice2 = 0;
            int idSB = 0;
            try{
                System.out.print("Your Choice: ");
                choice2 = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            if (choice2 > 0 && choice2<quit){
                choice2 -=1 ;
                Slot chosenSlot = availableSlots.get(choice2);
                double slotPrice = chosenSlot.getPrice();
                if(paymentClass.eventPayment(scanner, payment, slotPrice)){
                    int numOfBooking = SlotBooking.getNumOfBooking();
                    int numOfPayment = Payment.getNumOfPayment();
                    sb[numOfBooking] = new SlotBooking(speaker, chosenSlot, payment[numOfPayment-1]);
                    clScr();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formattedDate = dateFormat.format(payment[numOfPayment-1].getDate());
                    System.out.println("Receipt\t\t\t\t    "+ formattedDate);
                    System.out.println("-----------");                    
                    System.out.print(sb[numOfBooking].toString());
                    
                    
                    System.out.println("\nPress any key to continue...");
                    scanner.nextLine();
                    scanner.nextLine();
                    String idValue = "";
                    
                    int idIndex = sb[numOfBooking].toString().indexOf("ID: ");

                    if (idIndex != -1) {
                        // Extract the ID value by taking the substring after "ID: " and up to the next newline character
                        int newlineIndex = sb[numOfBooking].toString().indexOf("\n", idIndex);

                        if (newlineIndex != -1) {
                            idValue = sb[numOfBooking].toString().substring(idIndex + 4, newlineIndex).trim();
                            
                            
                        }
                    }   

                    switch(idValue){


                        case "S1": idSB = 0; break;
                        case "S2": idSB = 1; break;
                        case "S3": idSB = 2; break;
                        case "S4": idSB = 3; break; 
                        case "S5": idSB = 4; break;
                        default: idSB = 0; break;

                    }

                    int semCount = Seminar.getSeminarCount();
                    
                    try {

                        System.out.println(chosenSlot);
                        // Create a SimpleDateFormat with the desired time format
                        SimpleDateFormat dateform = new SimpleDateFormat("HH:mm:ss");

                        // Parse the string to obtain a Date object
                        java.util.Date date = dateform.parse(slot[idSB].getStartTime());
                        java.util.Date date2 = dateform.parse(slot[idSB].getEndTime());

                        // Convert the Date object to java.sql.Time
                        java.sql.Time sqlTime = new java.sql.Time(date.getTime());
                        java.sql.Time sqlTime2 = new java.sql.Time(date2.getTime());

                        seminar[semCount] = new Seminar(slot[idSB].getID(), "" ,slot[idSB].getStartDate(), slot[idSB].getEndDate(), sqlTime, sqlTime2, slot[idSB].getPrice(), speaker, new ArrayList<>());
                        System.out.println(seminar[semCount].output());

                   } catch (ParseException e) {

                       // Handle parsing errors, such as invalid time format
                       e.printStackTrace();
                   }

                        

                        
                                 
                    

                    availableSlots.remove(choice2);

                }
                
                
                else if (choice2 == 0){
                    eventBooking(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
                }
                else{
                    System.out.println("Payment canceled. Returning to booking...");
                }
                break;
            }
            else if (choice2 == quit){
                eventBooking(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
            }
            else
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void choiceBookingManagement(Scanner scanner, String speaker, SlotBooking[] sb, Payment[] payment, List<Slot> availableSlots, List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees, Seminar[] seminar, Slot[] slot){
        clScr();
        System.out.println("\nBooking Management");
        System.out.println("---------------------");
        System.out.println("1. Booked event");
        System.out.println("2. Refund");
        System.out.println("\n0. Quit");
        int choice = 0;
        try{
                System.out.print("Your Choice: ");
                choice = scanner.nextInt();
            }
        catch (InputMismatchException e) {
            scanner.nextLine();
        }
        if (choice == 1){
            viewBookedEvents(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
        }
        
        else if (choice == 2) {
            cancelBookedEvents(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
        }
        
        else if (choice == 0) {
            eventBooking(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
        }
        
        else{
            System.out.println("Invalid choice. Please try again");
        }
    }
    
    public static void viewBookedEvents(Scanner scanner, String speaker, SlotBooking[] sb, Payment[] payment, List<Slot> availableSlots, List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees, Seminar[] seminar, Slot[] slot) {
        clScr();
        System.out.println("\nBooked Events");
        System.out.println("---------------");
        int num = 1;
        int[] venueNum = new int[100];
        for (int i = 0; i < sb.length; i++) {
            if (sb[i] != null && sb[i].getSpeaker().equals(speaker)) {
                System.out.println(num + ". " + sb[i].getVenue());
                venueNum[num-1]= i;
                num ++;
            }
        }
        System.out.println("\n0. Quit");
        int choice5 = 0;
        try{
                System.out.print("Your Choice: ");
                choice5 = scanner.nextInt();
            }
        catch (InputMismatchException e) {
            scanner.nextLine();
        }
        if (choice5 == 0) {
            choiceBookingManagement(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
        }
        else if (choice5 >0 && choice5 <= num){
            int num1 = venueNum[choice5-1];
             System.out.println(sb[num1].toString());
             
            System.out.println("\nPress any key to continue...");
            scanner.nextLine();
            scanner.nextLine();
            
            choiceBookingManagement(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);               
                     
        }
        else
            System.out.println("Invalid choice. Please try again");
    }

    public static void cancelBookedEvents(Scanner scanner, String speaker, SlotBooking[] sb, Payment[] payment, List<Slot> availableSlots, List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees, Seminar[] seminar, Slot[] slot) {
        clScr();
        while(true){
            System.out.println("\nBooked Events");
            System.out.println("---------------");
            int num = 1;
            for (int i = 0; i < sb.length; i++) {
                if (sb[i] != null && sb[i].getSpeaker().equals(speaker)) {
                    System.out.println((num) + ". " + sb[i].getVenue());
                    System.out.println("RM" + sb[i].getPrice());   
                    num++;
                }
            }
            System.out.println("\n0. Quit");
            int eventNumber = 0;        
            try{
                    System.out.print("Enter the number of the event to refund: ");
                    eventNumber = scanner.nextInt();
                }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }

            if (eventNumber >= 1 && eventNumber <= sb.length && sb[eventNumber-1] != null && sb[eventNumber-1].getSpeaker().equals(speaker)) {  
                Slot canceledSlot = sb[eventNumber-1].getSlot();
                double refund = sb[eventNumber-1].getPrice();
                availableSlots.add(canceledSlot);
                for (int i = eventNumber - 1; i < sb.length - 1; i++) {
                    sb[i] = sb[i + 1];
                }

                sb[sb.length - 1] = null;

                System.out.println("Event canceled successfully.");
                System.out.println("RM" + refund + " is refund successfully. ");
                System.out.println("\nPress any key to continue...");
                scanner.nextLine();
                scanner.nextLine();

                choiceBookingManagement(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);

            } 
            else if (eventNumber == 0){
                choiceBookingManagement(scanner, speaker, sb, payment, availableSlots, admins, speakers, attendees, seminar, slot);
            }
            else {
                System.out.println("Invalid event number or not your event. Please try again.");
            }
        }
        
    }
}

