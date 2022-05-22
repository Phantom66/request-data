package com.core.requestdata.model;

import lombok.Data;

@Data
public class RequestModel {

    private String tipoDocumento;
    private String documento;
    private String nombre;
    private String telefono;
    private String telefonoLocal;
    private String motivo;
    private String plazo;
    private String montoSolicitado;
    private String montoDolar;

    
}
