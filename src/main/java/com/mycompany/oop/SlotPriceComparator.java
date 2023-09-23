package com.mycompany.oop;

import java.util.Comparator;

public class SlotPriceComparator implements Comparator<Slot> {
    @Override
    public int compare(Slot slot1, Slot slot2) {
        return Double.compare(slot1.getPrice(), slot2.getPrice());
    }
}
