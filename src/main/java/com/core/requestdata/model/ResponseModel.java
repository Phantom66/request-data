package com.core.requestdata.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class ResponseModel<T> {

    private String code;
    private String description;
    private T data;
    
}
