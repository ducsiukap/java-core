import java.util.Arrays; // to use Arrays

public class JAVA009_ArraysClass {
    public static void main(String[] args) {
        // init an array:
        int arr[] = new int[] { 25, 8, 12, 13, 40, 71 };

        // to use Arrays:
        // Arrays.functionName(arrayName<, args>)
        System.out.println("\n--------------------");
        // Array.sort(arr) -> sort the array
        System.out.println("arr before sort(): " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("arr after sort(): " + Arrays.toString(arr));
        // Array.parallelSort() -> chia mảng thành nhiều phần và sắp xếp song song
        // -> tận dụng tối đa CPU nhưng chỉ nhanh hơn sort() nếu mảng lớn
        // Arrays.sort(arr, fromIndex, toIndex, Comparator)
        // Arryas.sort(arr, Comparator)
        // comparator -> overrite public int compare(a, b)

        System.out.println("\n--------------------");
        // Arrays.binarySearch(arr, fromIndex, toIndex, key, Comparator)
        // Arrays.binarySearch(arr, key)
        System.out.println("Search \"13\" on " + Arrays.toString(arr) +
                ", position: " + Arrays.binarySearch(arr, 13));

        System.out.println("\n--------------------");
        // Arrays.copyOf(arr, newLength)
        // if newLength > original range -> add 0 to the end
        System.out.println(Arrays.toString(Arrays.copyOf(arr, 10)));
        // Arrays.copyOfRange(arr, fromIndex, endIndex)

        System.out.println("\n--------------------");
        // compare 2 arrays:
        // Arrays.compare(arr1, arr2) -> int (>0 if arr1 > arr2, =0 if arr1 == arr2, <0
        // if arr1 < arr2)
        int[] arr2 = { 1, 2, 3, 4, 5 };
        System.out.println("Arrays.compare(" + Arrays.toString(arr) +
                ", " + Arrays.toString(arr2) + ") => " + Arrays.compare(arr, arr2));
        // Arrays.mismatch(arr1, arr2)
        // -> position of first not matched element in arr1 and arr2
        System.out.println("position of first not match element between " +
                Arrays.toString(arr) + " and " + Arrays.toString(arr2) + " is " + Arrays.mismatch(arr, arr2));
        // Arrays.equals(arr1, arr2) => boolean
        // primitive datatype: int[], ... -> compare each element in the array
        // object -> refer to the same object
        int[][] mdArr1 = { { 1, 2 }, { 3, 4 } };
        int[][] mdArr2 = { { 1, 2 }, { 3, 4 } };
        int[][] mdArr3 = Arrays.copyOf(mdArr1, mdArr1.length);
        int mdArr4[][] = mdArr1;
        System.out.println(Arrays.equals(mdArr1, mdArr2)); // false
        System.out.println(Arrays.equals(mdArr1, mdArr3));
        System.out.println(Arrays.equals(mdArr1, mdArr4));
        // Arrays.deepEquals(arr1, arr2)
        // -> compare the content, not care about reference address
        System.out.println(Arrays.deepEquals(mdArr1, mdArr2)); // true

        // to print the array:
        System.out.println("\n--------------------");
        System.out.println("Arrays.toString(arr): " + Arrays.toString(arr));
        System.out.println("Arrays.toString(mdArr1): " + Arrays.toString(mdArr1));
        System.out.println("Arrays.deepToString(mdArr1): " + Arrays.deepToString(mdArr1));

        System.out.println("\n--------------------");
        // Arrays.fill(arr, fillValue) -> fill an entire array or a subrange of an array
        // with a specific value.
        System.out.println("arr before fill(): " + Arrays.toString(arr));
        Arrays.fill(arr, 5); // fill
        System.out.println("arr after fill(): " + Arrays.toString(arr));

        // read more:
        // Arrays.asList() => return a list from array
        // Arrays.spliterator()
        // Arrays.stream()
        // about prefix, setAll
        // ...

        // references: https://www.geeksforgeeks.org/java/array-class-in-java/

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
