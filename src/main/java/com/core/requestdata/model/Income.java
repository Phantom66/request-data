package com.core.requestdata.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Income {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private BigDecimal amountIncome;

    private LocalDate dateIncome;

    @ManyToOne
    private Request request;
}
