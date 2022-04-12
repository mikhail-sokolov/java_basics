package com.luxoft.tasks;

import com.luxoft.demo.xml.stax.WritingDemo;

import javax.xml.stream.XMLOutputFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Read 'feed.xml' feed file with clients data and print all clients grouped by month of registration.
 *
 * Call 'generate' method for 'feed.xml' generation
 *
 * Hint: use xml reading like in com.luxoft.demo.xml
 */
public class XmlFeedProcessing {
    public static void main(String[] args) throws IOException {
        //generate();

    }

    public static void generate() throws IOException {
        Path path = Paths.get("feed.xml");
        Path file = Files.exists(path)
                ? path
                : Files.createFile(path);
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        WritingDemo.iteratorApi(file, xmlOutputFactory);
    }
}
