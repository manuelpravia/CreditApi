package com.nttdata.credit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CreditNotFoundException extends RuntimeException{

    public CreditNotFoundException(String id){
        super(String.format("Credit with %s not Found.",id));
    }
}
