package vn.devpro.Collections.BaiTap;

import java.util.Scanner;

public class Helper {
public static Scanner sc=new Scanner(System.in);
//hàm để tìm mã loại hàng trong danh sách loại hàng và hàm trả về index
//ngược lại trả về -1
public static int indexOfMaLoaiHang(int id) {
	for (LoaiHang loaihang : QuanLyLoaiHang.list) {
		if(loaihang.getID()==id)
		{
			return id;
		}
	}
	return -1;
}
//hàm trả về tên loại hàng dựa vào mã loại hàng

public static String tenLoaiHang(int id) {
	for (LoaiHang lh : QuanLyLoaiHang.list) {
		if (lh.getID()==id) {
			return lh.getTenLoaiHang();
		}
	}
	return null;
}
//hàm tìm mã hàng hóa trong danh sách hàng hóa
public static int timMaHangHoa(int id) {
	for (int i = 0; i < QuanLyHangHoa.list.size(); i++) {
		if(QuanLyHangHoa.list.get(i).getID()==id)
		{
			return i;
		}
	}
	return -1;
}
//Hàm trả về mã hàng
public static int indexOfMaHang(int id) {
	for (Hang hang : QuanLyHangHoa.list) {
		if(hang.getID()==id)
		{
			return hang.getID();
		}
	}
	return -1;
}
//hàm trả về mã khách hàng
public static int indexOfKhachHang(int id) {
	for (int i=0;i<QuanLyKhachHang.list.size();i++) {
		if(QuanLyKhachHang.list.get(i).getID()==id)
		{
			return i;
		}
	}
	return -1;
}
//hàm trả về tên loại hàng
public static int tenLoaiHang(String tenLh) {
	for (LoaiHang lh : QuanLyLoaiHang.list) {
		if (lh.getTenLoaiHang().compareToIgnoreCase(tenLh)==0) {
			return lh.getID();
		}
	}
	return -1;
}//hàm trả về tên khách hàng
public static int tenKhachHang(String name) {
	for (int i=0;i<QuanLyKhachHang.list.size();i++) {
		if(QuanLyKhachHang.list.get(i).getHoTen().contains(name))
		{
			return QuanLyKhachHang.list.get(i).getID();
		}
	}
	return -1;
}
//hàm nhập vào mã hàng trả về tên hàng
public static String tenHang(int id)
{
	for(int i=0;i<QuanLyHangHoa.list.size();i++)
	{
		if (QuanLyHangHoa.list.get(i).getID()==id) {
			return QuanLyHangHoa.list.get(i).getTenHang();
		}
	}
	return null;
}
//hàm nhập vào mã khách hàng trả về tên khách hàng
public static String tenKhachHang(int id)
{
	for(int i=0;i<QuanLyKhachHang.list.size();i++)
	{
		if (QuanLyKhachHang.list.get(i).getID()==id) {
			return QuanLyKhachHang.list.get(i).getHoTen();
		}
	}
	return null;
}
//hàm nhận vào mã hàng hóa và trả về đơn giá hàng hóa
public static double donGia(int id) {
	for (int i = 0; i < QuanLyHangHoa.list.size(); i++) {
		if (QuanLyHangHoa.list.get(i).getID()==id) {
			return QuanLyHangHoa.list.get(i).getDonGia();
		}
	}
	return 0;
	
}
}
