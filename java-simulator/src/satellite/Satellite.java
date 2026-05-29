package satellite;

import java.util.Random;

import model.DataPacket;

public class Satellite {

    private Random random;

    public Satellite() {
        this.random = new Random();
    }

    public DataPacket generateData() {

        double temperature = 10 + (40 * random.nextDouble());

        double radiation = 20 + (80 * random.nextDouble());

        long timestamp = System.currentTimeMillis();

        return new DataPacket(
                temperature,
                radiation,
                timestamp
        );
    }
}