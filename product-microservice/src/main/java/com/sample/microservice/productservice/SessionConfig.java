/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.microservice.productservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;

/**
 *
 * @author Francis
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfig 
{

    @Bean
    public HttpSessionIdResolver httpSessionIdResolver() {
        
            return HeaderHttpSessionIdResolver.xAuthToken(); 
    }
    
}
        