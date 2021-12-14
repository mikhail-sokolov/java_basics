package com.luxoft.tasks;

import java.util.Scanner;

import static com.luxoft.tasks.TemperatureConverter.parse;

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
            String input = readInput(prompt);

            int monthNumber = parse(input);
            if (monthNumber >= 1 && monthNumber <=12) {
                switch (monthNumber) {
                    case 1:
                        System.out.println("January");
                        break;
                    case 2:
                        System.out.println("February");
                        break;
                    case 3:
                        System.out.println("March");
                        break;
                    case 4:
                        System.out.println("April");
                        break;
                    case 5:
                        System.out.println("May");
                        break;
                    case 6:
                        System.out.println("June");
                        break;
                    case 7:
                        System.out.println("July");
                        break;
                    case 8:
                        System.out.println("August");
                        break;
                    case 9:
                        System.out.println("September");
                        break;
                    case 10:
                        System.out.println("October");
                        break;
                    case 11:
                        System.out.println("November");
                        break;
                    case 12:
                        System.out.println("December");
                        break;
                }
            } else {
                System.out.println("Not a month number");
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
