package com.luxoft.demo.inheritance.object;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

/**
 * Object is superclass of all Java classes.
 * Arrays are objects too.
 * Only primitive types int, double, long etc. are not objects
 */
public class Report {
    private long id;
    private LocalDate reportDate;
    private int[] totals;
    private String name = "default";

    public Report(long id, LocalDate reportDate, int[] totals) {
        this.id = id;
        this.reportDate = reportDate;
        this.totals = totals;
    }

    /**
     * Hash code is an integer derived from an object. Hash code is very important for hash tables.
     *
     * 1. If x and y are not equal, then x.hashCode() and y.hashCode() should be different, but it is possible that
     * hash codes are equal.
     * 2. If x and y are equal, then their hash codes must be equal
     *
     * Object.hashCode is derived from memory location
     * Override hashCode whenever you override equals. Combine hash codes of the fields that are used in the equals method
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Object.equals tests whether the object references are identical.
     * Override to change equality rules (for example by comparing objects content)
     *
     * The equals method has to be:
     *  Reflexive - x.equals(x)
     *  Symmetric - if x.equals(y), then y.equals(x)
     *  Transitive - if x.equals(y) and y.equals(x), then x.equals(z)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return id == report.id;
    }

    /**
     * Returns String representation of an object.
     * Object.toString uses class name and hash code
     */
    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        Object report = new Report(1L, now, new int[] {1, 2, 3});
        Object r = report;
        Object report2 = new Report(1L, now, new int[] {1, 2, 3});
        System.out.println(report);

        System.out.println(report == r);
        System.out.println(report.equals(report2));

        Object reports = new Report[10];
        Object i = 10; // implicit conversion to Integer class
        System.out.println(i.getClass());
    }
}
