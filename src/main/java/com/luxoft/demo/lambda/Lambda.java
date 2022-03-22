package com.luxoft.demo.lambda;

import com.luxoft.tasks.classes.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lambda {
    static class Mouse {
        private List<MouseEventListener> listenerList;

        Mouse() {
            this.listenerList = new ArrayList<>();
        }

        void click() {
            for (MouseEventListener listener: listenerList) {
                listener.onClick();
            }
        }

        void onMouseClick(MouseEventListener listener) {
            listenerList.add(listener);
        }
    }

    //@FunctionalInterface //Interface that has only one abstract method. Helps compiler to detect errors
    interface MouseEventListener {
        void onClick();
    }

    public static void main(String[] args) {
        Mouse mouse = new Mouse();

        //Before Java 8 and lambdas
        mouse.onMouseClick(new MouseEventListener() {
            @Override
            public void onClick() {
                System.out.println("Click!!!");
            }
        });
        Optional.of(1)
            .map((Integer integer) -> {
                return integer + 1;
            })
            .filter(integer -> integer < 0)
            .map(Object::toString)
            .map(Dog::new)
            .ifPresent(System.out::println);


        mouse.onMouseClick(() -> System.out.println("Lambda!!!"));
        
        mouse.click();
        mouse.click();
        mouse.click();

        //Lambda expression is an expression which evaluation yields an object.
        //The type of object depends on context in which lambda expression is used.
        //Same lambda expressions but different object types
        Callable<String> callable = () -> "String";
        //Object type is inferred from variable type
        Supplier<String> supplier = () -> "String";
        //Object type is inferred from 'map' method parameter type
        Optional.of(1).map(x -> x + 1);
        //Object type is inferred from 'run' method return value type
        run();
    }

    private static Callable<String> run() {
        return () -> "string";
    }

    @FunctionalInterface
    interface MyOwnFunctionalInterface<A, B, C, D, E, F> {
        F apply(A a, B b, C c, D d, E e);

        default F apply(A a, B b, C c, D d) {
            return apply(a, b, c, d, null);
        }

        static String staticMethod() {
            return "string";
        }
    }
}
