package com.core.requestdata.presenter;

import java.util.Date;
import com.core.requestdata.model.Client;
import com.core.requestdata.model.Request;
import com.core.requestdata.model.RequestModel;
import com.core.requestdata.model.ResponseModel;

import org.springframework.stereotype.Component;




@Component
public class RequestPresenter {


    public void setRequest(Request request, RequestModel requestModel){ 
        Client client = new Client();
        client.setDocument(Integer.parseInt(requestModel.getDocument()));
        client.setExistExchange(true);
        client.setPhone(requestModel.getPhone());
        client.setHomePhone(requestModel.getPhoneHome());
        client.setTypeDocument("V");
        client.setExistPatria(false);
        client.setName(requestModel.getName());
        request.setCreatedAt(new Date());
        request.setClient(client);
        request.setAmountRequest(Integer.parseInt(requestModel.getAmountRequest()));
        request.setTerm(1);
        request.setCodReason(1);
        request.setTypeCreditid(1);
    }


    public ResponseModel<Request> setResponse(Request request){
        return new ResponseModel<Request>("00", "Su registro ha sido exitoso", request);
    }
    
}
