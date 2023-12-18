package src;
import java.text.DecimalFormat;

public class HocSinh {
	private int mahs;
	private String tensinh;
	private String lop;
	private Double diem;
	private int tuoi;
	private String diachi;
	public HocSinh(int mahs, String tensinh, String lop, Double diem, int tuoi, String diachi) {
		super();
		this.mahs = mahs;
		this.tensinh = tensinh;
		this.lop = lop;
		this.diem = diem;
		this.tuoi = tuoi;
		this.diachi = diachi;
	}
	public HocSinh() {
		super();
	}
	public int getMahs() {
		return mahs;
	}
	public void setMahs(int mahs) {
		this.mahs = mahs;
	}
	public String getTensinh() {
		return tensinh;
	}
	public void setTensinh(String tensinh) {
		this.tensinh = tensinh;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public Double getDiem() {
		return diem;
	}
	public void setDiem(Double diem) {
		this.diem = diem;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	@Override
	public String toString() {
		return "mã học sinh : " + mahs + ", tên học sinh : " + tensinh + ", lớp : " + lop + ", điểm : " + diem + ", tuổi : " + tuoi
				+ ", địa chỉ: " + diachi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diachi == null) ? 0 : diachi.hashCode());
		result = prime * result + ((diem == null) ? 0 : diem.hashCode());
		result = prime * result + ((lop == null) ? 0 : lop.hashCode());
		result = prime * result + mahs;
		result = prime * result + ((tensinh == null) ? 0 : tensinh.hashCode());
		result = prime * result + tuoi;
		return result;
	}
    public String getFormattedDiem() {
        // Format diem to one decimal place
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(diem);
    }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HocSinh other = (HocSinh) obj;
		if (diachi == null) {
			if (other.diachi != null)
				return false;
		} else if (!diachi.equals(other.diachi))
			return false;
		if (diem == null) {
			if (other.diem != null)
				return false;
		} else if (!diem.equals(other.diem))
			return false;
		if (lop == null) {
			if (other.lop != null)
				return false;
		} else if (!lop.equals(other.lop))
			return false;
		if (mahs != other.mahs)
			return false;
		if (tensinh == null) {
			if (other.tensinh != null)
				return false;
		} else if (!tensinh.equals(other.tensinh))
			return false;
		if (tuoi != other.tuoi)
			return false;
		return true;
	}
	
}
