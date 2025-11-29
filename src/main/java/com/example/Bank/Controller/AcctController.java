package com.example.Bank.Controller;

import com.example.Bank.Entity.AcctCreationEntity;
import com.example.Bank.service.AcctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Acct")
public class AcctController {

    @Autowired
    AcctService acctService;


    @PostMapping("/create")
    public AcctCreationEntity creation(@RequestBody AcctCreationEntity acctCreationEntity){
         return acctService.create(acctCreationEntity);

    }
}
