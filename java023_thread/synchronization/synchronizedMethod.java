package java023_thread.synchronization;

class SynchronizedSender {
    private String[] messages;

    public SynchronizedSender(String... messages) {
        this.messages = messages;
    }

    // synchronized method
    // khóa toàn bộ method
    // chạy tuần tự
    // tức là các Thread sử dụng method này
    // và các Thread sử dụng synchronized method khác của object này
    // đều phải chờ
    synchronized public void fullSynchronizedSend() {
        System.out.println(Thread.currentThread().getName() + " sent message: ");
        for (String message : messages)
            System.out.println(message);
    }

    // các thread sử dụng method khác không synchronized vẫn chạy bình thường
    public void threadSayHello() {
        for (int i = 0; i < 5; ++i)
            System.out.println(Thread.currentThread().getName() + " say hello!");
    }
}

class FullySynchronizedSender extends Thread {
    private SynchronizedSender sender;
    // synchronized : tao cầm object này thì mày phải đợi tao dùng xong

    public FullySynchronizedSender(SynchronizedSender sender) {
        this.sender = sender;
    }

    @Override
    public void run() {
        sender.fullSynchronizedSend();
    }
}

class UnsynchronizedThread extends Thread {
    private SynchronizedSender sender;

    public UnsynchronizedThread(SynchronizedSender sender) {
        this.sender = sender;
    }

    @Override
    public void run() {
        sender.threadSayHello();
    }
}

public class synchronizedMethod {

    public static void main(String[] args) {

        SynchronizedSender sender = new SynchronizedSender("message-1", "message-2", "message-3");

        // fully synchronized
        FullySynchronizedSender sender1 = new FullySynchronizedSender(sender);
        FullySynchronizedSender sender2 = new FullySynchronizedSender(sender);
        FullySynchronizedSender sender3 = new FullySynchronizedSender(sender);

        // unsynchronized
        UnsynchronizedThread sender4 = new UnsynchronizedThread(sender);
        UnsynchronizedThread sender5 = new UnsynchronizedThread(sender);

        // khi một trong các thread này chạy
        // các thread khác phải chờ
        sender1.start();
        sender2.start();
        sender3.start();
        // không bị ảnh hưởng bởi synchronized
        sender4.start();
        sender5.start();

        // sample output:
        // Thread-3 say hello!
        // Thread-4 say hello!
        // Thread-0 sent message:
        // message-1
        // message-2
        // message-3
        // Thread-4 say hello!
        // Thread-4 say hello!
        // Thread-3 say hello!
        // Thread-4 say hello!
        // Thread-1 sent message:
        // message-1
        // message-2
        // message-3
        // Thread-4 say hello!
        // Thread-3 say hello!
        // Thread-3 say hello!
        // Thread-2 sent message:
        // Thread-3 say hello!
        // message-1
        // message-2
        // message-3

        // => sender 4 (unsynchronized) vẫn thực hiện khi sender3 (synchronized) đang
        // thực hiện

        // khi 1 trong sender: sender1, sender2, sender3 thực hiện
        // thì nó sẽ thực hiện đến hết rồi mới cho 2 sender còn lại thực hiện

        // => sender 4, 5 và 1 trong 3 sender (1, 2, 3) thực hiện song song

    }

}
