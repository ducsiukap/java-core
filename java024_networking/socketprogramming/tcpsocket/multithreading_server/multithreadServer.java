package java024_networking.socketprogramming.tcpsocket.multithreading_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

// Đồng thời hướng kết nối
// Mỗi client được gán cho 1 thread
// tránh blocking

// example: Login using TCP Socket

class ClientHandler1 extends Thread {
    private Socket client;
    private HashMap<String, String> database;

    public ClientHandler1(Socket client, HashMap<String, String> database) {
        this.client = client;
        this.database = database;
    }

    @Override
    public void run() {
        // call handle function
        // ....
        System.out.println("Processing client: " + client.getRemoteSocketAddress());

        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        //
        ) {
            out.println("username: ");
            String username = in.readLine();

            out.println("password: ");
            String password = in.readLine();

            out.println("=======================================");
            if (database.containsKey(username) && database.get(username).equals(password)) {
                out.println("Login success!");
            } else {
                out.print("Login failed!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class multithreadServer {
    public static void main(String[] args) {

        HashMap<String, String> database = new HashMap<>();
        database.put("vduczz", "vduczz");
        database.put("admin", "admin123");

        try (ServerSocket server = new ServerSocket(1303);) {
            while (true) {

                Socket client = server.accept();

                (new ClientHandler1(client, database)).start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
