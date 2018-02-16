/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.microservice.productservice.product;

import java.math.BigDecimal;
import java.util.Date;



import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Francis
 */
@Document
public class Product {
    
    @Id
    private String id;
    
    @Size(min=2,message="Product name must be at least 2 characters")
    private String name;
    
    
    @Min(0)
    private Integer quantity;
    
    @DecimalMin("0.0")
    private BigDecimal price;
    
    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date modifiedDate;
    
    public Product() {
    }

    public Product(String id, String name, Integer quantity, BigDecimal price, Date createdDate, Date modifiedDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    

                    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
               
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    
    
    
}
