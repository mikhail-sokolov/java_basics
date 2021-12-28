package com.luxoft.demo.wrappers;

public class Autoboxing {
    public static void main(String[] args) {
        //Automatic conversion between Integer and int
        Integer i = 10;
        int j = i;

        System.out.println(++i);

        int x = 1_000_000;
        int y = 1_000_000;
        System.out.println(x == y);

        Integer a = 1_000_000;
        Integer b = 1_000_000;
        System.out.println(a == b);

        //int s = null;
        Integer t = null;
    }
}
