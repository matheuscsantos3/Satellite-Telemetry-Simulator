package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Transmitter {

    public void connect() {

        try {

            Socket socket = new Socket("localhost", 5050);

            System.out.println("Connected to telemetry server");

            PrintWriter writer =
                    new PrintWriter(socket.getOutputStream(), true);

            writer.println("Telemetry packet from satellite");

            socket.close();

        } catch (IOException e) {

            System.out.println("Connection error: " + e.getMessage());
        }
    }
}