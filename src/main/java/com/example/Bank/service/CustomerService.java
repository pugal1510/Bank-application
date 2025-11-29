package com.example.Bank.service;

import com.example.Bank.Constants.BankingConstants;
import com.example.Bank.Entity.CustomerEntity;
import com.example.Bank.Repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;



    BankingConstants bb = new BankingConstants();

    // CREATE or UPDATE (UPSERT)
    public CustomerEntity createcustomer(CustomerEntity customerEntity) throws BadRequestException {

        // Find existing record by customerId
        Optional<CustomerEntity> customerOpt =
                customerRepository.findByCustomerid(customerEntity.getCustomerid());

        // If customer does NOT exist → CREATE
        if (customerOpt.isEmpty()) {
            if(customerRepository.existsByEmail(customerEntity.getEmail())){
                log.error("Email id already exists"+customerEntity.getEmail());
                throw new BadRequestException("Email id already exist");

            }

            customerEntity.setRefno(generateUnique());
            customerEntity.setCreatedBy(bb.CREATEDBY);
            customerEntity.setCreatedOn(LocalDateTime.now());
            return customerRepository.save(customerEntity);

        }

        // If exists → UPDATE
        return updatecustomer(customerOpt.get(), customerEntity);
    }


    // UPDATE EXISTING CUSTOMER
    private CustomerEntity updatecustomer(CustomerEntity existing, CustomerEntity request) {

        existing.setFirstName(request.getFirstName());
        existing.setLastName(request.getLastName());
        existing.setEmail(request.getEmail());
        existing.setPhoneNumber(request.getPhoneNumber());
        existing.setAdd(request.getAdd());

        existing.setLastModified(LocalDateTime.now());
        existing.setCreatedBy(bb.CREATEDBY);

        return customerRepository.save(existing);
    }

//Listing the customer data by customer id
    public CustomerEntity getCustomerByCustomerId(String customerid) {
        return customerRepository.findByCustomerid(customerid)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"Customer not found with ID: " + customerid));
    }


    private String generateUnique() {
        return UUID.randomUUID().toString().toUpperCase();

    }
}