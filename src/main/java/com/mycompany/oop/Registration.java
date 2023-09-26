package com.mycompany.oop;

import java.util.List;

public class Registration {
    public static void registerUser(String id, String password, String name, String category, String contactInfo, List<Admin> admins, List<Speaker> speakers, List<Attendee> attendees) {
        if ("Admin".equals(category)) {
            Admin newAdmin = new Admin(id, password, name, contactInfo);
            admins.add(newAdmin);
        } else if ("Speaker".equals(category)) {
            Speaker newSpeaker = new Speaker(id, password, name, contactInfo);
            speakers.add(newSpeaker);
        } else if ("Attendee".equals(category)) {
            Attendee newAttendee = new Attendee(id, password, name, contactInfo, null, null);
            attendees.add(newAttendee);
        }
    }
}
