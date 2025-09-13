package java024_networking.socketprogramming.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class client {
    public static void main(String[] args) {
        try (
                // create Multicast socket
                // MulticastSocket() -> random port
                // MulticastSocket(int port) -> specify port
                MulticastSocket client = new MulticastSocket(9999); // port=multicast port

        ) {
            // IP + port multicast
            InetAddress group = InetAddress.getByName("224.2.2.3");
            int port = 9999;
            // methods

            // join to group
            // .joinGroup(SocketAddress, NetworkInterface)
            client.joinGroup(new InetSocketAddress(group, port),
                    NetworkInterface.getByInetAddress(InetAddress.getLocalHost()));

            // leave a group
            // .leaveGroup(SocketAddress multicastAddr, NetworkInterface localInterface)

            // getNetworkInterface() / setNetworkInterface(NetworkInterface nic) -> lấy/chỉ
            // định card cho multicast
            // getTimeToLive() / setTimeToLive(int ttl) -> TTL

            // setLoopbackMode(boolean disable) // nhận lại gói tin multicast do mình gửi ?
            // disable = true -> deo nhan lai
            // disable = false -> nhan luon

            // send/receive packet
            // send(DatagramPacket p, byte ttl)
            // send(DatagramPacket packet)

            // receive(DatagramPacket packet) // blocking

            byte[] buf = new byte[1024];
            while (true) {

                // received packet
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                // receive packet from server
                client.receive(packet);

                // log
                System.out.println("receive: " + (new String(packet.getData())));
            }

            //
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
