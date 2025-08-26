package java019_interfaces;

interface A {
    // public static final fields;

    // a method inside the interface can be

    // abstract (default) -> no body, must be override in subclass
    void abstractFunc();

    // private methods -> have body, helper function for default/static/private
    // method
    // use only inside the interface
    private void privateFunc() {
        System.out.println("This is private method inside the interface A!");
    }

    // default methods -> have body, can be override in subclass
    default void defaultFunc() {
        // call private func
        privateFunc();
        System.out.println("This is default function inside the interface A, that calls privateFunc()!");
    }

    // static method -> have body, cannot be override, invoked via
    // interfaceName.method()
    static void staticFunc() {
        System.out.println("This is static function inside the interface A!");
    }
}

class B implements A {

    // have to override abstract method
    @Override
    public void abstractFunc() {
        System.out.println("This is abstract function, that was overridden in the class B!");
    }

    // can override the default method

    // cannot call or override private method
    // cannot override static method
}

public class methods {
    public static void main(String[] args) {
        B obj = new B();

        System.out.println("\n--------------------");
        // call non-static methods
        obj.abstractFunc();
        obj.defaultFunc();
        // call static method
        // obj.staticFunc(); // error
        A.staticFunc(); // via interface

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
