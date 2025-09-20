package java024_networking.rmi;

import java.rmi.*;

// ĐỊnh nghĩa interface remote
interface Calculator extends Remote {
    public int add(int a, int b) throws RemoteException;

    public int mul(int a, int b) throws RemoteException;
}
// giống như server

public class client {

    public static void main(String[] args) {
        try {
            // lấy stub
            Calculator c1 = (Calculator) Naming.lookup("rmi://localhost:9999/Calculator1");
            Calculator c2 = (Calculator) Naming.lookup("rmi://localhost:9999/Calculator2");

            // gọi method
            System.out.println(c1.add((int) (Math.random() * 100), (int) (100 * Math.random())));
            System.out.println(c2.mul((int) (Math.random() * 100), (int) (100 * Math.random())));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
