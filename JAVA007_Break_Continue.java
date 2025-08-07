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

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
