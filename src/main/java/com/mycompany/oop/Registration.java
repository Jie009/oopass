package com.mycompany.oop;

import static com.mycompany.oop.OOP.clScr;
import static com.mycompany.oop.welcomePage.welcomePage;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Registration {
    public static void RegistrationProcess(User admin, User speaker, User attendee) {
        Scanner scanner = new Scanner(System.in);
        welcomePage wp = new welcomePage();              
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
            wp.welcomePage(admin, speaker, attendee);
        }
        else if (choice >0 && choice < 3){
            switch (choice) {
                case 1:
                    category = "Speaker";
                    break;
                case 2:
                    category = "Attendee";
                    break;
                default:
                    System.out.println("Invalid choice");
                    return;
            }
        }
        else{
            System.out.println("Invalid choice, please try again");
        }
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

        User user = new User(id, password, name, category, contactInfo);
        user.updateUserList();
        System.out.println("Registration successful!");
        
        System.out.println("\nPress any key to continue...");
        scanner.nextLine();
        welcomePage(admin, speaker, attendee);
    }
}
    
