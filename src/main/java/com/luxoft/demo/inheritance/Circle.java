package com.luxoft.demo.inheritance;

// Circle is a subclass (child) and Shape is a super class (parent)
public class Circle extends Shape {
    private String color;

    public Circle(String color) {
        super("Circle");
        this.color = color;
    }

    public void changeColor(String colorName) {
        this.color = colorName;
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println(color + " " + name());
    }

    public void draw(String colorName) {
        System.out.println(colorName + " " + name());
    }

    public void draw(int rad) {
        System.out.println(name() + " of radius=" + rad);
    }

    //Final methods cannot be overridden
    /*@Override
    public String name() {
        return "My name";
    }*/

}
