package com.luxoft.demo.generics;


import com.luxoft.tasks.classes.Cat;
import com.luxoft.tasks.classes.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Generic type. Defines a set of parameterized types.
 * Generic class
 * T is formal type parameter
 */
public class Generics<T> {
    private Map<String, Object> container;

    public static void main(String[] args) {
        //Parameterized type. String is actual type parameter.
        Generics<String> var = new Generics<>(); // <> diamond operator

        //Generic type without type parameter is called 'raw type'. For compatibility only.
        //Don't use raw types in new code
        Generics var2;

        //String.class - type token
        Optional<String> value = var.get("String", String.class);

        List dogs = new ArrayList();
        dogs.add(new Dog("doggy"));
        dogs.add(new Cat("meow"));

        List<Cat> cats = new ArrayList<Cat>(); //before Java 7
        //cats.add(new Dog("doggy")); // compilation error
        cats.add(new Cat("meow"));
    }

    /**
     * Generic method
     */
    public <R> Optional<R> get(String key, Class<R> typeToken) {
        return Optional.ofNullable(container.get(key))
                .filter(typeToken::isInstance)
                .map(typeToken::cast);
    }



}
