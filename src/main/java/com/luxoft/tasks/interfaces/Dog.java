package com.luxoft.tasks.interfaces;

public class Dog extends Pet {
    public Dog(String name, int size) {
        super(name, size);
    }

    @Override
    public void makeNoise() {
        System.out.println("Bark!!");
    }
}
