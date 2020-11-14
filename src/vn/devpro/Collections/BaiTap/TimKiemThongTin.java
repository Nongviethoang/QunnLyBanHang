package vn.devpro.Collections.BaiTap;

public class TimKiemThongTin {
public static void start() {
	int chon;
	do {
		System.out.println("\t\nTìm kiếm thông tin ");
		System.out.println("\t1.Tìm kiếm thông tin loại hàng");
		System.out.println("\t2.Tìm kiếm thông tin hàng hóa");
		System.out.println("\t3.Tìm kiếm thông tin khách hàng");
		System.out.println("\t4.Tìm kiếm thông tin giỏ hàng");
		System.out.println("\t5. Tìm kiếm danh sách giỏ hàng");
		System.out.println("\t6. Quay lại");
		System.out.println("\t0. Đóng ứng dụng");
		System.out.println("\t Lựa chọn của bạn");
		chon=Integer.parseInt(Helper.sc.nextLine());
		switch (chon) {
		case 1:QuanLyLoaiHang.search();break;
		case 2:QuanLyHangHoa.start();break;
		case 3:break;
		case 4:break;
		case 5:break;
		case 6:return;
		case 0:System.exit(0);
		default:System.out.println("Lựa chọn không phù hợp");	
		}
	} while (true);
	
}
}
