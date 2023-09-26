package com.mycompany.oop;

import java.sql.Time;

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
