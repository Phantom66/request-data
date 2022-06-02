package com.core.requestdata.service;

import com.core.requestdata.model.*;
import com.core.requestdata.presenter.BalancePresenter;
import com.core.requestdata.presenter.RequestPresenter;
import com.core.requestdata.repository.ExpenseRepository;
import com.core.requestdata.repository.IncomeRepository;
import com.core.requestdata.repository.RequestDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class IncomeExpenseServiceImpl implements IncomeExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private BalancePresenter balancePresenter;

    @Autowired
    private RequestDataRepository requestDataRepository;

    @Override
    public ResponseModel<BalanceResponseModel> saveBalance(BalanceRequestModel balanceRequestModel) throws ParseException {

        BalanceCoreModel balanceCoreModel = new BalanceCoreModel();
        Request request = requestDataRepository.getById(balanceRequestModel.getId());

        balanceCoreModel = balancePresenter.convertToCore(balanceCoreModel, balanceRequestModel, request);

        List<ExpenseModel> egresos = balanceRequestModel.getEgresos();

        Integer count=0;
        List<Expense> expenseRecords = new ArrayList<>();

        for (ExpenseModel expenseModel : egresos){
            Expense expense = new Expense();
            expense.setDateExpense(balancePresenter.getDate());
            expense.setAmountExpense(expenseModel.getAmount());
            expense.setRequest(request);

            expenseRecords.add(expense);
        }
        expenseRecords = expenseRepository.saveAll(expenseRecords);

        List<IncomeModel> ingresos = balanceRequestModel.getIngresos();
        List<Income> incomeRecords = new ArrayList<>();
        LocalDate thisMonth    = LocalDate.now();

        for (IncomeModel incomeModel : ingresos){
            LocalDate lastMonth    = thisMonth.minusMonths(count);
            Income income = new Income();

            income.setRequest(request);
            income.setDateIncome(lastMonth.withDayOfMonth(1));
            income.setAmountIncome(incomeModel.getAmount());

            incomeRecords.add(income);
            count++;
        }
        log.info("incomes a guardar: {}",incomeRecords );
        incomeRecords = incomeRepository.saveAll(incomeRecords);

        return balancePresenter.setResponse(incomeRecords);
    }

}
