package com.core.requestdata.presenter;

import java.util.Date;
import com.core.requestdata.model.Client;
import com.core.requestdata.model.ClientResponse;
import com.core.requestdata.model.Request;
import com.core.requestdata.model.RequestModel;
import com.core.requestdata.model.ResponseModel;

import org.springframework.stereotype.Component;




@Component
public class RequestPresenter {

    public void setRequest(RequestModel in, Request out){ 
        Client client = new Client();
        client.setDocument(Integer.parseInt(in.getDocumento()));
        client.setExistExchange(true);
        client.setPhone(in.getTelefono());
        client.setHomePhone(in.getTelefonoLocal());
        client.setTypeDocument(in.getTipoDocumento());
        client.setExistPatria(false);
        client.setName(in.getNombre());
        out.setCreatedAt(new Date());
        out.setClient(client);
        out.setAmountRequest(Integer.parseInt(in.getMontoSolicitado()));
        out.setTerm(1);
        out.setCodReason(1);
        out.setTypeCreditid(1);
    }

    private ClientResponse setClientResponse(Request in, ClientResponse out) {        
        out.setTipoDocumento(in.getClient().getTypeDocument());
        out.setNumeroDocumento(Integer.toString(in.getClient().getDocument()));
        return out;
    }

    public ResponseModel<ClientResponse> setResponse(Request request){
        ClientResponse clientResponse = new ClientResponse();
        setClientResponse(request, clientResponse);
        return new ResponseModel<ClientResponse>("00", "Su registro ha sido exitoso", clientResponse);
    }
    
}
