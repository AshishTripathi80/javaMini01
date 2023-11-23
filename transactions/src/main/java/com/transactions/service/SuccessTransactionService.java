package com.transactions.service;

import com.transactions.model.SuccessTransaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BACKEND-SERVER-01")
public interface SuccessTransactionService {

    @GetMapping("/backendserver1/success/{accountNumber}")
    SuccessTransaction getSuccessTransaction(@PathVariable("accountNumber") String accountNumber);
}
