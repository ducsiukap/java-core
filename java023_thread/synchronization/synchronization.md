### **Vấn đề `Đồng bộ` - `Thread Synchronization`**

Trong `multithreading` có 1 vấn đề lớn là `safely work on shared resource` => Nhiều luồng cùng truy cập và sửa đổi biến/bộ nhớ dùng chung

- Tranh chấp tài nguyên ?
- Dữ liệu không nhất quán ?
- Nhiều trường hợp cần `giao tiếp` giữa các Thread để _`hiểu`_ trạng thái và hoạt động của nhau.

=> `syschronization` là 1 `mechanism` đảm bảo rằng tại 1 thời điểm chỉ 1 luồng được sử dụng tài nguyên!  
Có 2 cách để đạt được đồng bộ hóa:

- `Mutual Exclusion - MulEx`
  - keyword: `synchronized` // `method`, `block`, `static`
  - Ngoài ra, nên đọc thêm về [**`ReentrantLock`**](https://www.geeksforgeeks.org/java/reentrant-lock-in-java/)
- `Inter-Thread Communication` // giao tiếp giữa các thread.

