package java024_networking.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// bản chất, HTTP chỉ là text protocol chạy trên TCP
// gửi request/response theo format HTTP qua OutputStream

public class clientByteStream {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8080);

        // send request
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        // request without body
        String requestStr = "GET /cart HTTP/1.1\r\n" +
                "Host: localhost\r\n" +
                "Connection: close\r\n" + "\r\n";
        // send
        out.print(requestStr);
        out.flush();

        // receive response
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String response;
        System.out.println("server response: ");
        int contentLength = 0;
        while ((response = in.readLine()) != null && !response.isEmpty()) {
            System.out.println(response);
            // content length
            if (response.startsWith("Content-Length: ")) {
                contentLength = Integer.parseInt(response.split("\\s+")[1]);
            }
        }
        System.out.print("\r\n");

        if (contentLength > 0) {
            char[] buf = new char[contentLength];
            contentLength = in.read(buf, 0, contentLength);
            System.out.println(new String(buf, 0, contentLength));
        }

        System.out.println("====");

        // close socket
        client.close();
    }
}
