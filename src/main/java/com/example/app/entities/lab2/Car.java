package com.example.app.entities.lab2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Value("${car.mark}")
    private String mark;

    @PostConstruct
    public void init() {
        System.out.println("Class Car: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Car: destroy method");
    }

}