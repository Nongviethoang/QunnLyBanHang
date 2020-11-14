package vn.devpro.Collections.BaiTap;

import java.util.ArrayList;

public class GioHang {
private int ID;
private int ID_KhachHang;
private ArrayList<HangTrongGio> list=new ArrayList<HangTrongGio>();
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public int getID_KhachHang() {
	return ID_KhachHang;
}
public void setID_KhachHang(int iD_KhachHang) {
	ID_KhachHang = iD_KhachHang;
}
public void themHangVaoGio(HangTrongGio e) {
	list.add(e);
}
public ArrayList<HangTrongGio> getList() {
	return list;
}
public void setList(ArrayList<HangTrongGio> list) {
	this.list = list;
}
}
