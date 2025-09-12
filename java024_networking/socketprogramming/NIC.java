package java024_networking.socketprogramming;

import java.net.InetAddress;

// MAC - Media Access Control address (địa chỉ điều khiển truy cập môi trường) 
// -> là physical address gán cho mỗi NIC, dùng để nhận diện thiết bị trong LAN (mạng cục bộ)
// -> sử dụng ở Layer 2 : Data Link (tầng liên kết)
// IP - địa chỉ logic, dùng để định vị thiết bị/vùng LAN của thiết bị trên Internet
// -> logic address, sử dụng ở layer 3 Network.

// Tại sao không dùng mỗi IP để định danh thiết bị mà cần MAC
// tại 1 thời điểm, mỗi thiết bị trong LAN sẽ có 1 IP riêng biệt -> OK
// - nhưng thiết bị đó rời đi và kết nối lại LAN -> IP bị đổi -> không biết gửi đi đâu
// => dùng MAC : địa chỉ vật lý luôn cố định, 
// chỉ cần hỏi Router LAN (tra ARP table): MAC nào ứng với IP -> MAC đích
// switch dùng MAC đích để gửi gói tin (thay vì broatcast gói tin qua IP -> tốn băng thông, chậm)

// Tóm lại:
// IP để xác định LAN và MAC đích (broatcast qua LAN Router -> tra ARP table)
// MAC được Switch dùng để gửi gói tin tới đúng chỗ (tránh broatcast gói tin khắp LAN) -> giảm băng thông, tăng tốc độ

// -----------------
// NIC - Network Interface Card (Giao tiếp mạng): điểm liên kết giữa máy tính với mạng (public/private network)
// NIC có thể là:
//  - giao tiếp mạng vật lý -> NIC phần cứng thật, gắn trong mainboard, MAC address thật từ nhà sản xuất.
//  - giao tiếp mạng phần mềm, ảo -> Không có phần cứng riêng, kết nối application, container, VM với mạng thật.
//                                  // cũng có MAC address do phần mềm tạo

// NetworkInterface hỗ trợ cả 2 loại giao tiếp trên
// hữu ích với hệ thống nhiều NIC -> chọn cụ thể NIC nào sẽ thực hiện 1 hoạt động mạng cụ thể.

import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class NIC {
    public static void main(String[] args) {
        // method:

        // static method:
        // static NetworkInterface getByName(String name) throws SocketException
        // -> get NIC by name

        // static NetworkInterface getByIndex(int index)
        // -> get NIC by index (system)

        // static NetworkInterface getByInetAddress(InetAddress addr)
        // -> get by IP

        // static Enumeration<NetworkInterface> getNetworkInterfaces()
        // -> get all NIC
        try {
            InetAddress localhost = InetAddress.getByName("localhost"); // UnknownHostException
            NetworkInterface nic = NetworkInterface.getByInetAddress(localhost); // SocketException
            if (nic == null) {
                System.out.println("No such network interface: localhost");
            } else
                System.out.println(nic);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        // get NIC infor
        // String getName() -> system name, getDisplayName() -> displayname
        // byte[] getHardwareAddress() -> MAC
        // Enumeration<InetAddress> getInetAddresses() -> lấy danh sách IP gán trên NIC
        // Enumeration<NetworkInterface> getSubInterfaces() -> lấy sub-interface nếu có
        // NetworkInterface getParent() -> nếu là sub-interface
        try {
            Enumeration<NetworkInterface> nics = NetworkInterface.getNetworkInterfaces();

            while (nics.hasMoreElements()) {
                System.out.println("==================");

                NetworkInterface nic = (NetworkInterface) nics.nextElement();
                System.out.println("name: " + nic.getName() + ", display name: " + nic.getDisplayName());
                System.out.println("MAC: " + nic.getHardwareAddress());

                // get IP list on NIC
                Enumeration<InetAddress> IPs = nic.getInetAddresses();
                System.out.println("IP list");
                while (IPs.hasMoreElements()) {
                    System.out.println(IPs.nextElement());
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        // other methods:
        // isUp() -> NIC is active?
        // isLoopback() -> NIC is localhost
        // isPointToPoint()
        // isVirtual() -> NIC ảo hay vật lý
        // supportMulticast() -> suport multicast ?
        // int getMTU() -> kích thước gói tối đa / Maximum Transfer Unit
    }
}
