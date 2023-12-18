package src;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;




public class QuanLyHocSinh {

//    private static final String FILE_PATH = "D:\\file.xlsx";

    private static List<HocSinh> danhSachHocSinh;

    public QuanLyHocSinh() {
        danhSachHocSinh = new ArrayList<>();
    }

    public boolean themHocSinh(HocSinh hocSinh) {
        // Kiểm tra xem mã học sinh đã tồn tại trong danh sách chưa
        if (!kiemTraTonTaiMaHocSinh(hocSinh.getMahs())) {
            danhSachHocSinh.add(hocSinh);
            return true; // Thêm học sinh thành công
        } else {
            return false; // Mã học sinh đã tồn tại, không thể thêm
        }
    }

    // Phương thức kiểm tra xem mã học sinh đã tồn tại trong danh sách chưa
    private boolean kiemTraTonTaiMaHocSinh(int maHocSinh) {
        for (HocSinh hs : danhSachHocSinh) {
            if (hs.getMahs() == (maHocSinh)) {
                return true; // Mã học sinh đã tồn tại
            }
        }
        return false; // Mã học sinh chưa tồn tại
    }


    public void sapXepHocSinhTheoDiem() {
        Collections.sort(danhSachHocSinh, (hs1, hs2) -> hs1.getDiem().compareTo(hs2.getDiem()));
    }

    public void hienThiDanhSachHocSinh() {
        for (HocSinh hs : danhSachHocSinh) {
            System.out.println(hs);
        }
    }

    public HocSinh timKiemHocSinhTheoMa(int maHocSinh) {
        for (HocSinh hs : danhSachHocSinh) {
            if (hs.getMahs() == maHocSinh) {
                return hs; // Học sinh được tìm thấy
            }
        }
        return null;
    }

    public boolean suaThongTinHocSinh(int maHocSinh, HocSinh hocSinhMoi) {
        for (int i = 0; i < danhSachHocSinh.size(); i++) {
            if (danhSachHocSinh.get(i).getMahs() == maHocSinh) {
                // Sửa thông tin học sinh
                danhSachHocSinh.set(i, hocSinhMoi);
                return true; // Sửa thành công
            }
        }
        return false;
    }

//    public static List<HocSinh> readDataFromExcel() {
//        List<HocSinh> hocSinhs = new ArrayList<>();
//
//        try (FileInputStream fis = new FileInputStream(new File(FILE_PATH));
//             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {



 
    public boolean xoahocsinh(int mahsToDelete) {
        Iterator<HocSinh> iterator = danhSachHocSinh.iterator();

        while (iterator.hasNext()) {
            HocSinh hocSinh = iterator.next();

            if (hocSinh.getMahs() == mahsToDelete) {
                iterator.remove(); // Xóa HocSinh có ID cụ thể
               
               return true; 
            }
        }
		return false;
    }
	    public void deleteUserInput() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Nhập mã học sinh để xóa: ");
	        if (scanner.hasNextInt()) {
	            int mahsToDelete = scanner.nextInt();
	            xoahocsinh(mahsToDelete);
	        } else {
	            System.out.println("Đầu vào không hợp lệ. Vui lòng nhập một mã học sinh hợp lệ (giá trị số).");
	        }

	        scanner.close();
	    }
 }

