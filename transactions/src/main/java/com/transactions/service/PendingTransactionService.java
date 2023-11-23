package com.transactions.service;


import com.transactions.model.PendingTransaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BACKEND-SERVER-03")
public interface PendingTransactionService {
    @GetMapping("/backendserver3/pending/{accountNumber}")
    PendingTransaction getPendingTransaction(@PathVariable("accountNumber") String accountNumber);
}

