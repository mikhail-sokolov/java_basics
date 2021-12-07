package com.luxoft.tasks;

import java.util.Scanner;

/**
 * Create a program that converts temperatures from Fahrenheit to Celsius
 *
 * C = (F - 32) * 5/9
 *
 * F = (C * 9/5) + 32
 *
 * Read input using 'readInput' function:
 * The temperature type: F for Fahrenheit or C for Celsius (upper and lowercase allowed)
 *
 * Use 'parse' for converting String value to int
 *
 * Example output:
 * The temperature in Fahrenheit: 32
 * The temperature in Celsius: 0
 */
public class TemperatureConverter {

    public static void main(String[] args) {
        try {
            String prompt = "Press C to convert from Fahrenheit to Celsius.\nPress F to convert from Celsius to Fahrenheit.\nYour choice: ";

            //TODO
            String tempType = readInput(prompt);
            String tempValue = readInput("Please enter the temperature value in " + tempType + ": ");
            int t = parse(tempValue);

            if (tempType.equalsIgnoreCase("F")) {
                int c = (t - 32) * 5/9; //C = (F - 32) * 5/9
                System.out.println("The temperature in Fahrenheit: " + t);
                System.out.println("The temperature in Celsius: " + c);
            } else {
                if (tempType.equalsIgnoreCase("C")) {
                    int f = (t * 9/5) + 32;//F = (C * 9/5) + 32
                    System.out.println("The temperature in Fahrenheit: " + f);
                    System.out.println("The temperature in Celsius: " + t);
                }
            }

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
