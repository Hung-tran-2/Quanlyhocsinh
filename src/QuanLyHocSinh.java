import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QuanLyHocSinh {

    private static final String FILE_PATH = "path/to/your/file.xlsx";

    private List<HocSinh> danhSachHocSinh;

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
//
//            // Assuming you have only one sheet in the workbook
//            Iterator<Row> rowIterator = workbook.getSheetAt(0).iterator();
//
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//                Iterator<Cell> cellIterator = row.cellIterator();
//
//                int mahs = (int) cellIterator.next().getNumericCellValue();
//                String tensinh = cellIterator.next().getStringCellValue();
//                String lop = cellIterator.next().getStringCellValue();
//                double diem = cellIterator.next().getNumericCellValue();
//                int tuoi = (int) cellIterator.next().getNumericCellValue();
//                String diachi = cellIterator.next().getStringCellValue();
//
//                HocSinh hocSinh = new HocSinh(mahs, tensinh, lop, diem, tuoi, diachi);
//                hocSinhs.add(hocSinh);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return hocSinhs;
//    }
//
//    public static void writeDataToExcel(List<HocSinh> hocSinhs) {
//        try (XSSFWorkbook workbook = new XSSFWorkbook();
//             FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
//
//            // Create a sheet
//            Sheet sheet = workbook.createSheet("HocSinhData");
//
//            // Add header row
//            Row headerRow = sheet.createRow(0);
//            headerRow.createCell(0).setCellValue("Mã HS");
//            headerRow.createCell(1).setCellValue("Tên Sinh");
//            headerRow.createCell(2).setCellValue("Lớp");
//            headerRow.createCell(3).setCellValue("Điểm");
//            headerRow.createCell(4).setCellValue("Tuổi");
//            headerRow.createCell(5).setCellValue("Địa Chỉ");
//
//            // Add data rows
//            int rowNum = 1;
//            for (HocSinh hocSinh : hocSinhs) {
//                Row row = sheet.createRow(rowNum++);
//                row.createCell(0).setCellValue(hocSinh.getMahs());
//                row.createCell(1).setCellValue(hocSinh.getTensinh());
//                row.createCell(2).setCellValue(hocSinh.getLop());
//                row.createCell(3).setCellValue(hocSinh.getDiem());
//                row.createCell(4).setCellValue(hocSinh.getTuoi());
//                row.createCell(5).setCellValue(hocSinh.getDiachi());
//            }
//
//            // Write the workbook to the output stream
//            workbook.write(fos);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public boolean xoaHocSinh(int maHocSinh) {
        for (int i = 0; i < danhSachHocSinh.size(); i++) {
            if (danhSachHocSinh.get(i).getMahs() == maHocSinh) {
                danhSachHocSinh.remove(i);
                return true; // Xóa thành công
            }
        }
        return false; // Không tìm thấy học sinh có mã
    }

}