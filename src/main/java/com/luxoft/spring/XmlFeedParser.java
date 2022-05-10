package com.luxoft.spring;

import com.luxoft.demo.stream.StreamDemo;
import com.luxoft.demo.xml.stax.WritingDemo;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;


public class XmlFeedParser {
    private String feedFile;

    public XmlFeedParser(String feedFile) {
        this.feedFile = feedFile;
    }

    public Stream<StreamDemo.Customer> parse() throws XMLStreamException, IOException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        Stack stack = new Stack();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(Files.newInputStream(Paths.get(feedFile)));
        Map<String, Object> clientState = new HashMap<>();
        Stream.Builder<StreamDemo.Customer> clientStreamBuilder = Stream.builder();
        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                stack.push(startElement.getName().getLocalPart());

                if (startElement.getName().getLocalPart().equals("client")) {
                    clientState.clear();
                    Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                    if (idAttr != null) {
                        clientState.put("id", idAttr.getValue());
                    }
                }
            }

            if (xmlEvent.isCharacters() && !xmlEvent.asCharacters().isWhiteSpace()) {
                clientState.put(stack.peek(), xmlEvent.asCharacters().getData());
            }

            if (xmlEvent.isEndElement()) {
                EndElement endElement = xmlEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals(stack.peek())) {
                    stack.pop();
                }

                if (endElement.getName().getLocalPart().equals("client")) {
                    System.out.println(clientState);
                    clientStreamBuilder.add(
                        new StreamDemo.Customer(
                            Long.parseLong((String) clientState.get("id")),
                            (String) clientState.get("name"),
                            Integer.parseInt((String) clientState.get("age")),
                            LocalDate.parse((String) clientState.get("registrationDate"))
                        )
                    );
                }
            }
        }
        return clientStreamBuilder.build();
    }

    public static class Stack {
        private Deque<String> elements;

        public Stack() {
            this.elements = new ArrayDeque<>();
        }

        public void push(String name) {
            elements.push(name);
        }

        public String pop() {
            return elements.pop();
        }

        public String peek() {
            return elements.peek();
        }
    }

    public static Path generate(String feedFile) throws IOException {
        Path path = Paths.get(feedFile);
        Path file = Files.exists(path)
                ? path
                : Files.createFile(path);
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        WritingDemo.iteratorApi(file, xmlOutputFactory);
        return path;
    }
}
