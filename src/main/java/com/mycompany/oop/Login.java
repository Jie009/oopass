package com.mycompany.oop;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Login{
    static String ggcategory = "";
    static String ggid = "";
    // show the login menu
    public static void showLoginOptions(List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees, Scanner scanner){ 
        welcomePage wp = new welcomePage();
        OOP.clScr();
        System.out.println("===================================================");
        System.out.println("                    Login Page");
        System.out.println("");
        System.out.println("1 - Admin");
        System.out.println("2 - Speaker");
        System.out.println("3 - Attendee");
        System.out.println("");
        System.out.println("0 - EXIT");
        System.out.println("");
        System.out.println("===================================================");

        int choices = 0;
        try{
            System.out.print("Your Choice: ");
            choices = scanner.nextInt();
        }
        
        catch (InputMismatchException e) {
            scanner.nextLine();
        }
        if (choices == 0){
            wp.welcomePage(admins, speakers, attendees, scanner);
        }
        else if(choices >0 && choices <4){
            switch (choices) { 
                case 1:
                    // Admin login
                    ggcategory = "Admin";                
                    
                    break;
                case 2:
                    // Speaker login
                    ggcategory = "Speaker";        
                    break;
                case 3:
                    // Attendee login
                    ggcategory = "Attendee";
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;                
            }
            loginProcess(admins, speakers, attendees, scanner, ggcategory);
        }
        else{
            System.out.println("Invalid choice, please try again");
        }
    }    
    // let user input the login details
    public static void loginProcess(List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees, Scanner scanner, String category){
        welcomePage wp = new welcomePage();
        scanner.nextLine();
        OOP.clScr();
        System.out.println("===================================================");
        System.out.println("                    Login Page");
        System.out.println("");
        System.out.print("Enter Id: ");
        String id = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.println("");
        System.out.println("===================================================");
        boolean loginSuccessful = false;
        if (category.equals("Admin")){
            
            for (Admin admin : admins) {
                if (admin.getid().equals(id) && admin.getpassword().equals(password)) {
                    ggid = admin.getname();
                    loginSuccessful = true;
                    break;
                }
            }
        }
        else if (category.equals("Attendee")){
            for (Attendee attendee : attendees) {
                if (attendee.getid().equals(id) && attendee.getpassword().equals(password)) {
                    ggid = attendee.getname();
                    loginSuccessful = true;
                    break;
                }
            }       
        }
        else if (category.equals("Speaker")){
            for (Speaker speaker : speakers) {
                if (speaker.getid().equals(id) && speaker.getpassword().equals(password)) {
                    ggid = speaker.getname();
                    loginSuccessful = true;
                    break;
                }
            }       
        }    
             
        if (loginSuccessful) {
            System.out.println("Login Successful!");
            System.out.println("Press any key to continue...");
            scanner.nextLine();
        } 
        else {
            System.out.println("Login Failed. Incorrect ID or Password.");
            System.out.println("Press any key to continue...");
            scanner.nextLine();
            wp.welcomePage(admins, speakers, attendees, scanner);
        }
    }
    
    //get login user category
    public static String cat(){
        return ggcategory;
    }
    
    //get login user name
    public static String userId(){
        return ggid;
    }
}