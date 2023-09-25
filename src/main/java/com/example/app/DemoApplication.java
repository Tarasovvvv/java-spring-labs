package com.example.app;

import com.example.app.entities.lab2.Employee;
import com.example.app.entities.lab3.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		Employee employee1 = context.getBean(Employee.class);
		Employee employee2 = context.getBean(Employee.class);
		employee1.work();
		employee1.getPet().walk();
		employee1.getPet().voice();
		System.out.println(employee2.getAge());
		employee1.setAge(99);
		System.out.println(employee2.getAge());


		Storage storage1 = context.getBean(Storage.class);
		Book book1 = context.getBean(Book.class);
		Chair chair1 = context.getBean(Chair.class);
		Box box1 = context.getBean(Box.class);

		book1.send(storage1);
		chair1.send(storage1);
		box1.send(storage1);

		context.close();
	}
}
