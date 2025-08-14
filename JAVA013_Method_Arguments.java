import java.util.Arrays;

public class JAVA013_Method_Arguments {
    // read more aboud "command-line args":
    // https://www.geeksforgeeks.org/java/command-line-arguments-in-java/

    // Variable arguments (varagrs): take any number of inputs
    // syntax: dataType... varName
    // example:
    static void helloUser(String... users) {
        // now, users is automatically processed as String[]
        for (String user : users) {
            System.out.printf("Hello %s!\n", user);
        }
        System.out.println("users: " + Arrays.toString(users));
    }

    // note:
    // - one method can have only one varargs
    // - varargs must be placed at the end of function's args

    // ex:
    // void error01(int... varargs, int b, String c)
    // void error02(int... varargs1, int... varargs2)
    // void accepted(int a, int... varargs)
    public static void main(String[] args) {

        // passing args as an array
        System.out.println("\n--------------------");
        String users[] = { "vduczz", "user01", "user02" };
        helloUser(users);

        // list each user
        System.out.println("\n--------------------");
        helloUser("vduczz", "test01", "test02", "test03", "test04");

        System.out.println("\n--------------------");
        helloUser("vduczz");

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
