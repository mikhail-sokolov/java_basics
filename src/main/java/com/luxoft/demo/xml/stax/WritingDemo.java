package com.luxoft.demo.xml.stax;

import com.luxoft.demo.stream.StreamDemo;

import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * StAX - Streaming API for XML: event-driven pull parsing API for
 * reading and writing XML documents. StAX enables you to create bidirectional XML parsers that are fast, relatively
 * easy to program, and have a light memory footprint.
 *
 * Provide two API types: cursor API and iterator API
 */
public class WritingDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("c.xml");
        Path file = Files.exists(path)
                    ? path
                    : Files.createFile(path);
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        //cursorApi(file, xmlOutputFactory);
        iteratorApi(file, xmlOutputFactory);
    }

    private static void cursorApi(Path file, XMLOutputFactory xmlOutputFactory) {
        try (
            OutputStream stream = Files.newOutputStream(file);
            AutoCloseableAdapter w = new AutoCloseableAdapter(xmlOutputFactory.createXMLStreamWriter(stream))
        ) {
            XMLStreamWriter writer = w.asWriter();

            writer.writeStartDocument();
            writer.writeStartElement("clients");
            StreamDemo.customers().forEach(customer -> {
                try {
                    writer.writeStartElement("client");
                    writer.writeAttribute("id", String.valueOf(customer.id));
                    writer.writeAttribute("age", String.valueOf(customer.age));

                    writer.writeStartElement("name");
                    writer.writeCharacters(customer.name);
                    writer.writeEndElement();

                    /*writer.writeStartElement("age");
                    writer.writeCharacters(String.valueOf(customer.age));
                    writer.writeEndElement();*/

                    writer.writeEndElement();
                    writer.flush();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            });
            writer.writeEndElement();
            writer.writeEndDocument();
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class AutoCloseableAdapter implements AutoCloseable {
        private XMLEventWriter eventWriter;
        private XMLStreamWriter writer;

        public AutoCloseableAdapter(XMLStreamWriter writer) {
            this.writer = writer;
        }

        public AutoCloseableAdapter(XMLEventWriter writer) {
            this.eventWriter = writer;
        }

        @Override
        public void close() throws Exception {
            if (writer != null) {
                writer.close();
            } else {
                eventWriter.close();
            }
        }

        XMLStreamWriter asWriter() {
            return writer;
        }

        XMLEventWriter asEventWriter() {
            return eventWriter;
        }
    }

    private static void iteratorApi(Path file, XMLOutputFactory xmlOutputFactory) {
        XMLEventFactory xmlEventFactory = XMLEventFactory.newFactory();
        try (
            OutputStream stream = Files.newOutputStream(file);
            AutoCloseableAdapter w = new AutoCloseableAdapter(xmlOutputFactory.createXMLEventWriter(stream))
        ) {
            XMLEventWriter writer = w.asEventWriter();
            writer.add(xmlEventFactory.createStartDocument());
            writer.add(xmlEventFactory.createStartElement("", "", "clients"));

            StreamDemo.customers()
                .flatMap(customer -> {
                    Stream.Builder<XMLEvent> builder = Stream.builder();
                    builder.add(xmlEventFactory.createStartElement("", "", "client"));
                    builder.add(xmlEventFactory.createAttribute("id", String.valueOf(customer.id)));

                    builder.add(xmlEventFactory.createStartElement("", "", "name"));
                    builder.add(xmlEventFactory.createCharacters(customer.name));
                    builder.add(xmlEventFactory.createEndElement("", "", "name"));

                    builder.add(xmlEventFactory.createStartElement("", "", "age"));
                    builder.add(xmlEventFactory.createCharacters(String.valueOf(customer.age)));
                    builder.add(xmlEventFactory.createEndElement("", "", "age"));

                    builder.add(xmlEventFactory.createEndElement("", "", "client"));

                    return builder.build();
                })
                .forEach(event -> {
                    try {
                        writer.add(event);
                    } catch (XMLStreamException e) {
                        e.printStackTrace();
                    }
                });
            writer.add(xmlEventFactory.createEndElement("", "", "clients"));
            writer.add(xmlEventFactory.createEndDocument());
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
