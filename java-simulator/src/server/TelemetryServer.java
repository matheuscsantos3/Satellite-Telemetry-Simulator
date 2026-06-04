package server;

import java.io.*;
import java.net.*;

public class TelemetryServer {

    private int port;

    public TelemetryServer(int port) {
        this.port = port;
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Telemetry Server started on port " + port);

            Socket clientSocket = serverSocket.accept();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));

            String message = reader.readLine();
            System.out.println("Received: " + message);

            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}