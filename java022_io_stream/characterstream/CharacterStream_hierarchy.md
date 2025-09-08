## **`ByteStream Hierarchy`**

```
java.io (base)
    |
    |
    |___ Reader (Character Stream, abstract)
    |       |___ BufferedReader
    |       |       |___ LineNumberReader
    |       |___ FilterReader
    |       |       |___ PushbackReader
    |       |___ StringReader
    |       |___ CharArrayReader
    |       |___ PipedReader
    |       |___ InputStreamReader
    |               |___ FileReader
    |
    |___ Writer (Character Stream, abstract)
            |___ BufferedWriter
            |___ StringWriter
            |___ FilterWriter
            |___ CharArrayWriter
            |___ PipedWriter
            |___ PrintWriter
            |___ OutputStreamWriter
                    |___ FileWriter
```

## _`Note`_

`InputStreamReader` và `OutputStreamWrite` là 2 lớp quan trọng nhất của `Reader` và `Writer`, là cầu nối giữa `ByteStream` và `CharacterStream`.  
Chỉ có `CharArrayReader/Writer`, `StringReader/Writer` là dùng `Suorce` trực tiếp, còn lại đều `wrap an instance of Reader/Writer`, ví dụ:

- `FileReader/Writer` -> wrap `FileInput/OutputStream`.
- `InputStreamReader`/`OutputStreamWriter` -> wrap `InputStream`/`OutputStream`.
- Tương tự cho `PipedReader/Writer` (dùng cho `Thread`), `PushbackReader/Writer`.

`BufferedReader/Writer` wrap bất kỳ `instance` nào của `Reader/Writer`

## _`Common methods`_

- `Reader`:

  ```java
  int read(); // read a char, return -1 if eof
  int read(char[] buffer) // rean an array of char into buffer
                          // return a number of byte read
                          // or -1 if eofbytes, return number of byte that be read
  int read(char[] b, int off, int len) // read maximum `len` of char into buffer, stored from `off` index.

  boolean ready(); // check the buffer is ready to read
                   // đang chờ fetch (network),  -> chờ dữ liệu được gửi thêm (nhập thêm, fetch về, ... )
                   // còn ký tự để đọc không (file)
  long skip(long n) // skip n char

  // mark, reset (not all InputStream class have mark, limit)
  boolean markSupported() // check xem Stream hiện tại có support mark, reset ?
  void mark(int readlimit) // đánh dấu vị trí hiện tại
                           // `readlimit` : giới hạn an toàn từ vị trí hiện tại
                           // từ vị trí hiện tại + readlimit có thể reset về lại mark
                           // đọc qua current + readlimit -> không thể reset
  void reset() // back con trỏ lại vị trí đã mark nếu vị trí hiện tại còn trong marklimit

  // BufferedReader
  String readLine() // read a line
  ```

- `OutputStream`:

  ```java
    // write to stream
    void write(int c) // char unicode
    void write(char[] cbuf)
    void write(char[] cbuf, int off, int len)
    // write string
    void write(String str)
    void write(String str, int off, int len)
    // append
    void append(CharSequence sq) // append at the end

    // BufferedWriter
    void flush() // đẩy toàn bộ dữ liệu đang có buffer (nếu có)
                 // tới đích/ thiết bị thực sự
                 // quan trọng khi làm việc với BufferedOutputStream, PrintStream
    // note: buffer thường đợi đầy buffer/hoặc close mới đẩy data đi
    // flush() ép buffer đẩy đi kể cả khi chưa đầy
    void newLine() // '\n' or '\n\r'

    //PrintWriter
    print(Object x) // boolean, int, long, float, double, String, Object, char, char[]
    println(Object x)
    printf(String format, Object... args)


  ```

- `void close()` : close the Stream.
