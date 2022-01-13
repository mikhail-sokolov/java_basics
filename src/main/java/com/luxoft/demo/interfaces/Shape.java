package com.luxoft.demo.interfaces;

import com.luxoft.demo.enumeration.Color;

/**
 * Interface is a set of requirements for classes
 * Any class that implements an interface must implement all "abstract" interface methods
 * Class can implement multiple interfaces. (Can inherit only one class)
 *
 * Classes can use interfaces to declare their requirements to the classes with which they collaborate
 *
 * All methods and fields are public.
 * Fields are static
 *
 * Since Java 8 static methods are allowed
 */
public interface Shape extends Drawable {
    int CONSTANT = 10;

    double area();
    int perimeter();
    void setColor(Color color);

    static Shape triangle(int a, int b, int c) {
        return new Shape() {
            @Override
            public double area() {
                return 0;
            }

            @Override
            public int perimeter() {
                return 0;
            }

            @Override
            public void setColor(Color color) {

            }

            @Override
            public void draw() {

            }
        };
    }
}
