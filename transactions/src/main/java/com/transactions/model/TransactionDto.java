package com.transactions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto implements Transaction {
    private String transactionId;
    private String status;
    private String amount;
    private String date;
}

