Ref: [Java Networking](https://www.geeksforgeeks.org/java/java-networking/)

---

# What is **`Networking Programming`** ?

`Networking Programming` : writting programs that can be executed over various devices. In other words, we connect various devices to each other to share the resources using a `network` / `internet`.

---

### **Common `network protocols`**

- `TCP - Transmission Control Protocol`:

  - `connection-oriented` : `client` and `server` have to establish the connection before transfer the data. (bắt tay 3 bước)
  - high reliability (không mất, đúng thứ tự).
  - `more slowly than UDP`

- `UDP - User Datagram Protocol`:

  - `connection-less protocol` : opening the connection, error checking, recovery is not require.
  - `less reliable` but **_`faster than TCP`_**.
  - Readmore about `QUIC` protocols.

---

### **`Networking Terminology`**

- `IP address` - identify the device on the network. Range `0.0.0.0` to `255.255.255.255`.  
  => Home address
- `Port` - the port that the application process running on it.  
   => Application process = rooms -> number of room.
- `Protocol` -> how data is transmitted between devices. `TCP`, `UDP`, `FTP`, `HTTP`, ...
- `Socket` : **`endpoint`** of a two-way communication connection between the two applications running on the network.  
  `Socket = IP + Port + Protocol` => Điểm tiếp xúc giữa 2 tiến trình
- `MAC address`

---

### **Java Networking `Classes` and `Interfaces`**

| `Classes`      | `Interface`       |
| -------------- | ----------------- |
| DatagramPacket | SocketOption      |
| InetAddress    | SocketImplFactory |
| Socket         | ProtocolFamily    |
| ServerSocket   | FileNameMap       |
| DatagramSocket | CookiePolicy      |
| CatchRequest   | CookieStore       |
| CookieHandler  |
| CookieManager  |
| Proxy          |
| URL            |
| URL Connection |
