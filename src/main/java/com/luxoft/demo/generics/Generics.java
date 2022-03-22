package com.luxoft.demo.generics;


import com.luxoft.tasks.classes.Cat;
import com.luxoft.tasks.classes.Dog;

import java.util.*;

/**
 * Generic type. Defines a set of parameterized types.
 * Generic class
 * T is formal type parameter
 */
public class Generics<T> {
    private Map<String, Object> container;

    public Generics() {
        container = new HashMap<>();
    }

    public static void main(String[] args) {
        //Parameterized type. String is actual type parameter.
        Generics<String> var = new Generics<>(); // <> diamond operator

        //Generic type without type parameter is called 'raw type'. For compatibility only.
        //Don't use raw types in new code
        Generics var2;

        var.put("String", "key");
        var.put("cat", new Cat("Meow"));

        //String.class - type token
        Optional<String> value = var.get("String", String.class);
        System.out.println(value);

        Optional<String> aCat = var.get("cat", String.class);
        System.out.println(aCat);

        Optional<Cat> aRealCat = var.get("cat", Cat.class);
        System.out.println(aRealCat);

        List dogs = new ArrayList();
        dogs.add(new Dog("doggy"));
        dogs.add(new Cat("meow"));

        for (int i = 0; i < dogs.size(); i++) {
            Object possibleDog = dogs.get(i);
            if (possibleDog instanceof Dog) {
                Dog dog = (Dog) possibleDog;
                dog.makeNoise();
            } else {
                System.out.println("Not a dog!!!");
            }
        }

        List<Cat> cats = new ArrayList<Cat>(); //before Java 7
        //cats.add(new Dog("doggy")); // compilation error
        cats.add(new Cat("meow"));
    }

    private void put(String key, Object value) {
        container.put(key, value);
    }

    /**
     * Generic method
     */
    public <R> Optional<R> get(String key, Class<R> desirableType) {
        return Optional.ofNullable(container.get(key))
                .filter(desirableType::isInstance)
                .map(desirableType::cast);
    }



}
