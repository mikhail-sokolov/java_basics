package com.luxoft.demo.classes;

public class Client {
    private static int nextId = 1;

    private int id;
    private PhoneNumber phoneNumber;

    public Client(PhoneNumber phoneNumber) {
        this.id = nextId++;
        this.phoneNumber = phoneNumber;
    }

    public void sendMessage(String message) {
        phoneNumber.sendSms(message);
    }

    private static int generateId() {
        return nextId++;
    }
}
