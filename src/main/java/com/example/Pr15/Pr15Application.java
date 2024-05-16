package com.example.Pr15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class Pr15Application {

	public static void main(String[] args) {
		SpringApplication.run(Pr15Application.class, args);
	}

}
