package network;

import model.DataPacket;

public class Transmitter {

    public void send(DataPacket packet) {
        System.out.println("Sending packet: " + packet);
    }
}