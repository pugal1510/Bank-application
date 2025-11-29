package com.example.Bank.dto;

import lombok.Data;

@Data
public class WithdrawRequest {
    private Long accountNumber;
    private Double amount;
}