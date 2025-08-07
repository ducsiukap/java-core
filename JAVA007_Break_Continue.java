import java.util.Scanner;

public class JAVA007_Break_Continue {
    public static void main(String[] args) {
        // break: exit current loop
        System.out.println("\n--------------------");
        System.out.println(">>> Break the current loop with: break");
        for (int i = 0; i < 5; ++i) {
            System.out.print(">>> Outer loop #" + i + ": ");
            int j = 0;
            while (true) {
                System.out.print("Inner#" + j + " ");
                if (j >= i) {
                    System.out.print("--- break inner loop, return to outer ---");
                    break; // break while loop, back to for loop
                }
                ++j;
            }
            System.out.println();
        }

        System.out.println("\n--------------------");
        System.out.println("labeled loop");
        // labeled break
        // step 1 - mark the label: label: for()/while()/do-while()
        // step 2 - break the labeled loop: break label;
        Scanner sc = new Scanner(System.in);
        outer: while (true) {
            System.out.println(">>> Outer");
            while (true) {
                System.out.println("<<< select loop to break:\n[o] : outer\n[i] : inner");
                String userChoice = sc.nextLine();
                if (userChoice.equals("o")) {
                    System.out.println(">>> EXIT OUTER LOOP!");
                    break outer;
                } else if (userChoice.equals("i")) {
                    System.out.println(">>> exit inner loop!");
                    break;
                } else {
                    System.out.println(">>> your choice is invalid, please try again!");
                }
            }
        }
        sc.close();

        // continue: skip current step in current loop
        System.out.println("\n--------------------");
        System.out.println(">>> Skip current step in loop with: continue");
        System.out.print(">>> Print odd number in range [1, 100] with continue: ");
        for (int i = 1; i <= 100; ++i) {
            if ((i & 1) != 1)
                continue; // skip print(i)
            System.out.print(i + " ");
        }
        System.out.println();

        // labeled continue:
        // label: loop(){}
        // continue label;

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
