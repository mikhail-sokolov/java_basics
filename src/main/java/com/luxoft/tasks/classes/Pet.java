package com.luxoft.tasks.classes;

public abstract class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public abstract void makeNoise();
    public void run() {
        System.out.println("Run");
    }
    public String getName() {
        return name;
    }

}
