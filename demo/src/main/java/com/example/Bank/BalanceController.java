package com.example.Bank;


import com.example.Bank.model.TransferBalance;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController("/balance")
public class BalanceController {

    private final BankService bankService;

    public BalanceController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId) throws IllegalAccessException {
        return bankService.getBalance(accountId);
    }


    @PostMapping("/add")
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance){
        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferBalance transferBalance){

        bankService.makeTransfer(transferBalance);
    }

}
