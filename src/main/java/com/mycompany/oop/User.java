    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop;


public class User {
    private String id;
    private String password;
    private String name;
    private String category;
    private String contactInfo;
    private static String[][] userList = new String[100][5];
    private static int userCount = 0;

    // Constructor
    public User(String id, String password, String name, String category, String contactInfo) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.category = category;
        this.contactInfo = contactInfo;
    }

    //getters
    public String getid(){
    return id;
    }

    public String getpassword(){
    return password;
    }
    public String getname(){
    return name;
    }
    public String getcategory(){
    return category;
    }
    public String getcontactInfo(){
    return contactInfo;
    }
    // Update User List
    public void updateUserList() {
        userList[userCount][0] = id;
        userList[userCount][1] = password;
        userList[userCount][2] = name;
        userList[userCount][3] = category;
        userList[userCount][4] = contactInfo;
        userCount++;
    }

    // Validate Login
    public static String validateLogin(String id, String password, String category) {
        for (int i = 0; i < userCount; i++) {
            if (userList[i][0].equals(id) && userList[i][1].equals(password) && userList[i][3].equals(category)) {
                return userList[i][2]; // Return the name of the user
            }
        }
        return null; // Login failed
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
    // Admin subclass
    public class Admin extends User {
        public Admin(String id, String password, String name, String contactInfo) {
            super(id, password, name, "Admin", contactInfo);
        }

    }


    // Attendee subclass
    public class Attendee extends User {
        public Attendee(String id, String password, String name, String contactInfo) {
            super(id, password, name, "Attendee", contactInfo);
        }

    }
}

