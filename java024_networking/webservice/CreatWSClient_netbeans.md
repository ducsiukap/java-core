# Create WS server with netbeans.

1. Tạo Web Project

- File → New Project → Java Web → Web Application → Next
- Đặt Project Name → Next
- Chọn Server (GlassFish/Tomcat) → Next
- Chọn Java EE version 7+ → Finish

2. Tạo SOAP Web Service

- Nhấn chuột phải Project → New → Web Service
- Đặt tên class, ví dụ HelloService
- Nhấn Finish

3. Deploy và chạy

- Nhấn chuột phải Project → Run
- NetBeans sẽ deploy project lên GlassFish/Tomcat
- Mở trình duyệt, URL WSDL sẽ là:

  ```url
  http://localhost:8080/YourProjectName/HelloService?wsdl
  ```

  Đây là endpoint WSDL để client kết nối.

4. Test

NetBeans có Web Service Tester:

- Chuột phải HelloService.java → Test Web Service
- Nhập giá trị cho sayHello → nhấn Test Web Service → xem kết quả.

ex: server:

```java
// server
package com.example;

 import javax.xml.ws.Endpoint;
 import javax.jws.WebService;
 import javax.jws.WebMethod;

 @WebService
 public class HelloService {
     @WebMethod
     public String sayHello(String name) {
         return "Hello, " + name + "!";
     }
 }

 public class Server {
     public static void main(String[] args) {
         String url = "http://localhost:8080/hello";
         Endpoint.publish(url, new HelloService()); // publish endpoint
         System.out.println("Server running at " + url);
     }
 }

```

# Create WS client with netbeans.

1. Tạo Project Java (hoặc Web Project)

   - Mở NetBeans → File → New Project.
   - Chọn Java with Ant → Java Application hoặc Java with Maven → Java Application, nhấn Next.
   - Đặt tên project → Finish.

2. Thêm Web Service Client (SOAP)

   - Nếu Web Service là SOAP:
   - Nhấn chuột phải Project → New → Web Service Client. - - Nhập WSDL URL hoặc chọn Local WSDL file.
   - NetBeans sẽ tự tạo:

     - Các class proxy để gọi web service.
     - Package yourprojectname.wsclient.

   - Nhấn Finish.

   ```java
   // client
    package com.example;

    public class Client {
        public static void main(String[] args) {
            HelloService service = new HelloService();
            Hello port = service.getHelloPort();

            String response = port.sayHello("Duc");
            System.out.println(response);
        }
    }
   ```
