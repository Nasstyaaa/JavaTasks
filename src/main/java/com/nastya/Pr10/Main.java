package com.nastya.Pr10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Lighter lighter = context.getBean(args[0], Lighter.class);
        System.out.print("Human switch on ");
        lighter.doLight();
    }
}
