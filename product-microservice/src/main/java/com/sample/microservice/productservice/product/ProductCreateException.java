/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.microservice.productservice.product;

/**
 *
 * @author Francis
 */
public class ProductCreateException extends RuntimeException {

    public ProductCreateException(String string) {
        super(string);
    }

    
}
