package com.luxoft.tasks;

import java.util.Scanner;

/**
 * Write a program that converts a number from 1 to 12 to the corresponding month.
 *
 * Prompt for a number and display the corresponding calendar month, with 1 being January and 12 being December.
 *
 * For any value outside that range, display an appropriate error message.
 *
 * Hint: Use 'switch' statement
 */
public class MonthByNumber {
    public static void main(String[] args) {
        try {
            String prompt = "Enter any number from 1 to 12: ";

            //TODO

        } catch (NumberFormatException e) {
            System.err.println("Not a number: " + e);
        }
    }

    public static String readInput(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).next();
    }

    //Throws NumberFormatException if not a number
    public static int parse(String string) {
        return Integer.parseInt(string);
    }
}
