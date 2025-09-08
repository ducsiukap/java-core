package java022_io_stream.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStream {
    // file input/output stream -> read/write byte from file

    public static void main(String[] args) {
        // target
        String filename = "java022_io_stream/bytestream/hello.txt";
        // FileNotFoundException
        // IOException

        // FileOutputStream -> write byte to file
        System.out.println("\n--------------------");
        // throws exception
        // or
        // using try-catch to handle exception
        try (
                // override file
                FileOutputStream fout = new FileOutputStream(filename);

        // append at end of file
        // FileOutputStream fout1 = new FileOutputStream(filename, true);
        ) {
            // write a byte
            fout.write(65); // 'A'
            System.out.println("write to " + filename + ": " + ((char) 65));

            // message
            String[] messages = { "Hello!", "Xin chao!", "こんにちは!" };
            for (String message : messages) {
                // write new line
                // fout.write((byte) '\n');

                // write message
                byte[] buf = message.getBytes();
                fout.write(buf);
                System.out.println("write to " + filename + ": " + message);
            }

            // note: Nếu byte được ghi vào > 256 -> lấy 8 bit cuối của byte đó để write
        } catch (IOException e) {
            e.printStackTrace();
        }

        // FileInputStream -> read from file
        System.out.println("\n--------------------");
        try (FileInputStream fin = new FileInputStream(filename);) {

            // read a byte
            int b = fin.read();
            if (b == -1)
                System.out.println("------ EOF ------");
            else
                System.out.println("read from " + filename + " : " + ((char) b));

            // read an array of byte
            byte[] buf = new byte[1024];
            int off = 0;
            // them `len` neu muon gioi han so ky tu doc moi lan
            int len = Math.min(5, buf.length - off);
            int byteread = 0;
            do {
                byteread = fin.read(buf, off, len);
                // or 
                // byteread = fin.read(buf, off, buf.length - off); // doc den EOF hoac full buffer thi thoi 
                String message = new String(buf, off, off + byteread);
                if (byteread == -1)
                    System.out.println("------ EOF ------");
                else
                    System.out.println("read from " + filename + " : " + message);
                off += byteread; // cap nhat offset
                len = Math.min(5, buf.length - off); // cap nhat len
            } while (byteread != -1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}


