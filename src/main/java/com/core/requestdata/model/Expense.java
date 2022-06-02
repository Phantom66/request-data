package com.core.requestdata.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private BigDecimal amountExpense;

    private LocalDate dateExpense;

    @ManyToOne
    private Request request;

}