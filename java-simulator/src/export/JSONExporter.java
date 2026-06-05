package export;

import java.io.FileWriter;
import java.io.IOException;

import model.DataPacket;

public class JSONExporter {

    public void export(DataPacket packet) {

        try {

            FileWriter writer = new FileWriter("telemetry.json", true);

            writer.write("{\n");
            writer.write("  \"temperature\": " + packet.getTemperature() + ",\n");
            writer.write("  \"radiation\": " + packet.getRadiation() + ",\n");
            writer.write("  \"timestamp\": " + packet.getTimestamp() + "\n");
            writer.write("}\n");

            writer.close();

            System.out.println("Packet exported to JSON");

        } catch (IOException e) {

            System.out.println("Export error: " + e.getMessage());
        }
    }
}