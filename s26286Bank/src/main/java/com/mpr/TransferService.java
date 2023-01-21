package com.mpr;

import com.mpr.model.Status;
import com.mpr.model.TransferInfo;
import com.mpr.model.User;
import com.mpr.storage.TransferStorage;
import com.mpr.storage.UserStorage;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TransferService {
    private final UserStorage userStorage;
    private final TransferStorage transferStorage;
    public TransferService(UserStorage userStorage, TransferStorage transferStorage) {
        this.userStorage = userStorage;
        this.transferStorage = transferStorage;
    }
    public TransferInfo makeTransferFrom(String clientId, double ammount) {
        Optional<User> user = userStorage.getUserById(clientId);
        if (user.isEmpty()) {
            return new TransferInfo(Status.DECLINED, 0);
        }
        double balance = user.get().getBalance();
        if (balance-ammount > 0) {
            userStorage.updateBalance(clientId, balance-ammount);
            return new TransferInfo(Status.ACCEPTED, user.get().getBalance());
        } else {
            return new TransferInfo(Status.DECLINED, balance);
        }
    }

    public TransferInfo makeTransferTo(String clientId, double amount) {
        Optional<User> user = userStorage.getUserById(clientId);
        if (user.isEmpty()) {
            return new TransferInfo(Status.DECLINED, 0);
        }
        double balance = user.get().getBalance();
        userStorage.updateBalance(clientId, balance + amount);
        return new TransferInfo(Status.ACCEPTED, user.get().getBalance());
    }
}
