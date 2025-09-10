package java023_thread.synchronization;

// tương tự synchronized method
// synchronized object khóa object cho tới khi thread thực hiện xong (ảnh hưởng tất cả các Thread khác có thao tác với object)
class MyObjectX {
    public int data;

    public MyObjectX(int data) {
        this.data = data;
    }
} // sample object

class MyClassX {
    private MyObjectX sharedObj;
    private int unsharedObj;

    public MyClassX(MyObjectX sharedObj, int unsharedObj) {
        this.sharedObj = sharedObj;
        this.unsharedObj = unsharedObj;
    }

    // using shared object:
    public void useSharedObject() {
        // phần này không bị block
        // các thread đi vào vẫn có thể thực hiện phần này
        System.out.println(Thread.currentThread().getName() + " want to lock SHARED OBJECT.");

        // phần này bị block
        synchronized (sharedObj) {
            System.out.println(Thread.currentThread().getName() + " lock SHARED OBJECT, value: " + this.sharedObj.data);
            for (int i = 0; i < 3; ++i)
                System.out.println(Thread.currentThread().getName() + " processing on SHARED OBJECT");
            System.out
                    .println(Thread.currentThread().getName() + " unlock SHARED OBJECT, value: " + this.sharedObj.data);
        }
    }

    public void readSharedObject() {
        for (int i = 0; i < 3; ++i)
            System.out.println(Thread.currentThread().getName() + " read SHARED OBJECT, value: " + this.sharedObj.data);
    }

    public void useUnsharedObject() {
        for (int i = 0; i < 3; ++i)
            System.out.println(
                    Thread.currentThread().getName() + " processing on UNSHARED OBJECT, value: " + this.unsharedObj);
    }
}

// processing shared
class MyThreadX1 extends Thread {
    private MyClassX obj;

    public MyThreadX1(MyClassX obj, String name) {
        this.obj = obj;
        this.setName(name);
    }

    @Override
    public void run() {
        obj.useSharedObject();
    }
}

// read shared
class MyThreadX2 extends Thread {
    private MyClassX obj;

    public MyThreadX2(MyClassX obj, String name) {
        this.obj = obj;
        this.setName(name);
    }

    @Override
    public void run() {
        obj.readSharedObject();
    }
}

// processing unshared
class MyThreadX3 extends Thread {
    private MyClassX obj;

    public MyThreadX3(MyClassX obj, String name) {
        this.obj = obj;
        this.setName(name);
    }

    @Override
    public void run() {
        obj.useUnsharedObject();
    }
}

public class synchronizedObject {
    public static void main(String[] args) {
        // object
        MyClassX object = new MyClassX(new MyObjectX(30), 10);

        MyThreadX1 t1 = new MyThreadX1(object, "T1");
        MyThreadX1 t2 = new MyThreadX1(object, "T2");

        MyThreadX2 t3 = new MyThreadX2(object, "T3");
        MyThreadX2 t4 = new MyThreadX2(object, "T4");

        MyThreadX3 t5 = new MyThreadX3(object, "T5");
        MyThreadX3 t6 = new MyThreadX3(object, "T6");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

        // sample output
        // T1 want to lock SHARED OBJECT.
        // T2 want to lock SHARED OBJECT.
        // T5 processing on UNSHARED OBJECT, value: 10
        // T4 read SHARED OBJECT, value: 30
        // T3 read SHARED OBJECT, value: 30
        // T6 processing on UNSHARED OBJECT, value: 10
        // T3 read SHARED OBJECT, value: 30
        // T4 read SHARED OBJECT, value: 30
        // T4 read SHARED OBJECT, value: 30
        // T1 lock SHARED OBJECT, value: 30
        // T5 processing on UNSHARED OBJECT, value: 10
        // T1 processing on SHARED OBJECT
        // T1 processing on SHARED OBJECT
        // T1 processing on SHARED OBJECT
        // T3 read SHARED OBJECT, value: 30
        // T6 processing on UNSHARED OBJECT, value: 10
        // T1 unlock SHARED OBJECT, value: 30
        // T5 processing on UNSHARED OBJECT, value: 10
        // T2 lock SHARED OBJECT, value: 30
        // T6 processing on UNSHARED OBJECT, value: 10
        // T2 processing on SHARED OBJECT
        // T2 processing on SHARED OBJECT
        // T2 processing on SHARED OBJECT
        // T2 unlock SHARED OBJECT, value: 30

        // có thể thấy
        // T1 đến trước và LOCK object đối với T2

        // Khi T1 LOCK shared obj -> T2 phải chờ
        // T3, T4 đều xử lý trên shared object
        // nhưng không phải trong khối `synchronized (Object)` nên vẫn thực hiện được
        // T5, T6 không sử dụng shared object => vẫn chạy bình thường

        // Khi T1 UNLOCK thì T2 mới thực hiện tiếp được

        // synchronized (X) -> chỉ ảnh hưởng tới
        // các Thread khác mà hàm run() của nó cũng có synchronized (X)
        // còn các Thread sử dụng Object khác hoặc Thread sử dụng X nhưng hàm run của nó
        // không có synchronized(X) thì vẫn chạy bình thường

        // tóm lại:
        // synchronized method ảnh hưởng tới các synchronized method khác của
        // cùng instance => ảnh hưởng theo instance (khác instance thì không phải chờ)

        // synchronized (object) ảnh hưởng tới chỗ khác có synchronized (object) ?

        // static synchronized method ảnh hưởng tới tất cả các
        // static synchronized method khác của class,
        // kể cả khác instance (khác instance vẫn phải chờ)
    }

}
