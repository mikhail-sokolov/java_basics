package com.luxoft.tasks.collections;


import java.util.*;

/**
 * Given a random sequence of numbers (e.g. 2, 3, 5, 4, 6, 7, 10, 2, 4) return the first duplicate number in the
 * sequence.
 */
public class Task1 {
    public static void main(String[] args) {
        Iterable<Integer> ints = IntSequence.sequence(2, 3, 5, 4, 6, 7, 5, 10);
        Optional<Integer> duplicate = firstDuplicate(ints);
        System.out.println(duplicate.map(String::valueOf).orElseGet(() -> "No duplicates"));

    }
    public static Optional<Integer> firstDuplicate(Iterable<Integer> ints) {
        //TODO
        return Optional.empty();
    }
}
