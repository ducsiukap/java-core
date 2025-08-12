public class JAVA008_Array {
    public static void main(String[] args) {
        System.out.println("\n--------------------");
        // declare an array:
        // type[] arrName = new type[size]{elements}

        int[] b = new int[] { 1, 2, 3 }; // or
        int a[] = new int[3]; // => {0, 0, 0}

        // access element via index: arrName[index]
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;

        // get length of array: arrName.length

        // array is an object (inherit from java.lang.Object)
        // toString(), equals(), hashCode()...
        System.out.println(a.equals(b)); // a and b is not reference to same object
        int c[] = b;
        System.out.println(c.equals(b)); // b & c reference to the same object

        // passing arr to method
        System.out.println("\n--------------------");
        printArr(a);

        // return array from method
        int arr[] = initArr(10);
        printArr(arr);

        // multi-diementsion array
        System.out.println("\n--------------------");
        int mdArr[][] = new int[3][3];
        for (int i = 0; i < mdArr.length; ++i) {
            for (int j = 0; j < mdArr[i].length; ++j) {
                arr[i] = (i + 1) * (j + 1);
            }
        }
        // or
        int[][] mdArr2 = new int[3][];
        for (int i = 0; i < mdArr2.length; ++i) {
            // mdArr2[i] = new int[size]
            // jagged arr: each row must not has the same size
            mdArr2[i] = initArr(5);
        }
        System.out.println("mdArr1: ");
        for (int i = 0; i < mdArr.length; ++i)
            printArr(mdArr[i]);
        System.out.println("mdArr2: ");
        for (int i = 0; i < mdArr2.length; ++i)
            printArr(mdArr2[i]);
        // => n-D arr: int[][][]...[] arrName

        System.out.println("\n--------------------");
        // final array:
        final int myArr[] = { 1, 2, 3, 4, 5 };
        printArr(myArr);
        // can not reassigned to other array
        // myArr = {1, 1, 1}; // error
        // but, can change element inside it
        myArr[0] = 10; // ok
        printArr(myArr);

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

    // passing array to method
    static void printArr(int[] arr) {
        System.out.print("passed array: ");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        // arr = new int[] { 1, 2, 3, 4, 5 }; // only change on this function
        // when return to main(), is will not be reflected

        // but, this line:
        // arr[0] = 1000;
        // will change arr when return to the main() => {1000, 1, 2}
        System.out.println();
    }

    // return array from method
    static int[] initArr(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = i + 1;
        return arr;
    }
}
