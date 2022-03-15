package com.luxoft.tasks.collections;

import java.util.*;

/**
 * Given a random sequence of numbers (e.g. 2, 3, 5, 4, 6, 7, 10, 2, 4) return the most frequent element.
 */
public class Task2 {
    public static void main(String[] args) {
        Iterable<Integer> ints = IntSequence.sequence(2, 3, 5, 4, 6, 7, 5, 10, 6, 5, 10, 2, 3, 4, 4, 5,4,4,4);
        Optional<Integer> duplicate = mostFrequentElement(ints);
        System.out.println(duplicate.map(String::valueOf).orElse("No duplicates"));
    }

    private static Optional<Integer> mostFrequentElement(Iterable<Integer> ints) {
        //HashMap, LinkedHashMap, TreeMap
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (Integer i : ints) {
            freqMap.merge(i, 1, Integer::sum);
        }
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -Integer.compare(o1.getValue(), o2.getValue());
            }
        };
        PriorityQueue<Map.Entry<Integer, Integer>> top = new PriorityQueue<>(comparator);
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            top.offer(entry);
        }
        return Optional.of(top.poll().getKey());
    }


}
