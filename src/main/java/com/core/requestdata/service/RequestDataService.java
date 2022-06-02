package com.core.requestdata.service;


import com.core.requestdata.model.ClientResponse;
import com.core.requestdata.model.RequestModel;
import com.core.requestdata.model.ResponseModel;



public interface RequestDataService {
    public ResponseModel<ClientResponse> save(RequestModel requestModel);
}
