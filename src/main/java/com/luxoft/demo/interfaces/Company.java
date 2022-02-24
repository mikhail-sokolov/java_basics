package com.luxoft.demo.interfaces;

import java.util.Arrays;
import java.util.Objects;

/**
 * Comparable is one of the common interfaces that allows setting of an order between objects
 */
public class Company implements Comparable<Company>  {
    private String name;
    private final int numberOfEmployees;

    public Company(String name, int numberOfEmployees) {
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return numberOfEmployees == company.numberOfEmployees && name.equals(company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfEmployees);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", numberOfEmployees=" + numberOfEmployees +
                '}';
    }

    /**
     * Returns a negative integer - this object is less than the specified object
     * zero - equal to the specified object
     * a positive integer - greater than the specified object
     */
    @Override
    public int compareTo(Company o) {
        return Integer.compare(this.numberOfEmployees, o.numberOfEmployees);
    }

    public static void main(String[] args) {
        Company[] companies = {
            new Company("Google", 100_000),
            new Company("Amazon", 30_000),
            new Company("Tesla", 50_000),
            new SubCompany("Sub", 1)
        };

        System.out.println(Arrays.toString(companies));

        Arrays.sort(companies);

        System.out.println(Arrays.toString(companies));
    }
}
