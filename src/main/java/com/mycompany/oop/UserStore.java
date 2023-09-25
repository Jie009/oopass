package com.mycompany.oop;

import java.util.ArrayList;
import java.util.List;

public class UserStore {
    private List<User> userList;

    public UserStore() {
        this.userList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUserById(String id) {
        for (User user : userList) {
            if (user.getid().equals(id)) {
                return user;
            }
        }
        return null;
    }

    // Implement other methods to manage users as needed

    public List<User> getAllUsers() {
        return userList;
    }
}

