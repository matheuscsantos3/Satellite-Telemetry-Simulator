package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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

            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected: "
                    + clientSocket.getInetAddress());

            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {

            System.out.println("Server error: " + e.getMessage());
        }
    }
}