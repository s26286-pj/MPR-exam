package com.mpr;

import com.mpr.model.User;
import com.mpr.storage.UserStorage;

import java.util.Optional;

public class UserService {
    private UserStorage userStorage;

    public UserService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public User createUser(String id, double balance) {
        this.userStorage.add(new User(id, balance));
        return this.findUserbyId(id);
    }

    public User findUserbyId(String id) {
        Optional<User> user = userStorage.getUserById(id);
        if (user.isEmpty()) {
            return null;
        } else {
            return user.get();
        }
    }

    public void updateBalanceById(String id, double newBalance) {
        User user = this.findUserbyId(id);
        user.setBalance(newBalance);
    }
}
