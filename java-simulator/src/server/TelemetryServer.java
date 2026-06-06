package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TelemetryServer {

    private int port;

    public TelemetryServer(int port) {
        this.port = port;
    }

    public void start() {

        try {

            DatagramSocket socket =
                    new DatagramSocket(port);

            System.out.println("Telemetry Server started on port " + port);

            byte[] buffer = new byte[1024];

            while (true) {

                DatagramPacket packet =
                        new DatagramPacket(
                                buffer,
                                buffer.length);

                socket.receive(packet);

                String message =
                        new String(
                                packet.getData(),
                                0,
                                packet.getLength());

                System.out.println("Received: " + message);
            }

        } catch (IOException e) {

            System.out.println("Server error: " + e.getMessage());
        }
    }
}