package com.luxoft.tasks.interfaces;

public abstract class Pet implements Comparable<Pet> {
    private String name;
    private int size;

    public Pet(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public abstract void makeNoise();
    public void run() {
        System.out.println("Run");
    }

    @Override
    public int compareTo(Pet o) {
        return Integer.compare(this.size, o.size);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
