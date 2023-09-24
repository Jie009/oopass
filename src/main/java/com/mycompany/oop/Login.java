package com.mycompany.oop;

import static com.mycompany.oop.OOP.clScr;
import static com.mycompany.oop.welcomePage.welcomePage;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    
    public Login(){
        
    }
    
    public String loginProcess(User admin, User speaker, User attendee){
        
        boolean cont = true;
        Scanner scanner = new Scanner(System.in);
        welcomePage wp = new welcomePage();
        clScr();
        System.out.println("Login Options:");
        System.out.println("---------------");
        System.out.println("1. Admin login");
        System.out.println("2. Speaker login");
        System.out.println("3. Attendee login");
        System.out.println("\n0. Quit:");

        int choice = 0;
        String id = "";
        String password = "";
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
        else if(choice >0 && choice <4){
            
            switch (choice) {
                case 1:
                    category = "Admin";
                    break;
                case 2:
                    category = "Speaker";
                    break;
                case 3:
                    category = "Attendee";
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
        else{
            System.out.println("Invalid choice, please try again");
        }
        scanner.nextLine();
        clScr();
        System.out.print("\nEnter ID: ");
        id = scanner.nextLine();
        System.out.print("Enter Password: ");
        password = scanner.nextLine();

        
        String loggedInUser = User.validateLogin(id, password, category);
        if (loggedInUser != null) {
            System.out.println("Login successful. Welcome, " + loggedInUser + "!");
            System.out.println("\nPress any key to continue...");
            scanner.nextLine();

        } else {
            System.out.println("Login failed. Please check your credentials.");
            category = "";
            System.out.println("\nPress any key to continue...");
            scanner.nextLine();
            welcomePage(admin, speaker, attendee);
        }
   
        return category;
    }
}
