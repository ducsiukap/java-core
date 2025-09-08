package java022_io_stream.characterstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRW {
    public static void main(String[] args) {
        // FileReader == InputStreamReader(FileInputStream)
        // FileWriter == OutputStreamWriter(FileOutputStream)

        // example: Copy file
        String originalFile = "java022_io_stream/characterstream/hello.txt";
        String copyFile = "java022_io_stream/characterstream/hello_copy.txt";
        try (
                FileReader fin = new FileReader(originalFile);
                FileWriter fout = new FileWriter(copyFile);

        //
        ) {
            char cbuf[] = new char[1024];
            int read = 0;
            while ((read = fin.read(cbuf, 0, cbuf.length)) != -1) {
                // copy
                fout.write(cbuf, 0, read);

                // log
                System.out.println(
                        "Copy \"" + (new String(cbuf, 0, read)) + "\" from hello.txt to hello_copy.txt successfully!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
