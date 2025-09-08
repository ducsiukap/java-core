package java022_io_stream.bytestream;

import java.io.PrintStream;

public class PrintStreamClass {
    public static void main(String[] args) {
        // PrintStream extend FilteredOutputStream

        PrintStream console = new PrintStream(System.out);
        // ngoài write(), flush(), close()
        // còn có các method nạp chồng:
        // - print(value) // value canbe a value of one of types:
        // + boolean, char, int, long, float, double,
        // + char[],
        // + String,
        // + Object
        // - println(value) = print(value + "\n")
        // - println() = print("\n")
        console.print(13); // print(int x)
        console.println(); // print("\n")

        // print string
        console.println("Hello wrold!");

        // print char[]
        char[] buf = "PrintStream".toCharArray();
        console.println(buf);

        // close stream
        console.close();
    }
}
