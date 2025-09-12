package java024_networking.socketprogramming.udpsocket;

import java.net.DatagramSocket;
import java.net.SocketException;

public class PortScanner {
    public static void main(String[] args) {
        for (int port = 1024; port <= 65535; ++port) {
            try (DatagramSocket ds = new DatagramSocket(port);) {
            } catch (SocketException e) {
                System.out.println("Port: " + port + " is running!");
            }
        }
        // Port: 1900 is running!
        // Port: 2177 is running!
        // Port: 5050 is running!
        // Port: 5353 is running!
        // Port: 5355 is running!
        // Port: 49664 is running!
        // Port: 58790 is running!
        // Port: 58791 is running!
        // Port: 58792 is running!
        // Port: 58793 is running!
        // Port: 60420 is running!
        // Port: 64885 is running!
    }
}
