package java024_networking.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class httpClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        // create a client
        HttpClient client = HttpClient.newHttpClient();

        // build request
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/hello")) // uri
                .GET() // method
                // .header(header_name, value)...
                .build(); // build request

        // get response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("======================");
        System.out.println("server response:");
        System.out.println(response.statusCode()); // status code
        System.out.println(response.body()); // body
    }
}
