package com.backendserver01.service;

import com.backendserver01.model.Success;
import com.backendserver01.model.SuccessTransaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    public SuccessTransaction getSuccessTransactions(String accountNumber) {



        // Hardcoded data for success transactions
        List<SuccessTransaction> successTransactions =new ArrayList<>();
        SuccessTransaction successTransaction =new SuccessTransaction();
        successTransaction.setAccountNumber("12233300011001");
        List<Success> successes = new ArrayList<>();

        Success success1 = new Success();
        success1.setTransactionId("123456789");
        success1.setStatus("success");
        success1.setAmount("500");
        success1.setDate("30-05-2023");

        Success success2 = new Success();
        success2.setTransactionId("789566233");
        success2.setStatus("success");
        success2.setAmount("100");
        success2.setDate("31-05-2023");

        Success success3 = new Success();
        success3.setTransactionId("556666678");
        success3.setStatus("success");
        success3.setAmount("700");
        success3.setDate("20-05-2023");

        successes.add(success1);
        successes.add(success2);
        successes.add(success3);
        successTransaction.setSuccess(successes);
        successTransactions.add(successTransaction);

        // Filter transactions based on the specified account number and get the first one
        Optional<SuccessTransaction> filteredSuccessTransaction = successTransactions.stream()
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
