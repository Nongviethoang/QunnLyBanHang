package vn.devpro.Collections.BaiTap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLyLoaiHang {
	static ArrayList<LoaiHang> list = new ArrayList<LoaiHang>();

	public static void start() {
		int chon;
		do {
			System.out.println("=====Cập nhật thông tin loại hàng======");
			System.out.println("Chọn một thao tác");
			System.out.println("\t1. Thêm loại hàng mới ");
			System.out.println("\t2. Xem danh sách loại hàng");
			System.out.println("\t3. Sửa thông tin loại hàng");
			System.out.println("\t4. Xóa thông tin loại hàng");
			System.out.println("\t5. Quay lại");
			System.out.println("\t0. Đóng ứng dụng");
			System.out.println("Lựa chọn");
			chon = Integer.parseInt(Helper.sc.nextLine());
			switch (chon) {
			case 1:
				themLoaiHangMoi();
				break;
			case 2:
				xemDanhSachLoaiHang();
				break;
			case 3:
				suaThongTinLoaiHang();
				break;
			case 4:
				xoaThongTinLoaiHang();
				break;
			case 5:
				return;

			case 0:
				System.out.println("Đóng ứng dụng");
				System.exit(0);
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ");
				break;
			}

		} while (true);
	}
	static int autoID=1;//Mã loại hàng sinh tự động
	private static void themLoaiHangMoi() {
		System.out.println("------Nhập mới một loại hàng------");
		LoaiHang loaiHang=new LoaiHang();
		System.out.println("Nhập tên loại hang:");String tenLH=Helper.sc.nextLine();
		if (tenLH.compareTo("")==0) {
			System.out.println("tên loại hàng không được để trống");return;
		}
		loaiHang.setID(autoID);
		loaiHang.setTenLoaiHang(tenLH);
		autoID++;
		list.add(loaiHang);
		System.out.println("Thêm loại hàng thành công, bấm 2 để xem danh sách");
	}

	private static void xemDanhSachLoaiHang() {
		Collections.sort(list,new Comparator<LoaiHang>() {

			@Override
			public int compare(LoaiHang o1, LoaiHang o2) {
				// TODO Auto-generated method stub
				return o1.getTenLoaiHang().compareTo(o2.getTenLoaiHang());
			}
		});
		System.out.println("DANH SÁCH LOẠI HÀNG");
		System.out.printf("%-6s%-30s%n","Mã LH","Tên loại hàng");
		for (LoaiHang loaiHang : list) {
			loaiHang.display();
		}
	}
	private static void suaThongTinLoaiHang() {
		System.out.println("=====Sửa thông tin loại hàng=====");
//		System.out.println("Nhập mã cần sửa");int id=Integer.parseInt(Helper.sc.nextLine());
//		for (LoaiHang loaiHang : list) {
//			if(loaiHang.getID()==id)
//			{
//				System.out.println("Nhập tên mới");
//				String tenHang=Helper.sc.nextLine();
//				loaiHang.setTenLoaiHang(tenHang);
//				System.out.println("Sửa thành công, bấm 2 để xem danh sách");
//			}
//		}
		System.out.println("Nhập mã cần sửa:");int id=Integer.parseInt(Helper.sc.nextLine());
		//tìm xem trong danh sách có tồn tại id vừa nhập
		if(Helper.indexOfMaLoaiHang(id)==-1)
		{
			System.out.println("Không có loại hàng này trong danh sách");return;
		}
		System.out.println("Nhập tên mới");
		String tenHang=Helper.sc.nextLine();
		if(tenHang.compareTo("")==0)
		{
			System.out.println("Tên hàng không được để trống!");return;
		}
		else {
			list.get(id).setTenLoaiHang(tenHang);
		System.out.println("Sửa thành công, bấm 2 để xem danh sách");
		}	
	}

	private static void xoaThongTinLoaiHang() {
		System.out.println("XÓA THÔNG TIN LOẠI HÀNG");
		System.out.println("Nhập mã loại hàng cần xóa");
		int id=Integer.parseInt(Helper.sc.nextLine());
	
		if(Helper.indexOfMaLoaiHang(id)==-1)
		{
			System.out.println("Không có loại hàng này trong danh sách");return;
		}
		//System.out.println();
		list.remove(Helper.indexOfMaLoaiHang(id)-1);
		System.out.println("Xóa thành công,bấm 2 để xem lại danh sách");
	}
	public static void search() {
		int chon;
		do {
			System.out.println("=====Tìm kiếm thông tin loại hàng======");
			System.out.println("Chọn một thao tác");
			System.out.println("\t1. Tìm theo mã loại hàng ");
			System.out.println("\t2. Tìm theo tên loại hàng");
			System.out.println("\t3. Quay lại");
			System.out.println("\t0. Đóng ứng dụng");
			System.out.println("Lựa chọn");
			chon = Integer.parseInt(Helper.sc.nextLine());
			switch (chon) {
			case 1:
				timTheoMaLoaiHang();
				break;
			case 2:
				timTheoTenLoaiHang();
				break;
			case 3:
				return;

			case 0:
				System.out.println("Đóng ứng dụng");
				System.exit(0);
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ");
				break;
			}
		} while (true);
	}

	private static void timTheoMaLoaiHang() {
		System.out.println("===Tìm kiếm loại hàng theo mã====");
		System.out.println("Nhập mã loại hàng cần tìm kiếm");
		int id=Integer.parseInt(Helper.sc.nextLine());
		if (Helper.indexOfMaLoaiHang(id)==-1) {
			System.out.println("Không có mã loại hàng này");return;
		}
		System.out.println("Thông tin Loại hàng có mã "+id);
		list.get(Helper.indexOfMaLoaiHang(id)).display();
	}

	private static void timTheoTenLoaiHang() {
		System.out.println("====Tìm tên loại hàng=====");
		System.out.println("Nhập tên loại hàng cần tìm:");
		String tenLoaiHang=Helper.sc.nextLine();
		if (Helper.tenLoaiHang(tenLoaiHang)==-1) {
			System.out.println("Không có tên loại hàng này");return;
		}
		list.get(Helper.tenLoaiHang(tenLoaiHang)).display();
	}
}
