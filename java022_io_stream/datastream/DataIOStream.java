package java022_io_stream.datastream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DataIOStream {
    public static void main(String[] args) {
        // DataStream - luồng dữ liệu có định dạng / luồng dữ liệu nguyên thửy

        // DataStream extends ByteStream:
        // DataInputStream extends FilteredInputStream
        // DataOutputStream extends FilteredOutputStream

        // bọc 1 instance của ByteStream
        // có các methods của ByteStream

        // ngoài ra còn bổ sung các method
        // public final void writeBoolean(boolean b) throws IOException
        // public final void writeByte(int b) throws IOException
        // public final void writeShort(int s) throws IOException
        // public final void writeChar(int c) throws IOException
        // public final void writeInt(int i) throws IOException
        // public final void writeLong(long l) throws IOException
        // public final void writeFloat(float f) throws IOException
        // public final void writeDouble(double d) throws IOException
        // public final void writeChars(String s) throws IOException
        // public final void writeBytes(String s) throws IOException
        // public final void writeUTF(String s) throws IOException

        // tương tự với read
        // boolean readBoolean() → 1 byte
        // byte readByte() → 1 byte
        // short readShort() → 2 byte (big-endian)
        // char readChar() → 2 byte Unicode
        // int readInt() → 4 byte
        // long readLong() → 8 byte
        // float readFloat() → 4 byte
        // double readDouble() → 8 byte
        // void readFully(byte[] b) → đọc đầy đủ mảng byte
        // void readFully(byte[] b, int off, int len) → đọc đầy đủ đoạn mảng
        // String readUTF() → đọc chuỗi UTF-8 với length prefix 2 byte

        try (
                DataInputStream din = new DataInputStream(System.in);
                DataOutputStream dout = new DataOutputStream(System.out);
        //
        ) {
            // read an integer
            dout.writeChars("Enter an integer: ");
            int readint = din.readInt(); // mẹ nó đọc cả \n\r để làm chuỗi :) bố lễ mày
                                         // ví dụ đọc nhập 30 + enter -> // "30\n\r" -> nhị phân -> int :)
            //
            System.out.println(readint);
            dout.writeInt(readint); // thằng readint được chuyển thành char[]/string nên có dạng "30\n\r" :)

            // tôt nhất nên đọc từ file nhị phân/ hoặc gì đó ~ (dữ liệu nhị phân)
            // Đọc/ghi dữ liệu nhị phân theo kiểu Java
            // Giao tiếp Java-Java (client, server, ..)
            // Đọc/Ghi file nhị phân

            // chỉ nên dùng DataOutputStream để phản hồi lại DataInputStream
            dout.writeUTF("\n--------------------\n");
            // read int
            dout.writeUTF("Enter an integer number: ");
            int x = din.readInt();
            dout.writeChars("Your integer: ");
            dout.writeInt(x);
            // read float
            dout.writeUTF("Enter a float number: ");
            float y = din.readFloat(); // float thì đéo thế :)
            dout.writeBytes("Your float: ");
            dout.writeFloat(y);
            // string
            // đéo nên dùng readUTF :)
            // nói chung là ảo ma
            // DataInputStream chỉ nên đọc dữ liệu được truyền từ DataOutputStream thôi
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
