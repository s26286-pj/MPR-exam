package com.mpr.storage;

import com.mpr.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class UserStorage {

    private final List<User> userList = new ArrayList<>();
    public UserStorage() {}

    public void add(User user) {
        userList.add(user);
    }
    public Optional<User> getUserById(String id) {
        return userList
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public void updateBalance(String clientId, Number ammount) {
        //{status, saldo}
    }
}
