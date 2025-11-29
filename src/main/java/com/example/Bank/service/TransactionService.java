package com.example.Bank.service;

import com.example.Bank.Entity.AcctCreationEntity;
import com.example.Bank.Entity.TransactionEntity;
import com.example.Bank.Repository.AccountRepository;
import com.example.Bank.Repository.TransactionRepository;
import com.example.Bank.dto.DepositeRequest;
import com.example.Bank.dto.TransRequest;
import com.example.Bank.dto.WithdrawRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    public TransactionEntity withdraw(WithdrawRequest request) {

        // 1. Fetch real account from DB
        AcctCreationEntity account = accountRepository
                .findByAccountnumber(request.getAccountNumber())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Account number not found"));
        System.out.println("account number :"+request.getAccountNumber());

        double amount = request.getAmount();
        double balance = account.getBalance();

        log.info("Balance={}, Amount={}", balance, amount);

        // 2. Check balance
        if (balance < amount) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Insufficient balance");
        }

        // 3. Deduct and update
        account.setBalance(balance - amount);
        account.setLastmodified(LocalDateTime.now());

        accountRepository.save(account);

        // 4. Save transaction
        TransactionEntity txn = new TransactionEntity();
        txn.setType("WITHDRAW");
        txn.setAmount(amount);
        txn.setTransactiontime(LocalDateTime.now());
        txn.setAccountNumber(account);

        return transactionRepository.save(txn);
    }


    public TransactionEntity Deposite(DepositeRequest deposite){
        AcctCreationEntity account=accountRepository
                .findByAccountnumber(deposite.getAccountNumber())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Account number not found"));

                double amount=deposite.getAmount();
                double balance=account.getBalance();


                double newbalance=amount+balance;
                account.setBalance(newbalance);
                account.setLastmodified(LocalDateTime.now());
                accountRepository.save(account);

        TransactionEntity txn = new TransactionEntity();
        txn.setType("DEPOSITE");
        txn.setAmount(amount);
        txn.setTransactiontime(LocalDateTime.now());
        txn.setAccountNumber(account);

        return transactionRepository.save(txn);

    }
    public TransactionEntity trans(TransRequest transRequest) {
        AcctCreationEntity fromacct = accountRepository
                .findByAccountnumber(transRequest.getFromAccount())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "FROM Account number not found"));

        AcctCreationEntity toacct = accountRepository
                .findByAccountnumber(transRequest.getToAccount())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TO Account number not found"));

        double fromAmount = fromacct.getBalance();
        double toAmmount = toacct.getBalance();
        double amount = transRequest.getAmount();

        if (fromAmount > amount) {
            double newbalancefrom = fromAmount - amount;
            fromacct.setBalance(newbalancefrom);
            double newbalanceto = toAmmount + amount;
            toacct.setBalance(newbalanceto);
            accountRepository.save(fromacct);
            accountRepository.save(toacct);

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficent balance");
        }

        TransactionEntity txn = new TransactionEntity();
        txn.setType("Trans");
        txn.setAmount(amount);
        txn.setTransactiontime(LocalDateTime.now());
        txn.setFromAccount(fromacct);
        txn.setToAccount(toacct);


        return transactionRepository.save(txn);
    }

}