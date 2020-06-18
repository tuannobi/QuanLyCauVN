# QuanLyCauVN
1. Công nghệ sử dụng:
Các công nghệ sử dụng:
- IDE: Netbeans IDE 8.2 RC
- Hệ quản trị csdl: mySql
- Ngôn ngữ backend: Java Servlet/JSP
- Font End: HTML, CSS. Bootstrap v4, Jquery.
- Apache Maven 3.6.3 (có thể search google để trình bày thành một mục riêng giới thiệu sơ lược về Maven)
Link: https://daynhauhoc.com/t/maven-la-gi-su-dung-maven-trong-du-an-java/11518
- Hibernate 5.4 (có thể search google để trình bày thành một mục riêng giới thiệu về hibernate)

- Tomcat Web Server 9.0
2. Mô tả nghiệp vụ:
Hệ thống hoạt động với 3 loại người dùng: DRVN (quyền cao nhất), Chi cục/ Sở GTVT và nhân viên thuộc chi cục
Người dùng được quyền đăng ký tài khoản và đăng nhập vào tài khoản tương ứng.
2.1 DRVN
DRVN quản lý cầu (với full quyền)
DRVN quản lý các chi cục/ Sở giao thông vận tải, phân công cho mỗi chi cục quản lý một số cầu nhất định
DRVN được quyền xuất danh sách toàn bộ cầu
DRVN thống kê số lượng cầu theo tình trạng: rất yếu, yếu và bình thường
DRVN quản lý chủ đầu tư 
2.2 Chi cục/ Sở GTVT
Mỗi chi cục quản lý cầu đã được chỉ định bởi DRVN.
Chi cục được phép import và export dữ liệu cầu tương ứng với chi cục.
DRVN quản lý chủ đầu tư
2.3 Nhân viên thuộc chi cục
Nhân viên chỉ được phép xem danh sách cầu và chi tiết cầu tương ứng.
3. Sơ đồ Use case tổng quát:
 
4. Sơ đồ ERD:
 
5. Sử dụng mô hình MVC
MVC viết tắt Model – View- Controller. Đây là một mô hình thông dụng được dùng trong lập trình web. Mô hình chia source code thành nhiều phần riêng biệt nhau để mỗi bộ phận có thể làm việc độc lập với nhau.
5.1 Package Model
 
Model ánh xạ các lớp tương ứng với các bảng trên csdl bao gồm cả cấu trúc và các ràng buột khóa chính, khóa ngoại.
5.2 Package View
 

View nhận nhiệm vụ giao tiếp với người dùng cuối, nhận dữ liệu nhập từ người dùng để hiển thị kết quả hoặc truyền qua lớp controller để thực hiện các tác vụ tương ứng.
5.3 Package Controller

 

Controller nhận dữ liệu từ View để xử lý các yêu cầu nghiệp vụ, tính toán có thể gọi lớp Dao để xử lý các tác vụ liên quan đến csdl sau đó trả kết quả về View
5.4 Package DAO
 
Lớp Dao giao tiếp với csdl. Thực hiện các tác vụ như Thêm, Xóa, Sửa, Tìm kiếm dữ liệu trong csdl.
