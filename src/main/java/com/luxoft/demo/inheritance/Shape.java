package com.luxoft.demo.inheritance;

public abstract class Shape {
    private String name;
    private String color;

    protected Shape(String name) {
        this.name = name;
    }

    public void draw() {
        System.out.println("Drawing a " + name);
    }

    public int area() {
        return 0;
    }

    public int perimeter() {
        return 0;
    }

    protected final String name() {
        return name;
    }

}
