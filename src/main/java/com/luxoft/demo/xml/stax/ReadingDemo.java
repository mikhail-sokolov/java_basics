package com.luxoft.demo.xml.stax;


import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * StAX - Streaming API for XML: event-driven pull parsing API for
 * reading and writing XML documents. StAX enables you to create bidirectional XML parsers that are fast, relatively
 * easy to program, and have a light memory footprint.
 *
 * Provide two API types: cursor API and iterator API
 */
public class ReadingDemo {
    public static void main(String[] args) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream("c.xml"));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("client")) {
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            System.out.println("Client id=" + idAttr);
                        }
                    }
                }
            }

        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}