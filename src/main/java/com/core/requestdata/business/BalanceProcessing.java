package com.core.requestdata.business;

import com.core.requestdata.model.BalanceRequestModel;
import com.core.requestdata.model.ExpenseModel;
import com.core.requestdata.model.IncomeModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class BalanceProcessing {


    public BigDecimal calculateExpenseTotal(BalanceRequestModel balanceRequestModel) {

        List<ExpenseModel> egresos = balanceRequestModel.getEgresos();
        BigDecimal expenseTotal = new BigDecimal(0);
        for (ExpenseModel expenseModel : egresos ){
                expenseTotal = expenseModel.getAmount().add(expenseTotal);
        }

        return expenseTotal;
    }

    public BigDecimal calculateIncomeAverage(BalanceRequestModel balanceRequestModel) {

        List<IncomeModel> ingresos = balanceRequestModel.getIngresos();
        BigDecimal ingresoTotal = new BigDecimal(0);
        BigDecimal count = new BigDecimal(0);

        for (IncomeModel incomeModel : ingresos ){
            ingresoTotal = incomeModel.getAmount().add(ingresoTotal);
            count.add(BigDecimal.valueOf(1));
        }

        return ingresoTotal.divide(count);
    }
}
