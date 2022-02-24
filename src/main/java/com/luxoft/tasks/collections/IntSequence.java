package com.luxoft.tasks.collections;

import java.util.Iterator;

public class IntSequence implements Iterable<Integer> {
    private final int[] elements;

    public IntSequence(int[] ints) {
        this.elements = ints;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int[] xs = elements;
            int currentElement = 0;

            @Override
            public boolean hasNext() {
                return currentElement < elements.length;
            }

            @Override
            public Integer next() {
                return xs[currentElement++];
            }
        };
    }

    public static IntSequence sequence(int... ints) {
        return new IntSequence(ints);
    }
}
