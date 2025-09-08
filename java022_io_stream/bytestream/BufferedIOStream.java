package java022_io_stream.bytestream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOStream {
    public static void main(String[] args) {
        // BufferedInput/OutputStream là subclass của FilteredInput/OutputStream
        // -> bọc một instance khác của Input/OutputStream
        // Bổ sung đệm cho Input/OutputStream -> đọc ghi nhanh hơn
        // giống cache trước khi ghi vào mem

        try (
                // BufferedInputStream
                BufferedInputStream keypad = new BufferedInputStream(System.in);
                // có thể bọc FileInputSteam...
                BufferedInputStream fin = new BufferedInputStream(
                        new FileInputStream("java022_io_stream/bytestream/hello.txt"));
                // hoặc các instance khác của InputStream

                // BufferedOutputStream
                BufferedOutputStream console = new BufferedOutputStream(System.out); // System.out is a instace of
                                                                                     // PrintStream
                BufferedOutputStream fout = new BufferedOutputStream(
                        new FileOutputStream("java022_io_stream/bytestream/hello.txt"));) {
            // read a byte
            int b = keypad.read();

            System.out.println("==== [sout] byte read: ====");
            // print into console
            console.write((byte) b);
            console.write(((byte) '\n')); // endl
            // write to file
            fout.write((byte) b);

            // flush() để chắc chắn đẩy dữ liệu đi
            console.flush();

            // read a string
            keypad.skip(keypad.available()); // để loại bỏ phần còn lại mới đọc tiếp được
                                             // nếu không sẽ lấy phần còn lại trong buff
            // read
            byte[] buf = new byte[1024];
            int byteread = keypad.read(buf);

            // write
            System.out.println("==== [sout] byte read: ====");
            console.write(buf, 0, byteread);
            fout.write(buf, 0, byteread);
            console.flush();

            // read multiple string ?
            // Ctrl + D to stop read
            while ((byteread = keypad.read(buf)) != -1) {
                System.out.println("==== [sout] byte read: ====");
                console.write(buf, 0, byteread);
                fout.write(buf, 0, byteread);
                // flush()
                console.flush();
            }
            // flush() to file
            fout.flush();

            // read from file
            byte[] filecontent = new byte[1024];
            byteread = fin.read(filecontent);
            System.out.println(fin.available());
            System.out.println("==== [sout] filecontent: ====");
            System.out.println(new String(filecontent, 0, byteread));

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}