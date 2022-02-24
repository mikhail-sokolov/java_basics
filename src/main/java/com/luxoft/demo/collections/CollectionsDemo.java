package com.luxoft.demo.collections;

import com.luxoft.demo.enumeration.Color;
import com.luxoft.demo.inheritance.Circle;
import com.luxoft.demo.interfaces.Company;
import com.luxoft.demo.interfaces.Shape;

import java.util.*;

/**
 * Introduced in Java 1.2 to make existing collections consistent
 *
 * Contains the following data structures: List, Set, Map, Queue and Deque
 *
 * Updated to support generics in Java 5
 *
 * Updated to support Stream API in Java 8
 *
 * Generic types - can be parametrized by the element's type, so Java compiler is able to check correctness of
 * read/write operations
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        //iterable();
        //collection(new ArrayList<>());
        //collection(new HashSet<>());
        //orderedSet();
        //enumSet();
        hashSet();
    }

    /**
     * Iterable - something that can be iterated over
     * Iterator - API for iteration over a set
     */
    public static void iterable() {
        Iterable<Integer> ints = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = ints.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        Iterable<Integer> i = new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    @Override
                    public boolean hasNext() {
                        return true;
                    }

                    @Override
                    public Integer next() {
                        return 10;
                    }
                };
            }
        };

        for (Integer x: i) {
            System.out.println(x);
        }
    }

    /**
     * Generic collection of elements.
     */
    public static void collection(Collection<Integer> ints) {
        ints.add(1);
        ints.addAll(Arrays.asList(2, 3));
        System.out.println("------------------------------------------");
        //Uses iterator API
        for (Integer i: ints) {
            System.out.println(i);
        }
        System.out.println(ints.isEmpty());
        System.out.println("------------------------------------------");
        System.out.println(ints.size());
        System.out.println(ints.contains(2));
        ints.remove(2);
        System.out.println(ints.contains(2));
        System.out.println(ints.size());
    }

    /**
     * Indexed collection of elements.
     * Preserves order in which elements were inserted
     **/
    public static void list() {
        List<Integer> ints = new ArrayList<>();
        //List<Integer> arrayAsList = Arrays.asList(1, 2, 3);

        ints.add(1);
        ints.addAll(Arrays.asList(2, 3));
        System.out.println("------------------------------------------");
        //Uses iterator API
        for (Integer i: ints) {
            System.out.println(i);
        }
        System.out.println(ints.isEmpty());
        System.out.println("------------------------------------------");
        System.out.println(ints.size());
        System.out.println(ints.contains(2));
        ints.remove(2);
        System.out.println(ints.contains(2));
        System.out.println(ints.size());

        ints.set(1, 1);
        for (int i = 0; i < ints.size(); i++) {
            ints.get(1);
        }
    }

    public static void listIterator() {
        List<Integer> ints = Arrays.asList(1, 2, 3);
        ListIterator<Integer> iterator = ints.listIterator();
        //iterator.
    }

    /**
     * Collection that contains no duplicate elements. In general set have no concept of order.
     * All methods are inherited from Collection interface
     */
    public static void set() {
        Set<Integer> ints = new HashSet<>();

        ints.add(1);
        ints.addAll(Arrays.asList(2, 2, 2, 2));
        System.out.println("------------------------------------------");
        //Uses iterator API
        for (Integer i: ints) {
            System.out.println(i);
        }
        System.out.println(ints.isEmpty());
        System.out.println("------------------------------------------");
        System.out.println(ints.size());
        System.out.println(ints.contains(2));
        ints.remove(2);
        System.out.println(ints.contains(2));
        System.out.println(ints.size());
    }

    public static void orderedSet() {
        /**
         * TreeSet requires that an element implements Comparable interface or Comparator implementation is provided
         * by a constructor
         */
        Set<Integer> ints = new TreeSet<>();

        try {
            Set<Circle> shapes = new TreeSet<>();
            shapes.add(new Circle("blue"));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        Set<Company> companies = new TreeSet<>();
        Company abc = new Company("ABC", 100_000);
        companies.add(abc);
        Company ddd = new Company("DDD", 5_000);
        companies.add(ddd);
        companies.add(new Company("XYZ", 10_000));
        for (Company company: companies) {
            System.out.println(company);
        }


        Comparator<Company> companyComparator = new Comparator<Company>() {
            @Override
            public int compare(Company o1, Company o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Set<Company> companies1 = new TreeSet<>(companyComparator);
        companies1.add(abc);
        companies1.add(ddd);
        companies1.add(new Company("XYZ", 10_000));

        for (Company company: companies1) {
            System.out.println(company);
        }

        SortedSet<Company> sortedSet = new TreeSet<>(companies1);
        System.out.println("First: " + sortedSet.first());
        System.out.println("Last: " + sortedSet.last());

        NavigableSet<Company> navigableSet = new TreeSet<>(companies1);
        System.out.println(navigableSet.higher(ddd));
    }

    public static void enumSet() {
        Set<Color> colors = EnumSet.of(Color.BLUE, Color.WHITE);
        colors.add(Color.BLUE);
        for (Color color: colors) {
            System.out.println(color);
        }
    }

    public static void hashSet() {
        Set<Company> companies = new HashSet<>();
        companies.add(new Company("ABC", 1));
        companies.add(new Company("ABC", 1));
        System.out.println(companies.size());
    }

    /**
     * Generic collection of elements.
     */
    public static void map() {
        Collection<Integer> ints = new ArrayList<>();

        ints.add(1);
        ints.addAll(Arrays.asList(2, 3));
        System.out.println("------------------------------------------");
        //Uses iterator API
        for (Integer i: ints) {
            System.out.println(i);
        }
        System.out.println(ints.isEmpty());
        System.out.println("------------------------------------------");
        System.out.println(ints.size());
        System.out.println(ints.contains(2));
        ints.remove(2);
        System.out.println(ints.contains(2));
        System.out.println(ints.size());
    }
}
