package com.luxoft.tasks;

/**
 * Create a program that generates multiplication tables for the numbers 0 through 12.
 *
 * Example Output
 *
 *         0 X 0 = 0
 *         0 X 1 = 0
 *         ....
 *         12 x 11 = 132
 *         12 x 12 = 144
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.println("" + i + " x " + j);
            }
        }

    }
}
