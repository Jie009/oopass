package com.mycompany.oop;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Report extends ReportAbstract {
    
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
    private Payment[] payment;
    private SeminarEnroll[] seminarenrolls;
        
    //Constructor
    public Report(Seminar[] seminars, SlotBooking[] slotbooking, SeminarEnroll[] seminarenrolls, Attendee[] attendee, Payment[] payment){
        
        enrollData = new ArrayList<>();
        this.seminars = seminars;
        this.slotbooking = slotbooking;
        this.seminarenrolls = seminarenrolls; 
        this.attendee = attendee;
    }

    //Get start time using id
    public Time getStartTimeByID(String id){
        
        for(Seminar seminard: seminars){
               
            if(seminard.getID().equals(id)){
                
                return seminard.getStartTime();
            }
        }
        
        return null;
    }
    
     //Get end time using id
    public Time getEndTimeByID(String id){
        
        for(Seminar seminard: seminars){
           
            if(seminard.getID().equals(id)){
                
                return seminard.getEndTime();
            }
        }
        
        return null;
    }
    
    //Add to arraylist
    public void addToReport(ArrayList<SeminarEnroll> data){
        
        enrollData.addAll(data);
    }
    
    
    //Generate selection list
    public int generateList(int category){
        
        OOP.clScr();
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        boolean exit = false;
        System.out.println("What report do you wanna generate?");
        
        if(category == 1){
            
            System.out.println("===================================================");
            System.out.println("                 Report Generator");
            System.out.println("");
            System.out.println("1 - Total Attendees Joined for Seminar");
            System.out.println("2 - Financial Report for Seminar");
            System.out.println("3 - Total Slot by Date");
            System.out.println("");
            System.out.println("0 - EXIT");
            System.out.println("");
            System.out.println("===================================================");
            System.out.print("Enter your choice:  ");
        
            choice = scan.nextInt();
            if(choice == 0){
                
                exit = true;
            }
            
            //Validation
            while(choice > 3 && exit == false){


                try {

                    System.out.println("Please choose a number.");
                    System.out.print("> "); 
                    choice = scan.nextInt();    


                }catch(InputMismatchException e){

                    System.out.println("Input must be a number");
                }
                
                


            }
      
            
        }else if(category == 2){
            
            OOP.clScr();
            System.out.println("===================================================");
            System.out.println("                  Report Generator");
            System.out.println("");
            System.out.println("1 - Total Attendees Joined for Seminar");
            System.out.println("2 - Financial Report");
            System.out.println("");
            System.out.println("0 - EXIT");
            System.out.println("");
            System.out.println("===================================================");   
            System.out.print("Enter your choice:  ");
            choice = scan.nextInt();
            if(choice == 0){
                
                exit = true;
            }
            //Validation
            while(choice > 2 && exit == false){


                try {

                    System.out.println("Please choose a number.");
                    System.out.print("> "); 
                    choice = scan.nextInt();    


                }catch(InputMismatchException e){

                    System.out.println("Input must be a number");
                }
                
                


            }
         
        
        
        }
        
        return choice;

    }
    
    //Generate report
    public boolean generateReport(int reportChoice, int category, String name){
        
        int count = 0;
        for (int i = 0; i < seminars.length; i++) {
            
            if(seminars[i] != null){
                

                for (int j = 0; j < attendee.length; j++) {

                    if(seminars[j] != null){
                        
                        count++;
                    }

                }
                
            }
            
        }
        if(count != 0){
            
            splitID();
            
        }
        
        Scanner scan = new Scanner(System.in);
        boolean exitStatus = false;
            
        
        //ADMIN ONLY
        if(category == 1){
            
            //SEMINAR ATTENDEE PER COUNT
            //require data, welcomePage contains the data seminar[0-1]
            
            if(reportChoice == 1){

                int attendeechoice;
                boolean status = true;


                do {

                    int sb = 0;
                    int sdcount = 0;
                    
                    OOP.clScr();
                     System.out.println("===================================================");
                     System.out.println("                 Report Generator");
                     System.out.println("");
                     System.out.println("1 - All Seminars");
                     System.out.println("2 - Search by a Seminar");
                     System.out.println("");
                     System.out.println("0 - EXIT");
                     System.out.println("");
                     System.out.println("===================================================");
                    System.out.print("Enter you choice:  ");
                    attendeechoice = scan.nextInt();

                    //Validation
                    if(attendeechoice == 0){

                        status = false;
                        exitStatus = true;
                        break;
                    }

                    if(attendeechoice > 2){

                        System.out.println("Please Choose again.");

                    }else{
                        
                        
                        
                        for (int i = 0; i < seminars.length; i++) {

                            if(seminars[i] != null){


                                for (int j = 0; j < attendee.length; j++) {

                                    if(seminars[j] != null){

                                        sdcount++;
                                    }

                                }

                            }

                        }
                    }
                    
                    if(sdcount != 0){

                        countAttendeeSeminar(attendeechoice); 

                    }else{

                        System.out.println("There are currently no enrolls");
                        System.out.println("");
                        System.out.println("\nPress enter to continue..");

                        scan.nextLine();          
                        scan.nextLine();          
                    }

  


                }while(status == true);             


            //CHECK ONGOING SEMINAR
            }else if(reportChoice == 2){

                checkSeminars(category, name);
                exitStatus = true;
                
                
            //CHECK ALL SLOT
            }else if(reportChoice == 3){

                checkBooking();
                exitStatus = true;
                

            //EXIT TO ADMIN HOMEPAGE
            }else if(reportChoice == 0){

                exitStatus = true;
            }

            
            
        }else if(category == 2){
            
            if(reportChoice == 1){

                int attendeechoice;
                boolean status = true;
                int sdcount = 0;


                do {

                    int sb = 0;
                    
                    OOP.clScr();
                    System.out.println("===================================================");
                    System.out.println("                 Report Generator");
                    System.out.println("");
                    System.out.println("1 - All Seminars");
                    System.out.println("2 - Search by a Seminar");
                    System.out.println("");
                    System.out.println("0 - EXIT");
                    System.out.println("");
                    System.out.println("===================================================");
                    System.out.print("Enter you choice:  ");
                    attendeechoice = scan.nextInt();

                    //Validation
                    if(attendeechoice == 0){

                        status = false;
                        exitStatus = true;
                        break;
                    }

                    if(attendeechoice > 2){

                        System.out.println("Please Choose again.");

                    }else{

    
                        
                        sdcount = 0;
                        for (int i = 0; i < seminars.length; i++) {

                            if(seminars[i] != null){


                                for (int j = 0; j < attendee.length; j++) {

                                    if(seminars[j] != null){

                                        sdcount++;
                                    }

                                }

                            }

                        }
                    }
                    
                    if(sdcount != 0){

                        countAttendeeSeminar(attendeechoice); 

                    }else{

                        System.out.println("There are currently no enrolls");
                    }

                    


                }while(status == true);             


            }else if(reportChoice == 2){
                
                //Financial report
                checkSeminars(category, name);
                
                

            }else if(reportChoice == 0){
                
                exitStatus = true;

            }  
            
        }
        
        return exitStatus;
        
        

    }
    


    //Setter title
    public void setTitle(String title){
        
        this.title = title;
    }
    
    //Get title
    public String getTitle(){
        
        return title;
    }

    //Set seminarenroll
    public void setSeminarEnroll(SeminarEnroll seminarEnroll){
        
        this.seminarEnroll = seminarEnroll;
    }
    
    //Get seminarenroll
    public SeminarEnroll getSeminarEnroll(){
        
        return seminarEnroll;
    }
    
    //Process of splitting id
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
    
    //Count how many attendees per seminar same as in monitor
    public void countAttendeeSeminar(int attendeechoice){
        
        Scanner scan = new Scanner(System.in);
        int num = 0;
        OOP.clScr();
        System.out.println("===================================================");
        if(attendeechoice == 1){
            for(int i=0; i<seminarID.length; i++){

                if(seminarID[i] != null){
                    
                    if(num == 0){
                        
                        System.out.printf("\n%-30s %-30s", "Seminar", "Number of Attendees");
                        num++; 
                        
                    }

                    System.out.printf("\n%-30s %-30s", seminarID[i], count[i]);
                }
            }     
        System.out.println("\n===================================================");    
        }else if(attendeechoice == 2){

            String userInput;
            do {
                
                System.out.print("Enter Seminar ID (S1 to S5): ");
                userInput = scan.nextLine();


                if (userInput.matches("S[1-5]")) {

                    break; // Exit the loop if input is valid

                } else {
                    System.out.println("Invalid input. Please enter S1 to S5.");
                }
                        
            } while (true);
            
            System.out.printf("\n%-30s %-30s", "Seminar", "Number of Attendees");
            for(int i=0; i<seminarID.length; i++){
                
                if(seminarID[i] != null && seminarID[i].equals(userInput)){

                    if(num == 0){
                        
                        System.out.printf("\n%-30s %-30s", "Seminar", "Number of Attendees");
                        num++; 
                        
                    }
                    
                    System.out.printf("\n%-30s %-30s", seminarID[i], count[i]);
                }
            }            
           
        System.out.println("\n===================================================");      
        }


        if(num == 0){
            
            System.out.println("There are currently no attendees or seminars.");
        }
        
        System.out.println("");
        System.out.println("\nPress enter to continue..");
        scan.nextLine();               
        
    }  
    
    //Finance
    public void checkSeminars(int userStatus, String name){
        
        Scanner scan = new Scanner(System.in);
        Date currentDate = new Date();
        SimpleDateFormat convertDate = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = convertDate.format(currentDate);
        int totalAttendeeJoined = 0;
        double totalAttendee = 0;
        double totalCost = 0;
        int count = 0;
        int attendeeCount = 0;
        String speakerSlotID = "";
        
        for(int i=0; i<slotbooking.length; i++){

            if(slotbooking[i] != null){
                count++;
                
                if(userStatus == 1){
                    
                    speakerSlotID = slotbooking[i].getID();
                    for(int j=0; j<seminars.length; j++){

                        if(seminars[j] != null){

                            if(seminars[j].getID().equals(speakerSlotID)){

                                totalCost += seminars[j].getPrice();

                            }
                        }
                    }
                    
                    
                }

                //1 is admin
                if(userStatus == 2){

                    if(slotbooking[i].getSpeaker().equals(name)){

                        speakerSlotID = slotbooking[i].getID();
                        for(int j=0; j<seminars.length; j++){

                            if(seminars[j] != null){

                                if(seminars[j].getID().equals(speakerSlotID)){

                                    totalCost += seminars[j].getPrice();

                                }
                            }
                        }
                        
                        for(int j=0; j<attendee.length; j++){
                            
                            if(attendee[j] != null){
                                
                                attendeeCount++;
                            
                                if((attendee[j].getSeminarID()).equals(speakerSlotID)){

                                    System.out.println(seminarenrolls[i].getAttendee().getTotal());
                                    totalAttendee += seminarenrolls[i].getAttendee().getTotal();

                                    }


                               }

                            }

                        }     
                }               


                if(count<=0){

                    System.out.println("There are no bookings at the moment..");
                    System.out.println("\nPress enter to continue..");
                    scan.nextLine();  
                    
                }else if(userStatus == 2 && attendeeCount == 0){
 
                    System.out.println("There are no enrolling attendees.");
                    System.out.println("\nPress enter to continue..");
                    scan.nextLine();                   
                    
                }
                
                if(userStatus == 1){
                    
                    OOP.clScr();
                    System.out.println("==========================================================");
                    System.out.printf("\n\t\tFinancial Report by %-30s", formattedDate);
                    System.out.printf("\n\t\tTotal: RM%.2f", totalCost);
                    System.out.println("\n\n==========================================================");
                
                }else if(userStatus == 2){

                    OOP.clScr();
                    System.out.println("==========================================================");
                    System.out.printf("\n\t\tFinancial Report by %-30s", formattedDate);
                    System.out.printf("\n\t\tTotal: RM%.2f", totalAttendee);
                    System.out.printf("\n\t\tTotal Cost: RM%.2f", totalCost);
                    System.out.printf("\n\t\tTotal Profit: RM%.2f", (totalAttendee-totalCost));
                    System.out.println("\n\n==========================================================");

                }
            
              
    
            }
        }
        
        System.out.println("");
        System.out.println("\nPress enter to continue..");
        scan.nextLine(); 
//        generateReport(1, 1, name);
        
    }
    
    //Check slot using date
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
        
        System.out.println("How do you wanna check slot?");
        System.out.println("1 - Today Date");
        System.out.println("2 - Custom Date");
        int choice = scan.nextInt();

        //Today date
        if(choice == 1){

            String formattedDate = convertDate.format(currentDate);
            System.out.printf("\nAfter Date: %-50s ", formattedDate);

            for(int i=0; i<slotbooking.length; i++){

                if(slotbooking[i] != null){
                    count++;

                    venue[i] = slotbooking[i].getVenue();
                    slotStartDate[i] = slotbooking[i].getStartDate();
                    slotEndDate[i] = slotbooking[i].getEndDate();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

                    java.sql.Time sqlTimes = null;
                    java.sql.Time sqlTime2 = null;


                    try {

                        // Parse the string into a Date object
                        Date parsedDate = dateFormat.parse(slotbooking[i].getStartTime());

                        // Create a java.sql.Time object from the parsed Date
                        sqlTimes = new java.sql.Time(parsedDate.getTime());

                        // Parse the string into a Date object
                        Date parsedDate2 = dateFormat.parse(slotbooking[i].getEndTime());

                        // Create a java.sql.Time object from the parsed Date
                        sqlTime2 = new java.sql.Time(parsedDate2.getTime());

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }                             




                    //Less than 0 means its before
                    int comparisonResult = currentDate.compareTo(slotStartDate[i]);
                    if(comparisonResult < 0){

                        System.out.printf("\nNo: %-25s", i+1);
                        System.out.printf("\nVenue:  %-25s ", venue[i]);
                        System.out.printf("\nSlot Start Time:  %-25s ", sqlTimes);
                        System.out.printf("\nSlot End Time:  %-25s ", sqlTime2);
                        System.out.printf("\nSlot Start Date:  %-25s ", slotStartDate[i]);
                        System.out.printf("\nSlot End Date:  %-25s ", slotEndDate[i]);
                        System.out.println("");

                    }

                }

            } 

            System.out.println("\nPress enter to continue..");
            scan.nextLine();
            scan.nextLine();


        //Custom Date
        }else if(choice == 2){

            System.out.print("Enter a date (dd-MM-yyyy): ");
            boolean status = false;
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            String userInput = scan.next();

            java.sql.Time sqlTimes = null;
            java.sql.Time sqlTime2 = null;

            do {

                try {

                    // Parse the user input into a java.util.Date
                    java.util.Date utilDate = convertDate.parse(userInput);

                    // Convert the java.util.Date to a java.sql.Date in the desired format
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                    // Format the date as "yyyy-MM-dd"
                    String formattedDate = convertDate.format(sqlDate);
                    


                    System.out.printf("\nAfter Date: %-50s ", formattedDate);

                    //Loop through slotbooking to get time and venue and date
                    for(int i=0; i<slotbooking.length; i++){

                        if(slotbooking[i] != null){


                            venue[i] = slotbooking[i].getVenue();
                            slotStartDate[i] = slotbooking[i].getStartDate();
                            slotEndDate[i] = slotbooking[i].getEndDate();

                            try {

                                // Parse the string into a Date object
                                Date parsedDate = dateFormat.parse(slotbooking[i].getStartTime());

                                // Create a java.sql.Time object from the parsed Date
                                sqlTimes = new java.sql.Time(parsedDate.getTime());

                                // Parse the string into a Date object
                                Date parsedDate2 = dateFormat.parse(slotbooking[i].getEndTime());

                                // Create a java.sql.Time object from the parsed Date
                                sqlTime2 = new java.sql.Time(parsedDate2.getTime());

                            } catch (ParseException e) {
                                e.printStackTrace();
                            }                                    

                            //SQLDATE EARLIER THAN CUSTOM DATE
                            int comparisonResult = sqlDate.compareTo(slotStartDate[i]);
                            if(comparisonResult < 0){

                                System.out.printf("\nNo: %-25s", i+1);
                                System.out.printf("\nVenue:  %-25s ", venue[i]);
                                System.out.printf("\nSlot Start Time:  %-25s ", sqlTimes);
                                System.out.printf("\nSlot End Time:  %-25s ", sqlTime2);
                                System.out.printf("\nSlot Start Date:  %-25s ", slotStartDate[i]);
                                System.out.printf("\nSlot End Date:  %-25s ", slotEndDate[i]);
                                System.out.println("");

                            }
                        }

                    }

                } catch (ParseException e) {

                    status = true;
                    System.out.println("Invalid date format. Please use dd-MM-yyyy.");

                }

            }while(status == true);

            if(count<=0){

                System.out.println("There are no bookings at the moment..");

            }
            
            System.out.println("");
            System.out.println("\nPress enter to continue..");
            scan.nextLine();
            scan.nextLine();

        }                


 
    }

    
    
}
