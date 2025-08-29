package java020_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// A collection in Java is a group of individual objects that are treated as a single unit
//  => have some common methods

// two main root interfaces of Java collection
// - java.util.Collection 
// - java.util.Map

/* Collection  Framework
 * 
 * Iterable (I)
 *      |
 *      |___ Collection (I)
 *              |
 *              |---- List 
 *              |       |--- ArrayList (C)
 *              |       |--- Vector (C)
 *              |       |--- Stack (C)
 *              |       |--- LinkedList (C)
 *              |
 *              |---- Queue (I) 
 *              |       |---- PriorityQueue (C)
 *              |       |---- Dequeue (I)
 *              |                 |
 *              |                 |--- ArrayDeque (C)
 *              |
 *              |---- Set (I)
 *                      |--- HashSet (C)
 *                      |--- EnumSet (C)
 *                      |--- LinkedHashSet (C)
 *                      |--- SortedSet (I)
 *                              |--- TreeSet (C)
 *******:
 - I - Interface
 - C - Class              
 */

/* Map Interface
 * 
 * Map (I)
    |--- SortedMap (I)
    |        |--- TreeMap (C)
    |
    |--- HashMap (C)
           |--- LinkedHashMap (C)
 */

public class collections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        System.out.println("\n--------------------");
        // common method of Collection Interface

        // add(Object)
        list.add(1);
        list.add(2);
        System.out.println(list);
        // addAll(Collection)
        list.addAll(list);
        System.out.println(list);
        System.out.println();

        // clear() -> remove all item

        // contains(Object): Boolean
        System.out.println(list.contains((int) (Math.random() * 10 + 1)));
        // containsAll(Collection)
        System.out.println();

        // equals()
        ArrayList<Integer> al = new ArrayList<>(list);
        al.add(100);
        System.out.println(list.equals(al)); // [1, 2, 1, 2] vs [1, 2, 1, 2, 100]
        System.out.println();

        // hashCode()

        // isEmpty() : Boolean

        // iterator() -> return iterator over the elems in this collection
        Iterator<Integer> it = list.iterator();
        System.out.println(it.next());
        System.out.println();

        // parallelStream()

        // remove(index)
        // remove(Object)
        // removeIf(Predicate p)
        list.removeIf((item) -> (item & 1) == 1);
        System.out.println(list);
        System.out.println();

        // retainAll(Collection o)
        for (int i = 1; i <= 10; ++i)
            list.add((int) (Math.random() * 20 + 1));
        List<Integer> o = new ArrayList<>();
        for (int i = 1; i < 10; ++i)
            o.add(i);
        System.out.println(list + " " + o);
        list.retainAll(o);// intersection
        System.out.println(list);
        System.out.println();

        // size()
        System.out.println(list.size() + "\n");

        // spliterator()
        // stream() -> readmore
        // toArray()

        System.out.println("\n--------------------");
        // Collections Class (Collections-> class , Collection -> interface)
        // Collections -> utility class, static class
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            l1.add((int) (Math.random() * 20 + 1));
            l2.add((int) (Math.random() * 20 + 1));
        }
        System.out.println("list1: " + l1);
        System.out.println("list2: " + l2);
        System.out.println();

        // addAll(Collection, element:varargs) : Boolean
        Collections.addAll(l1, 1, 2, 2, 3);
        System.out.println("list1: " + l1);
        System.out.println();

        // sort(Collection o)
        Collections.sort(l1);
        System.out.println("list1: " + l1);
        System.out.println();

        // binarySearch(Collection o) -> index or -1
        System.out.println(Collections.binarySearch(l1, 13));
        System.out.println();

        // reverse
        Collections.reverse(l1);
        System.out.println("list1: " + l1);
        System.out.println();

        // shuffle(Collection o) -> xáo trộn
        // fill(Collection o, T obj)
        Collections.fill(l2, 100);
        System.out.println("list2: " + l2);

        // readmore:
        // https://www.geeksforgeeks.org/java/collections-class-in-java/

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
