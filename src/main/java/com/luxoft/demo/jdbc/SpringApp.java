package com.luxoft.demo.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        ActorsRepository actorsRepository = applicationContext.getBean("actors", ActorsRepository.class);
        String name = actorsRepository.getActorName(10);
        System.out.println(name);
    }
}
