package java020_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Cursors in Java:
// - Iterator
// - Enumeration (Phiên bản cũ hơn của iterator)
// - ListIterator (Mở rộng Iterator, cho phép tiến/lùi/chỉnh sửa phần tử)

public class iterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; ++i)
            list.add((int) (Math.random() * 100 + 1));
        System.out.println("List: " + list);
        System.out.println("\n--------------------");

        // create iterator
        Iterator<Integer> it = list.iterator();

        // method:
        while (it.hasNext()) {
            // .hasNext() : Boolean
            // -> true nếu còn phần tử sau phần tử hiện tại
            // -> false nếu đã duyệt hết

            System.out.println(">>> item: " + it.next());
            // .next()
            // -> trỏ tới và trả về phần tử tiếp theo / NoSuchElementException

            it.remove();
            // remove() -> xóa phần tử tiếp hiện tại đang trỏ tới
            // - remove() phải được gọi sau khi gọi next()
            // - sau mỗi lần gọi next(), chỉ được gọi 1 lần remove()
            // it.remove(); // error
        }

        // *note: Iterator và List trỏ tới cùng địa chỉ
        // -> mọi thay đổi đều sẽ áp dụng lên original list

        System.out.println("List: " + list);

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
