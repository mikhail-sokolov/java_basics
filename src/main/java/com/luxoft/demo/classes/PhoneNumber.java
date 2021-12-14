package com.luxoft.demo.classes;

public class PhoneNumber {
    public static final PhoneNumber EMERGENCY = new PhoneNumber("911");

    //Fields
    private final String phoneNumber; //can not be changed later

    private PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void makeCall() {
        System.out.println("Calling " + this.phoneNumber);
    }

    public void sendSms(String message) {
        System.out.println("Sending '" + message + "' to " + this.phoneNumber);
    }

    @Override
    public String toString() {
        return phoneNumber;
    }

    public static PhoneNumber getPhoneNumber(String phoneNumber) {
        if ("911".equalsIgnoreCase(phoneNumber)) {
            return EMERGENCY;
        }
        return new PhoneNumber(phoneNumber);
    }
}
