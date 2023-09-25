package com.mycompany.oop;
public class Registration {
    public static User registerUser(String id, String password, String name, String category, String contactInfo) {
        User newUser = null;

        switch (category) {
            case "Admin":
                newUser = new Admin(id, password, name,contactInfo);
                break;
            case "Speaker":
                newUser = new Speaker(id, password, name,contactInfo);
                break;
            case "Attendee":
                newUser = new Attendee(id, password, name, contactInfo);
                break;
            default:
                System.out.println("Invalid category.");
                break;
        }

        return newUser;
    }
}
