package com.example.demo;

import com.example.demo.Service.SchedulerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.management.ObjectName;
import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerFactory;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.example.demo.Service", "com.example.demo.Controller", "com.example.demo.Data"})
public class Pr18Application {

	public static void main(String[] args) {
		//SpringApplication.run(Pr18Application.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(Pr18Application.class, args);
		SchedulerServiceImpl schedulerService = context.getBean(SchedulerServiceImpl.class);
		schedulerService.doScheduledTask();
		System.out.println("The MBean operation was called successfully.");
	}
}
