package com.luxoft.tasks.classes;

public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("Bark!!");
    }
}
