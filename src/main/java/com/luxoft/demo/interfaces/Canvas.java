package com.luxoft.demo.interfaces;

public class Canvas {

    public void draw(Drawable shape) {
        //drawing a shape
    }

    public static void main(String[] args) {

        //Interface is not a class.
        //Shape shape = new Shape();

        //You can use interface as a variable type
        Shape rect = new Rectangle(10, 5);

        boolean isShape = rect instanceof Shape;
    }
}
