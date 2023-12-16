import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuanLyHocSinh {
    private List<HocSinh> danhSachHocSinh;

    public QuanLyHocSinh() {
        danhSachHocSinh = new ArrayList<>();
    }

    public void themHocSinh(HocSinh hocSinh) {
        danhSachHocSinh.add(hocSinh);
    }

    // Bug introduced here: reversed comparison in the sorting logic
    public void sapXepHocSinhTheoDiem() {
        Collections.sort(danhSachHocSinh, (hs1, hs2) -> hs1.getDiem().compareTo(hs2.getDiem()));
    }

    public void hienThiDanhSachHocSinh() {
        for (HocSinh hs : danhSachHocSinh) {
            System.out.println(hs);
        }
    }

    public static void main(String[] args) {
        QuanLyHocSinh quanLyHocSinh = new QuanLyHocSinh();

        // Thêm học sinh
        quanLyHocSinh.themHocSinh(new HocSinh(1, "Nguyen Van A", "10A", 8.5, 15, "Ha Noi"));
        quanLyHocSinh.themHocSinh(new HocSinh(2, "Tran Thi B", "10B", 9.0, 16, "Ho Chi Minh"));
        quanLyHocSinh.themHocSinh(new HocSinh(3, "Le Van C", "10C", 7.8, 15, "Da Nang"));

        // Hiển thị danh sách trước khi sắp xếp
        System.out.println("Danh sach truoc khi sap xep:");
        quanLyHocSinh.hienThiDanhSachHocSinh();

        // Sắp xếp học sinh theo điểm - Bug introduced here
        quanLyHocSinh.sapXepHocSinhTheoDiem();

        // Hiển thị danh sách sau khi sắp xếp
        System.out.println("\nDanh sach sau khi sap xep:");
        quanLyHocSinh.hienThiDanhSachHocSinh();
    }
}
