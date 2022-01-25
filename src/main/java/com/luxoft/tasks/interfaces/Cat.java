package com.luxoft.tasks.interfaces;

public class Cat extends Pet {
    public Cat(String name, int size) {
        super(name, size);
    }

    @Override
    public void makeNoise() {
        System.out.println("Meow!!");
    }
}
