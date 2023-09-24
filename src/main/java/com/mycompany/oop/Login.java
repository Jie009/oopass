/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop;

import java.util.Scanner;

public class Login {
    
    public Login(){
        
    }
    
    public String loginProcess(){
        
        boolean cont = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login Options:");
        System.out.println("1. Admin login");
        System.out.println("2. Speaker login");
        System.out.println("3. Attendee login");
        System.out.print("Please enter the number: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        String category = "";
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

        String loggedInUser = User.validateLogin(id, password, category);
        if (loggedInUser != null) {
            System.out.println("Login successful. Welcome, " + loggedInUser + "!");

        } else {
            System.out.println("Login failed. Please check your credentials.");
            category = "";
        }
   
        return category;
    }
}
