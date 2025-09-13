package java024_networking.socketprogramming.multicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.Socket;

public class client2 {
    // multicast group
    static final String mcastIP = "224.0.0.1";
    static final int mcastPort = 9999;

    // tcp server
    static final String tcpServerIP = "localhost";
    static final int tcpServerPort = 1303;

    public static void main(String[] args) {

        // thread nhận message từ multicast group
        new Thread(() -> {
            try (MulticastSocket mcastSocket = new MulticastSocket(mcastPort)) {
                // join group
                mcastSocket.joinGroup(new InetSocketAddress(mcastIP, mcastPort),
                        NetworkInterface.getByInetAddress(InetAddress.getLocalHost()));

                // receive message
                byte[] buf = new byte[1024];
                while (true) {
                    DatagramPacket receivePack = new DatagramPacket(buf, buf.length);

                    // receive
                    mcastSocket.receive(receivePack);

                    // log
                    String message = new String(receivePack.getData(), 0, receivePack.getLength());
                    System.out.println("receive: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // thread nhan tcp socket
        try (
                Socket tcpSocket = new Socket(tcpServerIP, tcpServerPort); // connect to server
                BufferedReader in = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()))

        ) {
            String notice;
            while ((notice = in.readLine()) != null) {
                System.out.println(notice);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
