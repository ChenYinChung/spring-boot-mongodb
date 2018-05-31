package com.sb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
@SpringBootApplication
@ComponentScan(basePackages = { "com.sb" })
@PropertySource({"classpath:application.properties","classpath:mongodb.properties"})

@EnableCaching
public class WebApplication {

     static final Logger logger = LoggerFactory.getLogger(WebApplication.class);


    public static void main(String args[]){
        //執行SpringApplication
        SpringApplication.run(WebApplication.class, args);
    }
}