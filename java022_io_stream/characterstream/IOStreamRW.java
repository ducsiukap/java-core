package java022_io_stream.characterstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class IOStreamRW {
    public static void main(String[] args) {
        // InputStreamReader, OutputStreamWriter là một trong những lớp quan trọng nhất
        // của CharacterStream
        // Cầu nối giữa ByteStream và CharacterStream
        // FileReader == InputStreamReader(FileInputStream)

        // InputStreamReader constructor
        // InputStreamReader(InputStream in)
        // InputStreamReader(InputStream in, String charsetName)
        // InputStreamReader(InputStream in, Charset cs)
        // InputStreamReader(InputStream in, CharsetDecoder dec)

        // OutputStreamWriter constructor
        // InputStreamReader(InputStream in)
        // InputStreamReader(InputStream in, String charsetName)
        // InputStreamReader(InputStream in, Charset cs)
        // InputStreamReader(InputStream in, CharsetDecoder dec)

        // public String getEncoding() -> trả về định dạng mã hóa

        // throws UnsupportedEncodingException

        // Buffered: bổ sung bộ đẹm giúp cho read/write nhanh hơn

        String filename = "java022_io_stream/characterstream/hello.txt";

        try (

                // OutputStreamReader
                BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename))); // throw
                                                                                                                        // FileNotFoundException
                BufferedWriter consoleWriter = new BufferedWriter(new OutputStreamWriter(System.out));

                // InputStreamReader
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename))); // throw
                                                                                                                      // FileNotFoundException
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in)); // vào chuẩn

        // throw UnsupportedEncodingException
        ) {
            // read a character
            int c = consoleReader.read();
            // write a character
            consoleWriter.write("read char: " + c); // write to console
            consoleWriter.newLine();// BufferedReader method
            // flush()
            consoleWriter.flush();
            fileWriter.write(c); // write to file
            fileWriter.newLine(); // BufferedReader method

            // read an array of char[]
            char cbuf[] = new char[1024];
            int readAmount = 0;

            consoleReader.read(cbuf); // loại bỏ phần còn lại từ lần nhập trước
            while ((readAmount = consoleReader.read(cbuf, 0, cbuf.length)) != -1) {
                // write to console
                consoleWriter.write("read char[]: ");
                consoleWriter.write(cbuf, 0, readAmount);

                // flush()
                consoleWriter.flush();
                // write to file
                fileWriter.write(cbuf, 0, readAmount);
            }

            // consoleReader.readLine(); // loai bỏ phần còn lại trong buffer với
            // BufferedReader
            // read a line (String)
            // BufferedReader method
            String line = consoleReader.readLine();
            consoleWriter.write("read a line: " + line);

            fileWriter.write(line);
            fileWriter.flush();

            // read from file
            consoleWriter.newLine();
            consoleWriter.write("\n--------------------");
            consoleWriter.newLine();
            consoleWriter.write("filecontent: ");
            consoleWriter.newLine();

            while ((readAmount = fileReader.read(cbuf, 0, cbuf.length)) != -1) {
                consoleWriter.write(cbuf, 0, readAmount);
                consoleWriter.newLine();
            }
            consoleWriter.flush();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
