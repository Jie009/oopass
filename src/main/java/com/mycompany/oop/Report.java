/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Report {
    
    private String title;
    private SeminarEnroll seminarEnroll;
    private ArrayList<SeminarEnroll> enrollData;
    private String seminarCheck;
    private String[] seminarID;
    private Attendee[] attendee;
    private String attendeeID;
    private Seminar[] seminars;
    private int[] count;
    private SlotBooking[] slotbooking;
    private SlotBooking slotBooking;
    private SeminarEnroll[] seminarenrolls;
        
    public Report(Seminar[] seminars, SlotBooking[] slotbooking, SeminarEnroll[] seminarenrolls, Attendee[] attendee){
        
        enrollData = new ArrayList<>();
        this.seminars = seminars;
        this.slotbooking = slotbooking;
        this.seminarenrolls = seminarenrolls; 
        this.attendee = attendee;
    }

    
    public Time getStartTimeByID(String id){
        
        for(Seminar seminard: seminars){
               
            if(seminard.getID().equals(id)){
                
                return seminard.getStartTime();
            }
        }
        
        return null;
    }
    
    public Time getEndTimeByID(String id){
        
        for(Seminar seminard: seminars){
           
            if(seminard.getID().equals(id)){
                
                return seminard.getEndTime();
            }
        }
        
        return null;
    }
    
    public void addToReport(ArrayList<SeminarEnroll> data){
        
        enrollData.addAll(data);
    }
    
    public int generateList(int category){
        
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        System.out.println("What report do you wanna generate?");
        
        if(category == 1){
            
            System.out.println("0 - EXIT");
            System.out.println("1 - Total Attendees Joined for Seminar");
            System.out.println("2 - Top Payment Methods");
            System.out.println("3 - Financial Report for Seminar");
            System.out.println("4 - Total Slot Bookings by Date");
        
            choice = scan.nextInt();
        
            //Validation
            while(choice >= 4 || choice == 0){

                choice = scan.nextInt();

                try {

                    System.out.println("Please choose a number.");


                }catch(InputMismatchException e){

                    System.out.println("Input must be a number");
                }


            }

            return choice;              
            
            
            
            
        }else if(category == 2){
            
            System.out.println("0 - EXIT");
            System.out.println("1 - Total Attendees Joined for Seminar");
            System.out.println("2 - Financial Report for Seminar");       
            choice = scan.nextInt();

            //Validation
            while(choice > 4 || choice == 0){

                choice = scan.nextInt();

                try {

                    System.out.println("Please choose a number.");


                }catch(InputMismatchException e){

                    System.out.println("Input must be a number");
                }


            }

            return choice;          
        
        
        }
        
        return choice;

    }
    
    public void generateReport(int reportChoice, int category){
        
        splitID();
        Scanner scan = new Scanner(System.in);
        
        if(category == 1){
            
            if(reportChoice == 1){

                int attendeechoice;
                boolean status = true;


                do {

                    int sb = 0;
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("------------------------------------------");
                    System.out.println("            Choose an option.");
                    System.out.println("------------------------------------------");
                    System.out.println("-1 - Exit");
                    System.out.println("1 - All Seminars");
                    System.out.println("2 - Search by a Seminar");
                    System.out.println("");
                    attendeechoice = scan.nextInt();

                    //Validation
                    if(attendeechoice == -1){

                        status = false;
                        break;
                    }

                    if(attendeechoice > 2){

                        System.out.println("Please Choose again.");

                    }else{


                        countAttendeeSeminar(attendeechoice);

                    }


                }while(status == true);             


            }else if(reportChoice == 2){

                int paymentChoice;
                boolean status = true;

                do {

                    int sb = 0;
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("------------------------------------------");
                    System.out.println("            Choose an option.");
                    System.out.println("------------------------------------------");
                    System.out.println("-1 - Exit");
                    System.out.println("1 - Payment by Attendee");
                    System.out.println("2 - Payment by Speaker");
                    System.out.println("");
                    paymentChoice = scan.nextInt();

                    //Validation
                    if(paymentChoice == -1){

                        status = false;
                        break;
                    }

                    if(paymentChoice > 2){

                        System.out.println("Please Choose again.");

                    }else{


                        generateTopPayment(paymentChoice);


                    }


                }while(status == true);   






            }else if(reportChoice == 3){

                checkSeminars();
                
                
            //exit
            }else if(reportChoice == 4){

                checkBooking();

            }else if(reportChoice == 0){


            }

            
            
        }else if(category == 2){
            
            if(reportChoice == 1){

                int attendeechoice;
                boolean status = true;


                do {

                    int sb = 0;
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("------------------------------------------");
                    System.out.println("            Choose an option.");
                    System.out.println("------------------------------------------");
                    System.out.println("-1 - Exit");
                    System.out.println("1 - All Seminars");
                    System.out.println("2 - Search by a Seminar");
                    System.out.println("");
                    attendeechoice = scan.nextInt();

                    //Validation
                    if(attendeechoice == -1){

                        status = false;
                        break;
                    }

                    if(attendeechoice > 2){

                        System.out.println("Please Choose again.");

                    }else{


                        countAttendeeSeminar(attendeechoice);

                    }


                }while(status == true);             


            }else if(reportChoice == 2){

                checkSeminars();

            }else if(reportChoice == 0){


            }else{


            }
            
            
        }
        
        
        
        

    }
    
    public void generateTopPayment(int paymentChoice){
        
        int count = 0;
        int count2 = 0;

        String[] method = { "Credit card", "Online Banking", "Touch & Go", "Cash" };
        int[] methodCount = new int[4];
        Scanner scan = new Scanner(System.in);

        if(paymentChoice == 1){
            
            for(int k=0; k<attendee.length; k++){
                
                if(attendee[k] != null){
                    
                    count++;
                    for(int i=0; i<attendee.length; i++){


                        for(int j=0; j<method.length; j++){

                            if(attendee[i].getMethod().equals(method[j])){

                                    methodCount[j]++;
                            }
                        }
                    }

                    List<ReportPaymentComparable> paymentMethods = new ArrayList<>(); 
                    paymentMethods.clear();

                    paymentMethods = Arrays.asList(

                       new ReportPaymentComparable("Credit card", methodCount[0]),
                       new ReportPaymentComparable("Online Banking", methodCount[1]),
                       new ReportPaymentComparable("Touch & Go", methodCount[2]),
                       new ReportPaymentComparable("Cash", methodCount[3])

                   );


                   // Sort paymentMethods based on counts
                   Collections.sort(paymentMethods);

                    System.out.println("");
                    System.out.printf("%-30s", "Top Payment Method for Attendee");
                    System.out.println("");
                   // Print the sorted payment methods
                   for (ReportPaymentComparable methodObj : paymentMethods) {
                       System.out.println(methodObj);
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

        }else if(paymentChoice == 2){
            
            for(int k=0; k<slotbooking.length; k++){
                
                if(slotbooking[k] != null){
                    
                    count2++;
                    for(int i=0; i<slotbooking.length; i++){


                        for(int j=0; j<method.length; j++){

                            if(slotbooking[i].getMethod().equals(method[j])){

                                methodCount[j]++;
                            }
                        }
                    }

                    List<ReportPaymentComparable> paymentMethods = new ArrayList<>(); 
                    paymentMethods.clear();

                    paymentMethods = Arrays.asList(

                       new ReportPaymentComparable("Credit card", methodCount[0]),
                       new ReportPaymentComparable("Online Banking", methodCount[1]),
                       new ReportPaymentComparable("Touch & Go", methodCount[2]),
                       new ReportPaymentComparable("Cash", methodCount[3])

                   );


                   // Sort paymentMethods based on counts
                   Collections.sort(paymentMethods);

                    System.out.println("");
                    System.out.printf("%-30s", "Top Payment Method for Slot Booking");
                    System.out.println("");
                   // Print the sorted payment methods
                   for (ReportPaymentComparable methodObj : paymentMethods) {
                       System.out.println(methodObj);
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

     
    }

    
    public void setTitle(String title){
        
        this.title = title;
    }
    
    public String getTitle(){
        
        return title;
    }

    public void setSeminarEnroll(SeminarEnroll seminarEnroll){
        
        this.seminarEnroll = seminarEnroll;
    }
    
    public SeminarEnroll getSeminarEnroll(){
        
        return seminarEnroll;
    }
    
    public void splitID(){
        
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
    
    public void countAttendeeSeminar(int attendeechoice){
        
        Scanner scan = new Scanner(System.in);

        if(attendeechoice == 1){
            
            System.out.printf("\n%-30s %-30s", "Seminar", "Number of Attendees");
            for(int i=0; i<seminarID.length; i++){

                if(seminarID[i] != null){


                    System.out.printf("\n%-30s %-30s", seminarID[i], count[i]);
                }
            }            
            
        }else if(attendeechoice == 2){
            
            System.out.println("Please input a Seminar ID: ");
            String userInput = scan.nextLine();
            
            System.out.printf("\n%-30s %-30s", "Seminar", "Number of Attendees");
            for(int i=0; i<seminarID.length; i++){

                if(seminarID[i] != null && seminarID[i].equals(userInput)){


                    System.out.printf("\n%-30s %-30s", seminarID[i], count[i]);
                }
            }            
           
            
        }
        
        System.out.println("");
        System.out.println("\nPress enter to continue..");
        scan.nextLine();               
        
    }  
    
    public void checkSeminars(){
        
        Scanner scan = new Scanner(System.in);
        Date currentDate = new Date();
        SimpleDateFormat convertDate = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = convertDate.format(currentDate);
        int totalAttendeeJoined = 0;
        double totalAttendee = 0;
        double totalCost = 0;
        int count = 0;
        
        //change
        String name = "Liew";
        
        for(int k=0; k<slotbooking.length; k++){
            
            if(slotbooking[k] != null){
                
                count++;
                for(int i=0; i<slotbooking.length; i++){

                    if(slotbooking[i].getSpeaker().equals(name)){

                        String speakerSlotID = slotbooking[i].getID();
                        System.out.println(speakerSlotID);
                        for(int j=0; j<attendee.length; j++){

                            if((attendee[j].getSeminarID()).equals(speakerSlotID)){

                                totalAttendee += attendee[j].getTotal();

                            }
                        }

                    } 
            
                }               
        
        
                for(int i=0; i<slotbooking.length; i++){

                    if(slotbooking[i].getSpeaker().equals(name)){

                        totalCost += slotbooking[i].getTotal();

                    }            

                }    
                

                System.out.printf("\nFinancial Report by %-30s", formattedDate);
                System.out.printf("\nTotal: RM%.2f", totalAttendee);
                System.out.printf("\nTotal Cost: RM%.2f", totalCost);
                System.out.printf("\nTotal Profit: RM%.2f", (totalAttendee-totalCost));
        
        
                                    
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
    
    public void checkBooking(){
        
        Scanner scan = new Scanner(System.in);
        Date currentDate = new Date();
        int count = 0;
        
        Time[] slotStartTime = new Time[1000];
        Time[] slotEndTime = new Time[1000];
        Date[] slotStartDate = new Date[1000];
        Date[] slotEndDate = new Date[1000];
        String[] venue = new String[1000];
        
        Time sqlTime = new Time(System.currentTimeMillis());
        Time stampStart = Time.valueOf("11:00:00");
        Time stampEnd = Time.valueOf("23:00:00");

        SimpleDateFormat convertDate = new SimpleDateFormat("dd-MM-yyyy");
        
        System.out.println("How do you wanna check boooking?");
        System.out.println("1 - Today Date");
        System.out.println("2 - Custom Date");
        int choice = scan.nextInt();
        
        for(int k=0; k<slotbooking.length; k++){
            
            if(slotbooking[k] != null){
                
                count++;
                //Today date
                if(choice == 1){

                    String formattedDate = convertDate.format(currentDate);
                    System.out.printf("\nDate: %-50s ", formattedDate);

                    for(int i=0; i<slotbooking.length; i++){

                        venue[i] = slotbooking[i].getVenue();
                        slotStartTime[i] = Time.valueOf(slotbooking[i].getStartTime());
                        slotEndTime[i] = Time.valueOf(slotbooking[i].getEndTime());
                        slotStartDate[i] = slotbooking[i].getStartDate();
                        slotEndDate[i] = slotbooking[i].getEndDate();

                        //Less than 0 means its before
                        int comparisonResult = currentDate.compareTo(slotStartDate[i]);
                        if(comparisonResult < 0){

                            System.out.printf("\nNo: %-25s", i+1);
                            System.out.printf("\nVenue:  %-25s ", venue[i]);
                            System.out.printf("\nSlot Start Time:  %-25s ", slotStartTime[i]);
                            System.out.printf("\nSlot End Time:  %-25s ", slotEndTime[i]);
                            System.out.printf("\nSlot Start Date:  %-25s ", slotStartDate[i]);
                            System.out.printf("\nSlot End Date:  %-25s ", slotEndDate[i]);
                            System.out.println("");

                        }

                        if(slotbooking == null){

                            break;
                        }

                    } 

                    System.out.println("\nPress enter to continue..");
                    scan.nextLine();


                //Custom Date
                }else if(choice == 2){

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

                            //Loop through slotbooking to get time and venue and date
                            for(int i=0; i<slotbooking.length; i++){

                                venue[i] = slotbooking[i].getVenue();
                                slotStartTime[i] = Time.valueOf(slotbooking[i].getStartTime());
                                slotEndTime[i] = Time.valueOf(slotbooking[i].getEndTime());
                                slotStartDate[i] = slotbooking[i].getStartDate();
                                slotEndDate[i] = slotbooking[i].getEndDate();

                                //More than 0 means its after
                                int comparisonResult = sqlDate.compareTo(slotStartDate[i]);
                                if(comparisonResult < 0){

                                    System.out.printf("\nNo: %-25s", i+1);
                                    System.out.printf("\nVenue:  %-25s ", venue[i]);
                                    System.out.printf("\nSlot Start Time:  %-25s ", slotStartTime[i]);
                                    System.out.printf("\nSlot End Time:  %-25s ", slotEndTime[i]);
                                    System.out.printf("\nSlot Start Date:  %-25s ", slotStartDate[i]);
                                    System.out.printf("\nSlot End Date:  %-25s ", slotEndDate[i]);
                                    System.out.println("");

                                }

                                if(slotbooking == null){

                                    break;

                                }

                            }

                        } catch (ParseException e) {

                            status = true;
                            System.out.println("Invalid date format. Please use dd-MM-yyyy.");

                        }

                    }while(status == true);

                    System.out.println("\nPress enter to continue..");
                    scan.nextLine();

                }                
                
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

    
    
}
