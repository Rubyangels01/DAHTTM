package poly.bean;
public class MEAL {
	int maMon,idLoai,idND,idCongThuc;
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
	
	public int getIdLoai() {
		return idLoai;
	}
	public void setIdLoai(int idLoai) {
		this.idLoai = idLoai;
	}
	public MEAL(int maMon, int idLoai, int idND, int idCongThuc, String tenMon, String hinhAnh, String moTa) {
		super();
		this.maMon = maMon;
		this.idLoai = idLoai;
		this.idND = idND;
		this.idCongThuc = idCongThuc;
		this.tenMon = tenMon;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
	}
	
	
	
	
	
	
	
	
}
