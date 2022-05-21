package com.core.requestdata.service;

import com.core.requestdata.model.Request;
import com.core.requestdata.model.RequestModel;
import com.core.requestdata.model.ResponseModel;
import com.core.requestdata.presenter.RequestPresenter;
import com.core.requestdata.repository.RequestDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestDataServiceImpl implements RequestDataService {

    @Autowired
    private RequestDataRepository requestDataRepository;

    @Autowired
    private RequestPresenter requestPresenter;

    @Override
    public ResponseModel<Request> save(RequestModel requestModel) {
        Request request = new Request();
        requestPresenter.setRequest(request, requestModel);
        return requestPresenter.setResponse(requestDataRepository.save(request));
    }

}
