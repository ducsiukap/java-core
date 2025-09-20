package java024_networking.rmi;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

// 1. Interface định nghĩa các phương thức có thể gọi từ xa
interface Calculator extends Remote {
    public int add(int a, int b) throws RemoteException;

    public int mul(int a, int b) throws RemoteException;
}

// 2. Cài đặt lớp triển khai
// Cách 1. extends UnicastRemoteObject
// tự động export đối tượng từ xa thông qua gọi super() trong constructor
class CalcImpl1 extends UnicastRemoteObject implements Calculator {

    // constructor
    public CalcImpl1() throws RemoteException {
        // super(); // export tự động đối tượng từ xa
        // port = 0 -> hệ thống tự chọn port

        super(5706); // export tự động đối tượng từ xa
                     // port = 1302
    }

    // triển khai các method
    public int add(int a, int b) throws RemoteException {
        System.out.format("[CalcImpl1] request add(%d, %d)\n", a, b);
        return a + b;
    }

    public int mul(int a, int b) throws RemoteException {
        System.out.format("[CalcImpl1] request mul(%d, %d)\n", a, b);
        return a * b;
    }
}

// cách 2: không extend UnicastRemoteObject
// không export tự động đối tượng từ xa
// linh hoạt hơn vì có thể extend class khác
class CalcImpl2 implements Calculator {
    // constructor
    public CalcImpl2() throws RemoteException {
    }

    // triển khai các method
    public int add(int a, int b) throws RemoteException {
        System.out.format("[CalcImpl2] request add(%d, %d)\n", a, b);
        return a + b;
    }

    public int mul(int a, int b) throws RemoteException {
        System.out.format("[CalcImpl2] request mul(%d, %d)\n", a, b);
        return a * b;
    }
}

public class server {

    public static void main(String[] args) throws RemoteException {
        Calculator calc1 = new CalcImpl1(); // đã export tự động
                                            // vì extends UnicastRemoteObject
                                            // và gọi super() trong constructor
                                            // Calculator calc1 -> calc1 là stub
        System.out.println("Exporting CalcImpl1 on port 5706");

        CalcImpl2 calc2 = new CalcImpl2(); // chưa export
        // export cho calc2
        Calculator stub = (Calculator) UnicastRemoteObject.exportObject(calc2, 1303); // port của remote object
                                                                                      // 2 khai niệm khác nhau với port
                                                                                      // của rmiregistry
        System.out.println("Exporting CalcImpl1 on port 1303");
        // UnicastRemoteObject.exportObject(object, port);
        // trả về Stub

        Registry registry = LocateRegistry.createRegistry(9999);
        // tạo mới rmiregistry chạy trên cổng 9999

        // Đăng ký với Server Registry
        // cách 1: dùng lớp Naming
        try {
            Naming.rebind("rmi://localhost:9999/Calculator1", calc1);
            // Naming methods:
            // 1. public static String[] list(String url) throws RemoteException,
            // MalformedURLException
            // 2. public static Remote lookup(String url) throws RemoteException,
            // NotBoundException, MalformedURLException
            // 3. public static void bind(String url, Remote obj) throws RemoteException,
            // AlreadyBoundException, MalformedURLException
            // 4. public static void rebind(String url, Remote obj) throws RemoteException,
            // MalformedURLException
            // 5. public static void unbind(String url) throws RemoteException,
            System.out.println("calc1 bound in registry on rmi://localhost:9999/Calculator1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // cách 2: dùng lớp Registry
        // Registry, LocateRegistry
        try {

            // method tương tự Naming

            // bind
            registry.rebind("Calculator2", stub);
            // -> url: rmi://localhost:9999/Calculator2
            System.out.println("calc2 bound in registry on rmi://localhost:9999/Calculator2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
