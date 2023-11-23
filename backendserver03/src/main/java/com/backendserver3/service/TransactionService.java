package com.backendserver3.service;

import com.backendserver3.model.Pending;
import com.backendserver3.model.PendingTransaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    public PendingTransaction getPendingTransactions(String accountNumber) {



        // Hardcoded data for pending transactions
        List<PendingTransaction> pendingTransactions =new ArrayList<>();
        PendingTransaction pendingTransaction =new PendingTransaction();
        pendingTransaction.setAccountNumber("12233300011001");
        List<Pending> pendings = new ArrayList<>();

        Pending pending1 = new Pending();
        pending1.setTransactionId("123456789");
        pending1.setStatus("pending");
        pending1.setAmount("500");
        pending1.setDate("30-05-2023");

        Pending pending2 = new Pending();
        pending2.setTransactionId("789566233");
        pending2.setStatus("pending");
        pending2.setAmount("100");
        pending2.setDate("31-05-2023");

        Pending pending3 = new Pending();
        pending3.setTransactionId("556666678");
        pending3.setStatus("pending");
        pending3.setAmount("700");
        pending3.setDate("20-05-2023");

        pendings.add(pending1);
        pendings.add(pending2);
        pendings.add(pending3);
        pendingTransaction.setPending(pendings);
        pendingTransactions.add(pendingTransaction);

        Optional<PendingTransaction> filteredSuccessTransaction = pendingTransactions.stream()
                .filter(t -> accountNumber.equals(t.getAccountNumber()))
                .findFirst();

        // Check if a matching transaction was found
        if (filteredSuccessTransaction.isPresent()) {
            return filteredSuccessTransaction.get();
        } else {

            return null; // or throw an exception, depending on your requirements
        }
    }
}
