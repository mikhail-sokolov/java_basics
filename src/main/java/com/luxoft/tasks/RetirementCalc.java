package com.luxoft.tasks;

import java.time.LocalDate;

/**
 * Create a program that determines how many years a person has left until retirement and the year the person can
 * retire.
 * Define variables for current age and the age a person want to retire.
 *
 * The program should produce the output as in the example below:
 * Current age: 45
 * Retire age: 65
 * You have 20 years left until you cat retire.
 * It's 2021, so you can retire in 2041.
 *
 * In case of any errors display "System error" message. Use yearAfter function.
 *
 */
public class RetirementCalc {

    public static void main(String[] args) {

    }

    public static int yearAfter(int years) {
        return LocalDate.now().plusYears(years).getYear();
    }
}
