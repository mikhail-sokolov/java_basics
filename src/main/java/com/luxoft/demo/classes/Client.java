package com.luxoft.demo.classes;

public class Client {
    private static int nextId = 1;
    private Email email;
    private int id;
    private PhoneNumber phoneNumber;

    /*
    //init block
    {
        id = nextId++;
    }*/

    private Client() {
        this.id = nextId++;
    }

    public Client(PhoneNumber phoneNumber) {
        this();
        this.phoneNumber = phoneNumber;
    }

    public Client(Email email) {
        this();
        this.email = email;
    }

    public void sendMessage(String message) {
        if (phoneNumber != null) {
            phoneNumber.sendSms(message);
        } else if (email != null) {
            email.sendEmail(message);
        }
    }

    private static int generateId() {
        return nextId++;
    }
}
