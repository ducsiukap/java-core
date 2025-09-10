package java023_thread.synchronization;

class Sender1 extends Thread {
    String[] messages;

    public Sender1(String... message) {
        this.messages = message;
    }

    // run()
    @Override
    public void run() {
        for (String message : messages) {
            System.out.println(Thread.currentThread().getName() + " sent message: " + message);
        }
    }
}

public class unsynchronized {

    public static void main(String[] args) {
        Sender1 sender1 = new Sender1("one", "two", "three");
        Sender1 sender2 = new Sender1("four", "five", "six", "seven");
        Sender1 sender3 = new Sender1("eight", "night", "ten");

        sender1.start();
        sender2.start();
        sender3.start();
        // expected:
        // khi 1 thread gửi message, nó phải thực hiện gửi toàn bộ message.
        // ex:
        // Thread-1 sent message: four
        // Thread-1 sent message: five
        // Thread-1 sent message: six
        // Thread-1 sent message: seven
        // Thread-0 sent message: one
        // Thread-0 sent message: two
        // Thread-0 sent message: three
        // Thread-2 sent message: eight
        // Thread-2 sent message: night
        // Thread-2 sent message: ten

        // wait, what?
        // check the output
        // output canbe
        // Thread-1 sent message: four
        // Thread-0 sent message: one
        // Thread-2 sent message: eight
        // Thread-2 sent message: night
        // Thread-0 sent message: two
        // Thread-1 sent message: five
        // Thread-1 sent message: six
        // Thread-0 sent message: three
        // Thread-2 sent message: ten
        // Thread-1 sent message: seven

        // => unsynchronization
    }
}
