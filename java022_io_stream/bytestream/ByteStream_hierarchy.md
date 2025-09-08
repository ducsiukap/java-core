## **`ByteStream Hierarchy`**

```
java.io (base)
    |
    |___ InputStream (Byte Stream, abstract)
    |       |___ FileInputStream
    |       |___ FilterInputStream
    |       |       |__ BufferedInputStream
    |       |       |__ DataInputStream
    |       |       |__ PushbackInputStream
    |       |___ ObjectInputStream
    |       |___ ByteArrayInputStream
    |       |___ PipedInputStream
    |
    |___ OutputStream (Byte Stream, abstract)
    |       |___ FileOutputStream
    |       |___ FilterOutputStream
    |       |       |__ BufferedOutputStream
    |       |       |__ DataOutputStream
    |       |       |__ PrintStream
    |       |___ ObjectOutputStream
    |       |___ ByteArrayOutputStream
    |       |___ PipedOutputStream
```

## _`Note`_

Các `instance` của `InputStream`/`OutputStream` có thể chia thành 2 nhánh:

- `Suorce`/`Sink`: các `Class` được nối trực tiếp với nguồn dữ liệu thật của riêng nó.
  Ví dụ:
  - `FileInputStream`/`FileOutputStream` -> đọc/ghi `File`.
  - `ByteArray` -> đọc/ghi từ `mảng byte[]`
  - ...
- `Filter`/`Decorator`: các lớp bọc một `InputStream`/`OutputStream` khác để thêm tính năng, gồm:
  - `FilteredInputStream` và subclass (`BufferedInputStream`, `DataInputStream`, `PushbackInputStream`, ...) của nó bọc các lớp `InputStream` khác.
  - `FilteredOutputStream` và subclass (`BufferedOutputStream`, `DataOutputStream`, `PrintStream`, ...) của nó bọc các lớp `OutputStream` khác.

## _`Common methods`_

- `InputStream`:

  ```java
  int read(); // read a byte, return -1 if eof
  int read(byte[] buffer) // rean an array of byte into buffer
                          // return a number of byte read
                          // or -1 if eofbytes, return number of byte that be read
  int read(byte[] b, int off, int len) // read maximum `len` of byte into buffer, stored from `off` index.
  int available() // return the number of byte that can be read immediately

  // mark, reset (not all InputStream class have mark, limit)
  boolean markSupported() // check xem Stream hiện tại có support mark, reset ?
  long skip(long n) // skip n byte
  void mark(int readlimit) // đánh dấu vị trí hiện tại
                           // `readlimit` : giới hạn an toàn từ vị trí hiện tại
                           // từ vị trí hiện tại + readlimit có thể reset về lại mark
                           // đọc qua current + readlimit -> không thể reset
  void reset() // back con trỏ lại vị trí đã mark nếu vị trí hiện tại còn trong marklimit
  ```

- `OutputStream`:
  ``` java
    // write to stream
    void write(byte b)
    void write(byte[] b)
    void write(byte[] b, int off, int len)

    void flush() // đẩy toàn bộ dữ liệu đang có buffer (nếu có)
                 // tới đích/ thiết bị thực sự
                 // quan trọng khi làm việc với BufferedOutputStream, PrintStream
    // note: buffer thường đợi đầy buffer/hoặc close mới đẩy data đi 
    // flush() ép buffer đẩy đi kể cả khi chưa đầy
  ```

- `void close()` : close the Stream.
