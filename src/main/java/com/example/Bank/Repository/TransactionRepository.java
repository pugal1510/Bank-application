package com.example.Bank.Repository;

import com.example.Bank.Entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  TransactionRepository extends JpaRepository<TransactionEntity,Long> {
}
