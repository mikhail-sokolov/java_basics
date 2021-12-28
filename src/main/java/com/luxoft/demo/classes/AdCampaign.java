package com.luxoft.demo.classes;

public class AdCampaign {
    private Client[] clients;
    private String message;

    public AdCampaign(Client[] clients, String message) {
        this.clients = clients;
        this.message = message;
    }

    public AdCampaign(Client client, String message) {
        this(new Client[] { client }, message);
    }

    public void execute() {
        for (Client client: clients) {
            client.sendMessage(message);
        }
    }

    public static void main(String[] args) {
        Client[] clients;

        if (args.length != 0) {
            clients = new Client[args.length];
            int i = 0;
            for (String argument: args) {
                clients[i] = new Client(PhoneNumber.getPhoneNumber(argument));
                i++;
            }
        } else {
            clients = new Client[3];

            clients[0] = new Client(PhoneNumber.getPhoneNumber("555"));
            clients[1] = new Client(PhoneNumber.getPhoneNumber("777"));
            clients[2] = new Client(PhoneNumber.getPhoneNumber("911"));
        }

        AdCampaign adCampaign = new AdCampaign(clients, "Happy birthday!!!");
        AdCampaign anotherCampaign = new AdCampaign(clients, "Happy birthday!!!");
        objectEquality();
        //adCampaign.execute(); // execute(adCampaign)
    }

    public static void objectEquality() {
        Client client = new Client(PhoneNumber.getPhoneNumber("555"));
        String message = "Happy birthday!!!";
        AdCampaign adCampaign = new AdCampaign(client, message);
        AdCampaign anotherCampaign = new AdCampaign(client, message);
        System.out.println(adCampaign == anotherCampaign);
    }


}
