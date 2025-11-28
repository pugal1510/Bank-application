package com.example.Bank.Repository;


import com.example.Bank.Entity.CustomerEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {



    public CustomerEntity existsByEmail(String email);

    Optional<CustomerEntity> findByCustomerid(String customerid);




}
