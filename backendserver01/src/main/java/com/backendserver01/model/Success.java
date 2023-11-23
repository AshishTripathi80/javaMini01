package com.backendserver01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Success {
    private String transactionId;
    private String status;
    private String amount;
    private String date;

    // constructors, getters, and setters
}