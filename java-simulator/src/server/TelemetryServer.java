package server;

import java.io.IOException;
import java.net.ServerSocket;

public class TelemetryServer {

    private final int port;

    public TelemetryServer(int port) {
        this.port = port;
    }

    public void start() {

        try {

            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("================================");
            System.out.println("Telemetry Server started");
            System.out.println("Port: " + port);
            System.out.println("Waiting for connection...");
            System.out.println("================================");

            serverSocket.close();

        } catch (IOException e) {

            System.out.println("Server error: " + e.getMessage());
        }
    }
}