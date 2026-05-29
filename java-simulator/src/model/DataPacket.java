package model;

public class DataPacket {

    private double temperature;
    private double radiation;
    private long timestamp;

    public DataPacket(double temperature, double radiation, long timestamp) {
        this.temperature = temperature;
        this.radiation = radiation;
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getRadiation() {
        return radiation;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "DataPacket {" +
                "temperature=" + temperature +
                ", radiation=" + radiation +
                ", timestamp=" + timestamp +
                '}';
    }
}