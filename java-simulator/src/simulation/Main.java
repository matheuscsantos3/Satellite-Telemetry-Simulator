package simulation;

import model.DataPacket;
import satellite.Satellite;

public class Main {

    public static void main(String[] args) {

        Satellite satellite = new Satellite();

        for (int i = 0; i < 10; i++) {

            DataPacket packet = satellite.generateData();

            System.out.println(packet);
        }
    }
}