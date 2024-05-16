package com.nastya.Pr10;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
     @Bean
     public Lamp Lamp(){
        return new Lamp();
     }

    @Bean
    public Firefly Firefly(){
        return new Firefly();
    }

    @Bean
    public Flashlights Flashlights(){
        return new Flashlights();
    }
}
