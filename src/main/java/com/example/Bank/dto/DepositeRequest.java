package com.example.Bank.dto;

import lombok.Data;

@Data
public class DepositeRequest {
    private Long accountNumber;
    private Double amount;
}
