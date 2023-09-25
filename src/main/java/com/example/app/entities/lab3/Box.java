package com.example.app.entities.lab3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Box implements Addable {

    public void send(Storage storage) {
        System.out.println("Коробка отправлена на склад");
        storage.add(this);
    }

    @PostConstruct
    public void init() {
        System.out.println("Class Box: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Box: destroy method");
    }
}
