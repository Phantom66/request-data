package com.core.requestdata.controller;

import com.core.requestdata.model.*;
import com.core.requestdata.service.IncomeExpenseServiceImpl;
import com.core.requestdata.service.RequestDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;


@Slf4j
@RequestMapping("/")
@RestController
public class RequestDataController {

    @Autowired
    private RequestDataServiceImpl requestDataServiceImpl;

    @Autowired
    private IncomeExpenseServiceImpl incomeExpenseServiceImpl;

    @PostMapping("save-request-data")
    public ResponseEntity<ResponseModel<ClientResponse>> getRequest(@RequestBody RequestModel requestModel) {
        log.info("Controller {}", requestModel);
        return new ResponseEntity<>(requestDataServiceImpl.save(requestModel), HttpStatus.OK);
    }

    @PostMapping("save-ingresos-egresos")
    public ResponseEntity<ResponseModel<BalanceResponseModel>> save(@RequestBody BalanceRequestModel balanceRequestModel) throws ParseException {
        log.info("Controller save ingresos-egresos {}", balanceRequestModel);
        return new ResponseEntity<>(incomeExpenseServiceImpl.saveBalance(balanceRequestModel), HttpStatus.OK);
    }

}
