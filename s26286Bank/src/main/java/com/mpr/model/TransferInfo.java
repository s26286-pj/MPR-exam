package com.mpr.model;

public class TransferInfo {
    private final Status status;

    private final double currentBalance;

    public TransferInfo(Status status, double currentBalance) {
        this.status = status;
        this.currentBalance = currentBalance;
    }

    public double getCurrentBalance() {
        return this.currentBalance;
    }

    public Status getStatus() {
        return this.status;
    }
}
