package com.core.requestdata.model;

import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class BalanceRequestModel {

    private boolean existPatria;
    private boolean existExchange;
    private Long id;
    private List<ExpenseModel> egresos;
    private List<IncomeModel> ingresos;

}
