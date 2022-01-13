package com.luxoft.demo.inner;



public class Car {
    private boolean isEngineStarted;

    public void start() {
        Engine engine = new Engine();
        engine.start();
    }

    public class Engine {
        private void start() {
            if (!isEngineStarted) {
                //TODO
            }
        }
    }

    public static class Cargo {

    }
}
