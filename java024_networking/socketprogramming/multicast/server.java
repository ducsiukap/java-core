package java024_networking.socketprogramming.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class server {
    public static void main(String[] args) {
        try (DatagramSocket server = new DatagramSocket();) {
            // IP multicast
            InetAddress group = InetAddress.getByName("224.2.2.3");
            int port = 9999;
            // server truyền thông như UDP, chỉ khác chỗ gửi tới IP của multicast group

            int mess = 1;
            while (true) {
                String sendMessage = mess + " -- " + InetAddress.getLocalHost();
                byte[] buf = sendMessage.getBytes();

                // send packet to group
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, port);
                server.send(packet);

                // sleep 1s
                Thread.sleep(1000);

                ++mess;
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
