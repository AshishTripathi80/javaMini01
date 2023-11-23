package com.transactions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Success implements Transaction {
    private String transactionId;
    private String status;
    private String amount;
    private String date;

    // constructors, getters, and setters
}