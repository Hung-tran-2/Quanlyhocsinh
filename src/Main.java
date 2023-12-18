import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLyHocSinh quanLyHocSinh = new QuanLyHocSinh();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------ MENU ------");
            System.out.println("1. Thêm học sinh");
            System.out.println("2. Sắp xếp học sinh theo điểm");
            System.out.println("3. Hiển thị danh sách học sinh");
            System.out.println("4. Tìm kiếm học sinh theo mã");
            System.out.println("5. Sửa thông tin học sinh");
            System.out.println("6. xóa học sinh");

            System.out.println("0. Thoát chương trình");

            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();

            switch (choice) {
            case 1:
                // Thêm học sinh
                System.out.print("Nhập mã học sinh: ");
                int maHocSinh = scanner.nextInt();
                System.out.print("Nhập tên học sinh: ");
                String tenHocSinh = scanner.next();
                System.out.print("Nhập lớp học: ");
                String lop = scanner.next();
                System.out.print("Nhập điểm học sinh: ");
                double diem = scanner.nextDouble();
                System.out.print("Nhập tuổi học sinh: ");
                int tuoi = scanner.nextInt();
                System.out.print("Nhập địa chỉ học sinh: ");
                String diaChi = scanner.next();

                HocSinh hocSinh = new HocSinh(maHocSinh, tenHocSinh, lop, diem, tuoi, diaChi);

                // Thực hiện thêm học sinh và kiểm tra kết quả
                if (quanLyHocSinh.themHocSinh(hocSinh)) {
                    System.out.println("Thêm học sinh thành công!");
                } else {
                    System.out.println("Mã học sinh đã tồn tại, không thể thêm!");
                }
                break;

                case 2:
                    // Sắp xếp học sinh theo điểm
                    quanLyHocSinh.sapXepHocSinhTheoDiem();
                    System.out.println("Đã sắp xếp danh sách học sinh theo điểm.");
                    break;

                case 3:
                    // Hiển thị danh sách học sinh
                    quanLyHocSinh.hienThiDanhSachHocSinh();
                    break;

                case 4:
                    // Tìm kiếm học sinh theo mã
                    System.out.print("Nhập mã học sinh cần tìm: ");
                    int maCanTim = scanner.nextInt();
                    HocSinh timThay = quanLyHocSinh.timKiemHocSinhTheoMa(maCanTim);
                    if (timThay != null) {
                        System.out.println("Học sinh có mã " + maCanTim + ":\n" + timThay);
                    } else {
                        System.out.println("Không tìm thấy học sinh có mã " + maCanTim);
                    }
                    break;

                case 5:
                    // Sửa thông tin học sinh
                    System.out.print("Nhập mã học sinh cần sửa: ");
                    int maCanSua = scanner.nextInt();
                    HocSinh hocSinhMoi = new HocSinh();
                    System.out.print("Nhập tên mới: ");
                    hocSinhMoi.setTensinh(scanner.next());
                    System.out.print("Nhập lớp mới: ");
                    hocSinhMoi.setLop(scanner.next());
                    System.out.print("Nhập điểm mới: ");
                    hocSinhMoi.setDiem(scanner.nextDouble());
                    System.out.print("Nhập tuổi mới: ");
                    hocSinhMoi.setTuoi(scanner.nextInt());
                    System.out.print("Nhập địa chỉ mới: ");
                    hocSinhMoi.setDiachi(scanner.next());

                    boolean suaThanhCong = quanLyHocSinh.suaThongTinHocSinh(maCanSua, hocSinhMoi);
                    if (suaThanhCong) {
                        System.out.println("Sửa thông tin thành công!");
                    } else {
                        System.out.println("Không tìm thấy học sinh có mã " + maCanSua);
                    }
                    break;
                  
                case 6:
                    int maCanXoa = 0;  // Khởi tạo biến để lưu mã học sinh cần xóa
                    
                    // Sử dụng vòng lặp để đảm bảo người dùng nhập vào một số nguyên
                    while (true) {
                        System.out.print("Nhập mã học sinh cần xóa: ");
                        
                        // Kiểm tra xem người dùng đã nhập một số nguyên chưa
                        if (scanner.hasNextInt()) {
                            maCanXoa = scanner.nextInt();
                            break;  // Thoát khỏi vòng lặp nếu đã nhập đúng kiểu dữ liệu
                        } else {
                            System.out.println("Vui lòng nhập một số nguyên.");
                            scanner.nextLine();  // Loại bỏ đầu vào không hợp lệ
                        }
                    }
                    
                    // Consume the newline character
                    scanner.nextLine();

                    boolean xoaThanhCong = quanLyHocSinh.xoahocsinh(maCanXoa);
                    if (xoaThanhCong) {
                        System.out.println("Xóa học sinh thành công!");
                    } else {
                        System.out.println("Không tìm thấy học sinh có mã " + maCanXoa);
                    }
                    break;

//                case 7:
//                    // Read data from Excel
//                    List<HocSinh> excelData = readDataFromExcel();
//                    quanLyHocSinh.setDanhSachHocSinh(excelData);
//                    System.out.println("Đã đọc dữ liệu từ tệp Excel.");
//                    break;
//
//                case 8:
//                    // Write data to Excel
//                    List<HocSinh> currentData = quanLyHocSinh.getDanhSachHocSinh();
//                    writeDataToExcel(currentData);
//                    System.out.println("Đã ghi dữ liệu vào tệp Excel.");
//                    break;           
                case 0:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
