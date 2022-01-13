package com.luxoft.demo.interfaces;

import com.luxoft.demo.enumeration.Color;

public class Rectangle implements Shape {
    private int a;
    private int b;
    private Color color;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
        this.color = Color.BLACK;
    }

    @Override
    public void draw() {

    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public int perimeter() {
        return 2 * (a + b);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
