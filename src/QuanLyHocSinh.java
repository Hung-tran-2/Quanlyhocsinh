	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class QuanLyHocSinh {

	    private static final String FILE_PATH = "path/to/your/file.xlsx";

	    public static List<HocSinh> readDataFromExcel() {
	        List<HocSinh> hocSinhs = new ArrayList<>();

	        try (FileInputStream fis = new FileInputStream(new File(FILE_PATH));
	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

	            // Assuming you have only one sheet in the workbook
	            Iterator<Row> rowIterator = workbook.getSheetAt(0).iterator();

	            while (rowIterator.hasNext()) {
	                Row row = rowIterator.next();
	                Iterator<Cell> cellIterator = row.cellIterator();

	                int mahs = (int) cellIterator.next().getNumericCellValue();
	                String tensinh = cellIterator.next().getStringCellValue();
	                String lop = cellIterator.next().getStringCellValue();
	                double diem = cellIterator.next().getNumericCellValue();
	                int tuoi = (int) cellIterator.next().getNumericCellValue();
	                String diachi = cellIterator.next().getStringCellValue();

	                HocSinh hocSinh = new HocSinh(mahs, tensinh, lop, diem, tuoi, diachi);
	                hocSinhs.add(hocSinh);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return hocSinhs;
	    }

	    public static void writeDataToExcel(List<HocSinh> hocSinhs) {
	        try (XSSFWorkbook workbook = new XSSFWorkbook();
	             FileOutputStream fos = new FileOutputStream(FILE_PATH)) {

	            // Create a sheet
	            var sheet = workbook.createSheet("HocSinhData");

	            // Add header row
	            Row headerRow = sheet.createRow(0);
	            headerRow.createCell(0).setCellValue("Mã HS");
	            headerRow.createCell(1).setCellValue("Tên Sinh");
	            headerRow.createCell(2).setCellValue("Lớp");
	            headerRow.createCell(3).setCellValue("Điểm");
	            headerRow.createCell(4).setCellValue("Tuổi");
	            headerRow.createCell(5).setCellValue("Địa Chỉ");

	            // Add data rows
	            int rowNum = 1;
	            for (HocSinh hocSinh : hocSinhs) {
	                Row row = sheet.createRow(rowNum++);
	                row.createCell(0).setCellValue(hocSinh.getMahs());
	                row.createCell(1).setCellValue(hocSinh.getTensinh());
	                row.createCell(2).setCellValue(hocSinh.getLop());
	                row.createCell(3).setCellValue(hocSinh.getDiem());
	                row.createCell(4).setCellValue(hocSinh.getTuoi());
	                row.createCell(5).setCellValue(hocSinh.getDiachi());
	            }

	            // Write the workbook to the output stream
	            workbook.write(fos);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void deleteRecord(int mahs) {
	        List<HocSinh> hocSinhs = readDataFromExcel();
	        hocSinhs.removeIf(hocSinh -> hocSinh.getMahs() == mahs);
	        writeDataToExcel(hocSinhs);
	    }

//	    public static void main(String[] args) {
//	        // Example usage:
//	        // Read data from Excel
//	        List<HocSinh> hocSinhs = readDataFromExcel();
//
//	        // Delete a record by ID
//	        int mahsToDelete = 123; // Specify the ID to delete
//	        deleteRecord(mahsToDelete);
//
//	        // Write data to Excel
//	        writeDataToExcel(hocSinhs);
//	    }
	    private List<HocSinh> hocSinhs = new ArrayList<>();

	    // Phương thức để xóa một HocSinh theo ID từ danh sách
	    public void deleteHocSinhById(int mahsToDelete) {
	        Iterator<HocSinh> iterator = hocSinhs.iterator();

	        while (iterator.hasNext()) {
	            HocSinh hocSinh = iterator.next();

	            if (hocSinh.getMahs() == mahsToDelete) {
	                iterator.remove(); // Xóa HocSinh có ID cụ thể
	                System.out.println("HocSinh với ID " + mahsToDelete + " đã được xóa thành công.");
	                return; // Thoát khỏi phương thức sau khi xóa
	            }
	        }

	        // Nếu vòng lặp hoàn thành mà không tìm thấy ID cụ thể
	        System.out.println("HocSinh với ID " + mahsToDelete + " không được tìm thấy trong danh sách.");
	    }

	    // Phương thức để xử lý đầu vào người dùng và gọi phương thức deleteHocSinhById
	    public void deleteUserInput() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Nhập mã học sinh để xóa: ");
	        if (scanner.hasNextInt()) {
	            int mahsToDelete = scanner.nextInt();
	            deleteHocSinhById(mahsToDelete);
	        } else {
	            System.out.println("Đầu vào không hợp lệ. Vui lòng nhập một mã học sinh hợp lệ (giá trị số).");
	        }

	        scanner.close();
	    }

	    public static void main(String[] args) {
	        QuanLyHocSinh hocSinhManager = new QuanLyHocSinh();

	        // Ví dụ sử dụng:
	        // Điền danh sách với dữ liệu (bạn có thể tùy chỉnh phần này)
	        hocSinhManager.hocSinhs.add(new HocSinh(1, "Học Sinh 1", "Lớp A", 8.5, 18, "Địa chỉ 1"));
	        hocSinhManager.hocSinhs.add(new HocSinh(2, "Học Sinh 2", "Lớp B", 7.5, 17, "Địa chỉ 2"));

	        // Gọi phương thức nhập liệu người dùng
	        hocSinhManager.deleteUserInput();

	        // In danh sách cập nhật hoặc thực hiện bất kỳ thao tác nào khác
	        for (HocSinh hocSinh : hocSinhManager.hocSinhs) {
	            System.out.println(hocSinh);
	        }
	    }

}
