/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop;

import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Monitoring extends MonitorAbstract {
    
    private String title;
    private ArrayList<SeminarEnroll> enrollData;
    private ArrayList<SlotBooking> bookingData;
    private ArrayList<SeminarEnroll> enrollMonitor;
    private ArrayList<Seminar> seminarInfo;
    private Seminar[] seminars;
    private SeminarEnroll[] seminarenrolls;
    private SlotBooking slotBooking;
    private String seminarCheck;
    private String[] seminarID;
    private String attendeeID;
    private int[] count;
    private SlotBooking[] slotbooking;
    private Slot[] slot;
    
    
    public Monitoring(Seminar[] seminars, SlotBooking[] slotbooking, SeminarEnroll[] seminarenrolls, Slot[] slot){
        
        enrollData = new ArrayList<>();
        bookingData = new ArrayList<>();
        this.seminars = seminars;
        this.slotbooking = slotbooking;
        this.seminarenrolls = seminarenrolls;
        this.slot = slot;
    }

    
    public void setTitle(String title){
        
        this.title = title;
    }
    
    public String getTitle(){
        
        return title;
    }
    
    public void setEnrollMonitor(ArrayList<SeminarEnroll> enrollMontior){
        
        this.enrollMonitor = enrollMonitor;
    }
    
    
    public ArrayList<SeminarEnroll> getEnrollMontior(){
        
        return enrollMonitor;
    }
    
    public void setSlotBooking(SlotBooking slotBooking){
        
        this.slotBooking = slotBooking;
    }
    
    public SlotBooking slotBooking(){
        
        return slotBooking;
    }
    
    public void addEnrollToMonitor(ArrayList<SeminarEnroll> enrolldata){
        
        enrollData.addAll(enrolldata);
    }
    
    public void addBookingToMonitor(ArrayList<SlotBooking> bookingdata){
        
        bookingData.addAll(bookingdata);
    }

    
    public int displayChoices(){

        OOP.clScr();
        boolean exit = false;
        
        Scanner scan = new Scanner(System.in);
        System.out.println("===================================================");
        System.out.println("               Choose an option");
        System.out.println("");
        System.out.println("1 - Update Slot");
        System.out.println("2 - Monitor Venue Start and End Time by Date");
        System.out.println("3 - Monitor Seminars by Time");
        System.out.println("0 - EXIT");
        System.out.println("");
        System.out.println("===================================================");
        System.out.print("Enter your choice:  ");

        
        int choice = scan.nextInt();
        if(choice == 0){

            exit = true;
        }
        
        //Validation
        while(choice > 3){
            
            choice = scan.nextInt();
            
            try {
                
                System.out.println("Please choose (0-3).");
                
                
            }catch(InputMismatchException e){
                
                System.out.println("Input must be a number");
            }

            
        }
        
        return choice;
    
    }
    
    public Time getStartTimeByID(String id){
        
        for(Seminar seminard: seminars){
               
            if(seminard != null){
                
                if(seminard.getID().equals(id)){

                    return seminard.getStartTime();
                }
                
            }
            
        }
        
        return null;
    }
    
    public Time getEndTimeByID(String id){
        
        for(Seminar seminard: seminars){
               
            if(seminard != null){
                
                if(seminard.getID().equals(id)){

                    return seminard.getEndTime();
                }
                
            }
        }
        
        return null;
    }


    
    
    public boolean displayList(int choice){
        
        Scanner scan = new Scanner(System.in);
        countAttendeeSeminar();
        boolean exit = true;
        
        //Search current enrolls by time
        if(choice == 1){
            
            int slotChoice;
            boolean status = true;
            
            
            do {

                int sb = 0;
                
                OOP.clScr();
                System.out.println("===================================================");
                System.out.println("               Choose an option");
                System.out.println("");
                System.out.println("1 - Search by Seminar ID");
                System.out.println("2 - Search by Username");
                System.out.println("");
                System.out.println("0 - EXIT");
                System.out.println("===================================================");
                System.out.print("Enter your choice:  ");

                slotChoice = scan.nextInt();
                
                //Validation
                if(slotChoice == 0){
                    exit = true;
                    status = false;
                }

                if(slotChoice > 2 && slotChoice != 0){

                    System.out.println("Please Choose again.");
                    System.out.print("> ");

                }else if(slotChoice != 0){
                    
                    //Check seminars
                    updateSlot(slotChoice);
                    
                }


            }while(status == true);            
        
                       
                    
        
        
        //Check venue
        }else if(choice == 2){

            int choiceVenue;
            boolean status = true;
            
            
            do {

                int sb = 0;
                OOP.clScr();
                System.out.println("===================================================");
                System.out.println("               Choose an option");
                System.out.println("");
                System.out.println("1 - Today Date");
                System.out.println("2 - Custom Date");
                System.out.println("");
                System.out.println("0 - EXIT");
                System.out.println("===================================================");
                System.out.print("Enter your choice:  ");
 
                choiceVenue = scan.nextInt();
                
                //Validation
                if(choiceVenue == 0){

                    status = false;
                    exit = true;
                }

                if(choiceVenue > 2 && choiceVenue != 0){

                    System.out.println("Please Choose again.");

                }else if(choiceVenue != 0){
                    
                    //Check venue
                    checkVenue(choiceVenue);
                    
                }


            }while(status == true);
            
        //Check seminars by time
        }else if(choice == 3){
            
            int ongoingChoice;
            boolean status = true;
            
            
            do {

                int sb = 0;
                OOP.clScr();
                System.out.println("===================================================");
                System.out.println("               Choose an option");
                System.out.println("");
                System.out.println("1 - Current Time");
                System.out.println("2 - Custom Time");
                System.out.println("");
                System.out.println("0 - EXIT");
                System.out.println("===================================================");
                System.out.print("Enter your choice:  ");

                ongoingChoice = scan.nextInt();
                
                //Validation
                if(ongoingChoice == 0){

                    status = false;
                    exit = true;
                }

                if(ongoingChoice > 2 && ongoingChoice != 0){

                    System.out.println("Please Choose again.");

                }else if(ongoingChoice != 0){
                    
                    //Check seminars
                    checkSeminars(ongoingChoice);
                    
                }


            }while(status == true);            
                 
        }
        
        return exit;
         
    }
  
    
    public void checkSeminars(int ongoingChoice){
        
        Time currentTime = new Time(System.currentTimeMillis());
        Time seminarStartTime;
        Time seminarEndTime;
        Scanner scan = new Scanner(System.in);
        

        if(ongoingChoice == 1){
            
            int count = 0;
            System.out.println("Current Time: " + currentTime);
            for(int i=0; i<seminarID.length; i++){
                
                seminarStartTime = getStartTimeByID(seminarID[i]);
                seminarEndTime = getEndTimeByID(seminarID[i]); 
                
                
                
                if(seminarID[i] != null){

                    if (currentTime.compareTo(seminarStartTime) >= 0 && currentTime.compareTo(seminarEndTime) <= 0) {

                        System.out.println(seminarID[i] + " is conducting.");
                        count++;

                    }


                }


            }

            if(count == 0){

                System.out.println("No seminars are being conducted right now.");

            }
     
            
        }else if(ongoingChoice == 2){
            
            System.out.print("Enter time in 24HR Format (HH:mm:ss): ");
            String userInput = scan.next();
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

            try {
                // Parse the user input into a java.util.Date (as we need a date to convert to java.sql.Time)
                java.util.Date utilDate = timeFormat.parse(userInput);

                // Convert the java.util.Date to a java.sql.Time
                java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());

                
                int count = 0;
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("Chosen Time: " + sqlTime);
                for(int i=0; i<seminarID.length; i++){

                    seminarStartTime = getStartTimeByID(seminarID[i]);
                    seminarEndTime = getEndTimeByID(seminarID[i]); 



                    if(seminarID[i] != null){

                        if (sqlTime.compareTo(seminarStartTime) >= 0 && sqlTime.compareTo(seminarEndTime) <= 0) {

                            System.out.println(seminarID[i] + " is conducting.");
                            count++;

                        }


                    }


                }

                if(count == 0){

                    System.out.println("No seminars are being conducted on " + sqlTime + ".");

                }               
                
                
                
                
            } catch (ParseException e) {
                
                System.out.println("Invalid time format. Please use HH:mm:ss.");
                System.out.println("Example: 23:20:10");
            }           
              
            
        }
        
                    
        System.out.println("\nPress enter to continue..");
        scan.nextLine();
        scan.nextLine();
        
        
            
        
                
    }
    
    
    public void checkVenue(int choiceVenue){
        
        Date currentDate = new Date();
        Time sqlTime = new Time(System.currentTimeMillis());
        Scanner scan = new Scanner(System.in);
        
        //Check slot time by venue
        Time slotStartTime;
        Time slotEndTime;
        Date slotStartDate;
        Date slotEndDate;
        
        SimpleDateFormat convertDate = new SimpleDateFormat("dd-MM-yyyy");
        int count = 0;
        
        for (int k = 0; k < slotbooking.length; k++) {
            
            if(slotbooking[k] != null){
                count++;
                if(choiceVenue == 1){

                    String formattedDate = convertDate.format(currentDate);
                    System.out.println("Current Date: " + formattedDate);
                    for(int i=0; i<slotbooking.length; i++){
                        
                        if(slotbooking[i] != null){
                            
                            slotStartDate = slotbooking[i].getStartDate();
                            slotEndDate = slotbooking[i].getEndDate();
                            slotStartTime = Time.valueOf(slotbooking[i].getStartTime());
                            slotEndTime = Time.valueOf(slotbooking[i].getEndTime());

                            int comparisonResult = currentDate.compareTo(slotStartDate);
                            if(comparisonResult < 0){

                                if(slotbooking[i] != null){

                                    System.out.println("The time of " + slotbooking[i].getVenue() + " is " + slotStartTime + " until " + slotEndTime);

                                    if (sqlTime.compareTo(slotStartTime) >= 0 && sqlTime.compareTo(slotEndTime) <= 0) {

                                        System.out.println(slotbooking[i].getVenue() + " is conducting.");

                                    }

                                }

                            }else{

                                System.out.println("No seminar is conducting on " + formattedDate + ".");
                            }
                            
                        }

                    }

                    //Less than 0 means its before

                }else if(choiceVenue == 2){

                    System.out.print("Enter a date (dd-MM-yyyy): ");
                    boolean status = false;
                    String userInput = scan.next();

                    do {

                        try {

                            // Parse the user input into a java.util.Date
                            java.util.Date utilDate = convertDate.parse(userInput);

                            // Convert the java.util.Date to a java.sql.Date in the desired format
                            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                            // Format the date as "yyyy-MM-dd"
                            String formattedDate = convertDate.format(sqlDate);

                            System.out.printf("\nDate: %-50s ", formattedDate);
                            System.out.println("Current Date: " + formattedDate);

                            for(int i=0; i<slotbooking.length; i++){
                                
                                if(slotbooking[i] != null){
                                    
                                    slotStartDate = slotbooking[i].getStartDate();
                                    slotEndDate = slotbooking[i].getEndDate();
                                    slotStartTime = Time.valueOf(slotbooking[i].getStartTime());
                                    slotEndTime = Time.valueOf(slotbooking[i].getEndTime());                        

                                    int comparisonResult = sqlDate.compareTo(slotStartDate);
                                    if(comparisonResult < 0){

                                        if(slotbooking[i] != null){

                                            System.out.println("The time of " + slotbooking[i].getVenue() + " is " + slotStartTime + " until " + slotEndTime);

                                            if (sqlTime.compareTo(slotStartTime) >= 0 && sqlTime.compareTo(slotEndTime) <= 0) {

                                                System.out.println(slotbooking[i].getVenue() + " is conducting.");

                                            }

                                        }

                                    }else{

                                        System.out.println("No seminar is conducting on " + formattedDate + ".");
                                    }
                                    
                                }
                            }

                            //Less than 0 means its before



                        } catch (ParseException e) {

                            status = true;
                            System.out.println("Invalid date format. Please use dd-MM-yyyy.");

                        }

                    }while(status == true);

                }

                System.out.println("\nPress enter to continue..");
                scan.nextLine();            

            }else{
                
                if(count<=0){
                    
                    System.out.println("There are no bookings at the moment..");
                    System.out.println("\nPress enter to continue..");
                    scan.nextLine();  
                    break;
                }
            }         
            
        }
        
        
        
    }
    
    
    public void updateSlot(int slotChoice){
        
        Scanner scan = new Scanner(System.in);
        
        

        /*
        
        Slot is for speakers, seminar is for attendees.
        
        Basically, slot is updateable but seminars are not for attendees.
        Slot is same as Seminar but different name for different person
        
        Speaker books a slot (seminar)
        Seminar enrolls seminar (slot booked by speaker)
        
        */
        
        int count = 0;
        if(slotChoice == 1){

            System.out.println("Input a Slot/Seminar ID: ");
            String userInput = scan.nextLine();
            
            for (int i = 0; i < slot.length; i++) {
                
                if(slot[i] != null){

                    count++;
                    String slotID = slot[i].getID();
                    if(userInput.equals(slotID)){
                        
                        OOP.clScr();
                        System.out.println("");

                        System.out.println("What do you wanna change?");
                        System.out.println("0 - EXIT");
                        System.out.println("1 - Venue");
                        System.out.println("2 - Time");
                        System.out.println("3 - Date");
                        System.out.println("4 - Description");
                        System.out.println("5 - Seat Number");
                        System.out.println("6 - Price");
                        System.out.println("");
                        System.out.print("> ");
                        int updateChoice = scan.nextInt();
                        scan.nextLine();
                        
                        //Exit
                        if(updateChoice == 0){
                            break;
                            
                        //Venue
                        }else if(updateChoice == 1){
                            
                            System.out.println("Input the new venue: ");
                            String updateInput = scan.nextLine();
                            
                            String original = slot[i].getVenue();
                     
                            slot[i].setVenue(updateInput);
                            System.out.println("Original: " + original);
                            System.out.println("Modified: " + slot[i].getVenue());

                            System.out.println("\nPress enter to continue..");
                            scan.nextLine();
                            
                        //Time
                        }else if(updateChoice == 2){
                            
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Please choose an option.");
                            System.out.println("1 - Update Start Time");
                            System.out.println("2 - Update End Time");
                            int choiceTime = scan.nextInt();
                            scan.nextLine();
                            String updateInput = "";
                            
                            if(choiceTime == 1){
                                
                                boolean status = false;
                                
                                System.out.print("Input the new Start Time in 24HR Format (HH:mm:ss): ");
                                
                                //Error occured status will be true
                                do {
                                    
                                
                                    try {
                                        
                                        updateInput = scan.nextLine();
                                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                                        // Parse the user input into a java.util.Date (as we need a date to convert to java.sql.Time)
                                        java.util.Date utilDate = timeFormat.parse(updateInput);

                                        // Convert the java.util.Date to a java.sql.Time
                                        java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
                                        
                                        if(sqlTime != null){
                                            
                                            status = false;
                                        }

                                    } catch (ParseException e) {

                                        System.out.println("Invalid time format. Please use HH:mm:ss.");
                                        System.out.println("Example: 23:20:10");
                                        System.out.println("Input the new Start Time in 24HR Format (HH:mm:ss):");
                                        status = true;
                                    
                                    }
                                    
                                }while(status == true);
                                
                                String original = slot[i].getStartTime();
                     
                                slot[i].setStartTime(updateInput);
                                System.out.println("Original: " + original);
                                System.out.println("Modified: " + slot[i].getStartTime());
                                
                            }else if(choiceTime == 2){
                                
                                boolean status = false;
                                
                                System.out.print("Input the new End Time in 24HR Format (HH:mm:ss): ");
                                
                                //Error occured status will be true
                                do {
                                    
                                
                                    try {
                                        
                                        updateInput = scan.nextLine();
                                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                                        // Parse the user input into a java.util.Date (as we need a date to convert to java.sql.Time)
                                        java.util.Date utilDate = timeFormat.parse(updateInput);

                                        // Convert the java.util.Date to a java.sql.Time
                                        java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
                                        
                                        if(sqlTime != null){
                                            
                                            status = false;
                                        }

                                    } catch (ParseException e) {

                                        System.out.println("Invalid time format. Please use HH:mm:ss.");
                                        System.out.println("Example: 23:20:10");
                                        System.out.println("Input the new End Time in 24HR Format (HH:mm:ss):");
                                        status = true;
                                    
                                    }
                                    
                                }while(status == true);
                                 
                                
                                String original = slot[i].getEndTime();
                     
                                slot[i].setEndTime(updateInput);
                                System.out.println("Original: " + original);
                                System.out.println("Modified: " + slot[i].getEndTime());        
                            }

                            System.out.println("\nPress enter to continue..");
                            scan.nextLine();
                            
                        //Date
                        }else if(updateChoice == 3){
                            
                            System.out.println("");
                            System.out.println("");
                            System.out.println("Please choose an option.");
                            System.out.println("1 - Update Start Date");
                            System.out.println("2 - Update End Date");
                            int choiceDate = scan.nextInt();
                            scan.nextLine();
                            String updateInput = "";                       
                            boolean status = true;
                            SimpleDateFormat convertDate = new SimpleDateFormat("dd-MM-yyyy");
                            
                            if(choiceDate == 1){
                                
                                System.out.print("Enter a date (dd-MM-yyyy): ");
                                
                                do {
                                    
                                    updateInput = scan.nextLine();
                                    
                                    try {

                                        // Parse the user input into a java.util.Date
                                        java.util.Date utilDate = convertDate.parse(updateInput);

                                        // Convert the java.util.Date to a java.sql.Date in the desired format
                                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                                        if(sqlDate != null){
                                            
                                            Date original = slot[i].getStartDate();
                                            slot[i].setStartDate(sqlDate);
                                            status = false;
                                

                                            System.out.println("Original: " + original);
                                            System.out.println("Modified: " + slot[i].getStartDate());  
                                                                            
                                            
                                        }



                                    } catch (ParseException e) {

                                        status = true;
                                        System.out.println("Invalid date format. Please use dd-MM-yyyy.");
                                        System.out.print("Enter a date (dd-MM-yyyy): ");

                                    }
                                    

                                }while(status == true);       

                            }else if(choiceDate == 2){
                                
                                System.out.print("Enter a date (dd-MM-yyyy): ");
                                
                                do {
                                    
                                    updateInput = scan.nextLine();
                                    
                                    try {

                                        // Parse the user input into a java.util.Date
                                        java.util.Date utilDate = convertDate.parse(updateInput);

                                        // Convert the java.util.Date to a java.sql.Date in the desired format
                                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                                        if(sqlDate != null){
                                            
                                            Date original = slot[i].getEndDate();
                                            slot[i].setEndDate(sqlDate);
                                            System.out.println("Original: " + original);
                                            System.out.println("Modified: " + slot[i].getEndDate());
                                            status = false;
                                        }



                                    } catch (ParseException e) {

                                        status = true;
                                        System.out.println("Invalid date format. Please use dd-MM-yyyy.");
                                        System.out.print("Enter a date (dd-MM-yyyy): ");

                                    }
                                    

                                }while(status == true);       
                                
                                
                                System.out.println("\nPress enter to continue..");
                                scan.nextLine();
                                                                 
                                
                            }
                            
                        //Description    
                        }else if(updateChoice == 4){
                            
                            System.out.println("Input the new Description: ");
                            String updateInput = scan.nextLine();
                            
                            String original = slot[i].getDesc();
                     
                            slot[i].setDesc(updateInput);
                            System.out.println("Original: " + original);
                            System.out.println("Modified: " + slot[i].getDesc());

                            System.out.println("\nPress enter to continue..");
                            scan.nextLine();
                            
                        //Seat Number
                        }else if(updateChoice == 5){
                            
                            System.out.println("Input the new Number of Seat Numbers: ");
                            int updateInput = scan.nextInt();
                            
                            int original = slot[i].getSeatNo();
                     
                            slot[i].setSeatNo(updateInput);
                            System.out.println("Original: " + original);
                            System.out.println("Modified: " + slot[i].getSeatNo());                        

                            System.out.println("\nPress enter to continue..");
                            scan.nextLine();
                                                                 
                                                            
                        //Price   
                        }else if(updateChoice == 6){
                            
                            System.out.println("Input the new Price: ");
                            double updateInput = scan.nextDouble();
                            
                            double original = slot[i].getPrice();
                     
                            slot[i].setPrice(updateInput);
                            System.out.printf("Original: RM%.2f", original);
                            System.out.printf("Modified: RM%.2f", slot[i].getPrice());         

                            System.out.println("\nPress enter to continue..");
                            scan.nextLine();                        
                        
                        }
                        
                            
                    }
                    
                }else{
                    
                    if(count<=0){
                    
                        System.out.println("There are no slots at the moment..");
                        System.out.println("\nPress enter to continue..");
                        scan.nextLine();  
                        break;
                    }  
                }
                    
            }
            
            
        }else if(slotChoice == 2){
            
            
            
            
        }
        
        
        
    }        
    

  
    public void countAttendeeSeminar(){
        
        // Directly access the private field
        ArrayList<SeminarEnroll> enrollments = enrollData;
        seminarID = new String[100];
        count = new int[100];
        for(int a=0; a<count.length; a++){

            count[a] = 0;
        }

        //Process of counting how many attendees for each seminar
        for(int i=0; i<enrollments.size(); i++){

            SeminarEnroll enrollment = enrollments.get(i);
            String enrollString = enrollment.toString();
            String[] parts = enrollString.split("-");
            boolean exists = false;

            if(parts.length == 2){

                attendeeID = parts[0];
                seminarCheck = parts[1];
                for(int j=0; j<i; j++){

                    if(seminarID[j] != null && seminarID[j].equals(seminarCheck)){

                        exists = true;
                        for(int k=0; k<enrollments.size(); k++){

                            if(seminarID[k] != null && seminarID[k].equals(seminarCheck)){

                                System.out.println();
                                count[k]++;
                            }
                        }
                    }

                }

                if(exists == false){

                    int slot = -1;

                    for (int k = 0; k < seminarID.length; k++) {
                        if (seminarID[k] == null) {
                            slot = k;
                            break;
                        }
                    }

                    if (slot != -1) {
                        seminarID[slot] = seminarCheck;
                        count[slot] = 1;
                    }   

                    seminarID[i] = seminarCheck;
                }




            }

        } 
        
        
        
    }
    
    
}

/*
            ArrayList<SlotBooking> booking = bookingData;
            String start = "";
            String endTime = "";
            String venueTime = "";
            String[] arrVenue = new String[100];
            int j = 0;

            //Process of checking whether the booking is in a range of a given time
            for(int i=0; i<booking.size(); i++){
                
                String bookingString = booking.toString();
                String[] lines = bookingString.split("\n");
                
                //might change
                for(String line: lines){
                    
                    
                    if(line.startsWith("Start time:")){
                        
                        startTime = line.substring("Start time:".length());

                    }else if(line.startsWith("End time:")){
                        
                        endTime = line.substring("End time:".length());
                        
                    }
                    

                }
                
                
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    Date date = sdf.parse(startTime);
                    Time sqlTime = new Time(date.getTime());
                    Date date2 = sdf.parse(endTime);
                    Time sqlTime2 = new Time(date.getTime());
                    
                    Time seminarStartTime = getStartTimeByID(seminarID[0]);
                    Time seminarEndTime = getEndTimeByID(seminarID[0]);
                    
                    
                    
                    //Validation
                    if (sqlTime.compareTo(seminarStartTime) >= 0 && sqlTime2.compareTo(seminarEndTime) <= 0) {
                        System.out.println("Current time is between start time and end time.");
                    } else {
                        System.out.println("Current time is not between start time and end time.");
                    }
                    
                    
                    
                    
                }catch(ParseException e){
                    
                    e.printStackTrace();
                    
                }         
                
            }



*/
