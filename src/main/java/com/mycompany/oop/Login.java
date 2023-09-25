package com.mycompany.oop;

import static com.mycompany.oop.OOP.clScr;
import static com.mycompany.oop.welcomePage.welcomePage;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login{
    public static void showLoginOptions(UserStore userStore, Scanner scanner){
        
        boolean cont = true;
        welcomePage wp = new welcomePage();
        clScr();
        System.out.println("Login Options:");
        System.out.println("---------------");
        System.out.println("1. Admin login");
        System.out.println("2. Speaker login");
        System.out.println("3. Attendee login");
        System.out.println("\n0. Quit:");

        int choice = 0;
        try{
            System.out.print("Your Choice: ");
            choice = scanner.nextInt();
        }
        
        catch (InputMismatchException e) {
            scanner.nextLine();
        }
        if (choice == 0){
            wp.welcomePage(userStore);
        }
        else if(choice >0 && choice <4){
            switch (choice) { 
                case 1:
                    // Admin login
                    login(userStore, "Admin", scanner);
                    break;
                case 2:
                    // Speaker login
                    login(userStore, "Speaker", scanner);
                    break;
                case 3:
                    // Attendee login
                    login(userStore, "Attendee", scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;                
            }
        }
        else{
            System.out.println("Invalid choice, please try again");
        }
//        scanner.nextLine();
//        clScr();
//        System.out.print("\nEnter ID: ");
//        id = scanner.nextLine();
//        System.out.print("Enter Password: ");
//        password = scanner.nextLine();
//
//        
//        String loggedInUser = User.validateLogin(id, password, category);
//        if (loggedInUser != null) {
//            System.out.println("Login successful. Welcome, " + loggedInUser + "!");
//            System.out.println("\nPress any key to continue...");
//            scanner.nextLine();
//
//        } else {
//            System.out.println("Login failed. Please check your credentials.");
//            category = "";
//            System.out.println("\nPress any key to continue...");
//            scanner.nextLine();
////            welcomePage(admin, speaker, attendee);
//        }

    }
    public static void login(UserStore userStore, String category, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        User loginUser = userStore.getUserById(userId);

        if (loginUser != null && loginUser.getcategory().equals(category)) {
            String loginResult = loginUser.validateLogin(password);
            System.out.println(loginResult);
        } else {
            System.out.println("User not found or incorrect category.");
        }
    }
}
