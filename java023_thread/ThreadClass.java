package java023_thread;

// define a thread
class MyThread1 extends Thread {

    // have to override run()
    @Override
    public void run() {

        for (int i = 1; i < 11; ++i) {
            System.out.println(this.getName() + " count: " + i);
        }

    }
}

// auto start thread
class MyThread2 extends Thread {
    // constructor
    // Thread()
    // Thread(String name)
    // Thread(ThreadGroup group)
    // Thread(ThreadGroup group, Runnable target, String name)
    // Thread(ThreadGroup group, String name)
    // Thread(ThreadGroup group, Runnable target, String name, long stackSize)
    // Thread(Runnable target) // cái này dùng để tạo instance
    // Thread(Runnable target, String name)
    public MyThread2(String name) {
        super(name);
        this.start(); // start ngay trong constructor
    }

    // override run method
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i)
            System.out.println(this.getName() + " is woke up!");
    }

}

//
class MyThread3 extends Thread {

    String name;

    public MyThread3(String name) {
        super(name);
    }

    @Override
    public void run() {

        System.out.println("Current Thread: " + Thread.currentThread());
        // trả về Instance của thread đang được chạy
        // static method -> invoked via class namee: Thread.currentThread()
        // chỉ gọi trong run()
    }

}

public class ThreadClass {

    public static void main(String[] args) {

        // create an thread instance
        MyThread1 t1 = new MyThread1();
        MyThread1 t2 = new MyThread1();
        t1.start();
        t2.start();
        // create auto start thread instance
        // dont need to call start()
        MyThread2 t3 = new MyThread2("T3");
        MyThread2 t4 = new MyThread2("T4");
        MyThread2 t5 = new MyThread2("T5");
        // 5 thread chay song song
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            // main chờ t1, t2, t3, t4, t5 chạy xong mới chạy tiếp
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // methods of thread class
        // run()
        // start()
        // getName()/setName(String)
        // getId()
        // getPriority()/setPriority(int)
        // isAlive() -> check xem thread còn chạy không.

        System.out.println("=========================");
        // Thread.currentThread() -> static method, trả về Thread đang được chạy
        // ví dụ:
        // gọi ở main -> trả về main
        System.out.println(Thread.currentThread()); // main
        // goị ở MyThread1, MyThread2, ... => phải gọi trong run()
        MyThread3 t6 = new MyThread3("ABC");
        t6.start(); // run() // System.out.println("Current Thread: " + Thread.currentThread());
                    // -> trả về t6 Current Thread: Thread[#40,ABC,5,main]
                    // #ThreadID, ThreadName,ThreadPriority, ThreadGroup
        //

        // Điều khiển thread  -> throw InterruptException
        // Thread.sleep(ms) // static method, dừng thread hiện tại

        // Thread.yeild() // static method, nhường CPU cho thread khác chạy // tạm dừng
        // thread hiện tại (tự nguyện)

        // t1.join() // ThreadGroup chứa t1 chờ t1 chạy xong mới chạy tiếp thread khác.
        // t2.interrupt() // ThreadGroup ngắt t2
    }
}
