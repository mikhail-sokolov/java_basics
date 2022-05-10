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
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class XmlFeedProcessor {
    private XmlFeedParser parser;

    public XmlFeedProcessor(XmlFeedParser parser) {
        this.parser = parser;
    }

    public XmlFeedProcessor() {
    }

    public void setParser(XmlFeedParser parser) {
        System.out.println(parser.toString());
        this.parser = parser;
    }

    public void process() throws XMLStreamException, IOException {
        parser.parse()
            .collect(
                Collectors.groupingBy(
                    customer -> customer.registrationDate.getMonth(),
                    TreeMap::new,
                    Collectors.toList()
                )
            )
            .forEach((month, customers) -> {
                System.out.println(month);
                customers.forEach(System.out::println);
            });
    }
}
