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
    
    //setters
    public void setId(String id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
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

}