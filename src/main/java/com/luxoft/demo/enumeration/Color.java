package com.luxoft.demo.enumeration;

import com.luxoft.demo.interfaces.Shape;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Enumeration classes are subclasses of Enum class and inherits methods:
 *  name
 *  toString
 *  ordinal - int value associated with a constant (0, 1, ...)
 *
 * Enumeration class has exact number of object instances which is equal to the number of enumerated constants
 */
public enum Color {
    WHITE(0),// ordinal 0
    GREEN(100),// ordinal 1
    BLUE(100),// ordinal 2
    BLACK(200),// ordinal 3
    RED(200),// ordinal 4
    BROWN(200);// ordinal 5

    private int price;

    Color(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Color color = RED;
        System.out.println(color.name());
        System.out.println(color.ordinal());

        for (Color c: Color.values()) {
            System.out.println(c.name());
        }

        Color black = Color.valueOf("BLACK");
        System.out.println(black.name());
        System.out.println(black.getPrice());
        System.out.println(black.ordinal());

        List<Integer> ints = Arrays.asList(1,3,3,4,5,6);
        Iterator<Integer> intsIterator = ints.iterator();

        while (intsIterator.hasNext()) {
            System.out.println(intsIterator.next());
        }

    }

}
