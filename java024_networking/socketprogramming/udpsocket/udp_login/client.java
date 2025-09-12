package java024_networking.socketprogramming.udpsocket.udp_login;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class client {
    public static void main(String[] args) {
        // login data
        byte[][] loginRequest = { "vduczz:vduczz".getBytes(), "vduczz:testabc".getBytes(), "test:test".getBytes(),
                "admin:admin123".getBytes(), "admin:admin".getBytes() };
        // server IP + port
        try {
            InetAddress serverAddr = InetAddress.getByName("localhost");
            int serverPort = 1303;

            for (byte[] request : loginRequest) {
                try (DatagramSocket client = new DatagramSocket()) {
                    // request packet
                    DatagramPacket req = new DatagramPacket(request, request.length, serverAddr, serverPort);
                    // send request
                    client.send(req);

                    // wait for response
                    byte[] buf = new byte[1024];
                    DatagramPacket res = new DatagramPacket(buf, buf.length);
                    client.receive(res); // blocking

                    // log
                    System.out.println("====================================");
                    System.out.println("login with username:password = " + (new String(request)));
                    System.out.println("Status: " + (new String(res.getData())));
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
