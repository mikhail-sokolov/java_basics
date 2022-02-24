package com.luxoft.demo.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack<E> {
    private final Deque<E> elements;

    public Stack() {
        this.elements = new ArrayDeque<>();
    }

    public void push(E element) {
        this.elements.push(element);
    }

    public E pop() {
        return this.elements.pop();
    }
}
