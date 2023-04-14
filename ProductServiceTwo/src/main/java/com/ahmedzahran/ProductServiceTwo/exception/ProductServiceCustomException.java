package com.ahmedzahran.ProductServiceTwo.exception;

import lombok.Data;
import lombok.Getter;

@Data
public class ProductServiceCustomException extends RuntimeException {

    private String errorCode;
    public ProductServiceCustomException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }


}
