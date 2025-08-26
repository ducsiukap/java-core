package java019_interfaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

// FunctionalInterface: an interface contains only one abstract method
//  can have multiple default/static/private methods
@FunctionalInterface
interface MyMath {
    int op(int a, int b);
}

public class functionalInterface {
    public static void main(String[] args) {
        // can implements by subclass as normal interface

        // but can be implemented by lambda expression
        MyMath add = (a, b) -> a + b;
        MyMath sub = (a, b) -> a - b;
        MyMath mul = (a, b) -> a * b;

        int a = 10, b = 5;
        System.out.println("\n--------------------");
        System.out.println(add.op(a, b));
        System.out.println(sub.op(a, b));
        System.out.println(mul.op(a, b));

        // some built-in FunctionalInterface
        System.out.println("\n--------------------");
        Predicate<Integer> isOdd = (value) -> (value & 1) == 1; // .test()
        Comparable<Integer> compareTo100 = (value) -> value - 100;
        Consumer<Integer> csm = (value) -> System.out
                .println("Accept: " + value + ". Is Odd Number: " + isOdd.test(value) + ". Compare to 100: "
                        + compareTo100.compareTo(value)); // .accept()
        Supplier<Integer> sup = () -> (int) (Math.random() * 1000 + 1); // [1, 1000] // .get()
        for (int i = 0; i < 5; ++i)
            csm.accept(sup.get());
        // read more about some built-in functional interfaces:
        // Predicate<T> : ===> public boolean test(T o)
        // Function(T, R): ===> public R apply(T o)
        // Consumer<T> : ===> public void accept(T o) // do smth with o
        // Supplier<T>: ===> public T get() // return a value of type T
        // Runnable: ===> public void run()
        // Comparable<T> : ===> public int compareTo(T o)
        // Callable<V> : ===> public V call()
        // ActionListener : ===> public void actionPerformed(ActionEvent e)

        System.out.println("\n--------------------");
        // Comparator -> sort the collection
        List<Student> students = new ArrayList<>();
        students.add(new Student("Duc", "Pham Van", "ABC0244"));
        students.add(new Student("Dat", "Nguyen Duc", "ABC0195"));
        students.add(new Student("Anh", "Le Quynh", "ABC0011"));
        students.add(new Student("Duc", "Pham Van", "ABC0243"));

        List<Student> students2 = new ArrayList<>(students);
        List<Student> students3 = new ArrayList<>(students);
        System.out.println("Original: " + students);

        // sort the list using StudentComparator class (read below main funcion)
        students.sort(new StudentCompare());
        System.out.println("Sorted1: " + students);
        // sort using comparing(first_fields).thenComparing(second_field)..
        students2.sort(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName)
                .thenComparing(Student::getSID));
        System.out.println("Sorted2: " + students2);

        // reverse the sort order with .reversed()
        // students3.sort(new StudentCompare().reversed());
        // or
        students3.sort(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName)
                .thenComparing(Student::getSID).reversed());
        System.out.println("Reversed: " + students3);
        // giả sử nếu muốn reversed theo tiêu chí lastName -> sử dụng cách 2
        // firstName -> lastName -> reversed() -> sID
        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}

// Comparator is Functional interface
/*
 * interface Comparator<T> {
 * public int compare(T o1, T o2);
 * }
 */
class Student {
    String sID, firstName, lastName;

    public Student(String firstName, String lastName, String sID) {
        this.sID = sID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getSID() {
        return this.sID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return ("ID: " + this.sID + " --- Name: " + this.lastName + " " + this.firstName);
    }
}

// using Comparator
// way 1. write a class to compare
class StudentCompare implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        if (a.firstName.equals(b.firstName)) {
            if (a.lastName.equals(b.lastName))
                return a.sID.compareTo(b.sID);
            else
                return a.lastName.compareTo(b.lastName);
        }
        return a.firstName.compareTo(b.firstName);

        // compare order: first name, last name, student id
    }

    // boolean equals(Object obj);

    // default Comparator<T> reversed() {}

    // default Comparator<T> thenComparing(Comparator<? super T> other) {...}

    // static <T, U extends Comparable<? super U>> Comparator<T>
    // comparing(Function<? super T, ? extends U> keyExtractor) {...}
}

// way 2. read the main