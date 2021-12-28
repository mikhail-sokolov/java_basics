package com.luxoft.demo.inheritance.composition;

public class Main {
    public static void main(String[] args) {
        Square s = new Square(1);
        int c = calculation(s);
        System.out.println(c);
    }

    public static int calculation(Rectangle r) {
        r.setA(10);
        r.setB(15);
        return r.area();
    }

    public static int calculation(Square s) {
        return s.area();
    }

}
