package java024_networking.socketprogramming.tcpsocket.multithreading_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        try (Socket server = new Socket("localhost", 1303);
                BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
                PrintWriter out = new PrintWriter(server.getOutputStream(), true);
                // console (keypad input)
                BufferedReader keypad = new BufferedReader(new InputStreamReader(System.in));
        //
        ) {
            String message = in.readLine();
            System.out.print(message);
            // getusername
            out.println(keypad.readLine());

            message = in.readLine();
            System.out.print(message);
            // password
            out.println(keypad.readLine());

            // print the result
            message = in.readLine();
            System.out.println(message);
            message = in.readLine();// status
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
