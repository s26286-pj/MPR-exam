package com.mpr.model;

public class User {

    private final String id;
    private double balance;



    public User (String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    @Override
    public String toString() {
        return "id=" + this.id + " balance=" + this.balance;
    }
}
