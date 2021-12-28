package com.luxoft.demo.enumeration;

/**
 * Enumeration classes are subclasses of Enum class and inherits methods:
 *  name
 *  toString
 *  ordinal - int value associated with a constant (0, 1, ...)
 *
 * Enumeration class has exact number of object instances which is equal to the number of enumerated constants
 */
public enum Color {
    WHITE(0),
    GREEN(100),
    BLUE(100),
    BLACK(200),
    RED(200),
    BROWN(200);

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
    }
}
