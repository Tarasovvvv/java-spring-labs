package com.example.app.entities.lab2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet {
    @Value("${dog.name}")
    private String name;

    @PostConstruct
    public void init() {
        System.out.println("Class Dog: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Dog: destroy method");
    }

    public void walk() {
        System.out.println("Собака " + this.name + " гуляет!");
    }

    public void voice() {
        System.out.println("Собака " + this.name + " гавкает!");
    }
}