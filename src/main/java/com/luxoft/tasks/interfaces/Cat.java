package com.luxoft.tasks.interfaces;

public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeNoise() {
        System.out.println("Meow!!");
    }
}
