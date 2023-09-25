package com.mycompany.oop;

import static com.mycompany.oop.OOP.clScr;
import static com.mycompany.oop.welcomePage.welcomePage;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistrationProcess {
    public static void RegistrationProcess(UserStore userStore) {
        Scanner scanner = new Scanner(System.in);              
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
            welcomePage(userStore);

        }
        else if (choice >0 && choice < 3){
            User newUser = null;
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
                    newUser = new Speaker(id, password, name, contactInfo);
                    break;
                case 2:
                    newUser = new Attendee(id, password, name, contactInfo);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            if (newUser != null) {
                        userStore.addUser(newUser);
                        System.out.println("Registration successful!");
                        
                        System.out.println("\nPress any key to continue...");
                        scanner.nextLine();
                        welcomePage(userStore);
                    }
        }
        else{
            System.out.println("Invalid choice, please try again");
        }

    }
}
    
