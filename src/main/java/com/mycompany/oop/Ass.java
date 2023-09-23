/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ass;

import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Ass {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Date date;
        Time time;
        int test = scan.nextInt();
        if(test == 1){
            
            Seminar[] seminar = {
                
                new Seminar("S1", "Title", Date.valueOf("2023-10-21"), Date.valueOf("2023-10-22"), Time.valueOf("15:30:00"), 
                            Time.valueOf("17:30:00"), 200, "KL", new ArrayList<>()),
                new Seminar("S2", "Title2", Date.valueOf("2023-10-21"), Date.valueOf("2023-10-22"), Time.valueOf("16:30:00"), 
                            Time.valueOf("18:30:00"), 200, "KL", new ArrayList<>())
            };
            
            Attendee[] attendee = {
                
                new Attendee(new ArrayList<>(), 1, "A1", "S1"),
                new Attendee(new ArrayList<>(), 1, "A2", "S2"),
                new Attendee(new ArrayList<>(), 1, "A3", "S2"),
                    
            };
            
            SeminarEnroll[] seminarEnroll = {
                
                new SeminarEnroll(attendee[0], seminar[0], Date.valueOf("2023-10-21"), Time.valueOf("18:30:00")),
                new SeminarEnroll(attendee[1], seminar[1], Date.valueOf("2023-10-21"), Time.valueOf("18:30:00")),    
                new SeminarEnroll(attendee[2], seminar[1], Date.valueOf("2023-10-21"), Time.valueOf("18:30:00")),              
                new SeminarEnroll(attendee[0], seminar[1], Date.valueOf("2023-10-21"), Time.valueOf("18:30:00")),             
                new SeminarEnroll(attendee[1], seminar[0], Date.valueOf("2023-10-21"), Time.valueOf("18:30:00"))              
                          
                
            };
            
            Payment[] payment = {
                
                new Payment("Credit", 200),
                new Payment("Online Banking", 200),
                new Payment("TNG", 200),
                new Payment("Cash", 200)
            };
            
            Slot[] slot = {
                
                new Slot("Sports complex", "play game", "16:30:00", "17:30:00",Date.valueOf("2023-10-21"), Date.valueOf("2023-10-22"), 50, 200),
                new Slot("DK ABA", "play games v2", "18:30:00", "19:30:00",Date.valueOf("2023-10-21"), Date.valueOf("2023-10-22"), 50, 200)
            };
            
            SlotBooking[] slotBooking = {
                
                new SlotBooking("SB001", "test", slot[0], payment[0]),
                new SlotBooking("SB002", "test", slot[1], payment[1])
            };
            
            //delete System.out.println(seminarEnroll[0].toString());
            //delete System.out.println(seminarEnroll[1].toString());
            
            Monitoring monitor = new Monitoring(seminar, slotBooking, seminarEnroll);
            for(int i=0; i<seminarEnroll.length; i++){
                
                //Adding seminarenrolls array to arraylist
                seminarEnroll[i].deleteSeminarEnroll();
                
                //Adding each main classseminarenroll array to seminarenroll arraylist
                seminarEnroll[i].addSeminarEnroll(seminarEnroll[i]); 
                
                //Getting seminarenroll arraylist and put it in monitor class
                monitor.addEnrollToMonitor(seminarEnroll[i].getEnrollList());
            }
            
            //before (50)
            System.out.println(slotBooking[1].getSeatNo());
            slotBooking[1].setSeatNo(2);
            
            //after (2)
            System.out.println(slotBooking[1].getSeatNo());

            
            for(int i=0; i<slotBooking.length; i++){
                   
                slotBooking[i].deleteSlotBooking();
                //Adding each main class slotbooking array to slotbooking arraylist
                slotBooking[i].addSlotBooking(slotBooking[i]);
                //Getting slotbooking arraylist to monitor
                monitor.addBookingToMonitor(slotBooking[i].getBookingList());
            }
            
            int monitorChoice = monitor.displayChoices();
            monitor.displayList(monitorChoice);
              
            
            Report report = new Report(seminar, slotBooking, seminarEnroll);
            for(int i=0; i<seminarEnroll.length; i++){
                
                seminarEnroll[i].deleteSeminarEnroll();
                seminarEnroll[i].addSeminarEnroll(seminarEnroll[i]);

                report.addToReport(seminarEnroll[i].getEnrollList());
            }
            
            int reportChoice = report.generateList();
            report.generateReport(reportChoice);
          
            
            
            
        }else if(test == 2){
            
            
            
        }
        
    }
}
