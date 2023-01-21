package com.mpr.storage;

import com.mpr.model.Transfer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransferStorage {

    private final List<Transfer> transferList = new ArrayList<>();
    public TransferStorage() {}

    public void add (Transfer transfer) {
        transferList.add(transfer);
    }
}
