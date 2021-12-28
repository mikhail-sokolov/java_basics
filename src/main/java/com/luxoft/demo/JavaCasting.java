package com.luxoft.demo;

import com.luxoft.demo.classes.PhoneNumber;

public class JavaCasting {
    public static void main(String[] args) {
        Object phoneNumber = PhoneNumber.getPhoneNumber("123123");
        if (phoneNumber instanceof PhoneNumber) {
            PhoneNumber phone =  (PhoneNumber) phoneNumber;
            System.out.println(phone);
        } else {
            System.out.println("Wrong type!");
        }
    }
}
