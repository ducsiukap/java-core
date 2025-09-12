### `Datagram packet`

- Mang đầy đủ thông tin `source`, `destination` nhưng _`không đảm bảo`_:

  - gói tin đến đích
  - đến đúng thời điểm
  - đến đúng thứ tự
  - đúng nội dung

- `Header` gồm 4 fields (16 bits): `source port`, `dest port`, `lenght`, `checksum`

`Java` hỗ trợ `DatagramPacket` để tạo gói tin `datagram` truyền thông với giao thức `UDP`: **_`public final class DatagramPacket`_**

- 4 thành phần quan trọng: `IP`, `data`, `length`, `port`.
- Khởi tạo gói tin nhận:
  `public DatagramPacket(byte[] buffer, int length)`
- Khởi tạo gói tin gửi:  
  `public DatagramPacket(byte[] buffer, int length, InetAddress destination, int port)` or  
  `public DatagramPacket(byte[] buffer, int lenght, SocketAddress address)`

- methods:
  - `public InetAddress getAddress()`
  - `public int getPort()`
  - `public byte[] getData()`
  - `public int getLength()`  
    tương ứng với `get`, ta có 4 phương thức `set`.

---

### `Datagram Socket`

`DatagramSocket` cho phép tạo `Socket` truyền thông bằng giao thức `UDP` -> `send`/`receive` `Datagram packet`

`Constructor` -> tạo không thành công ném ngoại lệ `SocketException`:

- `DatagramSocket()`: OS chọn `random port`, thường dùng cho `client`, gửi gói tin tới `server`.
- `DatagramSocket(int port)`: bind tới tất cả các network trên máy tại cổng `port`.
- `DatagramSocket(int port, InetAddress addr)`
- `DatagramSocket(SocketAddress addr)`

`Methods`:

- `public void send(DatagramPacket dp)`
- `public void receive(DatagramPacket dp)`
- `bind()`, `isBound()`, `connect()`, `disconnect()`, `isConnected()`, `isClosed()`, `close()`
