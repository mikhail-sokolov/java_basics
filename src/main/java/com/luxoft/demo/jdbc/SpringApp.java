package com.luxoft.demo.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        ActorsRepository actorsRepository = applicationContext.getBean("actors", ActorsRepository.class);

        for (int i = 1; i < 20; i++) {
            String name = actorsRepository.getActorName(i);
            System.out.println(name);
        }
    }
}
