
package com.mycompany.oop;

import static com.mycompany.oop.OOP.clScr;
import static com.mycompany.oop.OOP.menu;
import static com.mycompany.oop.RegistrationProcess.RegistrationProcess;
import com.mycompany.oop.Login;
import com.mycompany.oop.RegistrationProcess;
import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class welcomePage {
    public static void welcomePage(UserStore userStore){ 
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        boolean bigLoop = true;
        String category = "";
        clScr();
        System.out.println("Welcome to the Seminar Management System!");
        System.out.println("------------------------------------------");
        
        while(bigLoop == true){
            
            do {

                System.out.println("Menu:");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");
                System.out.print("Please enter the number: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        Login.showLoginOptions(userStore, scanner);  
                        cont = false;
                        break;
                        

                    case 2:
                        // Call the Registration class
                        RegistrationProcess.RegistrationProcess(userStore);

                    case 3:
                        System.out.println("Thank you. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }          

            }while (cont == true);


            boolean userCont = true;
            Date date;
            Time time;
            int choice;

            category = Login.Category(null);
            System.out.println(category);
            while(userCont == true){

                if(category.equals("Admin")){
                    clScr();
                    System.out.println("Admin Menu");
                    System.out.println("---------------------");
                    System.out.println("1 - Monitor");
                    System.out.println("2 - Report");
                    System.out.println("0 - Logout"); 
                    System.out.println("---------------------");
                    System.out.print("Choose an option: ");
                    choice = scanner.nextInt();
                    userCont = menu(choice, category);


                }else if(category.equals("Speaker")){
                    clScr();
                    System.out.println("Speaker Menu");
                    System.out.println("---------------------");
                    System.out.println("1 - Slot Booking");
                    System.out.println("2 - Report");              
                    System.out.println("3 - Advertisement");                
                    System.out.println("0 - Logout");                
                    System.out.println("---------------------");
                    System.out.print("Choose an option: ");
                    choice = scanner.nextInt();
                    userCont = menu(choice, category);

                }else if(category.equals("Attendee")){
                    clScr();
                    System.out.println("Attendee Menu");
                    System.out.println("---------------------");
                    System.out.println("1 - Enroll Seminar");
                    System.out.println("2 - Logout");                
                    System.out.println("---------------------");
                    System.out.print("Choose an option: ");
                    choice = scanner.nextInt();
                    userCont = menu(choice, category);

                }


            }         
        
        
        
        }
        

    }
}
