package com.core.requestdata.service;


import com.core.requestdata.model.Request;
import com.core.requestdata.model.RequestModel;
import com.core.requestdata.model.ResponseModel;



public interface RequestDataService {
    public ResponseModel<Request> save(RequestModel requestModel);
}
