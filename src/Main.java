import java.util.Scanner;

//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.CreationHelper;
//import org.apache.poi.ss.usermodel.Font;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
public class Main {
    public static void main(String[] args) {
        QuanLyHocSinh quanLyHocSinh = new QuanLyHocSinh();
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 20; i++) {
            int mahs = i;
            String tensinh = "HocSinh " + i;
            String lop = "Lop " + (i % 5 + 1); // Assigning students to 5 different classes
            Double diem = Math.round(Math.random() * 100.0) / 10.0; // Rounded to one decimal place
            int tuoi = 15 + i; // Assuming students have ages ranging from 15 to 34
            String diachi = "DiaChi " + i;

            HocSinh hocSinh = new HocSinh(mahs, tensinh, lop, diem, tuoi, diachi);
            quanLyHocSinh.themHocSinh(hocSinh);
        }

        while (true) {
            System.out.println("------ MENU ------");
            System.out.println("1. Thêm học sinh");
            System.out.println("2. Sắp xếp học sinh theo điểm");
            System.out.println("3. Hiển thị danh sách học sinh");
            System.out.println("4. Tìm kiếm học sinh theo mã");
            System.out.println("5. Sửa thông tin học sinh");
            System.out.println("6. xóa học sinh");
//            System.out.println("7. ghi xuống file excel");
//            System.out.println("8. đọc file excel");
            System.out.println("0. Thoát");

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
                    quanLyHocSinh.themHocSinh(hocSinh);
                    System.out.println("Thêm học sinh thành công!");
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
                    System.out.print("Nhập mã học sinh cần xóa: ");
                    int maCanXoa = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    boolean xoaThanhCong = quanLyHocSinh.xoaHocSinh(maCanXoa);
                    if (xoaThanhCong) {
                        System.out.println("Xóa học sinh thành công!");
                    } else {
                        System.out.println("Không tìm thấy học sinh có mã " + maCanXoa);
                    }
                    break;   
//                case 7:
//                    System.out.print("Nhập đường dẫn tới tệp Excel để ghi: ");
//                    String filePathGhi = scanner.next();
//                    quanLyHocSinh.ghiFileExcel(quanLyHocSinh.getDanhSachHocSinh(), filePathGhi);
//                    System.out.println("Đã ghi xuống file Excel thành công!");
//                    break;
//                case 8:
                    // Đọc từ file Excel
//                    System.out.print("Nhập đường dẫn tới tệp Excel để đọc: ");
//                    String filePathDoc = scanner.next();
//                    quanLyHocSinh.setDanhSachHocSinh(QuanLyHocSinh.readDataFromExcel(filePathDoc));
//                    System.out.println("Đã đọc từ file Excel thành công!");
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
