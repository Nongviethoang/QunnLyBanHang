package vn.devpro.Collections.BaiTap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuanLyHangHoa {
	static ArrayList<Hang> list=new ArrayList<Hang>();
	static int autoID=1;
	public static void start() {
		int chon;
		do {
			System.out.println("=====Cập nhật thông tin hàng======");
			System.out.println("Chọn một thao tác");
			System.out.println("\t1. Thêm  hàng mới ");
			System.out.println("\t2. Xem danh sách  hàng");
			System.out.println("\t3. Sửa thông tin  hàng");
			System.out.println("\t4. Xóa thông tin  hàng");
			System.out.println("\t5. Quay lại");
			System.out.println("\t0. Đóng ứng dụng");
			System.out.println("Lựa chọn");
			chon = Integer.parseInt(Helper.sc.nextLine());
			switch (chon) {
			case 1:
				themHangMoi();
				break;
			case 2:
				xemDanhSachHang();
				break;
			case 3:
				suaThongTinHang();
				break;
			case 4:
				xoaThongTinHang();
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
	private static void themHangMoi() {
		System.out.println("\n====Thêm một hàng hóa mới====");
		System.out.println("Chọn loại hàng(Nhập mã loại hàng):");
		int id_loaiHang=Integer.parseInt(Helper.sc.nextLine());
		if (Helper.indexOfMaLoaiHang(id_loaiHang)==-1) {
			System.out.println("Chưa có loại hàng này");return;
		}
		System.out.println("NHập tên hàng hóa:");
		String tenHang=Helper.sc.nextLine();
		if(tenHang.compareTo("")==0)
		{
			System.out.println("tên hàng hóa không được để trống");return;
		}
		System.out.println("Nhập số lượng hàng hóa");
		int soLuong=Integer.parseInt(Helper.sc.nextLine());
		if (soLuong<0) {
			System.out.println("Số lượng phải là nguyên dương");return;
		}
		System.out.println("Nhập đơn giá:");
		double donGia=Double.parseDouble(Helper.sc.nextLine());
		if (donGia<0) {
			System.out.println("Đơn giá phải là số dương");return;
		}
		Hang hanghoa=new Hang(autoID, id_loaiHang, tenHang, soLuong, donGia);
		autoID++;
		list.add(hanghoa);
		System.out.println("Thêm hàng hàng hóa thành công,bấm 2 để thêm danh sách");
	}
	private static void xemDanhSachHang() {
		
		Collections.sort(list, new Comparator<Hang>() {

			@Override
			public int compare(Hang o1, Hang o2) {
				// TODO Auto-generated method stub
				return o1.getTenHang().compareToIgnoreCase(o2.getTenHang());
			}
		});
		System.out.println("=======Danh sách hàng hóa======");
		System.out.printf("%-10s%-6s%-15s%-8s%-10s%-12s%n","Loại hàng","Mã HH","Tên hàng hóa","Số lượng","Đơn giá","Thành tiền");
		//Lấy tên loại hàng trong danh sách loại hàng dựa vào mã loại hàng lưu trong hàng hóa
		for (Hang hang : list) {
			System.out.printf("%-10s",Helper.tenLoaiHang(hang.getID_LoaiHang()));
			hang.display();
		}
	}
	private static void suaThongTinHang() {
		System.out.println("Sửa thôn tin hàng hóa");
		System.out.println("Nhập mã hàng cần sửa");
		int id=Integer.parseInt(Helper.sc.nextLine());
		//tìm xem có trong danh sách hàng hóa không
		int index=Helper.timMaHangHoa(id);
		if(index==-1)
		{
			System.out.println("Không tồn tại mã hàng hóa này");return;
		}
		//xây dựng menu để sửa thông tin
		do {
			System.out.println("Chọn sửa thông tin");
			System.out.println("\t1. Sửa tên hàng");
			System.out.println("\t2. Sửa số lượng");
			System.out.println("\t3. Sửa đơn giá");
			System.out.println("\t4. quay lại");
			System.out.println("\t0.ĐÓng ứng dụng");
			System.out.println("Chọn chức năng");
			int chon=Integer.parseInt(Helper.sc.nextLine());
			switch (chon) {
			case 1:suaTenHang(list.get(index));
				break;
			case 2:suaTenSoLuong(list.get(index));
			break;
			case 3:suaDonGia(list.get(index));
			break;
			case 4:return;
			case 0:System.exit(0);
			
			default:System.out.println("Lựa chọn không đúng ");
				
			}
		} while (true);
		
	}
	private static void suaTenHang(Hang hang) {
	
		System.out.println("Nhập tên mới");
		String tenHang=Helper.sc.nextLine();
		if (tenHang.compareTo("")==0) {
			System.out.println("Tên hàng không được để trống!");return;
		}
		hang.setTenHang(tenHang);
		System.out.println("Sửa tên hàng thành công");
	}
	private static void suaTenSoLuong(Hang hang) {
	
		System.out.println("Nhập số lượng:");
		int sl=Helper.sc.nextInt();
		if (sl<0) {
			System.out.println("Số lượng không hợp lệ!");return;
		}
		hang.setSoLuong(sl);
		System.out.println("Sửa số lượng thành công");
		
	}
	private static void suaDonGia(Hang hang) {
		System.out.println("Nhập đơn giá mới:");
		double dg=Helper.sc.nextDouble();
		if (dg<0) {
			System.out.println("Đơn giá không hợp lệ!");return;
		}
		hang.setDonGia(dg);
		System.out.println("Sửa đơn giá thành công");
		
	}
	private static void xoaThongTinHang() {
		System.out.println("\t XÓA MỘT HÀNG HÓA");
		System.out.println("Nhập mã hàng cần xóa");
		int maHang=Integer.parseInt(Helper.sc.nextLine());
		if (Helper.indexOfMaHang(maHang)==-1) {
			System.out.println("Không có hàng trong danh sách");return;
		}
		list.remove(Helper.indexOfMaHang(maHang));
		System.out.println("Xóa thành công");
	}
	public static void search() {
		int chon;
		do {
			System.out.println("=====Tìm kiếm thông tin hàng======");
			System.out.println("Chọn một thao tác");
			System.out.println("\t1. Tìm theo id hàng ");
			System.out.println("\t2. Tìm theo tên hàng");
			System.out.println("\t3. Tìm theo số lượng hàng");
			System.out.println("\t4. Tìm theo đơn giá");
			System.out.println("\t5. Quay lại");
			System.out.println("\t0. Đóng ứng dụng");
			System.out.println("Lựa chọn");
			chon = Integer.parseInt(Helper.sc.nextLine());
			switch (chon) {
			case 1:
				timTheoMa();
				break;
			case 2:
				timTheoTenHang();
				break;
			case 3:
				timTheoSoLuongHang();
				break;
			case 4:
				timTheoDonGiaHang();
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
	private static void timTheoMa() {
		// TODO Auto-generated method stub
		
	}
	private static void timTheoTenHang() {
		// TODO Auto-generated method stub
		
	}
	private static void timTheoSoLuongHang() {
		// TODO Auto-generated method stub
		
	}
	private static void timTheoDonGiaHang() {
		// TODO Auto-generated method stub
		
	}
}
