/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop;

import java.sql.Time;

/**
 *
 * @author User
 */
public abstract class ReportAbstract {
    
    public abstract Time getStartTimeByID(String id);
    public abstract Time getEndTimeByID(String id);
    public abstract int generateList(int category);
    public abstract boolean generateReport(int reportChoice, int category, String name);
    public abstract void splitID();
    public abstract void countAttendeeSeminar(int attendeechoice);
    public abstract void checkSeminars(int Choice, String name);
    public abstract void checkBooking();
    
    
}
