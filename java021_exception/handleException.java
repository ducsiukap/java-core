package java021_exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Handler {

    // we have 2 ways to handle exception

    // 1. using try-catch
    // try-catch -> handle ngay tại nơi nó xảy ra
    public void try_catchHandle(String filename) {
        try (FileReader f = new FileReader(filename)) {
            // FileNotFoundException

            // do smth if no error occurs

        } catch (FileNotFoundException e) {
            // do smth if meet an error

            // method to print exception info:
            System.err.println("====================");
            System.err.println(">>> e.printStackTrace(): ");
            e.printStackTrace(); // name, message + location of error
            System.err.println("====================");
            System.err.println(e.toString()); // name + message of exception
            System.err.println(e.getMessage()); // message of exception
        } catch (IOException e) {
            // we can catch multiple exception
        } catch (Exception e) {
            // catch all exception
        } finally {
            System.out.println("Finally block!");
        }
    }

    // 2. using throws
    // throws từ hàm
    // không handle trực tiếp,
    // gán trách nhiệm handle lên bất kì ai gọi hàm đó
    public void methodThrows(String filename) throws FileNotFoundException, IOException {

        FileReader f = new FileReader(filename);
        // do smth...
        f.close();
    }
}

public class handleException {
    public static void main(String[] args) {
        Handler obj = new Handler();
        System.out.println("\n--------------------");
        obj.try_catchHandle("notfound.abc"); 
        //  try_catchHandle không throws exception nào (đã xử lý ngay tại hàm) 
        // => không cần handle

        System.out.println("\n--------------------");
        // methodThrows đã throws các exception
        // => khi gọi ta cần handle tại nơi gọi
        // => có thể lại throws tiếp :)
        // hoặc try_catch
        try {
            obj.methodThrows("notfound.abc");
        } catch (Exception e) {
            System.err.println("handled exception at main()");
        }

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
