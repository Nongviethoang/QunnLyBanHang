package vn.devpro.Collections.BaiTap;

import java.util.ArrayList;

public class QuanLyGioHang {
	static GioHang gioHang;
	static int autoId = 1;
	static ArrayList<GioHang> list = new ArrayList<GioHang>();

	public static void start() {

		do {
			System.out.println("====CẬP NHẬT THÔNG TIN GIỎ HÀNG=====");
			System.out.println("Chọn chức năng để cập nhật giỏ hàng");
			System.out.println("Chọn 1:Khởi tạo giỏ hàng");
			System.out.println("Chọn 2:Thêm hàng vào giỏ");
			System.out.println("Chọn 3:Xem hàng trong giỏ");
			System.out.println("Chọn 4:Sửa hàng trong giỏ");
			System.out.println("Chọn 5:Xóa hàng trong giỏ");
			System.out.println("Chọn 6:Thanh toán giỏ hàng");
			System.out.println("Chọn 7 để quay lại");
			System.out.println("Chọn 0 để đóng ứng dụng");
			System.out.println("Mời bạn chọn chức năng:");
			int chon = Integer.parseInt(Helper.sc.nextLine());
			switch (chon) {
			case 1:
				khoiTaoGioHang();
				break;
			case 2:
				themHangVaoGio();
				break;
			case 3:
				xenHangTrongGio();
				break;
			case 4:
				suaHangTrongGio();
				break;
			case 5:
				xoaHangTrongGio();
				break;
			case 6:
				thanhToanGioHang();
				break;
			case 7:
				gioHang = null;
				return;
			case 0:
				System.out.println("Đóng ứng dụng");
				System.exit(0);
			default:
				System.out.println("Lựa chọn không đúng");
				break;
			}
		} while (true);
	}

	private static void khoiTaoGioHang() {
		System.out.println("KHỞI TẠO GIỎ HÀNG");

		System.out.println("Chọn mã khách hàng");
		int id_khachHang = Integer.parseInt(Helper.sc.nextLine());
		// kiểm tra id khách hàng có trong ds khách hàng hay không
		int index = Helper.indexOfKhachHang(id_khachHang);
		if (index == -1) {
			System.out.println("Không có mã khách hàng nào");
			return;
		}
		// Khởi tạo giỏ hàng
		gioHang = new GioHang();
		gioHang.setID(autoId);
		gioHang.setID_KhachHang(id_khachHang);
		autoId++;
		System.out.println("khởi tạo giỏ hàng thành công");
	}

	private static void themHangVaoGio() {
		// TODO Auto-generated method stub
		System.out.println("THÊM HÀNG VÀO GIỎ");
		if (gioHang == null) {
			System.out.println("Chưa khởi tạo giỏ hàng, chọn 1 để khởi tạo giỏ hàng");
			return;
		}
		System.out.print("Chọn mã hàng hóa cần thêm:");
		int id_hangHoa = Integer.parseInt(Helper.sc.nextLine());
		// Kiểm tra hàng hóa có trong danh sách hàng hóa không
		int index = Helper.indexOfMaHang(id_hangHoa);
		if (index == -1) {
			System.out.println("Hàng hóa chưa có trong danh sách");
			return;
		}
		System.out.println("Số lượng mua:");
		int soLuong = Integer.parseInt(Helper.sc.nextLine());
		if (soLuong > QuanLyHangHoa.list.get(index).getSoLuong()) {
			System.out.println("Số lượng hàng hóa không hợp lệ hoặc không đủ để bán cho bạn");
			return;
		}
		// Kiểm tra xem hàng đã có trong giỏ chưa, nếu chưa có thì thêm mới nếu có rồi
		// thì chỉ tăng số lượng
		// Nếu tổng số lượng không vượt quá lượng hóa hóa có trong danh sách
		int index1;
		for (index1 = 0; index1 < gioHang.getList().size(); index1++) {
			if (gioHang.getList().get(index).getID_HangHoa() == id_hangHoa) {
				break;
			}
		}
		if (index < gioHang.getList().size())// Hàng đã có trong giỏ
		{
			if (gioHang.getList().get(index1).getSoLuong() + soLuong > QuanLyHangHoa.list.get(index1).getSoLuong()) {
				System.out.println("Không đủ hàng hóa cho bạn mua thêm");
				return;
			}
			soLuong += gioHang.getList().get(index1).getSoLuong();
			gioHang.getList().get(index1).setSoLuong(soLuong);
		} else {
			// Hàng chưa có trong giỏ thì thêm vào giỏ
			gioHang.themHangVaoGio(new HangTrongGio(id_hangHoa, soLuong));
			System.out.println("Đã thêm hàng vào giỏ thành công!");
		}
	}

	private static void xenHangTrongGio() {
		// TODO Auto-generated method stub
		if (gioHang == null) {
			System.out.println("Chưa khởi tạo giỏ hàng, chọn 1 để khởi tạo giỏ hàng");
			return;
		}
		System.out.println("GIỎ HÀNG CỦA BẠN");
		if (gioHang.getList().size() == 0) {
			System.out.println("Chưa mua hàng hóa nào, bấm 2 để thêm hàng vào trong giỏ");
			return;
		}
		System.out.println("Tên khách hàng:" + Helper.tenKhachHang(gioHang.getID_KhachHang()));
		System.out.printf("%-3s%-20s%-10s%-13s%-14s%n", "STT", "Tên hàng", "Số lượng", "Đơn giá", "Thành tiền");
		int stt = 1;
		double tongTien = 0;
		for (HangTrongGio hang : gioHang.getList()) {
			System.out.printf("%3d", stt);
			stt++;
			System.out.printf("%-20s", Helper.tenHang(hang.getID_HangHoa()));
			System.out.printf("%10d", hang.getSoLuong());
			System.out.printf("%,13.2f", Helper.donGia(hang.getID_HangHoa()));
			double thanhTien = hang.getSoLuong() * Helper.donGia(hang.getID_HangHoa());
			System.out.printf("%,15.2f%n", thanhTien);
			tongTien += thanhTien;
		}
		System.out.println("Tổng tiền:" + tongTien);
	}

	private static void suaHangTrongGio() {
		// TODO Auto-generated method stub
		System.out.println("Sửa hàng trong giỏ");
		System.out.println("NHập mã của hàng cẩn sửa");
		int id_hangHoa = Integer.parseInt(Helper.sc.nextLine());
		int index = 0;
		while (index < gioHang.getList().size() && gioHang.getList().get(index).getID_HangHoa() != id_hangHoa) {
			index++;
		}
		if (index < gioHang.getList().size()) {// Hàng có trong giỏ
			System.out.println("Nhập số lượng cần sửa");
			int soLuongMoi = Integer.parseInt(Helper.sc.nextLine());
			// Kiểm tra số lượng mới không vượt qua số lượng trong danh sách
			int i = 0;
			while (QuanLyHangHoa.list.get(i).getID() != id_hangHoa) {
				i++;
			}
			if (QuanLyHangHoa.list.get(i).getSoLuong() < soLuongMoi) {
				System.out.println("Số lượng mới vượi số lượng cho phép");
				return;
			}
			gioHang.getList().get(index).setSoLuong(soLuongMoi);
			System.out.println("Sửa thành công");
		} else {
			System.out.println("Mã hàng không có trong giỏ");
			return;
		}
	}

	private static void xoaHangTrongGio() {
		System.out.println("Xóa hàng trong giỏ");
		System.out.println("Nhập mã hàng cần xóa");
		int idHangHoa = Integer.parseInt(Helper.sc.nextLine());
		int index = 0;
		while (index < gioHang.getList().size() && gioHang.getList().get(index).getID_HangHoa() != idHangHoa) {
			index++;
		}
		if (index < gioHang.getList().size()) // Hàng có trong giỏ
		{
			gioHang.getList().remove(index);
			System.out.println("Xóa hàng trong giỏ thành công");
		} else {
			System.out.println("Hàng không có trong giỏ hàng");
		}
	}

	private static void thanhToanGioHang() {
		// In hóa đơn, in thông tin giỏ hàng
		xenHangTrongGio();
		// Cảm ơn và hẹn gặp lại
		System.out.println("Cảm ơn và hẹn gặp lại");
		// Đưa giỏ đã thanh toán vào trong giỏ hàng
		list.add(gioHang);
		// Cập nhật lại số lượng hàng hóa trong danh sách hàng hóa
		for (HangTrongGio hang : gioHang.getList()) {
			int index = Helper.indexOfMaHang(hang.getID_HangHoa());
			if (index != -1) {
				int soLuongConLai = QuanLyHangHoa.list.get(index).getSoLuong() - hang.getSoLuong();
				QuanLyHangHoa.list.get(index).setSoLuong(soLuongConLai);
			}
		}
	}

	// Viết hàm quản lý danh sách giỏ hàng để xem thông tin của tất cả
	public static void quanLyDanhSachGioHang() {
		// hiện thị thông tin các giỏ hàng
		//Tìm giỏ hàng của khách theo id của khách hàng
		// hiển thị tổng tiền của các giỏ hàng
	}
}
