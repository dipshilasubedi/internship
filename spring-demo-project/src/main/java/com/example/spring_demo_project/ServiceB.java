package com.example.spring_demo_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ServiceB {
    //  @Autowired
    private final ServiceA serviceA;

    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public void execute() {
        System.out.println("This is service B.");
        serviceA.doSomething();
    }
}
