/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.microservice.productservice.exception;

import java.util.Date;

/**
 *
 * @author Francis
 */
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String detail;

    public ExceptionResponse(Date timestamp, String message, String detail) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }


    
    @Override
    public String toString() {
        return "ExceptionResponse{" + "timestamp=" + timestamp + ", message=" + message + ", detail=" + detail + '}';
    }
    
    
}
