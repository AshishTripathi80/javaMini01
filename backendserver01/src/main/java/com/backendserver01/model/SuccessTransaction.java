package com.backendserver01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessTransaction {

    private String accountNumber;

    private List<Success> success;
}
