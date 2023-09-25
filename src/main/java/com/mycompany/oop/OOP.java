package com.mycompany.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OOP {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create some sample users
        List<Admin> admins = new ArrayList<>();
        List<Speaker> speakers = new ArrayList<>();
        List<Attendee> attendees = new ArrayList<>();
        welcomePage wp = new welcomePage();
        // Add the sample users to the user list
        
        admins.add(new Admin("ad", "ad", "Admin User", "admin@example.com"));
        speakers.add(new Speaker("sp", "sp", "Speaker User", "speaker@example.com"));
        attendees.add(new Attendee("at", "at", "Attendee User", "attendee@example.com"));
        
        wp.welcomePage(admins, speakers, attendees, scanner);
    }    
    
    
    public static void clScr(){
        for (int i = 0; i < 40; i++) {
            System.out.println(); 
        }
    }
}
