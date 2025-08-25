class Super_018 {

    public void doSmth() {
        System.out.println("doSmth() in Super is invoked!");
    }

    // Method overlaading:
    // - same name
    // - different parameters (type or number of parameters)
    // - or different return type
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b;
    }
}

class Sub_018 extends Super_018 {

    @Override
    public void doSmth() {
        System.out.println("doSmth() in Sub is invoked!");
    }

    // add(a, b): int
    // add(a, b, c): int
    public double add(double a, double b) {
        return a + b;
    }
}

public class JAVA018_Polymorphism {
    public static void main(String[] args) {
        Super_018 obj = new Super_018();
        System.out.println(obj.add(1, 2));
        System.out.println(obj.add(1, 2, 3));
        // System.out.println(obj.add(1.5, 2.5)); // error, không có method add(double,
        // double) trong Super
        obj.doSmth();
        System.out.println("\n--------------------");

        // sub
        Sub_018 obj_2 = new Sub_018();
        System.out.println(obj_2.add(1, 2));
        System.out.println(obj_2.add(1, 2, 3));
        System.out.println(obj_2.add(1.5, 2.5));
        obj_2.doSmth();

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
