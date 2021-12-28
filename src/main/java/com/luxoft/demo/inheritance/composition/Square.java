package com.luxoft.demo.inheritance.composition;

public class Square {
    private Rectangle square;

    public Square(int a) {
        this.square = new Rectangle(1, 1);
    }

    public int area() {
        return square.area();
    }
}
