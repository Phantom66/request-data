package com.core.requestdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeDocument;
    private int document;
    private String name;
    private String phone;
    private String homePhone;
    private boolean existPatria;
    private boolean existExchange;

}