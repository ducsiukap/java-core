## 02 thư viện để làm việc với Socket:

|        Package         |     I/O      | TCP                                                            |        UDP        | Usecase                                                   |
| :--------------------: | :----------: | :------------------------------------------------------------- | :---------------: | --------------------------------------------------------- |
|       `java.net`       |   blocking   | `Socket` for client<br>`ServerSocket` for server               | `DatagramSocket`  | - simply code, easy to understand<br>- ít client, app nhỏ |
| `java.nio`<br>(New IO) | non-blocking | `SocketChannel` for client<br>`ServerSocketChannel` for server | `DatagramChannel` | Server have multiple clients, high-performance            |
|                        |

`blocking` vs `non-blocking`:

- `blocking I/O`: khi gọi `I/O function` like `read()`, `accept()`, `receive()` -> chương trình _`đứng im và chờ`_ cho đến khi có dữ liệu.  
  **Trong lúc chờ, Thread đó không thể làm gì khác** -> 100 client ~ cần 100 thread phục vụ.

- `non-blocking I/O`: khi gọi `I/O function`, _`return immediately nếu không có dữ liệu`_  
  **Thread đó có thể tiếp tục làm việc khác thay vì chờ vô nghĩa**.  
  **Thường đi kèm cơ chế `multiplexing` (ex: `Selector` in `java.nio`) để `1 Thread` có thể quản lý `nhiều Socket`**.

---

## the 6 most important classes in `java.net`

- `InetAddress` -> IP  
  Methods:

  - `boolean equals(Object obj)`

  - `byte[] getAddress()` -> IP

  - `static InetAddress[] getAllByName(String host)` -> trả về mảng địa chỉ tất cả các máy trạm có cùng `hostname`.  
    ex: danh sách tất cả `IP` ứng với `www.google.com`
  - `static InetAddress getByName(String host)` -> xác định 1 địa chỉ IP đầu tiên của `host`.  
    ex: `IP` đầu tiên ứng với `www.google.com`.
  - `static InetAddress getByAddress(byte[] addr)` -> trả về (tạo) đối tượng InetAddress tương ứng với IP.

  - `static InetAddress getByAddress(String host, byte[] addr)` -> tạo đối tượng InetAddress dựa trên `hostname` và `IP`.

  - `static InetAddress getLocalHost()` -> lấy đối tượng InetAddress của máy cục bộ.

  - `String getCanonicalHostName()` -> tên miền

  - `String getHostAddress()` -> địa chỉ IP

  - `String getHostName()` -> trả về tên máy trạm.

  Note:

  - `getAllByName(String host)`, `getByName(String host)`, `getCanonicalHostName()` -> `DNS Lookup`, tìm kiếm thực sự trên mạng.
  - `getByAddress(byte[] address)`, `getByAddress(String host, byte[] address)` -> `no DNS lookup`, tự tạo 1 đối tượng InetAddress, không có thực trên Internet.

- `URI`/`URL`
  - `URI`- định danh tài nguyên, có thể là:
    - `URL`: http://example.com/index.html -> địa chỉ để _`truy cập`_ tài nguyên.
    - `URN`: urn:isbn:0451450523 -> (`scheme:scheme-specific-part`) tên duy nhất nhưng _`không nhất thiết truy cập được`_
  - `URL` : địa chỉ truy cập tài nguyên.  
    Định dạng: `protocol://host:port/path?query#fragement` or `protocol://userInfo@host:port/path?query#fragment`  
    ex: http://www.google.com:80/search?q=java#result
    - `protocol`: http
    - `host`: www.google.com
    - `:port`: 80
    - `/path`: /search
    - `?query`: q=java
    - `#fragment`: result -> định vị vị trí trong trang (tìm tới tag `<tagname id=fragment>` ) -> tìm tới thẻ có `id=result`

TCP server & client

- `ServerSocket`
- `Socket`

UDP package & socket

- `DatagramPacket`
- `DatagramSocket`
