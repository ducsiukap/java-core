package java024_networking.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

// com.sun.net.httpserver.HttpServer
import com.sun.net.httpserver.*;

public class httpServer {
    public static void main(String[] args) throws IOException {
        // create server
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // create route
        server.createContext("/hello", exchange -> {
            System.out.println("============");
            System.out.println("request from client: " + exchange.getRemoteAddress());

            // response message
            String response = "Hello " + exchange.getRemoteAddress() + " from server!";
            // status, content-lenght
            exchange.sendResponseHeaders(200, response.getBytes().length);
            // send response
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        server.setExecutor(null);
        server.start(); // start the server
        System.out.println("server running on port: 8080");
    }
}
