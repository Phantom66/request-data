package com.core.requestdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TYEP_DOCUMENT")
    private String typeDocument;
    @Column(name = "DOCUMENT")
    private int document;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "HOME_PHONE")
    private String homePhone;
    @Column(name = "EXIST_PATRIA")
    private boolean existPatria;
    @Column(name = "EXIST_EXCHANGE")
    private boolean existExchange;

}