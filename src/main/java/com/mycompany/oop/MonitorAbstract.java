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
public abstract class MonitorAbstract {
    
    
    
    public abstract int displayChoices();
    public abstract Time getStartTimeByID(String id);
    public abstract Time getEndTimeByID(String id);
    public abstract void displayList(int choice);
    public abstract void checkSeminars(int ongoingChoice);
    public abstract void checkVenue(int choiceVenue);
    public abstract void updateSlot(int slotChoice);
    public abstract void countAttendeeSeminar();
}
