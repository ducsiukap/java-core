package java024_networking.socketprogramming.multicast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

// gửi notice khi có client tham gia tới các client khác
public class server2 {
    // multicast group IP + port
    final static String mcastIP = "224.0.0.1";
    final static int mcastPort = 9999;
    // tcp
    final static int tcpPort = 1303; // handle client connect
    // client list // group nhận notice
    final static ConcurrentHashMap<Socket, String> clients = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        // send multicast message
        new Thread(() -> {
            try (MulticastSocket mcastServer = new MulticastSocket(mcastPort);) {
                InetAddress mcastGroup = InetAddress.getByName(mcastIP); //

                int messageCount = 1; // number of message
                while (true) {
                    String messageStr = "Message #" + messageCount;
                    byte[] messageByte = messageStr.getBytes();
                    // packet
                    DatagramPacket pack = new DatagramPacket(messageByte, messageByte.length, mcastGroup, mcastPort);
                    // send
                    mcastServer.send(pack);

                    // next message
                    ++messageCount;

                    // log
                    System.out.println("send: " + messageStr);

                    Thread.sleep(1000);
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // send notice
        new Thread(() -> {
            try (ServerSocket tcpServer = new ServerSocket(tcpPort)) {
                while (true) {
                    // accept client
                    Socket client = tcpServer.accept();
                    // log
                    System.out.println("receive: " + client.getRemoteSocketAddress());

                    // send notice
                    String noticeMessage = ">>> Client " + client.getRemoteSocketAddress()
                            + " has joined into the group! <<<";
                    for (Socket s : clients.keySet()) {
                        try {
                            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                            out.println(noticeMessage);
                        } catch (IOException e) {
                            // lỗi gửi tới e
                            clients.remove(s); // xóa e khỏi group nhận notice
                            s.close(); // đóng kết nối tới e
                        }
                    }
                    // put client
                    clients.put(client, client.getRemoteSocketAddress().toString());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

}