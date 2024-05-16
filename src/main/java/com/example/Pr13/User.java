package com.example.Pr13;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    @Value("${program.student.name}")
    private String name;

    @Value("${program.student.last_name}")
    private String last_name;

    @Value("${program.student.group}")
    private String group;
    @PostConstruct
    public void init(){
        System.out.println("Name: " + name);
        System.out.println("Surname: " + last_name);
        System.out.println("Group: " + group);
    }
}
