package com.mycompany.oop;
import java.util.Date;

public class Payment {
    private String method;
    private double total;
    private Date date;
    private static int numOfPayment=0;
    
    public Payment(){
        method = "Hello world";
        total = 0.00;
        date = new Date();
    }
    public Payment(String method, double total){
        this.method = method;
        this.total = total;
        date = new Date();
        numOfPayment ++;
    }
    
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
}
