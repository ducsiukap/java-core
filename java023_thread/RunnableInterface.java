package java023_thread;

// create thread using Runnable
class MyThreadX implements Runnable {

    // override run() method
    @Override
    public void run() {
        for (int i = 0; i < 100; ++i) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            // get name of thread
        }

        // note
        // cả Runnable interface và Thread class không thể handle checked exception
        // bằng cách throws exception
        // -> tóm lại là với bất kì Exception nào (Checked, Unchecked) có thể xảy ra
        // trong run()
        // cần handle thủ công bằng try-catch để tránh thread bị terminated.
    }

}

// auto run thread
class AutoRunningThread implements Runnable {
    // start() trong constructor
    public AutoRunningThread() {
        (new Thread(this)).start();
        // tao instance
        // start()
    }

    // override run
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("Auto thread \"" + Thread.currentThread().getName() + "\" - " + i);
        }
    }
}

public class RunnableInterface {
    public static void main(String[] args) {
        // create an thread object
        // using Thread(Runnable target) / Thread(Runnable target, String name)
        // constructor of Thread class
        Thread x1 = new Thread(new MyThreadX(), "X1");
        Thread x2 = new Thread(new MyThreadX(), "X2");

        x1.start();
        x2.start();

        try {
            x1.join();
            x2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // auto run thread
        Thread auto1 = new Thread(new AutoRunningThread());
        Thread auto2 = new Thread(new AutoRunningThread());

    }

}
