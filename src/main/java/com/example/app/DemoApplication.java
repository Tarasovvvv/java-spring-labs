package com.example.app;

import com.example.app.entities.lab2.Employee;
import com.example.app.entities.lab2.Pet;
import com.example.app.entities.lab4.*;
import com.example.app.entities.lab3.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.*;
import java.util.Properties;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		//AnnotationConfigApplicationContext context =
		//		new AnnotationConfigApplicationContext(Config.class);
		//l2
		//Employee employee1 = context.getBean(Employee.class);
		//Employee employee2 = context.getBean(Employee.class);
		//employee1.work();
		//employee1.getPet().walk();
		//employee1.getPet().voice();
		//System.out.println(employee2.getAge());
		//employee1.setAge(99);
		//System.out.println(employee2.getAge());
		//l3
		//Storage storage1 = context.getBean(Storage.class);
		//Book book1 = context.getBean(Book.class);
		//Chair chair1 = context.getBean(Chair.class);
		//Box box1 = context.getBean(Box.class);
		//book1.send(storage1);
		//chair1.send(storage1);
		//box1.send(storage1);
		//context.close();
		//l4
		Properties properties = new Properties();
		properties.setProperty("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/postgres");
		properties.setProperty("javax.persistence.jdbc.user", "postgres");
		properties.setProperty("javax.persistence.jdbc.password", "1");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit", properties);
		EntityManager em = emf.createEntityManager();
		// Создание таблицы
		em.getTransaction().begin();
		em.createNativeQuery("CREATE TABLE IF NOT EXISTS owner (id BIGINT PRIMARY KEY)").executeUpdate();
		em.createNativeQuery("CREATE TABLE IF NOT EXISTS specialist (id BIGINT PRIMARY KEY)").executeUpdate();
		em.createNativeQuery("CREATE TABLE IF NOT EXISTS medicalhistory (\n" +
				"  id SERIAL PRIMARY KEY,\n" +
				"  description VARCHAR(255)\n" +
				");").executeUpdate();
		em.createNativeQuery("CREATE TABLE IF NOT EXISTS pet2 (\n" +
				"  id SERIAL PRIMARY KEY,\n" +
				"  name VARCHAR(255),\n" +
				"  specialist_id BIGINT,\n" +
				"  medicalHistory_id BIGINT,\n" +
				"  FOREIGN KEY (specialist_id) REFERENCES specialist (id),\n" +
				"  FOREIGN KEY (medicalHistory_id) REFERENCES medicalhistory (id)\n" +
				");").executeUpdate();
		em.getTransaction().commit();

		Pet2 pet = new Pet2();
		pet.setName("Шарик");

		MedicalHistory mh = new MedicalHistory();
		mh.setDescription("простуда");
		mh.setPet(pet);

		pet.setMedicalHistory(mh);

		em.getTransaction().begin();
		em.persist(pet);
		em.persist(mh);
		em.getTransaction().commit();
	}
}
