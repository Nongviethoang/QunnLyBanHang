package vn.devpro.Collections.BaiTap;

public class Hang {
	private int ID;
	private int ID_LoaiHang;
	private String tenHang;
	private int soLuong;
	private double donGia;

	public Hang(int iD, int iD_LoaiHang, String tenHang, int soLuong, double donGia) {
		super();
		ID = iD;
		ID_LoaiHang = iD_LoaiHang;
		this.tenHang = tenHang;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public Hang() {
		super();
	}

	public double thanhTien() {
		return donGia * soLuong;
	}

	public void display() {
		// Cột đầu tiên là loại hàng, sẽ tính sau
		System.out.printf("%-6d%-15s%-8d%,-8.0f%,-12.0f%n", ID, tenHang, soLuong, donGia, thanhTien());
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID_LoaiHang() {
		return ID_LoaiHang;
	}

	public void setID_LoaiHang(int iD_LoaiHang) {
		ID_LoaiHang = iD_LoaiHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
}
