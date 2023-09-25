/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop;

import static com.mycompany.oop.OOP.clScr;
import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class SeminarEnroll {
    
    private Attendee attendee;
    private Seminar seminar;
    private ArrayList<SeminarEnroll> enrollList;
    private Date enrolledDate;
    private Time enrolledTime;
    private static int enrollCount = 0;
    
    private static Payment paymentClass = new Payment();    
    
    public SeminarEnroll(Attendee attendee, Seminar seminar){
        
        this.attendee = attendee;
        this.seminar = seminar;
        this.enrollList = new ArrayList<>();
        enrollCount++;

    }
    
    public void deleteSeminarEnroll(){
        
        enrollList.clear();
    }
    
    public void addSeminarEnroll(SeminarEnroll enrolls){
        
        enrollList.add(enrolls);
    }
    
    public ArrayList<SeminarEnroll> getEnrollList(){
        
        return enrollList;
    }
    
    public String getSpeaker(){
     
        return "name";
    }

    
    public String toString(){
        
        return attendee.toString() + "-" + seminar.toString();
    }
    
    public Time getStartTime(){
        
        return seminar.getStartTime();
    }
    
    public Time getEndTime(){
        
        return seminar.getEndTime();
    }
    
    public Time getTime(){
        
        return enrolledTime;
    }
    
    public Date getDate(){
        
        return enrolledDate;
    }
    
    public String getID(){
        
        return seminar.getID();
    }
    
    public static void setEnrollCount(int EC){
        
        enrollCount = EC;
    }
    
    public String getAttendeeID(){
        
        return attendee.toString();
    }
    
    public void setNumOfSeminar(int NumOfSeminar){
        
        attendee.setNumOfSeminar(NumOfSeminar);
    }
    
    public String getVenue(){
        
        return seminar.getLocation();
    }    
    
    public double getPrice(){
        
        return seminar.getPrice();
        
    }
    
    public int getNumOfSeminar(){
        
        return attendee.getNumOfSeminar();
    }
    
    public String output(){
     
        return seminar.output();
    }
    
    public Seminar getSeminar(){
        
        return seminar;
    }
    
    public static int getEnrollCount(){
        
        return enrollCount;
    }
    
    public Attendee getAttendee(){
        
        return attendee;
    }
    
    public Date getStartDate(){
        
        return seminar.getStartDate();
    }
    
    public Date getEndDate(){
        
        return seminar.getEndDate();
    }
    
    public void menu(){
        
        
        System.out.println( 
                  "\n=====================================================" 
                + "\n                  Choose an option"
                + "\n1. Enroll"            
                + "\n2. View Enrolls"
                + "\n3. Cancel Enroll"
                + "\n=====================================================" 
                + "\n>  ");
    }

    public void enroll(String name, Attendee[] attendee, SeminarEnroll[] SE, Seminar[] seminar, Payment[] payment){
        
        while(true){
              
            Scanner scanner = new Scanner(System.in);
            menu();
            int choice = scanner.nextInt();

            if(choice == 1){
                
                int num=0;
                Time currentTime = new Time(System.currentTimeMillis());
                Date currentDate = new Date(System.currentTimeMillis());
                Timestamp currentTimestamp = new Timestamp(currentDate.getTime() + currentTime.getTime());


                for (int i = 0; i < seminar.length; i++) {
                    
                    if(seminar[i] != null){
                        
                        num++;
                        Date seminarStartDate = seminar[i].getStartDate();
                        Time seminarStartTime = seminar[i].getStartTime();

                        // Compare seminar start date with current date
                        int dateComparisonResult = currentDate.compareTo(seminarStartDate);

                        // Compare seminar start time with current time
                        int timeComparisonResult = currentTime.compareTo(seminarStartTime);


                        // Check if seminar is before current date or if it's on the current date but before current time
                        if (dateComparisonResult < 0 || (dateComparisonResult == 0 && timeComparisonResult < 0)) {
                            System.out.println(seminar[i].output());
                        }
                        
                    }
                }
                
                if(num == 0){
                     
                    System.out.println("There are currently no seminars.");

                }else if(num > 0){
                    
                    System.out.println("Which seminar do you wanna enroll?");
                    System.out.print("Seminar ID: ");
                    String userInput = scanner.next();

                    for (int i = 0; i < seminar.length; i++) {

                        if(seminar[i] != null){

                            if(userInput.equals(seminar[i].getID())){

                                if(paymentClass.eventPayment(scanner, payment, seminar[i].getPrice())){

                                    int numOfPayment = Payment.getNumOfPayment();
                                    int numOfAttendee = Attendee.getNumOfAttendee();
                                    int enrollCount = SeminarEnroll.getEnrollCount();
                                    System.out.println(enrollCount);
                                    attendee[numOfAttendee] = new Attendee("test", seminar[i].getID(), payment[numOfPayment]);
                                    SE[enrollCount-1] = new SeminarEnroll(attendee[numOfAttendee], seminar[i]);


                                }
                                
                            }

                        }else{
                            
                            System.out.println("Seminar ID not found.");
                        }
                    }                
                    
                }

                

            }else if(choice == 2){

                
                viewBookedEvents(attendee, scanner, name, SE, seminar, payment);

            }else if(choice == 3){

                
                cancelBookedEvents(scanner, name, SE, seminar, payment);
            }
                    
            
        }
        
        
        
    }
 
    public static void viewBookedEvents(Attendee[] attendee, Scanner scanner, String name, SeminarEnroll[] SE, Seminar[] seminar, Payment[] payment) {

        System.out.println("Enrolled Events");
        System.out.println("---------------");
        for (int i = 0; i < SE.length; i++) {
            
            if(SE[i] != null){
                
                for (int j = 0; j < attendee.length; j++) {

                    if(attendee[j] != null){

                        if(SE[i].getAttendeeID().equals(attendee[j].getID())){
                            
                            System.out.println(SE[i].output());
                        }


                    }
                }
            }
            
        }
      
    }
    
    
    public static void cancelBookedEvents(Scanner scanner, String user, SeminarEnroll[] SE, Seminar[] seminar, Payment[] payment) {

        while(true){
            System.out.println("\nBooked Events");
            System.out.println("---------------");
            int num = 1;
            for (int i = 0; i < SE.length; i++) {

                if (SE[i] != null && SE[i].getAttendeeID().equals(user)) {
                    
                    System.out.println((num) + ". " + SE[i].getVenue());
                    System.out.println("Start Time: " + SE[i].getStartTime());   
                    System.out.println("End Time: " + SE[i].getEndTime());   
                    System.out.println("Start Date: " + SE[i].getStartDate());   
                    System.out.println("End Date: " + SE[i].getEndDate());   
                    System.out.printf("RM%.2f", SE[i].getPrice());  
                    System.out.println("");
                    num++;
                    
                }
            }

            System.out.println("\n0. Quit");
            int eventNumber = 0;        
            try {
                
                for (int i = 0; i < 5; i++) {
                    System.out.println(SE[i]);
                    
                }
                
                System.out.print("Enter the number of the event to refund (0 to exit): ");
                eventNumber = scanner.nextInt();
                if (eventNumber == 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                continue; // Continue the loop to prompt for input again
            }

            if (eventNumber >= 1 && eventNumber <= SE.length && SE[eventNumber - 1] != null) {
                System.out.println(SE[eventNumber - 1]);
                double refund = SE[eventNumber - 1].getPrice();
                SE[eventNumber - 1] = null;

                // Shift elements after the deleted index to the left
                for (int i = eventNumber - 1; i < SE.length - 1; i++) {
                    SE[i] = SE[i + 1];
                }

                // Set the last element to null or whatever value is appropriate
                SE[SE.length - 1] = null;
                setEnrollCount(SeminarEnroll.getEnrollCount() - 1);
                System.out.println("Event canceled successfully.");
                System.out.println("RM" + refund + " is refund successfully. ");
                break;
            } else {
                System.out.println("Invalid eventNumber or event not found.");
            }
        }
        
    }   

}
