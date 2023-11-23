package com.transactions.service;

import com.transactions.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private SuccessTransactionService successTransactionService;

    @Autowired
    private FailureTransactionService failureTransactionService;

    @Autowired
    private PendingTransactionService pendingTransactionService;
    public ResponseEntity<Map<String, List<Transaction>>> getTransaction01(String accountNumber, String status) {
        switch (status) {
            case "ALL" -> {
                List<Success> successTransactions = successTransactionService.getSuccessTransaction(accountNumber).getSuccess();
                List<Failure> failureTransactions = failureTransactionService.getFailureTransaction(accountNumber).getFailure();
                List<Pending> pendingTransactions = pendingTransactionService.getPendingTransaction(accountNumber).getPending();
                Map<String, List<Transaction>> response = new HashMap<>();
                response.put("success", mapToTransactionList(successTransactions));
                response.put("failure", mapToTransactionList(failureTransactions));
                response.put("pending", mapToTransactionList(pendingTransactions));
                return ResponseEntity.ok(response);
            }
            case "success" -> {
                List<Success> successOnly = successTransactionService.getSuccessTransaction(accountNumber).getSuccess();
                return ResponseEntity.ok(Collections.singletonMap("success", mapToTransactionList(successOnly)));
            }
            case "failure" -> {
                List<Failure> failureOnly = failureTransactionService.getFailureTransaction(accountNumber).getFailure();
                return ResponseEntity.ok(Collections.singletonMap("failure", mapToTransactionList(failureOnly)));
            }
            case "pending" -> {
                List<Pending> pendingOnly = pendingTransactionService.getPendingTransaction(accountNumber).getPending();
                return ResponseEntity.ok(Collections.singletonMap("pending", mapToTransactionList(pendingOnly)));
            }
            default -> {
                return ResponseEntity.badRequest().body(Collections.emptyMap());
            }
        }
    }

    private List<Transaction> mapToTransactionList(List<? extends Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> new TransactionDto(
                        transaction.getTransactionId(),
                        transaction.getStatus(),
                        transaction.getAmount(),
                        transaction.getDate()))
                .collect(Collectors.toList());
    }
}
