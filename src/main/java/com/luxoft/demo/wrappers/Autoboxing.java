package com.luxoft.demo.wrappers;

public class Autoboxing {
    public static void main(String[] args) {
        //Automatic conversion between Integer and int
        Integer i = 10;
        int j = i;


        System.out.println(++i);

        int x = 1_000_000;
        int y = 1_000_000;
        System.out.println("Primitive int");
        System.out.println(x == y);

        Integer a = 1_000_000;
        Integer b = 1_000_000;
        System.out.println("Integer");
        System.out.println(a == b);
        System.out.println(a.equals(b));

        Integer p = 127;
        Integer q = 127;
        System.out.println("Integer: 100");
        System.out.println(p == q);

        //int s = null;
        Integer t = null;
        //int k = t;
    }
}
