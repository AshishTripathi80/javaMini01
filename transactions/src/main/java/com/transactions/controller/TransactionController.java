package com.transactions.controller;

import com.transactions.model.*;
import com.transactions.service.FailureTransactionService;
import com.transactions.service.PendingTransactionService;
import com.transactions.service.SuccessTransactionService;
import com.transactions.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions/{accountNumber}")
    public ResponseEntity<Map<String, List<Transaction>>> getTransactions(@PathVariable String accountNumber, @RequestParam(required = false) String status) {

        LOGGER.info("Received request for accountNumber: {} with status: {}", accountNumber, status);

        return transactionService.getTransactionConcurrent(accountNumber, status);
    }
}
