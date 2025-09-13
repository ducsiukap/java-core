`FTP - File Transfer Protocol` : giao thức `truyền file` giữa `client/server`. Cho phép:

- client `Upload` file to `server`
- client `Download` file from `server`
- `quản lý directory`, `xóa/đổi tên file` trên server

#

**`FTP gateway`**  
`Command/Control` : `port=21` -> gửi lệnh FTP từ client lên server  
`Data` : `port=20 (active mode)` or bất kì cổng nào (`passive mode`) -> Truyền file.

#

**2 chế độ truyền dữ liệu**  
`Active mode`:

- client mở cổng `>1023` và ` chờ server kết nối vào`
- server kết nối từ cổng `20` của client  
  -> `nhược điểm`: thường bị firewall của client chặn

`Passive mode`:

- client mở kết nối tới server.
- server mở cổng ngẫu nhiên `> 1023` và báo cho client.
- client kết nối tới cổng đó và truyền dữ liệu.  
  -> hiện nay hầu hết dùng _Passive mode_

#

_`Java không có FTP built-in API`_, dùng framework ngoài.

- `Apache Commons Net API`
- `Spring Intergration FTP Module`
- ...

# upload/download file workflow ( `Apache Commons Net API`)

`Upload File`:

- kết nối và login tới server
- thiết lập `kết nối` kiểu _`local passive`_
- thiết lập `truyền dữ liệu` kiểu _`nhị phân`_
- tạo InputStream cho file local.
- xây dường dẫn từ xa cho server.
- gọi phương thức `storeXXX()` để truyền, có 2 cách:
  - dựa trên InputStream
  - dựa trên OutputStream
- đóng luồng
- gọi `completePendingCommand()` để hoàn thành công việc.
- thoát và đóng kết nối.

#

`Download file`

- Kết nối và login tới server.
- Thiết lập kết nối kiểu local passive.
- Thiết lập kiểu dữ liệu truyền là nhị phân.
- Thiết lập đường dẫn file từ xa
- Tạo OutputStream để ghi file local.
- Nhận file
  - `retrieveFile()`
  - `retrieveFileStream()`
- Đóng luồng.
- Thoát và đóng kết nối.
