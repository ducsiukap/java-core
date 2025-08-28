package java021_exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

// java exception handling -> managing runtime errors
// => ensure the app can not be terminated.

// all exceptions and errors are subclass of Throwable

// Type of exception
// 1. Built-in exception: Checked + Unchecked Exception
// - Checked: compile-time exception (checked at compile time by the compiler)
//      all Checked exception must be handle (throws, try-catch...)
//      ex: IOException, SQLException, FileNotFoundException, ClassNotFoundException, ... 
//      
// - Unchecked -> runtime exception => programming error
//      do not require explicit handling
//      ex: ArithmeticException, ClassCastException, NullPointerException, ArrayIndexOutOfBoundsException, ... 

// 2. User-Definded exception
// 

public class exception {
    public static void main(String[] args) {
        // handle checked exception
        try {
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            b.readLine();// IOException

            File f = new File("file.abc");
            FileReader fr = new FileReader(f); // FileNotFoundException
            fr.close();
        } catch (FileNotFoundException e) {
            // có thể chỉ định loại exception cụ thể được catch
            // hoặc dùng catch (Exception e) cho mọi exception
            // hoặc kết hợp cả 2

            // handle exception in catch block
            System.out.println("catch: FileNotFoundException!");
        } catch (IOException e) {
            // handle exception in catch block
            System.out.println("catch: IOException!");
        } finally {
            // finally block được chạy bất kể có xảy ra exception hay không
            // ->
        }

        // unchecked exception không ảnh hưởng tới việc compile -> chương trình vẫn được
        // thực thi
        // nhưng nếu exception xảy ra thì chương trình sẽ bị dừng nếu không handle

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }
}

// NullPointerException -> trying to accessing/using a null object

// Rules for Exception Handling with Method Overriding
// - The subclass can throw the same or smaller exceptions as the superclass
// methods./ or unchecked exception
// - The subclass can choose not to throw any exceptions.
// - The subclass cannot throw new checked exceptions not in the parent method.