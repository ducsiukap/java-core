package java023_thread.synchronization;

// Inter-Thread communication 
// Giao tiếp giữa các Thread để tránh xung đột tài nguyên

// Chủ yếu giải quyết bài toán Producer-Consumer
// bên lấy dữ liệu phải chờ bên gửi cung cấp dữ liệu

// có thể thêm thắt để giải quyết thêm vấn đề : Trong 1 thời điểm chỉ 1 bên được đọc và 1 bên được gửi.

// 3 hàm chính:
// public final void wait() throws InterruptException // or wait(long timeout)
// public final void notify()
// public final void notifyAll()

//
class SharedData {
    private int data; // data
    private boolean available; // data is produced ? ( comsumed ? 1-1 Produce-Consumer problem)

    public SharedData() {
        this.available = false;
        this.data = -1;
    }

    // asynchronous (khong dong bo)
    public void asyncProduce(int data) {
        this.data = data;
        System.out.println("produce: " + data);
    }

    public void asyncConsume() {
        System.out.println("consume: " + this.data);
        // return this.data;
    }

    // synchronized // N Producer - N Consumer
    // them synchronized de write lan luot
    public synchronized void syncProduceN(int data) {
        this.data = data;
        System.out.println("produce: " + data);
        // set available => ready to consume()
        this.available = true;
        // đánh thức các consumer còn đang chờ
        notify();
        // or notifyAll()
    }

    // them synchronized de read lan luot
    public synchronized void syncConsumeN() {
        if (!available) { // chưa có thì chờ
            try {
                this.wait();
            } catch (InterruptedException e) { // do smth, log, ...
            }
        }
        // available
        System.out.println("consume: " + this.data);
        // return this.data;
    }

    // 1 Producer - 1 Consumer
    public synchronized void syncProduce1(int data) {
        if (available) { // data is produced => waiting
            try {
                this.wait();
                // or this.wait(long timeout)
            } catch (InterruptedException e) {
            }
        }
        // data is not produced or be consumed
        this.data = data;
        System.out.println("produce: " + data);
        // mark produced
        this.available = true; // if data is not be consumed -> next producer cannot produce.
        // notify() các consumer đang chờ
        notify();
    }

    public synchronized void syncConsume1() {
        if (!available) { // data is not available -> wait
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        // if data is available
        System.out.println("consume: " + this.data);
        // mark data is not available
        this.available = false;
        // notify() to the producer
        notify();
        // return data;
    }

    // syncProduceN + syncConsumeN -> N Producer - N Consumer
    // syncProduceN + syncConsume1 -> N Producer - 1 Consumer
    // syncProduce1 + syncConsumeN -> 1 Producer - N Consumer
    // syncProduce1 + syncConsume1 -> 1 Producer - 1 Consumer
}

// asynchronous thread
class AsyncProduce extends Thread {
    private SharedData data;

    public AsyncProduce(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            // produce
            data.asyncProduce((int) (Math.random() * 100));

            try { // sleep
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

class AsyncConsumer extends Thread {
    private SharedData data;

    public AsyncConsumer(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            // consume
            data.asyncConsume();

            try { // sleep
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

// synchronized consumer, producer
class SyncProduceN extends Thread {
    private SharedData data;

    public SyncProduceN(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            // produce
            data.syncProduceN((int) (Math.random() * 100));

            try { // sleep
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

class SyncConsumerN extends Thread {
    private SharedData data;

    public SyncConsumerN(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            // consume
            data.syncConsumeN();

            try { // sleep
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

class SyncProduce1 extends Thread {
    private SharedData data;

    public SyncProduce1(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            // produce
            data.syncProduce1((int) (Math.random() * 100));

            try { // sleep
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

class SyncConsumer1 extends Thread {
    private SharedData data;

    public SyncConsumer1(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            // consume
            data.syncConsume1();

            try { // sleep
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class interthreadCommunication {

    public static void main(String[] args) {
        SharedData data = new SharedData(); // shared data

        AsyncProduce asp = new AsyncProduce(data);
        AsyncConsumer asc = new AsyncConsumer(data);

        SyncProduceN spn = new SyncProduceN(data);
        SyncConsumerN scn = new SyncConsumerN(data);

        SyncConsumer1 sc1 = new SyncConsumer1(data);
        SyncProduce1 sp1 = new SyncProduce1(data);

        asp.start();
        asc.start();

        try {
            asp.join();
            asc.join();

            System.out.println("===================");
        } catch (InterruptedException e) {
        }

        spn.start();
        scn.start();

        try {
            spn.join();
            scn.join();

            System.out.println("===================");
        } catch (InterruptedException e) {
        }

        sp1.start();
        sc1.start();
    }

}
