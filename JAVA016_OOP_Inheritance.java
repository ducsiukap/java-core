class SuperClass {
    public int a, b;

    public SuperClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void show() {
        System.out.printf("SuperClass: {\n]ta: %d,\n\tb: %d\n}\n", this.a, this.b);
    }

    // final method -> cannot be overridden in subclass
    public final int sum() {
        return this.a + this.b;
    }
}

class SubClass extends SuperClass {
    private int a; // che thuộc tính a của SuperClass
    // -> lúc này, không thể truy cập trực tiếp SuperClass.a trong thông qua
    // SubClass.a
    public String text;

    public SubClass(int a, int b, String text) {
        super(a, b);
        this.a = a;
        this.text = text;
    }

    @Override
    public void show() {
        System.out.printf(
                "SubClass: {\n\ta: %d,\n\tb: %d\n\ttext: %s\n}\n(super.a = %d)\n",
                this.a, this.b, this.text, super.a);
    }

    // @Override
    // public int sum() {
    // // return this.a + this.b + this.c; // cannot override final method
    // return super.sum() + this.c;
    // }
    // error

    public int mul() {
        return this.a * this.b;
    }

}

public class JAVA016_OOP_Inheritance {
    public static void main(String[] args) {
        // IS-A

        SubClass sub = new SubClass(10, 20, "vduczz");
        // access superclass members
        sub.b = 10;
        System.out.println(sub.sum());
        sub.show();
        // cannot access field a because its private in subclass -> hide the data of
        // superclass

        // access subclass members
        System.out.println(sub.mul());
        // => SubClass IS-A SuperClass!. So, its obj can access all its members and
        // members of superclass

        System.out.println("\n--------------------");
        SuperClass sup = new SubClass(10, 20, "Hello");
        // access superclass members
        sup.a = 15; // ok because a in super is public
        sup.b = 15;
        System.out.println(sup.sum());
        sup.show();

        // access subclass members
        // System.out.println(sup.mul()); // error
        // => SuperClass is NOT SubClass!. So, its obj can only access its members

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}

// read more about types of Inheritance: 
// Single, Multilevel, Hierarchical, Multiple, Hybrid
// 