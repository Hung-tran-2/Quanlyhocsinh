import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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



public class QuanLyHocSinh {

//    private static final String FILE_PATH = "D:\\file.xlsx";

    private static List<HocSinh> danhSachHocSinh;

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

//    public static List<HocSinh> readDataFromExcel() {
//        List<HocSinh> hocSinhs = new ArrayList<>();
//
//        try (FileInputStream fis = new FileInputStream(new File(FILE_PATH));
//             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheet("DanhSachHocSinh");
//            Iterator<Row> rowIterator = sheet.iterator();
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
//    public static void ghiFileExcel(List<HocSinh> danhSachHocSinh, String filePath) {
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("DanhSachHocSinh");
//
//        // Tạo hàng tiêu đề
//        Row headerRow = sheet.createRow(0);
//        headerRow.createCell(0).setCellValue("Mã HS");
//        headerRow.createCell(1).setCellValue("Tên sinh");
//        headerRow.createCell(2).setCellValue("Lớp");
//        headerRow.createCell(3).setCellValue("Điểm");
//        headerRow.createCell(4).setCellValue("Tuổi");
//        headerRow.createCell(5).setCellValue("Địa chỉ");
//
//        // Ghi dữ liệu từ danh sách vào tệp Excel
//        int rowNum = 1;
//        for (HocSinh hocSinh : danhSachHocSinh) {
//            Row dataRow = sheet.createRow(rowNum++);
//            dataRow.createCell(0).setCellValue(hocSinh.getMahs());
//            dataRow.createCell(1).setCellValue(hocSinh.getTensinh());
//            dataRow.createCell(2).setCellValue(hocSinh.getLop());
//            dataRow.createCell(3).setCellValue(hocSinh.getDiem());
//            dataRow.createCell(4).setCellValue(hocSinh.getTuoi());
//            dataRow.createCell(5).setCellValue(hocSinh.getDiachi());
//        }
//
//        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
//            workbook.write(fileOut);
//            System.out.println("Đã ghi dữ liệu vào tệp Excel thành công!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                workbook.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
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
    public List<HocSinh> getDanhSachHocSinh() {
        return danhSachHocSinh;
    }

    public void setDanhSachHocSinh(List<HocSinh> danhSachHocSinh) {
        this.danhSachHocSinh = danhSachHocSinh;
    }

    
}