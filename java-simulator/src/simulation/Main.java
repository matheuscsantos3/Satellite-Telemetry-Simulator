package simulation;

import ddr.DDRMemory;
import export.CSVExporter;
import export.JSONExporter;
import network.Transmitter;
import satellite.Satellite;
import satellite.SatelliteWorker;
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

        // Creates satellite workers
        SatelliteWorker worker1 =
                new SatelliteWorker(
                        satellite1,
                        memory,
                        csvExporter,
                        jsonExporter,
                        transmitter);

        SatelliteWorker worker2 =
                new SatelliteWorker(
                        satellite2,
                        memory,
                        csvExporter,
                        jsonExporter,
                        transmitter);

        SatelliteWorker worker3 =
                new SatelliteWorker(
                        satellite3,
                        memory,
                        csvExporter,
                        jsonExporter,
                        transmitter);

        // Creates satellite threads
        Thread satelliteThread1 = new Thread(worker1);

        Thread satelliteThread2 = new Thread(worker2);

        Thread satelliteThread3 = new Thread(worker3);

        // Starts satellite threads
        satelliteThread1.start();

        satelliteThread2.start();

        satelliteThread3.start();

        try {

            satelliteThread1.join();

            satelliteThread2.join();

            satelliteThread3.join();

        } catch (InterruptedException e) {

            System.out.println("Thread interrupted");
        }

        // Shows how many packets were stored
        System.out.println("Packets stored: " + memory.size());
    }
}