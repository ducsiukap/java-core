#

**`HTTP - HyperText Transfer Protocol` là giao thức `client/server` ở `Application layer`**

- Dùng để trao đổi dữ liệu giữa `web brower` và `web server` -> Định nghĩa `cấu trúc của các thông điệp` được trao đổi và `cách chúng được trao đổi qua mạng`.
- Sử dụng `TCP` ở `Transport layer` đảm bảo truyền tin cậy.

- **`Stateless`**: client và server không lưu trữ thông tin về đối tượng còn lại trong suốt phiên làm việc.  
   Tức là, mỗi `request` tới `server` là một `request độc lập`, server không dựa vào request trước đó để xác định client. Vấn đề:

  - Mỗi `request` phải chứa `đầy đủ thông tin`, gồm cả thông tin xác thực `// vấn đề xác thực client`.
  - Với `workflow nhiều bước` -> mỗi bước cần gửi lại data của bước trước đó -> `// payload nặng / cần biết người dùng đang ở bước nào, ...`
  - cá nhân hóa

  => Vì vậy, để `duy trì trạng thái` (_`HTTP server đẩy vấn đề stateful về phía client/bên thứ 3`_), cần một số cơ chế:

  - trong đa số trường hợp, chỉ cần `xác thực client` là đủ
  - `session`, `cookie`, `token`, ...

#

**`HTTP versions`**

- `HTTP/0.9 - 1991` : chủ yếu để thử nghiệm, chỉ hỗ trợ `GET`, không có `header`, `status-code`
- `HTTP/1.0 - 1996`:
  - Hỗ trợ `GET`, `POST`, `HEAD`
  - có `header`, `status-code`
  - `Stateless/Multiple/Non-persistent connection` : _**mỗi request gửi tới server là request độc lập, connection được đóng ngay sau khi server phản hồi**_
- `HTTP/1.1 - 1997 (Chuẩn hóa phiên bản HTTP/1.0 1996)`:
  - Phiên bản phổ biến nhất.
  - Hỗ trợ `persistent connection`: cho phép client-server `giữ kết nối` cho tới khi các đối tượng trên trang được truyền tải xong.
- `HTTP/2 2015`: tối ưu hiệu năng
  - `Binary protocol` -> không còn text thuần
  - `Multiplexing`: nhiều request song song trên cùng 1 `TCP connection`, **mỗi request response là 1 `stream`**. (gặp vấn đề `TCP head-of-line blocking` -> _khi 1 request response chậm/mất gói thì toàn bộ connection (các request khác cũng) phải chờ/bị chặn_)
  - `Header compression`, `Server push`
- `HTTP/3 2022` :
  - Chạy trên `QUIC` (UDP thay vì TCP) -> tránh vấn đề `TCP head-of-line blocking` ( nhờ chạy trên `UDP`, mỗi `stream` có cơ chế truyền lại gói tin riêng -> không ảnh hưởng tới toàn bộ connection/stream khác)
  - Kết nối nhanh hơn nhờ tích hợp `TLS 1.3` trong `QUIC`
  - Tối ưu cho `mobile`/`mạng không ổn định`  
    => Hiện nay dần phổ biến nhờ _`siêu tối ưu cho internet hiện đại`_

#

**`Request format:`**

```
[METHOD] REQUEST-URI HTTP/version \r\n
Host: domain (required)\r\n
Connection: close, keep-alive\r\n
Cache-Control: no-cache, ...\r\n
Date: ...\r\n
User-Agent:\r\n
Accept: text/html, application/json, ...\r\n
Accept-Language: vi, en, en-US, ...\r\n
Accept-Encoding: ...\r\n
Authorization: Bearer <token>\r\n
Cookie: sessionId...\r\n
Content-Type: application/json...\r\n
Content-Length: ...\r\n
\r\n
username=vduczz&password=123
```

trong đó:

- `[METHOD] REQUEST-URI HTTP/version\r\n` -> request line
- `Host...Content-Length` -> header / metadata
- Ngăn cách giữa header và body là `2 lần CRLF // \r\n\r\n`
- chỉ có `request header` mới có: `Host`, `User-Agent`, `Authorization`, `Cookie`, `Accept`
- Body (optional)

**`response format`**

```
HTTP/version STATUS-CODE REASON-PHRASE\r\n
<Header-Name-1>:<value>\r\n
...
\r\n
<Body>
```

trong đó:

- `response` format tương đối giống `request`, chỉ khác dòng đầu:  
  `[METHOD] REQUEST-URI HTTP/version\r\n` -> request line. (`request`)
  `HTTP/version STATUS-CODE REASON-PHRASE\r\n` -> status line. (`response`)
- một số `header` chỉ có trong response: `Server`, `Set-Cookie`, `Etag`, ...
- response thường có body.

#

### **`HTTP Client`** sử dụng Java Socket

- Bước 1: Tạo socket (Socket vs SocketChanel)
- Bước 2: Tạo luồng I/O tới socket (luồng input và output)
- Bước 3: Đọc và ghi vào luồng tuân theo giao thức của máy chủ (HTTP)
- Bước 4: Đóng luồng
- Bước 5: Đóng socket

#

### **`HTTP Server`** sử dụng Java Socket

- Bước 1: Tạo ServerSocket lắng nghe tại port xác định
- Bước 2: Tạo luồng I/O tới socket kết nối
- Bước 3: Đọc và ghi vào luồng theo giao thức HTTP
- Bước 4: Đóng luồng
- Bước 5: Đóng Socket

#

### **`Classes`** to work with Java HTTP

// client

- `HttpURLConnection`  
  -> làm việc với `HTTP URL`  
  -> `cũ`, có từ `Java 1.1`

- `HttpClient`
  -> hiện đại, thay thế HttpURLConnection
  -> `async`, `HTTP/2`, ...
- `HttpServer`  
  -> xây dưng `Web server` đơn giản - `light weight HTTP server`
