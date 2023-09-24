/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop;

public class Admin {
    private String id;
    private String password;
    private String name;
    private String contactInfo;

    public Admin(String id, String password, String name, String contactInfo) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getid(){
    return id;
    }
    public String getpassword(){
    return password;
    }
    public String getname(){
    return name;
    }
    public String getcontactInfo(){
    return contactInfo;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}
