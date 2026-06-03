package simulation;

import ddr.DDRMemory;
import model.DataPacket;
import satellite.Satellite;

public class Main {

    public static void main(String[] args) {

        Satellite satellite = new Satellite();
        DDRMemory memory = new DDRMemory();

        for (int i = 0; i < 10; i++) {

            DataPacket packet = satellite.generateData();

            memory.store(packet);
        }

        System.out.println("Packets stored: " + memory.size());
    }
}