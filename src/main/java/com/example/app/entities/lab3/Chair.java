package com.example.app.entities.lab3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Chair implements Addable {
    public void send(Storage storage) {
        System.out.println("Стул отправлен на склад");
        storage.add(this);
    }

    @PostConstruct
    public void init() {
        System.out.println("Class Chair: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Chair: destroy method");
    }
}
