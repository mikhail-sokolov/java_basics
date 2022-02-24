package com.luxoft.demo.collections;



public class ArraysDemo {

    public static void main(String[] args) {
        arrays();
    }

    /**
     * Basic collection type
     *
     * - Fixed size
     * - Primitive API - read/write and iteration
     * - Supports primitive types
     * - Native support by underlying platforms
     * - Basic building block for other data structures
     */
    public static void arrays() {
        int[] ints = new int[] { 1, 2, 3, 4, 5 };
        Integer[] xs = new Integer[10];

        //write element by index
        ints[0] = 10;

        //read element7 by index
        System.out.println(ints[0]);
        System.out.println("-------------------------------------");
        for (int i: ints) {
            System.out.println(i);
        }
        System.out.println("-------------------------------------");
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }



}
