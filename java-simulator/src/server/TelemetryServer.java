package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TelemetryServer {

    private int port;

    public TelemetryServer(int port) {
        this.port = port;
    }

    public void start() {

        try {

            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Telemetry Server started on port " + port);

            while (true) {

                Socket clientSocket = serverSocket.accept();

                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        clientSocket.getInputStream()));

                String message = reader.readLine();

                System.out.println("Received: " + message);

                clientSocket.close();
            }

        } catch (IOException e) {

            System.out.println("Server error: " + e.getMessage());
        }
    }
}