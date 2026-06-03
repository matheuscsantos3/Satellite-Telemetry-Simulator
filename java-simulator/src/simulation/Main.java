package simulation;

import ddr.DDRMemory;
import model.DataPacket;
import network.Transmitter;
import satellite.Satellite;
import server.GroundStation;

public class Main {

    public static void main(String[] args) {

        // Creates the satellite simulator
        Satellite satellite = new Satellite();

        // Creates the DDR memory that stores generated packets
        DDRMemory memory = new DDRMemory();

        // Creates the ground station
        GroundStation groundStation = new GroundStation();

        // Creates the transmitter module
        Transmitter transmitter = new Transmitter(groundStation);

        // Generates and stores 10 telemetry packets
        for (int i = 0; i < 10; i++) {

            DataPacket packet = satellite.generateData();

            memory.store(packet);
        }

        // Shows how many packets were stored
        System.out.println("Packets stored: " + memory.size());

        // Displays all packets stored in DDR memory
        for (DataPacket packet : memory.getAllPackets()) {
            System.out.println(packet);
        }

        // Simulates packet transmission to the ground station
        for (DataPacket packet : memory.getAllPackets()) {
            transmitter.send(packet.toString());
        }
    }
}