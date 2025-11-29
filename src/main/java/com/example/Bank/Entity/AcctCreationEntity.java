package com.example.Bank.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ACCOUNT_CREATION")
public class AcctCreationEntity {

    @Id
    @Column(name = "ACCOUNT_NUMBER")
    private Long accountnumber;

    @Column(name="CUSTOMER_ID")
    private String customerid;

    @Column(name = "ACCOUNT_TYPE", nullable = false, length = 20)
    private String acctype;

    @Column(name = "BALANCE", nullable = false)
    private Double balance;

    @Column(name = "STATUS", length = 20)
    private String status;

    @Column(name = "CREATED_ON")
    private LocalDateTime createdOn;

    @Column(name = "LAST_MODIFIED")
    private LocalDateTime lastmodified;


}