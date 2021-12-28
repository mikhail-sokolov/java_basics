package com.luxoft.demo.inheritance;

public class ShapesDemo {
    public static void main(String[] args) {
        Square square = new Square();
        square.draw();
        Circle circle = new Circle("Green");
        circle.draw("Red");
        circle.draw(10);

        Shape[] shapes = { square, circle };
        for (Shape shape: shapes) {
            shape.draw();

            if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                c.draw(10);
            }
        }



    }
}
