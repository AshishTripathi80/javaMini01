package com.backendserver3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PendingTransaction {

    private String accountNumber;

    private List<Pending> pending;
}
