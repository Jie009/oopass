package com.mycompany.oop;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Payment {
    private String method;
    private double total;
    private Date date;
    private static int numOfPayment=0;
    
    //NON ARG Constructor
    public Payment(){
        method = "Hello world";
        total = 0.00;
        date = new Date();
    }
    
    //Constructor with arg
    public Payment(String method, double total){
        this.method = method;
        this.total = total;
        date = new Date();
        numOfPayment ++;
    }
    
    //Getter
    public String getMethod(){
        return method;
    }
    public double getTotal(){
        return total;
    }
    public Date getDate(){
        return date;
    }
    
    public static int getNumOfPayment(){
        return numOfPayment;
    }
    
    //Payment process 
    public static boolean eventPayment(Scanner scanner, Payment[] payment, double price){
        int numOfPayment = Payment.getNumOfPayment();
        while (true){
            OOP.clScr();
            System.out.println("===================================================");
            System.out.println("                    Payment Options");
            System.out.println("");
            System.out.println("1 - Credit Card");
            System.out.println("2 - Online banking");
            System.out.println("3 - Touch & Go");
            System.out.println("4 - Cash");
            System.out.println("");
            System.out.println("0 - EXIT");
            System.out.println("");
            System.out.println("===================================================");
            int choice3 = 0;
            try{
                System.out.print("Your Choice: ");
                choice3 = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                scanner.nextLine();
            }
            String method = "";
            if (choice3 >0 && choice3 <5){
                switch (choice3){
                case 1:
                    method = "Credit Card";
                    break;
                case 2:
                    method = "Online banking";
                    break;
                case 3:
                    method = "Touch & Go";
                    break;
                case 4:
                    method = "Cash";
                    break;
                }

                payment[numOfPayment] = new Payment(method, price);
                return true;    
            }
            else if (choice3 == 0) {
                System.out.println("Payment canceled.");
                return false;
            } 
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
