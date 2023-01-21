package com.mpr.storage;

import com.mpr.model.Transfer;
import com.mpr.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransferStorage {

    private final List<Transfer> transferList = new ArrayList<>();
    public TransferStorage() {

    }

    public void add (Transfer transfer) {
        transferList.add(transfer);
    }
}
