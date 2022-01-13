package com.luxoft.tasks.classes;

/**
 * Define classes for pets. Extend Pet abstract class (E.g. cat, dog, parrot etc.).
 * Create an array of pets. Iterate through the array and call makeNoise method for every object in the array
 */
public class Task {
    public static void main(String[] args) {
        Pet[] pets = { new Cat("fluffy"), new Dog("nord") };
        for (Pet pet: pets) {
            pet.makeNoise();
        }
    }
}
