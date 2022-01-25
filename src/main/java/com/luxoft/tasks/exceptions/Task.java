package com.luxoft.tasks.exceptions;

import java.util.Scanner;

/**
 * Read input using 'readInput' method and validate it.
 *
 * - Don’t allow non-numeric values (Use Integer.parseInt for conversion of a string to a numeric value.
 *   'parseInt' method throws NumberFormatException if the provided string is not a numeric value)
 * - Don’t allow the user to enter values that are less than 18 and greater than 120.
 * - Use a loop to trap bad input, so you can ensure that the user enters valid values.
 * - Display a different error message for each error type
 */
public class Task {

    public static void main(String[] args) {
        String prompt = "How old are you? (enter your age): ";

        String input = readInput(prompt);

        int age = 0;
        System.out.println("Your age is: " + age);
    }

    public static String readInput(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).next();
    }
}
