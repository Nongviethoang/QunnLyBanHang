package vn.devpro.Collections.BaiTap;

public class QuanLyBanHang {
		
	public static void main(String[] args) {
		int chon;
		do {
			System.out.println("\n=============Chuong trinh quan ly ban hang=============");
			System.out.println("Chon chuc nang quan ly");
			System.out.println("\t1.Cap nhat thong tin he thong");
			System.out.println("\t2.Tim kiem thong tin he thong");
			System.out.println("\t0.Dong ung dung");
			System.out.println("Lua chon cua ban");
			chon=Integer.parseInt((Helper.sc.nextLine()));
			switch (chon) {
			case 1:QuanLiThongTin.start();break;
			case 2:TimKiemThongTin.start();break;
			case 0:
				System.out.println("Da dong ung dung");
				System.exit(0);
				return;
			default:
				System.out.println("Chon chuc nang chua phu hop");
				
			}
		}while(true);
	}
}
