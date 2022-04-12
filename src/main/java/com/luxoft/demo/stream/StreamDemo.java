package com.luxoft.demo.stream;


import com.luxoft.tasks.classes.Cat;
import com.luxoft.tasks.classes.Pet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        errorHandling();
    }

    /**
     * Stream is a sequence of elements supporting sequential and parallel aggregate operations.
     *
     * Stream = Iterator + Operators
     *
     * Stream API provides operators for composing a stream pipeline.
     *
     * A stream pipeline consists of a source (which might be an array, a collection, a generator function, an I/O channel, etc),
     * zero or more intermediate operations (which transform a stream into another stream) and
     *  a terminal operation (which produces a result or side-effect).
     *
     *  Computation on the source data is only performed when the terminal operation is initiated,
     *  and source elements are consumed only as needed.
     *
     *  A stream should be operated on (invoking an intermediate or terminal stream operation) only once.
     *
     *  Stream API allows declarative description of operations that should be performed over a set of elements
     */
    public static void creation() {

        //IntStream is a special stream type for handling stream of primitive int
        //There are special stream types for double and long primitive types
        IntStream intStream = new Random().ints(); //source
        Stream<Integer> boxed = intStream.boxed(); //source

        List<Boolean> booleanList = new ArrayList<>();
        Stream<Boolean> booleanStream = booleanList.stream(); // collection as a stream source

        Cat[] cats = new Cat[] { new Cat("kitty"), new Cat("fluffy") };
        Stream<Cat> catStream = Arrays.stream(cats); // non-null array a stream source

        Stream.of(1, 2, 3);
    }

    public static void operations1() {
        Cat[] cats = new Cat[]{ new Cat("kitty"), new Cat("fluffy"), new Cat("cat") };
        Arrays.stream(cats)
            .peek(System.out::println)
            .map(Pet::getName) // produces a new value by applying provided function to the elements of the stream
            .peek(System.out::println)
            .filter(name -> name.length() > 3) // filters elements by applying a predicate: emits only those elements that yields true
            .peek(System.out::println)
            .map(name -> name.toUpperCase())
            .forEach(name -> System.out.println(name)); //terminal operator (side-effect)
    }

    public static void operations2() {
        Cat[] cats = new Cat[] { new Cat("kitty"), new Cat("fluffy"), new Cat("cat") };
        List<String> names = Arrays.stream(cats)
                .map(cat -> cat.getName()) // produces a new value by applying provided function to the elements of the stream
                .filter(name -> name.length() > 3) // filters elements by applying a predicate: emits only those elements that yields true
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());//terminal operator (collection)

        System.out.println(names);
    }

    public static void operations3() {
        int sumOfFirstTenEvenNumbers = IntStream.range(1, 1001)
            .filter(x -> x % 2 == 0)
            .limit(10)
            .sum();
        System.out.println(sumOfFirstTenEvenNumbers);
    }

    public static void optional() {
        Cat[] cats = new Cat[]{new Cat("kitty"), new Cat("fluffy"), new Cat("cat")};
        Optional<String> c = Arrays.stream(cats)
            .map(cat -> cat.getName())
            .filter(name -> name.length() < 0)
            .map(name -> name.toUpperCase())
            .findFirst();

        c.ifPresent(cat -> System.out.println(cat));
        System.out.println(c.isPresent());
    }

    public static Optional<Customer> getCustomer(long id) {
        return Optional.empty();
    }

    public static Optional<Order> getOrderByCustomerId(long id) {
        return Optional.empty();
    }

    public static void optional2() {
        //map and flatMap - sequence of computations
        getCustomer(1)
            .map(customer -> customer.name) // customer -> string
            .ifPresent(System.out::println);

        Optional<Order> customerOrder = getCustomer(1)
            .flatMap(customer -> getOrderByCustomerId(customer.id)); // customer -> Optional<Order>

        if (customerOrder.isPresent()) {
            System.out.println(customerOrder.get());
        }
    }


    public static void flatMap2() {
        Stream.of(1,2,3,4,5)
            .peek(x -> System.out.println("Peek " + x))
            .flatMap(x -> {
                try {
                    return Stream.of(riskyOperation(x));
                } catch (Exception e) {
                    return Stream.empty();
                }
            })
            .flatMap(x -> {
                if (x % 2 == 0) {
                    return Stream.of(x, x);
                }
                return Stream.of(x);
            })
            .forEach(x -> System.out.println("Success " + x));
    }

    public static void errorHandling() {
        //Termination errors
        System.out.println("----------------------Termination");
        /*Stream.of(1,2,3,4,5)
                .peek(x -> System.out.println("Peek " + x))
                .map(x -> x + 1)
                .map(x -> {
                    try {
                        return riskyOperation(x);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(x -> "Value=" + x)
                .forEach(x -> System.out.println("Success " + x));
        */



        //Ignoring errors
        System.out.println("----------------------Ignoring");
        Stream.of(1,2,3,4,5)
            .peek(x -> System.out.println("Peek " + x))
            .map(x -> x + 1)
            .flatMap(x -> {
                try {
                    return Stream.of(riskyOperation(x));
                } catch (Exception e) {
                    return Stream.empty();
                }
            })
            .map(x -> "Value=" + x)
            .forEach(x -> System.out.println("Success " + x));

        //Propagating errors
        System.out.println("----------------------Propagating");

        class ErrorContext<T> {
            private T value;
            private Exception throwable;

            ErrorContext(T value, Exception throwable) {
                this.value = value;
                this.throwable = throwable;
            }

            public ErrorContext(T value) {
                this.value = value;
            }

            public T getValue() {
                return value;
            }

            public Exception getThrowable() {
                return throwable;
            }

            public boolean isError() {
                return Objects.nonNull(throwable);
            }

            @Override
            public String toString() {
                return "ErrorContext{" +
                        "value=" + value +
                        ", throwable=" + throwable +
                        '}';
            }
        }

        Map<Boolean, List<ErrorContext<Integer>>> result = Stream.of(1,2,3,4,5)
            .peek(x -> System.out.println("Peek " + x))
            .map(x -> x + 1)
            .map(x -> {
                try {
                    return new ErrorContext<>(riskyOperation(x));
                } catch (Exception e) {
                    return new ErrorContext<>(x, e);
                }
            })
            .map(x -> {
                if (x.isError()) {
                    return x;
                } else {
                    return new ErrorContext<>(x.getValue() * 10);
                }
            })
            .collect(Collectors.groupingBy(ctx -> ctx.isError()));


    }

    static int riskyOperation(int x) throws Exception {
        if (x == 3) {
            throw new IOException();
        }
        return x;
    }

    /**
     * Calculate the average amount of orders made by customers which age is between 30 and 40 years
     */
    public static void problemCollections() {
        int cnt = 0;
        int sum = 0;
        for (Customer customer: customerList()) {
            if (customer.age >= 30 && customer.age <= 40) {
                cnt++;
                sum += customer.orders.size();
            }
        }

        if (cnt != 0) {
            int avg = sum / cnt;
            System.out.println(avg);
        }
    }

    public static void problemStream() {
        customerList().stream()
            .filter(customer -> customer.age >= 30 && customer.age <= 40)
            .mapToInt(customer -> customer.orders.size())
            .average()
            .ifPresent(System.out::println);
    }

    public static List<Customer> customerList() {
        return customers().collect(Collectors.toList());
    }

    public static Stream<Customer> customers() {
        Random random = new Random();
        String[] names = { "Liam", "Olivia", "Oliver", "Emma", "Mia", "James", "Alexander" };
        return random.ints()
            .filter(value -> value > 20 && value < 70)
            .boxed()
            .map(age -> {
                Customer customer = new Customer(
                    Math.abs(random.nextInt()),
                    names[random.nextInt(names.length - 1)] + " " + names[random.nextInt(names.length - 1)],
                    age,
                    registrationDate(random)
                );
                random.ints(random.nextInt(5))
                    .forEach(customer::makeOrder);
                return customer;
            })
            .limit(10);

    }

    private static LocalDate registrationDate(Random random) {
        int diff = random.nextInt(5);
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1;
        return LocalDate.of(2022 - diff, month, day);
    }

    public static class Customer {
        public long id;
        public String name;
        public int age;
        public List<Order> orders;
        public LocalDate registrationDate;

        public Customer(long id, String name, int age, LocalDate registrationDate) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.registrationDate = registrationDate;
            this.orders = new ArrayList<>();
        }

        public Order makeOrder(int value) {
            Order order = new Order(value);
            orders.add(order);
            return order;
        }
    }

    public static class Order {
        public long id;
        public List<String> orderItems;

        public Order(long id) {
            this.id = id;
        }
    }





}
