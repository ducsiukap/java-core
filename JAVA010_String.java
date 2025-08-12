import java.util.Arrays;

public class JAVA010_String {
    public static void main(String[] args) {
        // String - an array of character
        // immutable - element and size can not be changed
        // khi gán 1 literal mới cho String, literal cũ không bị hủy mà vẫn lưu trong
        // String pool. String mới cũng được tạo (và lưu trong String pool nếu chưa có)
        // và gán cho biến.

        // creating a string
        // use literal
        /*
         * when create a new String with String literal => check the String pool:
         * - if it's already exists => refer to it
         * - if no, create a new String object
         */
        String myName1 = "vduczz";
        String myName2 = "vduc" + "zz";
        // now, myName1 and myName2 is refer to the same object in String pool

        // create using String constructor => create in normal, non-pool
        String myName3 = new String("vduczz"); // not refer to similar memory with myName1
        String myName4 = new String("vduczz"); // not refer to similar memory with myName1 and myName3

        System.out.println("\n--------------------");
        // String comparing
        // a == b -> a and b refer to the same object (same literal in String pool)
        // a.equals(b) -> compare the content of a and b
        System.out.println((myName1 == myName2) + " - " + myName1.equals(myName2));
        System.out.println((myName1 == myName3) + " - " + myName1.equals(myName3));
        System.out.println((myName1 == myName4) + " - " + myName1.equals(myName4));
        System.out.println((myName3 == myName4) + " - " + myName3.equals(myName4));
        System.out.println(myName3.intern() == myName1); // .intern() lấy địa chỉ của String trong pool
        // compareTo -> int: >0, == 0, < 0
        String test = "test";
        System.out.println(myName1 + ".compareTo(" + test + ") is " + myName1.compareTo(test));

        System.out.println("\n--------------------");
        // some popular method
        System.out.println("\"" + test + "\".length() : " + test.length()); // get length of string with length()
        System.out.println("Character at index 2 of \"" + test + "\" is \'" + test.charAt(2) + "\'"); // access element
                                                                                                      // with
                                                                                                      // .charAt(index)
        // .codePointAt(index), .codePointBefore(index)
        // indexOf(character) -> get first index of character in String
        // contains(subString) -> boolean
        // .subString(fromIndex, toIndex) -> get subString
        // .concat(String) -> String
        System.out.println("concat " + myName1 + " and " + test + ": " + myName1.concat(test));
        System.out.println("myName1: " + myName1);
        System.out.println("test: " + test);
        // replace(), replaceAll(), replaceFirst()
        // toUpperCase(), toLowerCase()
        // split("regex")
        System.out.println(Arrays.deepToString(myName1.split("u"))); // [vd, czz]
        // String.join(delimiter, elements)
        System.out.println(String.join(" | ", myName1, test)); // vduczz | test
        // .startsWith(), endsWith() => boolean
        // .toCharArray()
        // .isEmpty()
        // String.format(format, arguments)

        // read more:
        // https://www.geeksforgeeks.org/java/java-lang-string-class-java-set-2/

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
