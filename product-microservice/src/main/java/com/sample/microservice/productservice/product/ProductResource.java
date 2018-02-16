/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.microservice.productservice.product;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Francis
 */
@RestController
public class ProductResource {
        
    @Autowired
    private ProductRepository repo;
    
    //find with exception
    private Product findE(String id){
        Optional<Product> prod = repo.findById(id);
        if(prod==null)
            throw new ProductNotFoundException("prod.id="+id);
        return prod.get();
    }
             
    @GetMapping("/products")
    public List<Product> findAll(){
        List<Product> products = repo.findAll();        
        if(products==null)
            throw new ProductEmptyListException("No product in database");
        return products;
    }
    
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable String id){
        return findE(id);        
    }
    
    @PostMapping("/products")
    public ResponseEntity create(@Valid @RequestBody Product prod){
        Date date = new Date();
        prod.setCreatedDate(date);
        prod.setModifiedDate(date);
        Product savedProd = repo.save(prod);
        
        if(savedProd==null)
            throw new ProductCreateException("There was an error creating product");
            
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedProd.getId())
                .toUri();
                
        return ResponseEntity.created(location).build();        
    }
    
    @PutMapping("/products/{id}")
    public void update(@PathVariable String id,@RequestBody Product prod){      
        Date date = new Date();       
        Product tempProd = findE(id);
       
        tempProd.setModifiedDate(date);
        tempProd.setName(prod.getName());
        tempProd.setQuantity(prod.getQuantity());
        tempProd.setPrice(prod.getPrice());
        repo.save(tempProd);
    }
    
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable String id){
        Product prod = findE(id);
        repo.deleteById(id);
    }
    
    @GetMapping("/login")
    public void login(HttpSession session) {                
        
    }
                 
    @GetMapping("/logout")
    public void logout(HttpSession session) {                
        session.invalidate();
    }
    
}
