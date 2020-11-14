package vn.devpro.Collections.BaiTap;

import javax.swing.plaf.SliderUI;

public class LoaiHang {
	private int ID;
	private String tenLoaiHang;
	public LoaiHang(int iD, String tenLoaiHang) {
		super();
		ID = iD;
		this.tenLoaiHang = tenLoaiHang;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTenLoaiHang() {
		return tenLoaiHang;
	}
	public void setTenLoaiHang(String tenLoaiHang) {
		this.tenLoaiHang = tenLoaiHang;
	}
	public LoaiHang() {
		super();
	}
	public void display() {
		System.out.printf("%-6d%-30s%n",ID,tenLoaiHang);
	}
	

}
