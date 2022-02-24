package com.luxoft.demo.exceptions;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Sometimes you can encounter an error in your program:
 *  - programming errors: uninitialized variable, API misuse
 *  - device errors
 *  - user input errors
 *
 *  In such situations you can do the following:
 *  - Try to execute another block of code
 *  - Terminate the program
 *  - Return a default value
 *  - Propagate an error and defer error handling
 *
 *  Java uses exceptions to deal with errors.
 *
 *  Throwable is a superclass for all errors in java
 *  Throwable <-- Error
 *  Error is a subclass of Throwable that indicates serious problems that a reasonable application should not try to catch.
 *
 *  Throwable <-- Exception
 *  The class Exception and its subclasses are a form of Throwable that indicates conditions that a reasonable
 *  application might want to catch.
 *  The class Exception and any subclasses that are not also subclasses of RuntimeException are checked exceptions.
 *  Checked exceptions need to be declared in a method or constructor's throws clause if they can be thrown by
 *  the execution of the method or constructor and propagate outside the method or constructor boundary.
 *
 *  Exception <-- RuntimeException
 *  RuntimeException and its subclasses are unchecked exceptions. Unchecked exceptions do not need to be declared
 *  in a method or constructor's throws clause if they can be thrown by the execution of the method or
 *  constructor and propagate outside the method or constructor boundary.
 *
 * Exceptions
 * - checked
 * - unchecked
 *
 *  Uncaught exception terminates the program.
 *
 *  Although you can define your own exceptions it is recommended to use exception classes that are already defined if it's
 *  possible
 *  (e.g. NullPointerException, IllegalArgumentException)
 */
public class Err {
    public static void main(String[] args) throws IOException {
        //try-catch-finally
        tcf();

        //StringSource stringSource = new FileBasedStringSource("src/main/java/com/Main.java");
        //System.out.println(stringSource.get());


        /*try {
            riskyOps(11);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }*/

        /*
        //Runtime exceptions
        int r = computation(1, 1);
        System.out.println(r);

        int x = 1;
        int y = 1;

        if (y != 0) {
            int r2 = computation(x, y);
            System.out.println(r2);
        }*/
    }

    /**
     * Option 1
     */
    public void handleIt(int i) {
        try {
            riskyOps(i);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Option 2
     */
    public void propagate(int i) throws SQLException, IOException {
        riskyOps(i);
    }

    public static void riskyOps(int i) throws IOException, SQLException {
        if (i < 0) {
            throw new IllegalArgumentException("i is less than zero");
        }

        if (i > 3 && i <= 6) {
            throw new IOException("Boom!");
        }

        if (i > 6) {
            throw new SQLException("Crash!!!");
        }
    }


    public static int computation(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("the second parameter can not be zero");
        }
        return x / y;
    }

    /**
     * try with resource
     */
    public static void tcf() throws IOException {
        try (Scanner scanner = new Scanner(Paths.get("src/main/java/com/Main.java"))) {
            String line = scanner.next();
            System.out.println(line);
            riskyOps(line.length() - 1);
            System.out.println("try");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String generateUrl(String query) {
        return "https://goolge.com?q=" + Err.encodeUtf8(query);
    }

    public static String encodeUtf8(String string) {
        try {
            return URLEncoder.encode(string, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
