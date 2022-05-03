package com.luxoft.tasks;

import org.junit.*;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class XmlFeedProcessingTests {
    private static final String FEED_FILE = "test_feed.xml";
    private static Path feedFile;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Generating a feed");
        feedFile = XmlFeedProcessing.generate(FEED_FILE);
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Preparing test execution");
    }

    @Test(expected = NoSuchFileException.class)
    public void fileNotFound() throws XMLStreamException, IOException {
        XmlFeedProcessing.solution("aaa");
    }

    @Test
    public void success() throws XMLStreamException, IOException {
        XmlFeedProcessing.solution(FEED_FILE);
        assertTrue(true);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After test execution");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Deleting the generated feed");
        Files.delete(feedFile);
    }
}
