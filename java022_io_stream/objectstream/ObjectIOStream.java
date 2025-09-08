package java022_io_stream.objectstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// ObjectInputStream extends FilteredInputStream -> đọc Object từ File/stream
// ObjectOutputStream extends FilteredOutputStream -> ghi Object into
// File/stream.

// là bản nâng cấp hơn của DataStream
// ObjectStream có HẦU HẾT các methods của DataOutputStream 
// các method thêm:
// - readObject() / writeObject(obj)

// - defaultRead/WriteObject()
// - putFields() / writeFields()

// - reset() -> cho ObjectOutputStream -> xóa các Object đã cache trước đó


// chu trình ghi Object:
// Object ----(serialization)----> Stream of Bytes -----> File/DB/Memory

// chu trình đọc Object:
// File/DB/Memory ----> Stream of Bytes ----(deserialization)----> Object

// class that defines object must implement 
// java.io.Serializable
class MyObj implements Serializable {

    // có thể thêm serialVersionUID cho class để đảm bảo version phù hợp
    // private static final long serialVersionUID = 1L; // verson 1, 2, 3, ...
    int data;

    // use "Transient" keyword cho field để khi tuần tự hóa sẽ bỏ qua field đó
    // khi khởi tạo -> giá trị mặc định của kiểu dữ liệu
    // khi nào dùng ? -> nhạy cảm, bí mật // tạm thời, không cần lưu
    transient int hiddenData;

    // nếu có field là object thì object đó cũng cần phải implements Serializable!

    public MyObj(int data, int hiddenData) {
        this.data = data;
        this.hiddenData = hiddenData;
    }

    @Override
    public String toString() {
        return "MyObj {\n\tdata: " + this.data +
                ",\n\thiddenData: " + this.hiddenData +
                "\n}";
    }
}

public class ObjectIOStream {
    public static void main(String[] args) {
        try (
                ObjectOutputStream dout = new ObjectOutputStream(
                        new FileOutputStream("java022_io_stream/objectstream/data.dat"));
                ObjectInputStream din = new ObjectInputStream(
                        new FileInputStream("java022_io_stream/objectstream/data.dat"));
        //
        ) {
            MyObj obj = new MyObj(13, 03);

            // use writeObject() to write an object to stream/file
            dout.writeObject(obj); // hiddenData willnot be save
            System.out.println("Write object into data.dat:");
            System.out.println(obj);

            System.out.println("\n--------------------");
            // use readObject() to read an object from stream/file
            MyObj obj2 = (MyObj) din.readObject(); // type cast
                                                   // throw ClassNotFoundException
            System.out.println("Read object from data.dat:");
            System.out.println(obj2);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("\n--------------------");
        System.out.println("#vduczz");
    }

}
