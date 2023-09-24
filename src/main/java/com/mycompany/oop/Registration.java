/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registration Options:");
        System.out.println("1. Speaker register");
        System.out.println("2. Attendee register");
        System.out.print("Please enter the number: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        String category = "";
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

        System.out.print("Enter Contact Info: ");
        String contactInfo = scanner.nextLine();

        User user = new User(id, password, name, category, contactInfo);
        user.updateUserList();
        System.out.println("Registration successful!");
    }
}
    
