package com.example.Bank.model;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferBalance {

    private Long from;
    private Long to;
    private BigDecimal amount;

    public Long getTo() {
    }

    public BigDecimal getAmout() {
    }
}
