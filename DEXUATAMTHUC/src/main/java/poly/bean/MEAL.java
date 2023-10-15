package poly.bean;
public class MEAL {
	int maMon,idLoai,idNd,soLuongTK;
	String tenMon, hinhAnh,moTa;
	public int getMaMon() {
		return maMon;
	}
	public void setMaMon(int maMon) {
		this.maMon = maMon;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public MEAL() {
		super();
	}
	public MEAL(int maMon, String tenMon, String hinhAnh, String moTa) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
	}
	public MEAL(int maMon, String tenMon, String hinhAnh, String moTa, int idLoai, int idNd, int soLuongTK) {
		super();
		this.maMon = maMon;
		this.idLoai = idLoai;
		this.idNd = idNd;
		this.soLuongTK = soLuongTK;
		this.tenMon = tenMon;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
	}
	
	
}
