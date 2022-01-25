package com.luxoft.tasks.interfaces;

import java.util.Arrays;

/**
 * 1. Add size property ot Pet class which has int type.
 * 2. Implement Comparable interface by Pet class which uses pet size for comparison
 * 3. Create an array of pets and sort it using Arrays.sort method
 */
public class Task {
    public static void main(String[] args) {
        Pet[] pets = new Pet[] {
                new Dog("Bunny", 3),
                new Cat("Kitty", 1),
                new Cat("Fluffy", 2)
        };

        System.out.println(Arrays.toString(pets));
        Arrays.sort(pets);
        System.out.println(Arrays.toString(pets));
    }
}
