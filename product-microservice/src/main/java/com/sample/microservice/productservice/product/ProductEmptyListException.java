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
public class ProductEmptyListException extends RuntimeException {

    public ProductEmptyListException(String string) {
        super(string);
    }
    
}
