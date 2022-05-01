package com.example.demo;


import com.example.demo.exception.ExceptionErrorBalance;
import com.example.demo.model.TransferBalance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BankService {
    private final BalanceRepository repository;

    public BigDecimal getBalance(Long accountId) {
        BigDecimal balance = repository.getBalanceForId(accountId);
        if (balance == null){
            throw new ExceptionErrorBalance("There is no money on the balance");
        }
        return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount){
        return repository.addBalanceForId(to, amount);
    }


//    Здесь был лишний параметр с типом но без переменной.

//    По сути принимаем простой pojo сюда, извлекаем id-клиентов(как понял) ну и обращаемся к слою репозиторию.
    public void makeTransfer(TransferBalance transferBalance){
        Long from = transferBalance.getFrom();
        Long to = transferBalance.getTo();

        BigDecimal amount = transferBalance.getAmount();


//        У одного вычитаем баланс
        repository.addBalanceForId(to, amount);
//        К другому прибавляем
        repository.removeBalanceForId(from, amount);
    }
}
