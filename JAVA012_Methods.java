class Dog_012 {
    String name;

    // method: a block of code that perform a specific taskX
    /*
     * syntax:
     * [modifier] [staic/final/synchronized] returnType methodName (arguments) {
     * // body
     * [return returnValue;]
     * }
     */

    // Note:
    // - a method must be belong to a class

    public Dog_012(String name) {
        this.name = name;
    }

    // types of method
    // 1. Instance method
    public void makeSound() { // invoked via an object of this class
        System.out.println("Gau gau");
    }

    // 2. Static method
    public static void sayHiWithBoss(String bossName) { // using with "static" keyword
        // invoked via className.methodName()
        System.out.println("Hello " + bossName + "!");
        // can not use "this" or other non-static class members (methods, attributes) in
        // this class
        // this.makeSound() // error
        // this.name = abc // error
    }

    // 3. Built-in method: the method that is already defined in the Java class
    // libraries

    // 4. final method: the method can not be override (OOP)
    // using with "final" keyword

    // 5. Abstract method: the method is declared in abstract class (OOP)

    // 6. synchronized method: method that can be used in only one thread in the
    // same time.
    // using "synchronized" keyword
}

public class JAVA012_Methods {
    public static void main(String[] args) { // main (args[]) => hàm chứa chương trình thực thi of a java program.
        System.out.println("\n--------------------");
        // call a static method:
        Dog_012.sayHiWithBoss("vduczz");

        // call a instance method:
        Dog_012 Bong = new Dog_012("Bong");
        Bong.makeSound();

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
