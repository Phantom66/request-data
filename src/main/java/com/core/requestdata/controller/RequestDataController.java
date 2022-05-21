package com.core.requestdata.controller;

import com.core.requestdata.model.Request;
import com.core.requestdata.model.RequestModel;
import com.core.requestdata.model.ResponseModel;
import com.core.requestdata.service.RequestDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping("/")
@RestController
public class RequestDataController {

    @Autowired
    private RequestDataServiceImpl requestDataServiceImpl;

    @PostMapping("save-request-data")
    public ResponseEntity<ResponseModel<Request>> getRequest(@RequestBody RequestModel requestModel) {
        log.info("Controller {}", requestModel);
        return new ResponseEntity<>(requestDataServiceImpl.save(requestModel), HttpStatus.OK);
    }
}
