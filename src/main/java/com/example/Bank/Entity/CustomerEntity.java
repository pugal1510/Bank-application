package com.example.Bank.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name="CUSTOMER_DETAILS")
@Data
public class CustomerEntity {

    @Id
    @Column(name="REF_NO")
    private String refno;

    @Column(name="CUSTOMER_ID")
    private String customerid;

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL_ID",unique = true)
    private String email;//unique
    @Column(name = "PHONE_NO")
    private String phoneNumber;
    @Column(name = "ADDRESS")
    private String add;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_ON")
    private LocalDateTime createdOn;
    @Column(name = "LAST_MODIFIED")
    private LocalDateTime LastModified;


}
