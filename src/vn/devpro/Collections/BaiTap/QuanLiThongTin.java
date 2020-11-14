package vn.devpro.Collections.BaiTap;

public class QuanLiThongTin {
	public static void start() {
		int chon;
		do {
			System.out.println("\t\nCập nhật thông tin hệ thống ");
			System.out.println("\t1.Cập nhật thông tin loại hàng");
			System.out.println("\t2.Cập nhật thông tin hàng hóa");
			System.out.println("\t3.Cập nhật thông tin khách hàng");
			System.out.println("\t4.Cập nhật thông tin giỏ hàng");
			System.out.println("\t5. Cập nhật danh sách giỏ hàng");
			System.out.println("\t6. Quay lại");
			System.out.println("\t0. Đóng ứng dụng");
			System.out.println("\t Lựa chọn của bạn");
			chon=Integer.parseInt(Helper.sc.nextLine());
			switch (chon) {
			case 1:QuanLyLoaiHang.start();break;
			case 2:QuanLyHangHoa.start();break;
			case 3:QuanLyKhachHang.start();break;
			case 4:QuanLyGioHang.start();break;
			case 5:break;
			case 6:return;
			case 0:System.exit(0);
			default:System.out.println("Lựa chọn không phù hợp");	
			}
		} while (true);
	}
}
