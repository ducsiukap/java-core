
// for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// for Scanner class
import java.util.Scanner;

public class JAVA004_Standard_InOut {

    // BufferedReader throws IOExceptionZ
    public static void main(String[] args) throws IOException {
        // Standard output
        System.out.println("\n--------------------");
        System.out.println("Standard Output");
        // System.out.println(message) => print message into console
        System.out.print("hello - with print() ");
        System.out.print("hello - with print() ");
        System.out.print("hello - with print() ");
        // System.out.println(message) => print(message + "\n")
        System.out.println("hello - with println()");
        System.out.println("hello - with println()");
        System.out.println("hello - with println()");

        // Standard Input
        // with BuerredReader class
        System.out.println("\n--------------------");
        System.out.println("Standard Input with BufferedReader class");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // take a line of string
        System.out.print("Enter a string: ");
        String inputStr = br.readLine();
        // take an integer
        System.out.print("Enter a integer number: ");
        Integer inputInt = Integer.parseInt(br.readLine());
        System.out.println("Your String: " + inputStr);
        System.out.println("Your number: " + inputInt);

        // with Scanner class
        System.out.println("\n--------------------");
        System.out.println("Standard Input with Scanner class");
        Scanner sc = new Scanner(System.in);
        // sc.next() -> take a word
        // sc.nextLine() -> take a line of string
        // sc.nextType() -> take & cast input into value of Type:
        // Type canbe Int, Byte, Short, Long, Boolean, Float, Double, BigInteger,
        // BigDecimal
        System.out.print("Enter your age: ");
        Integer age = sc.nextInt();
        // use sc.nextLine() or br.readLine() to remove '\n' from buffer
        // if exist sc.nextType() or sc.next() before
        // ex: String name = sc.nextLine(); // can't type and return null string
        // because sc.nextInt() above did not read the '\n'
        sc.nextLine(); // remove '\n'
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Your name: " + name);
        System.out.println("Your age: " + age);

        sc.close();
        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
