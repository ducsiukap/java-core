package java019_interfaces;

// to achieve multiple inheritance -> using interfaces

// a class can extends only one another class
// but can implements multiple interfaces.

interface Flyable {
    void fly();

    void speedUp(int s);

    void slowDown(int s);
}

interface Soundable {
    void makeSound();
}

// interface can contains:
// - attributes -> public static final is default
// - methods -> public abstract is default
// - default methods -> public, have body, can be override
// - static methods -> public, have body, cannot be override, invoked using
// interface name
// - private methods -> have body, cannot be overrride, using only inside
// interface (helper func for default/static methods)

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// bird can fly ?
// bird can make sound ?
class Bird extends Animal implements Flyable, Soundable {
    private int flySpeed;

    public Bird(String name, int flySpeed) {
        super(name);
        this.flySpeed = flySpeed;
    }

    public int getFlySpeed() {
        return this.flySpeed;
    }

    // Override all interface abstract methods
    @Override
    public void fly() {
        System.out.println(this.getName() + " is flying! Speed: " + this.flySpeed);
    }

    @Override
    public void speedUp(int s) {
        this.flySpeed = Math.min(100, this.flySpeed + s);
    }

    @Override
    public void slowDown(int s) {
        this.flySpeed = Math.max(0, this.flySpeed - s);
    }

    @Override
    public void makeSound() {
        System.out.println("chip chip");
    }
}

// dog can fly ? =))
// dog can make sound ?
class Dog extends Animal implements Soundable {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("gau gau");
    }
}

public class interfaces {
    public static void main(String[] args) {
        System.out.println("\n--------------------");
        Bird bird = new Bird("Vet", 15);
        System.out.println("Bird: " + bird.getName());
        // flyable
        bird.fly();
        bird.speedUp(10);
        bird.fly();
        bird.slowDown(5);
        bird.fly();
        // soundable
        bird.makeSound();

        System.out.println("\n--------------------");
        Dog bong = new Dog("Bong");
        System.out.println("Dog: " + bong.getName());
        // soundable
        bong.makeSound();

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}

// Readmore about: 
// marker interfaces : Serializable, Cloneable
// -> marker interfaces: interface without body(methods & fields)
// -> used to mark smth about this class with JVM