package java021_exception;

// define exception 
class DivByZero extends Exception { // -> Checked Exception
    public DivByZero(String message) {
        if (message == null)
            message = "/ by zero";
        super(message);// call super constructor

        warning();
    }

    // we can add method to privide additional details
    public void warning() {
        System.out.println(">>> warning: caught DivByZero Exception!");
    }
}
// extends RuntimeException -> Unchecked Exception

// throw an exception
class IntegerDevider {
    private int a, b;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    // we can throw an exception any where in program
    // with Checked, we have to handle that.
    public int idiv() throws DivByZero {
        if (b == 0) {
            // div by zero -> throw exception
            DivByZero ex = new DivByZero(null);
            // Chained: we can specified root (cause) of caught exception:
            // using exception.initCause()
            ex.initCause(new ArithmeticException("customize message hehehe!"));

            // throw exception
            throw ex;
            // then, we have to handle DivByZero at here
            // or throws to caller

            // throw vs throws
            // - throw is used to throw an exception
            // the flow of execution of the program stops immediately
            // after the throw statement is executed
            // so, we have to handle it
            // ===> Khởi tạo và ném ra 1 ngoại lệ (thường là customize exception)
            // - throws : -> this method might throw one of the listed type exceptions
            // ===> dùng ngay sau tên hàm
            // ===> bất cứ lời gọi hàm nào đều cần handle the exception list

        }

        return a / b;
    }
}

public class customizeException {
    public static void main(String[] args) {
        IntegerDevider idiv = new IntegerDevider();

        // normal case
        idiv.setA(2);
        idiv.setB(1);
        // do idiv handle throw bằng cách throws
        // -> cần handle khi gọi
        try {
            System.out.println(">>> normal case: idiv() -> " + idiv.idiv());
        } catch (DivByZero e) {
            System.out.println(">>> catch: DivByZer(" + e.getMessage() + ")");
        }

        // exception case
        idiv.setB(0);
        try {
            System.out.println(">>> normal case: idiv() -> " + idiv.idiv());
        } catch (DivByZero e) {
            System.out.println(">>> catch: DivByZer(" + e.getMessage() + ")");
        } finally {
            // do smth

            // final: used with vars, methods, classes -> restrict modifiaction
            // finally -> block of code that always executes after try_catch block
            // finalize() -> method, called by Garbage Collector just before an object is removed.
        }

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}
