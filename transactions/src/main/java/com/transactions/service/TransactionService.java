package com.transactions.service;

import com.transactions.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private SuccessTransactionService successTransactionService;

    @Autowired
    private FailureTransactionService failureTransactionService;

    @Autowired
    private PendingTransactionService pendingTransactionService;

    public ResponseEntity<Map<String, List<Transaction>>> getTransactionConcurrent(String accountNumber, String status) {
        CompletableFuture<List<Transaction>> successFuture = CompletableFuture.supplyAsync(() ->
                mapToTransactionList(successTransactionService.getSuccessTransaction(accountNumber).getSuccess()));

        CompletableFuture<List<Transaction>> failureFuture = CompletableFuture.supplyAsync(() ->
                mapToTransactionList(failureTransactionService.getFailureTransaction(accountNumber).getFailure()));

        CompletableFuture<List<Transaction>> pendingFuture = CompletableFuture.supplyAsync(() ->
                mapToTransactionList(pendingTransactionService.getPendingTransaction(accountNumber).getPending()));

        try {
            List<Transaction> successTransactions = successFuture.get();
            List<Transaction> failureTransactions = failureFuture.get();
            List<Transaction> pendingTransactions = pendingFuture.get();

            Map<String, List<Transaction>> response = new HashMap<>();
            response.put("success", successTransactions);
            response.put("failure", failureTransactions);
            response.put("pending", pendingTransactions);

            return ResponseEntity.ok(response);
        } catch (InterruptedException | ExecutionException e) {
            // Handle exceptions appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyMap());
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