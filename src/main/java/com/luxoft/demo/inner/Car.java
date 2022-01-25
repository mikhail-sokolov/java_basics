package com.luxoft.demo.inner;


import com.luxoft.demo.enumeration.Color;
import com.luxoft.demo.interfaces.Shape;

public class Car {
    private boolean isEngineStarted;
    private Engine engine;
    private Cargo cargo;
    private String number;

    public Car(String number) {
        this.isEngineStarted = false;
        this.engine = new Engine("777");
        this.number = number;
    }

    public void start() {
        engine.start();
    }

    public void load(Cargo cargo) {
        this.cargo = cargo;
    }

    private void logEvent(String event) {
        System.out.println(event);
    }

    public class Engine {
        private String vin;

        public Engine(String vin) {
            this.vin = vin;
        }

        private void start() {
            if (!isEngineStarted) { //the same as Car.this.isEngineStarted
                Car.this.logEvent("The engine is started. VIN: " + vin);
            }
        }
    }

    public static class Cargo {
        public void printNumber(Car car) {
            System.out.println(car.number);
        }

    }

    public static void main(String[] args) {
        //You cannot create inner non-static class without the enclosing class object
        //Engine engine = new Engine();
        Car car = new Car("123");
        Engine engine1 = car.new Engine("888");
        car.start();

        //You can create an instance of static inner class without object of the enclosing class
        Cargo cargo = new Cargo();
        car.load(cargo);
        cargo.printNumber(car);
    }
}
