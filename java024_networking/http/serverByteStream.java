package java024_networking.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class serverByteStream {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        // server loop
        while (true) {

            // accept the client
            Socket client = server.accept(); // blocking

            // create Thread to handle client request
            new Thread(() -> {

                try {

                    // read request
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    String reqLine;
                    System.out.println("=======================");
                    System.out.println("receive request:");
                    while ((reqLine = in.readLine()) != null && !reqLine.isEmpty()) { // request line + header
                        System.out.println(reqLine);
                    }
                    System.out.print("\r\n"); // \r\n
                    // read the body
                    // Content-Length
                    // byte[] buf = new byte[Content-Length]
                    // ..

                    // send response
                    PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                    // response message
                    String response = "HTTP/1.1 200 OK\r\n" + // status-line
                            "Date: " + new Date() + "\r\n"; // header

                    String body = "Anh yêu em";// "hello " + client.getRemoteSocketAddress() + "\r\n"; // body
                    int contentLength = body.getBytes().length;
                    // add header
                    response += "Content-Length: " + contentLength + "\r\n\r\n"; // end of header
                    response += body; // add body

                    // System.out.println("\bserver response: " + response);
                    // send
                    out.print(response);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }

}
