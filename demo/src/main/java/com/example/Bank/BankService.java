package com.example.Bank;


import com.example.Bank.model.TransferBalance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BankService {
    private final BalanceController repository;



    public BigDecimal getBalance(Long accountId){
        BigDecimal balance = repository.getBalanceForId(accountId);
        if (balance == null){
            throw new IllegalAccessException();
        }
        return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount){
        return null;
    }


    public void makeTransfer(TransferBalance, TransferBalance TransferBalance){

    }
}
