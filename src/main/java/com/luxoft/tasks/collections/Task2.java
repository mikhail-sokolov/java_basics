package com.luxoft.tasks.collections;

import java.util.Map;
import java.util.Optional;

/**
 * Given a random sequence of numbers (e.g. 2, 3, 5, 4, 6, 7, 10, 2, 4) return the most frequent element.
 */
public class Task2 {
    public static void main(String[] args) {
        Iterable<Integer> ints = IntSequence.sequence(2, 3, 5, 4, 6, 7, 5, 10);
        Optional<Integer> duplicate = mostFrequentElement(ints);
        System.out.println(duplicate.map(String::valueOf).orElseGet(() -> "No duplicates"));
    }

    private static Optional<Integer> mostFrequentElement(Iterable<Integer> ints) {

        return Optional.empty();
    }

}
