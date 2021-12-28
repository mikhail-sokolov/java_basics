package com.luxoft.demo.classes;

public class Email {
    private final String email;

    public Email(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return email;
    }

    public void sendEmail(String message) {
        System.out.println("Sending '" + message + "' to " + this.email);
    }
}
