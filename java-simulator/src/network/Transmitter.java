package network;

import server.GroundStation;

public class Transmitter {

    private GroundStation groundStation;

    public Transmitter(GroundStation groundStation) {
        this.groundStation = groundStation;
    }

    public void send(String data) {

        System.out.println("Sending packet: " + data);

        groundStation.receive(data);
    }
}