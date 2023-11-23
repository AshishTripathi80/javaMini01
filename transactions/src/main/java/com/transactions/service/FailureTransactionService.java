package com.transactions.service;


import com.transactions.model.FailureTransaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BACKEND-SERVER-02")
public interface FailureTransactionService {
    @GetMapping("/backendserver2/failure/{accountNumber}")
    FailureTransaction getFailureTransaction(@PathVariable("accountNumber") String accountNumber);
}

