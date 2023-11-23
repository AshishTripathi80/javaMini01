package com.backendserver02.service;

import com.backendserver02.model.Failure;
import com.backendserver02.model.FailureTransaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    public FailureTransaction getFailureTransactions(String accountNumber) {



        // Hardcoded data for failure transactions
        List<FailureTransaction> failureTransactions =new ArrayList<>();
        FailureTransaction failureTransaction =new FailureTransaction();
        failureTransaction.setAccountNumber("12233300011001");
        List<Failure> failures = new ArrayList<>();

        Failure failure1 = new Failure();
        failure1.setTransactionId("123456789");
        failure1.setStatus("failure");
        failure1.setAmount("500");
        failure1.setDate("30-05-2023");

        Failure failure2 = new Failure();
        failure2.setTransactionId("789566233");
        failure2.setStatus("failure");
        failure2.setAmount("100");
        failure2.setDate("31-05-2023");

        Failure failure3 = new Failure();
        failure3.setTransactionId("556666678");
        failure3.setStatus("failure");
        failure3.setAmount("700");
        failure3.setDate("20-05-2023");

        failures.add(failure1);
        failures.add(failure2);
        failures.add(failure3);
        failureTransaction.setFailure(failures);
        failureTransactions.add(failureTransaction);

        // Filter transactions based on the specified account number


        Optional<FailureTransaction> filteredSuccessTransaction = failureTransactions.stream()
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
