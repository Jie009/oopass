package com.mycompany.oop;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class SlotDateComparator implements Comparator<Slot> {
   
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public int compare(Slot slot1, Slot slot2) {
        try {
            Date date1 = dateFormat.parse(slot1.getSlotDate());
            Date date2 = dateFormat.parse(slot2.getSlotDate());

            return date1.compareTo(date2);
        } catch (ParseException e) {
        }               
        return 0;
    }
}
