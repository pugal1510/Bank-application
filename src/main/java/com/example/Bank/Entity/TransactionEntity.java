package com.example.Bank.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "TRANSACTION_DETAILS")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @Column(name = "TRANSACTION_TYPE", nullable = false, length = 20)
    private String type; // DEPOSIT / WITHDRAW / TRANSFER

    @Column(name = "AMOUNT", nullable = false)
    private Double amount;

    @Column(name = "TRANSACTION_TIME", nullable = false)
    private LocalDateTime transactiontime;

    // For deposit/withdraw, only account will be used.
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_NUMBER", referencedColumnName = "ACCOUNT_NUMBER")
    private AcctCreationEntity accountNumber;

    // For transfer transactions
    @ManyToOne
    @JoinColumn(name = "FROM_ACCOUNT", referencedColumnName = "ACCOUNT_NUMBER")
    private AcctCreationEntity fromAccount;

    @ManyToOne
    @JoinColumn(name = "TO_ACCOUNT", referencedColumnName = "ACCOUNT_NUMBER")
    private AcctCreationEntity toAccount;
}