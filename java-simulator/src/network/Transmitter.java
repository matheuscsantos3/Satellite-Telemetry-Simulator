package network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Transmitter {

    private Random random = new Random();

    public void send(String data) {

        try {

            // Simulated transmission delay
            Thread.sleep(500);

            // Simulated packet loss (20%)
            if (random.nextInt(100) < 20) {

                System.out.println("Packet lost");

                return;
            }

            Socket socket = new Socket("localhost", 5050);

            System.out.println("Connected to telemetry server");

            PrintWriter writer =
                    new PrintWriter(socket.getOutputStream(), true);

            writer.println(data);

            socket.close();

        } catch (IOException e) {

            System.out.println("Connection error: " + e.getMessage());

        } catch (InterruptedException e) {

            System.out.println("Transmission interrupted");
        }
    }
}