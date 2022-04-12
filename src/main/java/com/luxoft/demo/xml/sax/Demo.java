package com.luxoft.demo.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * SAX: Simple API for XML (SAX), an event-driven, serial-access mechanism for accessing XML documents.
 * It is the fastest and least memory-intensive mechanism. Push parsing API.
 */
public class Demo {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            System.out.println("SAX parser");
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse("c.xml", new Print());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class Print extends DefaultHandler {
        @Override
        public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes
        ) throws SAXException {
            if (qName.equalsIgnoreCase("client")) {
                // get tag's attribute by name
                String id = attributes.getValue("id");
                System.out.println("Client id=" + id);
            }
        }
    }
}
