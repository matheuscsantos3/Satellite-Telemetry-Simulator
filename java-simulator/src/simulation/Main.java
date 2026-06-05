package simulation;

import ddr.DDRMemory;
import export.CSVExporter;
import export.JSONExporter;
import model.DataPacket;
import network.Transmitter;
import satellite.Satellite;
import server.TelemetryServer;

public class Main {

    public static void main(String[] args) {

        // Starts the telemetry server in a separate thread
        TelemetryServer server = new TelemetryServer(5050);

        Thread serverThread = new Thread(() -> {
            server.start();
        });

        serverThread.start();

        // Creates the satellite simulators
        Satellite satellite1 = new Satellite("SAT-1");
        Satellite satellite2 = new Satellite("SAT-2");
        Satellite satellite3 = new Satellite("SAT-3");

        // Creates the DDR memory that stores generated packets
        DDRMemory memory = new DDRMemory();

        // Creates the CSV exporter
        CSVExporter csvExporter = new CSVExporter();

        // Creates the JSON exporter
        JSONExporter jsonExporter = new JSONExporter();

        // Creates the transmitter module
        Transmitter transmitter = new Transmitter();

        // Generates and stores telemetry packets
        for (int i = 0; i < 10; i++) {

            DataPacket packet1 = satellite1.generateData();

            memory.store(packet1);

            csvExporter.export(packet1);

            jsonExporter.export(packet1);

            DataPacket packet2 = satellite2.generateData();

            memory.store(packet2);

            csvExporter.export(packet2);

            jsonExporter.export(packet2);

            DataPacket packet3 = satellite3.generateData();

            memory.store(packet3);

            csvExporter.export(packet3);

            jsonExporter.export(packet3);
        }

        // Shows how many packets were stored
        System.out.println("Packets stored: " + memory.size());

        // Displays all packets stored in DDR memory
        for (DataPacket packet : memory.getAllPackets()) {
            System.out.println(packet);
        }

        // Connects to the telemetry server
        for (DataPacket packet : memory.getAllPackets()) {
            transmitter.send(packet.toString());
        }
    }
}