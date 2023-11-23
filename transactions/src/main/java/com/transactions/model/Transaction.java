package com.transactions.model;

public interface Transaction {
    String getTransactionId();
    String getStatus();
    String getAmount();
    String getDate();
}
