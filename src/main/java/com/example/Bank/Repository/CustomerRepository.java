package com.example.Bank.Repository;


import com.example.Bank.Entity.CustomerEntity;
import com.example.Bank.service.CustomerService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
     boolean existsByEmail(String email);
     Optional<CustomerEntity> findByCustomerid(String customerid);




}
