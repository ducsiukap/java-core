abstract class Shape_017 {
    private String color;

    public Shape_017(String color) {
        this.color = color;
    }

    // getter & setter for color
    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // abstract method
    // mọi subclass đều phải implement method này
    public abstract double area();
}

class Circle_017 extends Shape_017 {
    private double radius;

    public Circle_017(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // override abstract method
    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }
}

class Rectangle_017 extends Shape_017 {
    private double width, height;

    public Rectangle_017(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // override abstract method
    @Override
    public double area() {
        return this.width * this.height;
    }
}

public class JAVA017_Abstraction {
    public static void main(String[] args) {
        Shape_017 circle = new Circle_017("green", 5);
        Shape_017 rectangle = new Rectangle_017("blue", 4, 6);

        System.out.println("circle.color: " + circle.getColor());
        System.out.println("circle.area: " + circle.area());

        System.out.println("rectangle.color: " + rectangle.getColor());
        System.out.println("rectangle.area: " + rectangle.area());

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}

// Abstraction = Inheritance + enforce override
