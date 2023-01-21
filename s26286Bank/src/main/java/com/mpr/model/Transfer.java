package com.mpr.model;

public class Transfer {
    private final String clientId;
    private final Number ammount;

    public Transfer(String clientId, Number ammount) {
        this.clientId = clientId;
        this.ammount = ammount;
    }
}
