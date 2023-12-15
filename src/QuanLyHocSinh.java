import java.util.ArrayList;
import java.util.List;

public class QuanLyHocSinh {
    private List<HocSinh> danhSachHocSinh;

    public QuanLyHocSinh() {
        danhSachHocSinh = new ArrayList<>();
    }

    // Thêm học sinh vào danh sách
    public void themHocSinh(HocSinh hocSinh) {
        danhSachHocSinh.add(hocSinh);
    }

    // Tìm kiếm học sinh theo mã học sinh
    public HocSinh timKiemHocSinhTheoMa(int maHocSinh) {
        for (HocSinh hs : danhSachHocSinh) {
            if (hs.getMahs() == maHocSinh) {
                return hs; // Học sinh được tìm thấy
            }
        }
        return null; // Không tìm thấy học sinh
    }

    // Sửa thông tin học sinh
    public boolean suaThongTinHocSinh(int maHocSinh, HocSinh hocSinhMoi) {
        for (int i = 0; i < danhSachHocSinh.size(); i++) {
            if (danhSachHocSinh.get(i).getMahs() == maHocSinh) {
                // Sửa thông tin học sinh
                danhSachHocSinh.set(i, hocSinhMoi);
                return true; // Sửa thành công
            }
        }
        return false; // Không tìm thấy học sinh cần sửa
    }

    public static void main(String[] args) {
        // Tạo đối tượng QuanLyHocSinh
        QuanLyHocSinh quanLy = new QuanLyHocSinh();

        // Thêm một số học sinh vào danh sách
        quanLy.themHocSinh(new HocSinh(1, "Nguyen Van A", "10A", 8.5, 16, "Hanoi"));
        quanLy.themHocSinh(new HocSinh(2, "Tran Thi B", "10B", 7.9, 15, "Hanoi"));
        quanLy.themHocSinh(new HocSinh(3, "Le Van C", "10C", 9.2, 17, "Hanoi"));

        // Tìm kiếm học sinh theo mã học sinh
        int maCanTim = 2;
        HocSinh hocSinhTimThay = quanLy.timKiemHocSinhTheoMa(maCanTim);

        if (hocSinhTimThay != null) {
            System.out.println("Thông tin học sinh có mã " + maCanTim + ":");
            System.out.println(hocSinhTimThay);
        } else {
            System.out.println("Không tìm thấy học sinh có mã " + maCanTim);
        }

        // Sửa thông tin học sinh có mã 2
        int maCanSua = 2;
        HocSinh hocSinhMoi = new HocSinh(2, "Tran Thi D", "10D", 8.0, 16, "Hanoi");
        boolean ketQuaSua = quanLy.suaThongTinHocSinh(maCanSua, hocSinhMoi);

        // Hiển thị thông tin sau khi sửa
        System.out.println("\nDanh sách học sinh sau khi sửa:");
        for (HocSinh hs : quanLy.danhSachHocSinh) {
            System.out.println(hs);
        }

        if (ketQuaSua) {
            System.out.println("\nSửa thông tin thành công!");
        } else {
            System.out.println("\nKhông tìm thấy học sinh cần sửa!");
        }
    }
}
