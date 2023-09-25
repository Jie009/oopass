package com.mycompany.oop;

import java.util.ArrayList;
import java.util.List;

public class UserStore {
    private List<Admin> adminList;
    private List<Speaker> speakerList;
    private List<Attendee> attendeeList;

    public UserStore() {
        this.adminList = new ArrayList<>();
        this.speakerList = new ArrayList<>();
        this.attendeeList = new ArrayList<>();
    }

    public void addAdmin(Admin admin) {
        adminList.add(admin);
    }

    public void addSpeaker(Speaker speaker) {
        speakerList.add(speaker);
    }

    public void addAttendee(Attendee attendee) {
        attendeeList.add(attendee);
    }
}

