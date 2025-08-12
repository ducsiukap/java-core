import java.util.StringTokenizer;

public class JAVA011_String_InterfacesAndClasses {
    public static void main(String[] args) {
        String str = "vduczz";

        System.out.println("\n--------------------");
        System.out.println("StringBuffer: ");
        // StringBuffer Class: Sequence of Character that can be modified
        // all methods are synchronized => safe to use in multithreaded environments.
        // slower than StringBuilder

        // create StringBuffer object
        // StringBuffer bf = new StringBuffer(); // khởi tạo StringBuffer có dung lương
        // (capacity) mặc định với 16 ký tụ trước khi cần cấp phát bộ nhớ

        // StringBuffer bf = new StringBuffer(size) // khởi tạo kèm capacity

        StringBuffer bf = new StringBuffer("Hello "); // tạo buffer có nội dung ban
        // đầu là "Hello ", capacity = "Hello ".length + 16

        // StringBuffer's methods:
        System.out.println("bf.append(str) => " + bf.append(str)); // .append(string)
        System.out.println("bf.insert(1, str) => " + bf.insert(1, str)); // .insert(index, string)
        System.out.println("bf.replace(1, 7, \"\") => " + bf.replace(1, 7, "")); // .replace(fromIndex, toIndex, string)
        // .delete(fromIndex, toIndex)
        System.out.println("bf.reverse() => " + bf.reverse());
        // .capacity() => current capacity of StringBuffer
        // .length() => current size of content
        // .charAt(), .setCharAt(index, char)
        // .deleteCharAt()
        // .codePointAt(), codePointBefore()
        // .indexOf(), .lastIndexOf()
        // subSequence(), substring(), .toString()

        System.out.println("\n--------------------");
        System.out.println("StringBuilder");
        // Điểm khác biệt duy nhất của StringBuilder là các method của nó
        // không synchronized, => sử dụng cho các chương trình đơn luồng
        // còn lại: API (methods), cơ chế capacity là giống nhau
        // nhanh hơn StringBuffer

        // create:
        // StringBuilder sb = new StringBuilder();
        // or: StringBuilder sb = new StringBuilder(capacity);
        // or: StringBuilder sb = new StringBuilder(initString)

        System.out.println("\n--------------------");
        System.out.println("StringTokenizer: "); // là class cũ, nên dùng .split(regex) thay thế

        // create
        StringTokenizer st = new StringTokenizer("Java is fun", " ");
        // StringTokenizer(str, delimiter, returnDelims(boolean))
        System.out.println("number of tokens: " + st.countTokens()); // .countTokens()
        while (st.hasMoreTokens()) { // hasMoreTokens() -> boolean
            System.out.println(st.nextToken()); // Lấy token tiếp theo
        }

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}