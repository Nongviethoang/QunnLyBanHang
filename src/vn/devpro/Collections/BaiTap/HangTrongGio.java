package vn.devpro.Collections.BaiTap;

public class HangTrongGio {
	private int ID_HangHoa;
	private int soLuong;
	public HangTrongGio() {
		super();
	}
	public HangTrongGio(int iD_HangHoa, int soLuong) {
		super();
		ID_HangHoa = iD_HangHoa;
		this.soLuong = soLuong;
	}
	public int getID_HangHoa() {
		return ID_HangHoa;
	}
	public void setID_HangHoa(int iD_HangHoa) {
		ID_HangHoa = iD_HangHoa;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	//Việc xử lí hàng trong giỏ tính sau
}
