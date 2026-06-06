package satellite;

import ddr.DDRMemory;
import export.CSVExporter;
import export.JSONExporter;
import model.DataPacket;
import network.Transmitter;

public class SatelliteWorker implements Runnable {

    private Satellite satellite;

    private DDRMemory memory;

    private CSVExporter csvExporter;

    private JSONExporter jsonExporter;

    private Transmitter transmitter;

    public SatelliteWorker(
            Satellite satellite,
            DDRMemory memory,
            CSVExporter csvExporter,
            JSONExporter jsonExporter,
            Transmitter transmitter) {

        this.satellite = satellite;

        this.memory = memory;

        this.csvExporter = csvExporter;

        this.jsonExporter = jsonExporter;

        this.transmitter = transmitter;
    }

    public void execute() {

        DataPacket packet = satellite.generateData();

        memory.store(packet);

        csvExporter.export(packet);

        jsonExporter.export(packet);

        transmitter.send(packet.toString());
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            execute();
        }
    }
}