import java.util.Scanner;

public class JAVA001_HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Your name: ");
        String name = sc.nextLine();

        System.out.println("--------------------");
        System.out.println("Hi, " + name + "!");

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
        sc.close();
    }
}