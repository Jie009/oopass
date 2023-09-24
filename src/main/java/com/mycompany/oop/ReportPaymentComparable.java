/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop;

/**
 *
 * @author User
 */
public class ReportPaymentComparable implements Comparable<ReportPaymentComparable> {
    
    
    private String method;
    private int count;
    
    public ReportPaymentComparable(String method, int count){
     
        this.method = method;
        this.count = count;
    }
    
    public String getMethod(){
     
        return method;
    }
    
    public int getAmount(){
        
        return count;
    }
    
    @Override
    public int compareTo(ReportPaymentComparable otherMethod){
        
        return Integer.compare(otherMethod.count, this.count);
    }

    @Override
    public String toString() {
        return String.format("%-15s: %d", method, count);
    }    
    
}
