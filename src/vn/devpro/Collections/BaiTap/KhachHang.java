package vn.devpro.Collections.BaiTap;

public class KhachHang {
	private int ID;
	private String hoTen;
	public KhachHang(int iD, String hoTen) {
		super();
		ID = iD;
		this.hoTen = hoTen;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public KhachHang() {
		super();
	}
	public void display() {
		System.out.printf("%-6s%-18s%n",ID,hoTen);
	}
}
