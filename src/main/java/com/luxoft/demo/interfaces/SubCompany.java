package com.luxoft.demo.interfaces;

public class SubCompany extends Company {
    public SubCompany(String name, int numberOfEmployees) {
        super(name, numberOfEmployees);
    }

    public boolean isSub() {
        return true;
    }
}
