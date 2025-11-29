package com.example.Bank.service;

import com.example.Bank.Entity.AcctCreationEntity;
import com.example.Bank.Entity.CustomerEntity;

import com.example.Bank.Repository.AccountRepository;
import com.example.Bank.Repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class AcctService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;



    public AcctCreationEntity create(AcctCreationEntity acctCreationEntity){
        acctCreationEntity.setCreatedOn(LocalDateTime.now());
        CustomerEntity customer=new CustomerEntity();

        Optional<CustomerEntity> customerOpt =
                customerRepository.findByCustomerid(acctCreationEntity.getCustomerid());
        if(customerOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    ("No customer id found for this acct "+customer.getCustomerid()));

        }
        log.info("customer saved ");
        accountRepository.save(acctCreationEntity);
        return acctCreationEntity;
    }


}
