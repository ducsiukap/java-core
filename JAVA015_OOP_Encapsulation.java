// this class shows how to react encapsulation in OOP
class User_015 {
    // Encapsulation:
    // almost fields need to be private.
    private String name, personalID;
    private int age;

    // Constructor
    public User_015() {
        this.name = null;
        this.personalID = null;
        this.age = 0;
    }

    public User_015(String name, String personalID, int age) {
        this.name = name;
        this.personalID = personalID;

        if (this.isValidAge(age)) {
            this.age = age;
        } else {
            this.age = 0;
            System.out.println("Amazing! Invalid age: " + age);
            System.out.println("User's age will be set to 0!");
        }
    }

    // getter to read private fields.
    public String getName() {
        return this.name;
    }

    public String getPersonalID() {
        return this.personalID;
    }

    public int getAge() {
        return this.age;
    }

    // setter -> write the private fields
    public void setName(String name) {
        this.name = name;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public void setAge(int age) {
        // this.age = age; // whether age need to validate ?
        if (this.isValidAge(age)) {
            this.age = age;
        } else {
            System.out.println("Amazing! Invalid age: " + age);
        }

    }

    // this function to validate the age
    // why this function is private ?
    // can it be invoked outside the class ?
    private boolean isValidAge(int age) {
        return (age >= 0 && age <= 200); // does smbd is 200 years old =))))))))
    }

    @Override
    public String toString() {
        return String.format("User_015 {\tname: %s, \n\tage: %d, \n\tpersonalID: %s\n}", name, age, personalID);
    }
}

// this class shows difference between private, static and final
class MyClass_015 {
    // private field: cannot be accessed outside the class,
    // have to use the getter & setter
    private int privateField;

    // static field: common field for all objects of this class
    // this field of any object has the same value
    private static int countObject = 0;

    // final field: a constant field,
    // the value of this field can be set only one time when the object is created
    // then, it cannot be change after
    public final int finalField;
    // public final với private final tương tự về ý nghĩa, chỉ khác cách truy cập

    // let's explore more about: static final field (using ChatGPT, Gemini, ... )

    public MyClass_015(int pf, int ff) {
        this.privateField = pf;
        this.finalField = ff;
        MyClass_015.countObject += 1;
    }

    // getter and setter for private field
    public int getPrivateField() {
        return this.privateField;
    }

    public static int getCountObject() {
        return countObject;
    }

    public void setPrivateField(int pf) {
        this.privateField = pf;
    }

    // public static void setCountObject(int count) {
    // MyClass_015.countObject = count;
    // }

    @Override
    public String toString() {
        return String.format("MyClass_015 {\n\tprivateField: %d, \n\tfinalField: %d, \n\tcountObject: %d\n}",
                this.privateField,
                this.finalField, countObject);
    }

}

public class JAVA015_OOP_Encapsulation {
    public static void main(String[] args) {

        // Private Fields

        // create user with invalid age
        User_015 user = new User_015(null, null, -1); // age = -1
        System.out.println("--------------------");

        // we can't directly access to the private fields
        // user.name = "vduczz"; // error, we have to use the setter and getter
        user.setName("vduczz");
        user.setPersonalID("000000000000");
        // test age validation
        user.setAge(-1);
        user.setAge(999);
        user.setAge(21);
        System.out.println("--------------------");

        // print the user
        // System.out.println("user.name: " + user.name); // error
        System.out.println("user.getName(): " + user.getName());
        System.out.println(user); // call user.toString()

        // private, static vs final
        System.out.println("--------------------");
        int n = 5;
        MyClass_015[] list = new MyClass_015[n];

        for (int i = 0; i < n; ++i) {
            list[i] = new MyClass_015((int) (Math.random() * 1000), (int) (Math.random() * 1000));
        }

        System.out.println("list[0].finalField: " + list[0].finalField); // public final -> can access directly

        System.out.println(String.format("Myclass_015.countObject: %d", MyClass_015.getCountObject()));
        for (int i = 0; i < n; ++i)
            System.out.println(list[i]);
        // all objs have the same countObject
        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}

