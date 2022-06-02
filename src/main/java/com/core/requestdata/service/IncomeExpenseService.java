package com.core.requestdata.service;


import com.core.requestdata.model.*;

import java.text.ParseException;


public interface IncomeExpenseService {

    public ResponseModel<BalanceResponseModel> saveBalance(BalanceRequestModel balanceRequestModel) throws ParseException;
}
