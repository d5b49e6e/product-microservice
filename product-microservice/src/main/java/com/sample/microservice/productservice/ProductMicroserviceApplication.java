package com.sample.microservice.productservice;

import com.sample.microservice.productservice.product.ProductRepository;
import com.sample.microservice.productservice.product.Product;
import java.math.BigDecimal;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductMicroserviceApplication implements CommandLineRunner{

    @Autowired
    private ProductRepository repo;
    
    public static void main(String[] args) {
            SpringApplication.run(ProductMicroserviceApplication.class, args);
    }


    @Override
    public void run(String ... args) {
            repo.deleteAll();
            
            Date createDate = new Date();
            //force id for easy testing with Postman
            repo.save(new Product("5a851cef01aa8707ac4f5451","Product 1",5,new BigDecimal("2500.05"),createDate,createDate));
            repo.save(new Product("5a851cef01aa8707ac4f5452","Product 2",10,new BigDecimal("2500.10"),createDate,createDate));
            repo.save(new Product("5a851cef01aa8707ac4f5453","Product 3",15,new BigDecimal("2500.15"),createDate,createDate));
            
    }
               
        
}
