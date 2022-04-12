package com.luxoft.demo.xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.nio.file.Paths;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ClientsDoc.class, Client.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            ClientsDoc clients = (ClientsDoc) unmarshaller.unmarshal(Paths.get("c.xml").toFile());
            clients.clients.forEach(System.out::println);
            clients.clients.forEach(client -> client.happyBirthday());

            Marshaller marshaller = jaxbContext.createMarshaller();
            //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(clients, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @XmlRootElement(name = "clients")
    @XmlAccessorType(XmlAccessType.FIELD)
    static class ClientsDoc {
        @XmlElement(name = "client")
        public List<Client> clients;
    }

    @XmlRootElement(name = "client")
    static class Client {
        private long id;
        private String fullname;
        private int age;

        public Client() {
        }

        public Client(long id, String name, int age) {
            this.id = id;
            this.fullname = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Client{" +
                    "id=" + id +
                    ", fullname='" + fullname + '\'' +
                    ", age=" + age +
                    '}';
        }

        public long getId() {
            return id;
        }

        @XmlAttribute
        public void setId(long id) {
            this.id = id;
        }


        public String getFullname() {
            return fullname;
        }

        @XmlElement(name = "name")
        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void happyBirthday() {
            this.age++;
        }
    }
}
