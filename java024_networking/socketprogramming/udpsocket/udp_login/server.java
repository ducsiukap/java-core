package java024_networking.socketprogramming.udpsocket.udp_login;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;

class ServerHandler extends Thread {
    private DatagramPacket client;
    private HashMap<String, String> db;
    private DatagramSocket server;

    // constructor
    public ServerHandler(DatagramPacket client, HashMap<String, String> db, DatagramSocket server) {
        this.client = client;
        this.db = db;
        this.server = server;
        this.start(); // auto start
    }

    // run
    @Override
    public void run() {
        // get IP + port
        InetAddress clientAddr = this.client.getAddress();
        int clientPort = this.client.getPort();
        System.out.println("Processing login request from client: " + clientAddr + ":" + clientPort);

        // data
        byte[] cliData = this.client.getData();
        int cliDataLength = this.client.getLength();

        // format username:password
        String request = new String(cliData, 0, cliDataLength);
        String[] requestToken = request.split(":");

        // response to client
        if (requestToken.length != 2) {
            byte[] serverResponse = "Bad Request!".getBytes();
            int serverResLength = serverResponse.length;
            DatagramPacket response = new DatagramPacket(serverResponse, serverResLength, clientAddr, clientPort);
        } else {
            String username = requestToken[0];
            String password = requestToken[1];

            // checking
            boolean loginStatus = (this.db.containsKey(username) &&
                    this.db.get(username).equals(password));

            byte[] serverResponse = (loginStatus ? "Success!" : "Failed!").getBytes();
            int serverResLength = serverResponse.length;

            // response
            DatagramPacket response = new DatagramPacket(serverResponse, serverResLength, clientAddr, clientPort);
            try {
                this.server.send(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class server {
    public static void main(String[] args) {

        // database
        HashMap<String, String> userDB = new HashMap<>();
        userDB.put("vduczz", "vduczz");
        userDB.put("admin", "admin123");

        // create server
        try (DatagramSocket server = new DatagramSocket(1303)) {
            System.out.println("Server is running on port: " + server.getLocalPort());

            while (true) {
                byte[] buf = new byte[1024];
                DatagramPacket reqPack = new DatagramPacket(buf, buf.length);

                //
                server.receive(reqPack); // blocking

                new ServerHandler(reqPack, userDB, server);

            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
