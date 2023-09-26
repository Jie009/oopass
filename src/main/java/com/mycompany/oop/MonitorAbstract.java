package com.mycompany.oop;

import java.sql.Time;

public abstract class MonitorAbstract {
     
    //Declare abstract classes for monitor
    //
    
    public abstract int displayChoices();
    public abstract Time getStartTimeByID(String id);
    public abstract Time getEndTimeByID(String id);
    public abstract boolean displayList(int choice);
    public abstract void checkSeminars(int ongoingChoice);
    public abstract void checkVenue(int choiceVenue);
    public abstract void updateSlot(int slotChoice);
    public abstract void countAttendeeSeminar();
}
