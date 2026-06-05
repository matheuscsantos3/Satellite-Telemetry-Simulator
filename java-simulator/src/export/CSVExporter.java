package export;

import java.io.FileWriter;
import java.io.IOException;

import model.DataPacket;

public class CSVExporter {

    public void export(DataPacket packet) {

        try {

            FileWriter writer = new FileWriter("telemetry.csv", true);

            writer.write(packet.toString() + "\n");

            writer.close();

            System.out.println("Packet exported to CSV");

        } catch (IOException e) {

            System.out.println("Export error: " + e.getMessage());
        }
    }
}