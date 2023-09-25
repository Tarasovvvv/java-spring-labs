package com.example.app.entities.lab2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Employee {
    private Car car;
    private Pet pet;
    @Value("${employee.name}")
    private String name;
    @Value("${employee.age}")
    private int age;

    @PostConstruct
    public void init() {
        System.out.println("Class Employee: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Employee: destroy method");
    }

    public Employee(@Autowired Car car, @Autowired @Qualifier("cat") Pet pet) {
        this.car = car;
        this.pet = pet;
    }

    public void work() {
        System.out.println("Работник " + this.name + " работает");
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}