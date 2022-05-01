package com.example.demo;


import java.math.BigDecimal;
import com.example.demo.model.TransferBalance;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/balance")
@AllArgsConstructor
public class BalanceController {

    private final BankService bankService;

    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId) {
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
