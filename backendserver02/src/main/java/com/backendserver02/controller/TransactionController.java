package com.backendserver02.controller;

import com.backendserver02.model.FailureTransaction;
import com.backendserver02.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backendserver2")
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/failure/{accountNumber}")
    public FailureTransaction getFailureTransactions(@PathVariable String accountNumber) {
        LOGGER.info("Received request for failure transactions for accountNumber: {}", accountNumber);

        FailureTransaction failureTransactions = transactionService.getFailureTransactions(accountNumber);

        LOGGER.info("Returning SuccessTransaction: {}", failureTransactions);
        return failureTransactions;
    }
}
