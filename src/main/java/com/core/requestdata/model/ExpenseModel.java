package com.core.requestdata.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ExpenseModel {

    private Long type;
    private BigDecimal amount;
    private Date date;
}
