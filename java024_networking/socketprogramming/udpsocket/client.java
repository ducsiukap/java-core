package java024_networking.socketprogramming.udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class client {
    public static void main(String[] args) {
        try (DatagramSocket client = new DatagramSocket();
        //
        ) {
            String message = "hello server";
            InetAddress serverAddr = InetAddress.getByName("localhost"); // UnknowHostException
            byte[] data = message.getBytes();
            DatagramPacket sendPack = new DatagramPacket(data, data.length, serverAddr, 5000);

            // send
            client.send(sendPack);

            // buffer
            byte[] buf = new byte[1024];
            // receive
            DatagramPacket receivePack = new DatagramPacket(buf, buf.length);
            //
            client.receive(receivePack); // blocking
            //
            System.out.print("receive: " + new String(receivePack.getData(), 0, receivePack.getLength()));
            System.out.println(" // from: " + receivePack.getAddress() + ":" + receivePack.getPort());

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
