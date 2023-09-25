package com.mycompany.oop;

import static com.mycompany.oop.OOP.clScr;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Login{
    static String ggcategory = "";
    static String ggid = "";
    public static void showLoginOptions(List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees, Scanner scanner){ 
        welcomePage wp = new welcomePage();
        clScr();
            
        System.out.println("Login Options:");
        System.out.println("---------------");
        System.out.println("1. Admin login");
        System.out.println("2. Speaker login");
        System.out.println("3. Attendee login");
        System.out.println("\n0. Quit:");

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
    public static void loginProcess(List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees, Scanner scanner, String category){
        welcomePage wp = new welcomePage();
        scanner.nextLine();
        System.out.print("Enter Id: ");
        String id = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // 调用新的登录方法 
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
    public static String cat(){
        return ggcategory;
    }
    public static String userId(){
        return ggid;
    }
}