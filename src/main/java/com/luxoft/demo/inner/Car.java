package com.luxoft.demo.inner;



public class Car {
    private boolean isEngineStarted;
    private Engine engine;
    private Cargo cargo;

    public Car() {
        this.isEngineStarted = false;
        this.engine = new Engine();
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

        private void start() {
            if (!isEngineStarted) { //the same as Car.this.isEngineStarted
                Car.this.logEvent("The engine is started. VIN: " + vin);
            }
        }
    }

    public static class Cargo {

    }

    public static void main(String[] args) {
        //You cannot create inner class without the enclosing class object
        //Engine engine = new Engine();
        Car car = new Car();
        Engine engine1 = car.new Engine();

        //You can create an instance of static inner class without object of the enclosing class
        Cargo cargo = new Cargo();
        car.load(cargo);
    }
}
