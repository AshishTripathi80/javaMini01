package com.backendserver01.controller;

import com.backendserver01.model.SuccessTransaction;
import com.backendserver01.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/backendserver1")
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/success/{accountNumber}")
    public SuccessTransaction getSuccessTransactions(@PathVariable String accountNumber) {
        LOGGER.info("Received request for accountNumber: {}", accountNumber);

        SuccessTransaction successTransaction = transactionService.getSuccessTransactions(accountNumber);

        LOGGER.info("Returning SuccessTransaction: {}", successTransaction);
        return successTransaction;
    }
}
