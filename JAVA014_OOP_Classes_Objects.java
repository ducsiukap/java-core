// Key features of Java OOP:
// 1. Structures the code into logical units (classes, objects)
// 2. binding datas and methods together => avoid unauthorized access to the data
// 3. make code modular, reusable and scalable
// 4. DRY principle

// A. Classes
// define a class 
// [modifier] class className [extends superClass] [implements intefaces] { //class_members }
/* 
1. modifiers: public, protected, default (no keyword), private
        => commonly used for methods or data members
        - a top-level class can be only public or default
        - a progam (a .java file) can have only one public class that has the same name with program (filename) and includes main() method
        - all others are default
2. superClass: a class can inherit from only one superClass
3. intefaces: a class can implements multiple interfaces
*/

import java.util.Arrays;

class User_014 {
    // class-member can be

    // 1. data member (or fields, attribute)
    private String name;
    private int age;
    private String[] hobbies;

    // 2. constructor: special method:
    // - no returnType or returnValue, same name with class,
    // - automatically invoked when an instance of class is created
    // contructor cannot be final, abstract, static and synchronized
    // private constructor: => read more about Singleton pattern
    // 2.1 Default constructor - no param
    public User_014() {
        name = null;
        hobbies = null;
        age = 0;
    }

    // 2.2 Parameters constructor
    public User_014(String name, int age) {
        this.name = name;
        this.age = age;
        this.hobbies = null;
    } // or

    public User_014(String name, int age, String... hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }

    // 2.3 Copy constructor
    public User_014(User_014 other) {
        this.name = other.name;
        this.age = other.age;

        // sallow copy
        // this.hobbies = other.hobbies; // refer to the same object!

        // deep copy
        this.hobbies = new String[other.hobbies.length]; // create a new object
        for (int i = 0; i < other.hobbies.length; ++i)
            this.hobbies[i] = other.hobbies[i];
    }

    // 3. nested class
    // 4. interfaces

    // 5. method
    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHobbies(String... hobbies) {
        this.hobbies = hobbies;
    }

    // getter
    public String getName() {
        return this.name;
    }

    // other logic method, ...

    // Object class's method
    // all Java class is inherited from Object class (automatically, does not need
    // "extends Object")
    // some method of Object class to override
    @Override
    public String toString() {
        return String.format("{\n\tname: %s, \n\tage: %d, \n\thobbies: ", name, age) + Arrays.deepToString(hobbies)
                + "\n}";
    }
    // public int hashCode()
    // public boolean equals()
    // getClass() // can not override
    // wait(), notify(), notifyAll()
    // protected Object clone() // extends Cloneable
    // protected void finalize() // do smth before object is deleted
}

public class JAVA014_OOP_Classes_Objects {
    public static void main(String[] args) {
        // B. Objects
        // create a object:
        // 1. using new keyword
        User_014 user = new User_014("vduczz", 21, "Programming", "Sport", "Animal");
        // 2. clone an existed object => user.clone()
        // 3. copy constructor
        User_014 copyUser1 = new User_014(user);
        /*
         * copy constructor vs assignment operator (=)
         * - Copy constructor: create a new object based on other object's data. the
         * copied has no relationsive with new object.
         * - Assigment op (=) : no object is created, 2 variables refer to the same
         * object
         */
        User_014 copyUser2 = user;

        // access to non-private class member (method, attributes) via dots (.) =>
        // object.method

        System.out.println("user = " + user); // user.toString() is invoked
        System.out.println("copyUser1 = " + copyUser1);
        System.out.println("copyUser2 = " + copyUser2);

        // change the copyUser1
        System.out.println("\n--------------------");
        copyUser1.setName("copyUser1's name");
        System.out.println("user = " + user); // user.toString() is invoked
        System.out.println("copyUser1 = " + copyUser1);
        System.out.println("copyUser2 = " + copyUser2);

        // change the copyUser2
        System.out.println("\n--------------------");
        copyUser2.setName("copyUser2's name");
        System.out.println("user = " + user); // user.toString() is invoked
        System.out.println("copyUser1 = " + copyUser1);
        System.out.println("copyUser2 = " + copyUser2);

        System.out.println("\n--------------------");
        System.out.println("#vduczz");

    }
}
