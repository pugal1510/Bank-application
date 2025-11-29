package com.example.Bank.dto;

import lombok.Data;

@Data
public class TransRequest {

    private Long toAccount;
    private Long fromAccount;
    private double amount;
}
