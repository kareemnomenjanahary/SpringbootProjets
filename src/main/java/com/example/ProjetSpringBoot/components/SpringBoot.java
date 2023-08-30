package com.example.ProjetSpringBoot.components;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "model",
        "repository",
        "controller",
        "service",
        "components"
})
public class SpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot.class,args);
    }
}
