package com.mycompany.oop;

import static com.mycompany.oop.OOP.clScr;
import static com.mycompany.oop.welcomePage.welcomePage;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RegistrationProcess {
    public static void RegistrationProcess(List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees, Scanner scanner) {          
        clScr();
        System.out.println("Registration Options:");
        System.out.println("---------------------");
        System.out.println("1. Speaker register");
        System.out.println("2. Attendee register");
        System.out.println("\n0. Quit");
        int choice = 0;
        String category = "";
        try{
            System.out.print("Your Choice: ");
            choice = scanner.nextInt();
        }

        catch (InputMismatchException e) {
            scanner.nextLine();
        }
        if (choice == 0){
            welcomePage(admins, speakers, attendees, scanner);

        }
        else if (choice >0 && choice < 3){
            scanner.nextLine();
            clScr();
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Contact Info: ");
            String contactInfo = scanner.nextLine();
            switch (choice) {
                case 1:
                    Registration.registerUser(id, password, name, "Speaker",contactInfo, admins, speakers, attendees);
                    break;
                case 2:
                    Registration.registerUser(id, password, name, "Attendee",contactInfo, admins, speakers, attendees);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

            System.out.println("Registration successful!");

            System.out.println("\nPress any key to continue...");
            scanner.nextLine();
            welcomePage(admins, speakers, attendees, scanner);                   
        }


    }
}
    
