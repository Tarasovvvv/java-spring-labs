package com.example.app.entities.lab3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("singleton")
public class Storage {
    private ArrayList<Addable> items = new ArrayList<>();

    @PostConstruct
    public void init() {
        System.out.println("Class Storage: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Storage: destroy method");
    }


    public void add(@Autowired @Qualifier("box") Addable item) {
        System.out.println("Склад принял предмет " + item.getClass().getSimpleName());
        this.items.add(item);
    }
}
