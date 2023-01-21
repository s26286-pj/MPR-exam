package com.mpr.model;

public class User {

    private final String id;
    private final Number balance;
    public User (String id, Number balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }
}
