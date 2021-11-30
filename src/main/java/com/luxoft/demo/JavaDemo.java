package com.luxoft.demo; //defining a package

import java.io.PrintStream;

/**
 * https://docs.oracle.com/javase/9/docs/api/overview-summary.html
 *
 * Everything is inside a class.
 * By convention, class names are CamelCase
 * Source file must be called as a public class defined in the file
 */
public class JavaDemo {
    /**
     * Entry point for every java program
     * @param args defines CLI arguments passed when a program is executed
     */
    public static void main(String[] args) { // <- braces are used for blocks
        System.out.println("Hello!!!");// <- statements end in semicolons

        PrintStream object = System.out;
        object.println(); // object.method(parameters)
        //literals();
        //typeConversions();
        //strings();
        loopContinue();
    }

    /*
        Multiline comments
        Java is case-sensitive: Main != main
     */
    public static void Main(String[] args) { // <- braces are used for blocks
        System.out.println("Hello!!!");// <- statements end in semicolons
    }

    public static void numericDataTypes() {
        int i;   //  4 bytes  -2,147,483,648 to 2,147,483,647
        short s; //  2 bytes  -32,768 to 32,767
        long l;  //  8 bytes  -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        byte b;  //  1 byte   -128 to 127
    }

    public static void floatingPointTypes() {
        float f;   // 4 bytes 6-7 significant decimal digits
        double d;  // 8 bytes 15 significant decimal digits
    }

    public static void charType() {
        char c; // Unicode characters
    }

    public static void booleanType() {
        boolean b; // true/false
    }

    public static void literals() {
        String literals = "string";
        //int x = 1L;
        long x = 1L;
        int hex = 0xCAFE;
        int binary = 0b1111;
        int y = 1_000_000_000;
        float f = 0.5F;
        char c = 'A';
        char c2 = '\n';
        char c3 = '\u2122'; //TM symbol
    }

    public static void primitiveTypes() {
        int i;
        long l;
        short s;
        byte b;
        double d;
        float f;
        char c;
        boolean bool;
    }

    public static void variables() {
        int i = 12;
        System.out.println("i=" + i);
        i = 22;
        System.out.println("i=" + i);
        {
            int j = 1;
            System.out.println("i=" + i);
        }
        //System.out.println("j=" + j);
        final int k = 10;
        //k = 0;
    }

    public void mathOps() {
        int sum = 1 + 2;
        System.out.println("Sum: " + sum);

        int sub = 1 - 2;
        System.out.println("Sub: " + sub);

        int mult = 2 * 2;
        System.out.println("Mult: " + mult);

        int div = 10 / 3;
        System.out.println("Div: " + div);

        int mod = 10 % 3;
        System.out.println("Mod: " + mod);
    }

    /**
     * Implicit:
     * byte -> short -> int -> long
     *          char -> int
     *                  int -> double
     *                  float -> double
     *
     * With a possible precision loss
     *  int -> float
     *  long -> double
     *  long -> float
     */
    public static void typeConversions() {
        int x = 10;
        long l = x;

        //explicit cast
        double d = 9.997;
        //int nn = d;
        int nx = (int) d;
        System.out.println("nx =" + nx);
        int rx = (int) Math.round(d);
        System.out.println("rx =" + rx);
        int cx = (int) Math.ceil(d);
        System.out.println(cx);
    }

    public static void moreOps() {
        int n = 1;
        n += 5; //-= *= /= %= and so on
        System.out.println("n += 5 ==" + n);
        n++; //n--
        System.out.println("n++ ==" + n);

        System.out.println("" + (n > 1)); // == != < <= > >=
        System.out.println(true && true); // || !

        int x = n < 5 ? 10 : 0; // the same as code in method x
        System.out.println(x);
    }

    public static int x(int n) {
        if (n < 5) {
            return 10;
        } else {
            return 0;
        }
    }

    enum Color {
        RED,
        GREEN,
        BLUE;
    }

    public static void enumType() {
        Color color = Color.RED;
    }

    /**
     * Sequences of Unicode characters
     * Instances of String class
     * Immutable
     */
    public static void strings() {
        String literal = "Hello Java";
        String uppercase = "Java".toUpperCase();
        System.out.println(uppercase);
        String substr = literal.substring(0, 6);
        System.out.println(substr);

        String join =  literal + "!";
        System.out.println(join);

        String s = literal + 10;
        System.out.println(s);

        boolean e = "Hello java".equals(literal);
        System.out.println(e);
        boolean e1 = "Hello java".equalsIgnoreCase(literal);
        System.out.println(e1);

        int length = "".length();

        char firstLetter = literal.charAt(0);

        String trim = "    Hello    ".trim();

        String nullString = null;

        String formattedString = String.format("Hello, %s. Next year, you'll be %d, ", "Jane Dow", 99);
        System.out.println(formattedString);
    }

    public static void controlFlow(int i) {
        if (i < 10) {
            System.out.println("Less than 10. In braces.");
        }

        if (i < 10)
            System.out.println("Less than 10");

        if (methodCall(i)) {
            System.out.println("Less than 10. Method call");
        }

        if (i > 10) {
            //do nothing
        } else {
            System.out.println("Less than 10. Else part");
        }

        if (i > 10) {
            //do nothing
        } else if (i < 5) {
            System.out.println("Less than 5. Chain");
        }
    }

    static boolean methodCall(int i) {
        return i < 10;
    }

    /**
     * 1. Create a maven project ("Hello Java")
     * 2. Create a package ("com.luxoft"). Packages have reverse domain structure;
     * 3. Create a class ("HelloJava")
     * 4. Create "main" method
     * 5. Define an int var and assign any value you like
     * 6. Add if statement. if int var is less than 20 then print Hello Java otherwise print Goodbye Java
     */
    static void task1() {

    }


    public static void whileLoop() {
        int i = 0;
        while (i < 10) {
            System.out.println("i=" + i);
            i++;
        }
    }

    public static void infiniteLoop() {
        int i = 0;
        while (true) {
            System.out.println("Forever in a loop");
            if (i > 50) {
                break; // terminates the loop
            }
            i++;
        }
    }

    public static void doWhileLoop() {
        int i = 0;
        do {
            System.out.println("i=" + i);
        } while (i < 1);
    }

    public static void forLoop() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i);
        }
    }

    public static void loopContinue() {
        System.out.println("----loopContinue-----");
        int i = 0;
        while (i < 10) {
            i++;
            if (i < 5) {
                continue;
            }
            System.out.println("i=" + i);
        }
    }

    public static void switchStatement(Color color) {
        switch (color) { //int, enum or strings
            case RED:
                System.out.println("RED");
                break;
            case GREEN:
                System.out.println("GREEN");
                break;
            case BLUE:
                System.out.println("BLUE");
                break;
            default:
                System.out.println("DEFAULT");
                break;
        }

    }

    /**
     * Rewrite loopContinue() method so that it doesn't use 'continue' (hint: use 'if' statement)
     */
    public static void loopContinue2() {

    }

    public static void arrays() {
        int[] ints;
        String[] strings;

        ints = new int[10]; // empty array of size 10, contains ten elements which value is 0 (int default value)
        ints[0] = 0; // array indexes are from 0 to "array".length - 1
        System.out.println(ints[1] == 0);

        // array indexes are from 0 to "array".length - 1 that is why we use i < ints.length
        for (int i = 0; i < ints.length; i++) {
            System.out.println("ints[" + i + "]" + ints[i]);
        }

        int[] xs = {10, 20, 30, 40, 50};
        forEachArrays(xs);

        forEachArrays(new int[] {1, 2, 3, 4, 5});
    }

    public static void forEachArrays(int[] ints) {
        for (int i : ints) {
            System.out.println(i);
        }
    }

}


