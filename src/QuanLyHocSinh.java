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

    public static void main(String[] args) {
        QuanLyHocSinh quanLy = new QuanLyHocSinh();

        quanLy.themHocSinh(new HocSinh(1, "Nguyen Van A", "10A", 8.5, 16, "Hanoi"));
        quanLy.themHocSinh(new HocSinh(2, "Tran Thi B", "10B", 7.9, 15, "Hanoi"));
        quanLy.themHocSinh(new HocSinh(3, "Le Van C", "10C", 9.2, 17, "Hanoi"));

        int maCanTim = 2;
        HocSinh hocSinhTimThay = quanLy.timKiemHocSinhTheoMa(maCanTim);

        if (hocSinhTimThay != null) {
            System.out.println("Thông tin học sinh có mã " + maCanTim + ":");
            System.out.println(hocSinhTimThay);
        } else {
            System.out.println("Không tìm thấy học sinh có mã " + maCanTim);
        }

        int maCanSua = 2;
        HocSinh hocSinhMoi = new HocSinh(2, "Tran Thi D", "10D", 8.0, 16, "Hanoi");
        boolean ketQuaSua = quanLy.suaThongTinHocSinh(maCanSua, hocSinhMoi);

        System.out.println("\nDanh sách học sinh sau khi sửa:");
        quanLy.hienThiDanhSachHocSinh();

        if (ketQuaSua) {
            System.out.println("\nSửa thông tin thành công!");
        } else {
            System.out.println("\nKhông tìm thấy học sinh cần sửa!");
        }
    }
}
