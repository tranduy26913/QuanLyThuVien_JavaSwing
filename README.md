# Hướng dẫn cài đặt và sử dụng phần mềm Quản lý thư viện

Yêu cầu phần mềm:
- Eclipse IDE for Java Developers - 2021-06
- MySQL Workbench 8.0 CE
- Môi trường Java 8u301

Hướng dẫn cài đặt:
Phần mềm Eclipse IDE for Java Developers - 2021-06: 
https://blogchiasekienthuc.com/thu-thuat-hay/cai-dat-eclipse-tren-windows-10.html
Phần mềm MySQL Workbench 8.0 CE:
https://blogchiasekienthuc.com/thu-thuat-hay/cai-dat-mysql-workbench-tren-windows-10.html
Môi trường Java 8u301:
https://viettuts.vn/java/cai-dat-moi-truong-java

## Cài đặt Database:
Bước 1: Mở phần mềm MySQL Workbench 8.0 CE
Bước 2: Đăng nhập vào Local instance MySQL 
Bước 3: Mở File "script.sql" ở thư mục db
Bước 4: Thực thi toàn bộ code trong file script.sql
Bước 5: Refresh lại SCHEMAS, lúc này schema "Thuvien" đã xuất hiện

## Cài đặt Project
Bước 1: Mở phần mềm Eclipse
Bước 2: Import project, chọn thư mục chứa project
Bước 3: Import 2 file thư viện ngoài là jdatepicker-1.3.4.jar (hỗ trợ tạo component date time picker) và
mysql-connector-java-8.0.27.jar (Hỗ trợ driver kết nối với mysql trên máy)
	+ Chuột phải vào Project, chọn Build Path > Configure Build Path
	+ Chọn tab Libraries
	+ Chọn Add External JARs
	+ Chọn 2 thư viện ở trên
Bước 4: Cấu hình lại connection string với MySQL tại DAO/DBConnection
Bước 5: Chọn môi trường Java1.8
Bước 6: Build Project và chạy