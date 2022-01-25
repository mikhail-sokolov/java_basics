package com.luxoft.demo.exceptions;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileBasedStringSource implements StringSource {
    private final String path;

    public FileBasedStringSource(String path) {
        this.path = path;
    }

    @Override
    public String get() {
        try (Scanner scanner = new Scanner(Paths.get(path))) {
            return scanner.next();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
