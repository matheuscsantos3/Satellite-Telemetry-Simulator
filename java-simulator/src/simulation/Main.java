package simulation;

import ddr.DDRMemory;
import model.DataPacket;
import network.Transmitter;
import satellite.Satellite;

public class Main {

    public static void main(String[] args) {

        // Creates the satellite simulator
        Satellite satellite = new Satellite();

        // Creates the DDR memory that stores generated packets
        DDRMemory memory = new DDRMemory();

        // Creates the transmitter module
        Transmitter transmitter = new Transmitter();

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

        // Simulates packet transmission
        for (DataPacket packet : memory.getAllPackets()) {
            transmitter.send(packet);
        }
    }
}