package com.backendserver3.controller;

import com.backendserver3.model.PendingTransaction;
import com.backendserver3.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backendserver3")
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/pending/{accountNumber}")
    public PendingTransaction getPendingTransactions(@PathVariable String accountNumber) {
        LOGGER.info("Received request for pending transactions for accountNumber: {}", accountNumber);

        PendingTransaction pendingTransactions = transactionService.getPendingTransactions(accountNumber);

        LOGGER.info("Returning SuccessTransaction: {}", pendingTransactions);

        return pendingTransactions;
    }
}
