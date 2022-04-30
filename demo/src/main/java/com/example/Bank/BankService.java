package com.example.Bank;


import com.example.Bank.model.TransferBalance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BankService {
    private final BalanceRepository repository;

    public BigDecimal getBalance(Long accountId) throws IllegalAccessException {
        BigDecimal balance = repository.getBalanceForId(accountId);
        if (balance == null){
            throw new IllegalAccessException();
        }
        return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount){
        return repository.addBalanceForId(to, amount);
    }


    public void makeTransfer(TransferBalance transferBalance){
        Long from = transferBalance.getFrom();
        Long to = transferBalance.getTo();

        BigDecimal amount = transferBalance.getAmount();

        repository.addBalanceForId(to, amount);
        repository.removeBalanceForId(from, amount);
    }
}
