package com.example.spring_demo_project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        ServiceB serviceB=context.getBean(ServiceB.class);
        serviceB.execute();
    }
}
