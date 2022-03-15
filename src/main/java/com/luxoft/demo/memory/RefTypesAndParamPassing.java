package com.luxoft.demo.memory;


public class RefTypesAndParamPassing {
    public static class ValueHolder {
        private int value;

        public ValueHolder(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        //refTypes();
        //callByValue();
        changingObjectData();
    }

    public static void refTypes() {
        //v holds the reference to a ValueHolder object created in the heap
        ValueHolder v3 = null;
        System.out.println(v3);
        ValueHolder v = new ValueHolder(1);
        ValueHolder v1 = v;
        System.out.println(v.toString());
        System.out.println(v1);

        ValueHolder v2 = new ValueHolder(2);
        System.out.println(v2);
        v2 = v;
        System.out.println(v2);
    }

    /**
     * Java uses 'call by value':
     * - The method gets a copy of value of any argument
     * - A method cannot change the contents of variables passed to it
     */
    public static void callByValue() {
        RefTypesAndParamPassing obj = new RefTypesAndParamPassing();
        ValueHolder v = new ValueHolder(1);
        System.out.println(v); //toString method is called implicitly
        int x = 10;
        obj.m(v, x);
        System.out.println(v); //toString method is called implicitly
        System.out.println(x);
    }

    public void m(ValueHolder valueHolder, int x) {
        valueHolder.setValue(2);
        valueHolder = new ValueHolder(10); //changing the reference
        System.out.println(valueHolder);
        x = x * 10;
        System.out.println(x);
    }

    /**
     * But for reference types you can change the content of an object
     * referenced by a variable
     */
    public static void changingObjectData() {
        RefTypesAndParamPassing obj = new RefTypesAndParamPassing();
        ValueHolder v = new ValueHolder(1);
        System.out.println(v); //toString method is called implicitly
        System.out.println("Value before: " + v.getValue());
        obj.m(v, 10);
        System.out.println(v); //toString method is called implicitly
        System.out.println("Value after: " + v.getValue());
    }
}
