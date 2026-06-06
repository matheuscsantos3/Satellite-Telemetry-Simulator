package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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

            DatagramSocket socket = new DatagramSocket();

            byte[] buffer = data.getBytes();

            InetAddress address =
                    InetAddress.getByName("localhost");

            DatagramPacket packet =
                    new DatagramPacket(
                            buffer,
                            buffer.length,
                            address,
                            5050);

            socket.send(packet);

            System.out.println("Packet sent via UDP");

            socket.close();

        } catch (IOException e) {

            System.out.println("Connection error: " + e.getMessage());

        } catch (InterruptedException e) {

            System.out.println("Transmission interrupted");
        }
    }
}