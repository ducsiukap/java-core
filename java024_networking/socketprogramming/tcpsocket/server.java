package java024_networking.socketprogramming.tcpsocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

// Java supports TCP Socket Programming with 2 class:
// java.net.Socket for client 
// java.net.ServerSocket for server

import java.net.ServerSocket; // server-side
import java.net.Socket;

// các luồng IO để trao đổi dữ liệu
// - byte -> InputStream/OutputStream
// - character -> BufferedReader / PrintWriter

public class server {
    public static void main(String[] args) {

        // constructor -> throws IOException
        // ServerSocket(int port) -> bind tới pord 5000
        // của mọi network interface trên máy (localhost:5000, 192.168.x.x:5000, ... )

        // ServerSocket(int port, int queueLength)
        // queueLength or backlog: số client tối đa có thể chờ accept

        // server = ServerSocket() -> then, have to call:
        // server.bind(new InetSocketAddress(int port)) để gắn port

        // ServerSocket(int port, int backlog, InetAddress bindAddr)
        // -> IP (bindAddr) + Port
        try (ServerSocket server = new ServerSocket(5000)) {
            // important method:
            // bind() -> isBound()

            // close() -> isClosed()
            // stop the server

            // public Socket accept() -> block the process cho tới khi có client kết nối tới
            while (true) {
                Socket req = server.accept(); // client request/packet
                                              // throws IOException

                // read message from client
                InputStream in = req.getInputStream();
                byte[] buf = new byte[1024];
                in.read(buf); // read
                String reqMessage = new String(buf);
                System.out.println("receive: " + reqMessage);

                // response
                PrintWriter res = new PrintWriter(req.getOutputStream(), true);
                String resMessage = "hello " + req.getRemoteSocketAddress();
                System.out.println("send: " + resMessage);
                res.println(resMessage);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
