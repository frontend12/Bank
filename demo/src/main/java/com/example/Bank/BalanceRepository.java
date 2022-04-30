package com.example.Bank;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BalanceRepository {

    private final Map<Long, BigDecimal> storage = new HashMap<>(Map.of(1L,BigDecimal.ZERO));


    public BigDecimal getBalanceForId(Long accountId){
        return storage.get(accountId);
    }

    public BigDecimal addBalanceForId(Long to, BigDecimal amount) {
        return storage.computeIfPresent(to, (k, v) -> v.add(amount));
    }

    public BigDecimal removeBalanceForId(Long to, BigDecimal amount) {
        return storage.computeIfPresent(to, (k, v) -> v.subtract(amount));
    }
}
