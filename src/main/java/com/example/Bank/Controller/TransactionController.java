package com.example.Bank.Controller;

import com.example.Bank.Entity.AcctCreationEntity;
import com.example.Bank.Entity.TransactionEntity;
import com.example.Bank.dto.DepositeRequest;
import com.example.Bank.dto.TransRequest;
import com.example.Bank.dto.WithdrawRequest;
import com.example.Bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trans")
public class TransactionController {
    @Autowired
    TransactionService transactionService;


    @PostMapping("/Withdraw")
    public TransactionEntity withdraw(@RequestBody WithdrawRequest transactionEntity){
        return  transactionService.withdraw(transactionEntity);
    }


    @PostMapping("/Deposite")
    public TransactionEntity Deposite(@RequestBody DepositeRequest depositeRequest){
        return  transactionService.Deposite(depositeRequest);
    }

    @PostMapping("/Trans")
    public TransactionEntity Trans(@RequestBody TransRequest transRequest){
        return  transactionService.trans(transRequest);
    }
}
