package java024_networking.socketprogramming.udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class server {
    public static void main(String[] args) {
        try (
                DatagramSocket server = new DatagramSocket(5000);
        //
        ) {

            while (true) {
                try {
                    byte[] buf = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
                    server.receive(receivePacket); // blocking

                    // request
                    // getData, getLength
                    byte[] data = receivePacket.getData(); // byte[]
                    int length = receivePacket.getLength();
                    // getAddress, getPort
                    InetAddress clientIP = receivePacket.getAddress();
                    int clientPort = receivePacket.getPort();
                    // log
                    System.out.println( 
                            "receive: " + (new String(data, 0, length)) + "// from client: " + clientIP + ":"
                                    + clientPort);

                    // response
                    String message = "hello client " + clientIP + ":" + clientPort;
                    byte[] sendData = message.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP,
                            clientPort);
                    System.out.println("send: " + message);
                    server.send(sendPacket); // send
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

}
