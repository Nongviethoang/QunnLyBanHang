package vn.devpro.Collections.BaiTap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLyKhachHang {
	static ArrayList<KhachHang> list=new ArrayList<KhachHang>();
	static int autoID=1;
	public static void start() {
		int chon;
		do {
			System.out.println("=====Cập nhật thông tin khách hàng======");
			System.out.println("Chọn một thao tác");
			System.out.println("\t1. Thêm khách hàng mới ");
			System.out.println("\t2. Xem danh sách khách hàng");
			System.out.println("\t3. Sửa thông tin khách hàng");
			System.out.println("\t4. Xóa thông tin khách hàng");
			System.out.println("\t5. Quay lại");
			System.out.println("\t0. Đóng ứng dụng");
			System.out.println("Lựa chọn");
			chon = Integer.parseInt(Helper.sc.nextLine());
			switch (chon) {
			case 1:
				themKhachHang();
				break;
			case 2:
				xemDanhSachKhachHang();
				break;
			case 3:
				suaThongTinKhachHang();
				break;
			case 4:
				xoaThongTinKhachHang();
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
	private static void themKhachHang() {
		System.out.println("===THÊM KHÁCH HÀNG MỚI===");
		KhachHang khachHang=new KhachHang();
		System.out.println("Nhập tên khách hàng:");
		String tenKh=Helper.sc.nextLine();
		if(tenKh.compareTo("")==0)
		{
			System.out.println("Tên khách hàng không được để trống");return;
		}
		khachHang.setID(autoID);
		khachHang.setHoTen(tenKh);
		list.add(khachHang);
		autoID++;
		System.out.println("Thêm khách hàng thành công!");
	}
	private static void xemDanhSachKhachHang() {
		Collections.sort(list, new Comparator<KhachHang>() {

			@Override
			public int compare(KhachHang o1, KhachHang o2) {
				// TODO Auto-generated method stub
				return o1.getHoTen().compareToIgnoreCase(o2.getHoTen());
			}
		});
		System.out.println("\t Danh sách khách hàng");
		System.out.printf("%-6s%-30s%n","Mã KH","Tên khách hàng");
		
		for (KhachHang khachHang : list) {
			khachHang.display();
		}
	}
	private static void suaThongTinKhachHang() {
		System.out.println("====SỬA THÔNG TIN KHÁCH HÀNG====");
		System.out.println("Nhập id khách hàng sửa:");
		int id=Integer.parseInt(Helper.sc.nextLine());
		if(Helper.indexOfKhachHang(id)==-1)
		{
			System.out.println("Không tồn tại mã khách hàng này"+id);return;
		}
		System.out.println("Nhập tên khách hàng:");
		String tenkh=Helper.sc.nextLine();
		if(tenkh.compareTo("")==0)
		{
			System.out.println("Tên khách hàng không được để trống");return;
		}
		list.get(id).setHoTen(tenkh);
		System.out.println("Sửa thành công tên khách hàng");
		
	}
	private static void xoaThongTinKhachHang() {
		System.out.println("===XÓA THÔNG TIN KHÁCH HÀNG===");
		System.out.println("Nhập mã khách hàng cần xóa");
		int id=Integer.parseInt(Helper.sc.nextLine());
		if(Helper.indexOfKhachHang(id)==-1)
		{
			System.out.println("Không tồn tại mã khách hàng"+id);return;
		}
		list.remove(id-1);
		System.out.println("xóa thành công khách hàng có id="+id);
	}
	public static void search() {
		int chon;
		do {
			System.out.println("=====Tìm kiếm thông tin khách hàng======");
			System.out.println("Chọn một thao tác");
			System.out.println("\t1. Tìm theo id khách hàng ");
			System.out.println("\t2. Tìm theo tên khách hàng");
			System.out.println("\t3. Quay lại");
			System.out.println("\t0. Đóng ứng dụng");
			System.out.println("Lựa chọn");
			chon = Integer.parseInt(Helper.sc.nextLine());
			switch (chon) {
			case 1:
				timTheoID();
				break;
			case 2:
				timTheoTen();
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
	private static void timTheoID() {
		// TODO Auto-generated method stub
		System.out.println("====Tìm kiếm khách hàng theo id=====");
		System.out.println("Nhập id cần tìm kiếm:");
		int id=Integer.parseInt(Helper.sc.nextLine());
		if (Helper.indexOfKhachHang(id)==-1) {
			System.out.println("Không tồn tại mã khách hàng "+id);return;
		}
		list.get(Helper.indexOfKhachHang(id)).display();
	}
	private static void timTheoTen() {
		// TODO Auto-generated method stub
		System.out.println("Tìm theo tên khách hàng");
		System.out.println("Nhập tên khách hàng:");String tenkh=Helper.sc.nextLine();
		if (Helper.tenKhachHang(tenkh)==-1) {
			System.out.println("Không có tên này");return;
		}
		list.get(Helper.tenKhachHang(tenkh)).display();
	}
}
