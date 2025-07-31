public class JAVA003_Operators {
    public static void main(String[] args) {
        byte a = 3; // 00000011
        byte b = 5; // 00000101
        byte c = -5; // = ~5 = 11111010
        boolean d = true;
        System.out.println("a =" + a + "\nb = " + b + "\nc = " + c + "\nd = " + d);

        // instanceof operator: type checking -> object instanceof class/interface
        System.out.println("\n--------------------");
        System.out.println("Instanceof Operator:");
        System.out.println("a instanceof Byte: " + (a instanceof Byte));
        System.out.println("b instanceof Byte: " + (b instanceof Byte));
        System.out.println("c instanceof Byte: " + (c instanceof Byte));
        System.out.println("d instanceof Boolean: " + (d instanceof Boolean));

        // Arithmetic Operators: +, -, *, /, %
        System.out.println("\n--------------------");
        System.out.println("Arithmetic Operators:");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        // unary operator: +, -, ++, --
        System.out.println("\n--------------------");
        System.out.println("Unary Operators:");
        // +a = 3, -a = -3
        System.out.println("a++ = " + (a++) + " // use value first, then increment a: a = " + a);
        System.out.println("++a = " + (++a) + " // increment first, the use value, a = " + a);
        // --a, a-- is the same as ++ but decrement value of a before/after calculate
        System.out.println("a-- = " + (a--) + " , --a = " + (--a)); // a-- = 5 (then, a = 4).So, --a = 3
        System.out.println("a++ + ++b + b++ + ++a = " + (a++ + ++b + b++ + ++a) + ", a = " + a + " , b = " + b);
        // 3 (then a=4) + 6 (then b = 6) + 6 (then b = 7) + 5 (then a = 5) = 20

        // Assignment Operators: =, +=, -=, *=, /=, %=
        System.out.println("\n--------------------");
        System.out.println("Assignment Operators:");
        System.out.println("a += b, a = " + (a += b));
        // x += y -> x = x + y
        // -=. *=, /=, %= are similar

        // Relational Operators: ==, !=, >, <, >=, <= (boolean)
        System.out.println("\n--------------------");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Relational Operators:");
        System.out.println("a == b: " + (a == b));

        // Logical Operators: &&(AND), ||(OR), !(NOT)
        System.out.println("\n--------------------");
        System.out.println("Logical Operators:");
        System.out.println("d && true: " + (d && true)); // true and true
        System.out.println("d || false: " + (d || false)); // true or false
        System.out.println("!d: " + (!d)); // not true

        // Bitwise Operators: &, |, ^, ~, <<, >>, >>>
        System.out.println("\n--------------------");
        System.out.println("Bitwise Operators:");
        // a = 12 (00001100), b = 7 (00000111), c = -5 (11111011)
        System.out.println("a & b = " + (a & b)); // 00000100 = 4
        System.out.println("a | b = " + (a | b)); // 00001111
        System.out.println("a ^ b = " + (a ^ b)); // 00001011
        System.out.println("~a = " + (~a)); // 11110011, ~a = -a - 1
        // các phép dịch sẽ chuyển sang số 32bit hoặc lớn hơn
        System.out.println("a << 1 = " + (a << 1)); // 00011000 (a*2)
        System.out.println("c >> 1 = " + (c >> 1)); // 11111101 (c/2) - không dịch bit dấu
        System.out.println("c >>> 1 = " + (c >>> 1)); // dịch cả bit dấu
        // 11111111 11111111 11111111 11111011 >>> 1
        // = 01111111 11111111 11111111 11111101 = 2147483645

        /*- Chuyển số âm sang bit (ví dụ -3):
            + bước 1: chuyển 3 sang bit: 00000011
            + bước 2: đảo bit: 11111100
            + bước 3: cộng thêm bit 1: 11111101
        
          - Chuyển bit sang số âm (ví dụ: 11111101):
            + đảo bit: 00000010
            + bước 2: cộng thêm bit 1: 00000011 (3)
            + bước 3: thêm dấu âm -> -3
        
          - phép ~a: ~a = -a - 1
          - phép dịch luôn chuyển về số 32bit hoặc cao hơn
         */
        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
