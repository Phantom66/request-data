package com.core.requestdata.presenter;

import com.core.requestdata.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Slf4j
@Component
public class BalancePresenter {

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

    public ResponseModel<BalanceResponseModel> setResponse(List<Income> incomes){
        BalanceResponseModel balanceResponseModel = new BalanceResponseModel();
        setBalanceResponseModel( balanceResponseModel, incomes);
        return new ResponseModel<>("00", "Su balance ha sido cargado con Éxito", balanceResponseModel);
    }

    private void setBalanceResponseModel(BalanceResponseModel balanceResponseModel, List<Income> incomes) {

        balanceResponseModel.setId(incomes.stream().count());

    }

    public ResponseModel<BalanceResponseModel> setCalcule(Request request){
        BalanceResponseModel balanceResponseModel = new BalanceResponseModel();


        return new ResponseModel<BalanceResponseModel>("00", "Su registro ha sido exitoso", balanceResponseModel);
    }

    public LocalDate getDate() {

        LocalDate date = LocalDate.now();
        date = date.withDayOfMonth(
                date.getMonth().length(date.isLeapYear())).minusMonths(1);
        log.info("date:", date);
        return date;

    }
}
