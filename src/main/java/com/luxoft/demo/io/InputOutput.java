package com.luxoft.demo.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputOutput {

    public static void main(String[] args) throws IOException {
        //basicIo();
        //charBasedIo();
        newIo();
    }

    private static void basicIo() throws IOException {
        String mjQuote = "The key to success is failure.";
        File file = new File("quote");
        boolean isCreated = file.createNewFile();

        if (isCreated) {
            try (OutputStream outputStream = new FileOutputStream(file)) {
                outputStream.write(mjQuote.getBytes(StandardCharsets.UTF_8));
            }
        } else {
            try (InputStream inputStream  = new FileInputStream(file)) {
                byte[] buffer = new byte[50];
                int actual = inputStream.read(buffer);
                ///System.arraycopy(buffer, 0, buffer, 0, actual);
                System.out.println(new String(buffer, StandardCharsets.UTF_8));
            }
        }
    }

    private static void charBasedIo() throws IOException {
        String mjQuote = "I can accept failure. Everyone fails at something. But I can't accept not trying";
        File file = new File("quote2");
        boolean isCreated = file.createNewFile();
        if (isCreated) {
            try (Writer writer = new PrintWriter(file)) {
                writer.write(mjQuote);
            }
        } else {
            try (Reader reader  = new FileReader(file)) {
                char[] buffer = new char[50];
                reader.read(buffer);
                System.out.println(buffer);
            }
        }
    }

    private static void newIo() throws IOException {
        Path newDir = Files.createDirectory(Paths.get("quoteDir"));
        System.out.println(newDir);
        //Files.deleteIfExists(newDir);
        List<String> lines = Files.readAllLines(Paths.get("quote2"));
        for (String line: lines) {
            System.out.println(line);
        }

        List<String> text = new ArrayList<>();
        text.add("Hello");
        text.add("World");
        Files.write(Paths.get("quote3"), text);
    }

}
