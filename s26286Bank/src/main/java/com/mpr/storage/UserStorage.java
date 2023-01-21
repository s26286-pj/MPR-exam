package com.mpr.storage;

import com.mpr.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserStorage {

    private final List<User> userList = new ArrayList<>();
    public UserStorage() {
        userList.add(new User("adam", 2000));
        userList.add(new User("mietek", 3000));
    }

    public Optional<User> getUserById(String id) {
        return userList
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
