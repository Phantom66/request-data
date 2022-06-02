package com.core.requestdata.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BalanceCoreModel {

    private Long requestId;
    private Long clientId;
    private int amountRequest;
    private int typeCreditId;
    private BigDecimal incomeAverage;
    private BigDecimal expenseTotal;

}

