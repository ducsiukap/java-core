public class JAVA006_Loops {
    public static void main(String[] args) {
        // for loop
        System.out.println("\n--------------------");
        System.out.print(">>> count from 0 to 100 with for() loop: ");
        // for(initialization, condition, inc/dec)
        for (int i = 0; i <= 100; ++i)
            System.out.print(i + " ");
        System.out.println();
        // or
        System.out.print(">>> count from 0 to 100 with for() loop: ");
        for (int i = 0, j = 1; i < 100; i += 2, j += 2)
            System.out.print(i + " " + j + " ");
        System.out.println();

        // for each: for (datatype var : arrOrCollection)
        System.out.println("\n--------------------");
        System.out.println(">>> Hello User with for-each:");
        String[] users = { "vduczz", "nddat", "bob", "alice" };
        for (String user : users)
            System.out.println(">>> Hello " + user);

        // while loop:
        System.out.println("\n--------------------");
        System.out.println(">>> count from 0 to 100 with while() loop: ");
        int num = 0;
        while (num <= 100) {
            System.out.print(num + " ");
            ++num;
        }
        System.out.println();

        // do-while loop:
        System.out.println("\n--------------------");
        System.out.println(">>> count from 0 to 100 with do-while loop: ");
        num = 0;
        do {
            System.out.print(num + " ");
            ++num;
        } while (num <= 100);
        System.out.println();

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
