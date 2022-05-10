package com.luxoft.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws XMLStreamException, IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        XmlFeedProcessor processor = applicationContext.getBean("processor", XmlFeedProcessor.class);
        processor.process();

    }
}
