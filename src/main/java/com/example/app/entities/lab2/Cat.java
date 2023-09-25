package com.example.app.entities.lab2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Pet {
    @Value("${cat.name}")
    private String name;

    @PostConstruct
    public void init() {
        System.out.println("Class Cat: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Cat: destroy method");
    }

    public void walk() {
        System.out.println("Кошка‚ " + this.name + " гуляет!");
    }

    public void voice() {
        System.out.println("Кошка‚ " + this.name + " мяукает!");
    }

}