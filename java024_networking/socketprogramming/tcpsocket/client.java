package java024_networking.socketprogramming.tcpsocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Java supports TCP Socket Programming with 2 class:
// java.net.Socket for client 
// java.net.ServerSocket for server

import java.net.Socket; // client-side

// các luồng IO để trao đổi dữ liệu
// - byte -> InputStream/OutputStream
// - character -> BufferedReader / PrintWriter

public class client {
    public static void main(String[] args) {
        // Socket constructor
        // Socket()

        // Socket(String host, int port) -> connect immediately to host:port
        // Socket(String host, int port, InetAddress localAddr, int localPort)
        // => Dùng khi máy có nhiều card mạng (multi-homed host)

        // Socket(InetAddress address, int port)
        // Socket(InetAddress address, int port, InetAddress localAddr, int localPort)

        // protected Socket(SocketImpl impl)
        try (Socket client = new Socket("localhost", 5000);) { // connect to localhost:5000

            // methods:

            // data stream
            // public OutputStream getOutputStream() throws IOException
            // -> gửi dữ liệu sang bên kia
            String reqMessage = "Hello Server!";
            OutputStream out = client.getOutputStream(); // byte stream
            out.write(reqMessage.getBytes());
            System.out.println("send: " + reqMessage);
            // or using PrintWriter
            // print(), println(), printf()
            // PrintWriter out_pw = new PrintWriter(client.getOutputStream(), true); //
            // auto-flush = true

            // public InputStream getInputStream() throws IOException
            // -> nhận dữ liệu bên kia gửi
            InputStream in = client.getInputStream();
            // or using BufferedReader
            // BufferedReader in_br = new BufferedReader(new InputStreamReader(in));
            byte[] resBuf = new byte[1024];
            in.read(resBuf);
            String resMessage = new String(resBuf);
            System.out.println("receive: " + resMessage);

            // connection information
            // public InetAddress getInetAddress()
            // public int getPort()
            // public InetAddress getLocalAddress()
            // public int getLocalPort()
            // public SocketAddress getRemoteSocketAddress() -> IP + port đối phương
            // public SocketAddress getLocalSocketAddress() -> IP + port cục bộ đang dùng

            // public boolean isConnected()
            // isBound(), isClosed(), isInputShutdown(), isOutputShutdown()

            // manage socket
            // public void connect(SocketAddress endpoint)
            // public void connect(SocketAddress, int timeout)
            // public void bind(SocketAddress bindpoint)
            // publoc void close()
            // shutdownInput(), shutdownOutput()

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
