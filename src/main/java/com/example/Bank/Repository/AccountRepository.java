package com.example.Bank.Repository;

import com.example.Bank.Entity.AcctCreationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<AcctCreationEntity,Long> {

    Optional<AcctCreationEntity>findByAccountnumber(Long accountnumber);

}