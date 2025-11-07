package Java.DoAn.Menu;

import java.util.Map;
import java.util.Scanner;

import Java.DoAn.Class_chinh.CTPhieuNhapHang;
import Java.DoAn.Class_chinh.PhieuNhapHang;
import Java.DoAn.DS_Class.DanhSachPNH;
import Java.DoAn.DS_Class.DanhSachNV;
import Java.DoAn.DS_Class.DanhSachSach;
import Java.DoAn.DS_Class.DanhSachCTPNH;

public class MenuPhieuNhapHang extends Menu {
	private DanhSachPNH dspnh;

	public MenuPhieuNhapHang(DanhSachPNH dspnh) {
		this.dspnh = dspnh;
	}

	@Override
	public void MenuChinh() {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("===== MENU QUAN LY PHIEU NHAP HANG =====");
			System.out.println("1. Xuat danh sach phieu nhap hang");
			System.out.println("2. Them phieu nhap hang");
			System.out.println("3. Tim kiem phieu nhap hang");
			System.out.println("4. Xoa phieu nhap hang");
			System.out.println("5. Sua thong tin phieu nhap hang");
			System.out.println("6. Thong ke tong nhap");
			System.out.println("7. Xem chi tiet phieu nhap hang theo ma"); // Menu mới
			System.out.println("0. Thoat");
			System.out.print("Nhap lua chon cua ban: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
					dspnh.xuat();
					System.out.println();
					break;
				case 2:
					themPhieuNhap();
					break;
				case 3:
					dspnh.timPNH();
					break;
				case 4:
					System.out.print("Nhap ma phieu nhap can xoa: ");
					String maXoa = sc.nextLine();
					dspnh.xoaPNH(maXoa);
					break;
				case 5:
					System.out.print("Nhap ma phieu nhap can sua: ");
					String maSua = sc.nextLine();
					dspnh.suaPNH(maSua);
					break;
				case 6:
					Map<Integer, Double> tongNhap = dspnh.thongKeTongNhap();
					System.out.println("Tong nhap theo nam:");
					for (Map.Entry<Integer, Double> e : tongNhap.entrySet()) {
						System.out.printf("Nam %d : %.2f\n", e.getKey(), e.getValue());
					}
					break;
				case 7:
					// Chức năng mới: Xem chi tiết phiếu nhập hàng theo mã
					System.out.print("Nhap ma phieu nhap hang can xem chi tiet: ");
					String maChiTiet = sc.nextLine();
					dspnh.xuatChiTietTheoMa(maChiTiet); // Gọi hàm vừa tạo ở DanhSachPNH
					break;
				case 0:
					System.out.println("Thoat khoi menu quan ly phieu nhap hang.");
					break;
				default:
					System.out.println("Lua chon khong hop le. Vui long chon lai.");
			}
		} while (choice != 0);
	}

	public void themPhieuNhap() {
		Scanner sc = new Scanner(System.in);
		DanhSachSach dssach = new DanhSachSach();
		DanhSachCTPNH dsctpnh = new DanhSachCTPNH();
		DanhSachPNH dspnhLocal = this.dspnh != null ? this.dspnh : new DanhSachPNH();
		DanhSachNV dsnv = new DanhSachNV();
		dsnv.docFile("Java/DoAn/input/inputNhanVien.txt");

		System.out.print("Nhap ma phieu nhap: ");
		String mapnh = sc.nextLine();
		System.out.print("Nhap ma nhan vien: ");
		String manv = sc.nextLine();
		if (dsnv.timNhanVien(manv) == null) {
			System.out.println("Ma nhan vien khong ton tai. Vui long kiem tra lai.");
			return;
		}
		System.out.print("Nhap ma nha cung cap: ");
		String mancc = sc.nextLine();
		System.out.print("Nhap ngay lap: ");
		String ngaylap = sc.nextLine();
		double tongtien = 0.0;

		System.out.print("Nhap so luong chi tiet phieu nhap: ");
		int soluongCT = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < soluongCT; i++) {
			System.out.print("Nhap ma sach: ");
			String masach = sc.nextLine();
			if (dssach.timSach(masach) == null) {
				System.out.println("Ma sach khong ton tai. Vui long kiem tra lai.");
				i--;
				continue;
			}
			System.out.print("Nhap so luong: ");
			int sl = sc.nextInt();
			System.out.print("Nhap don gia: ");
			double dongia = sc.nextDouble();
			sc.nextLine();
			double thanhtien = sl * dongia;
			tongtien += thanhtien;
			CTPhieuNhapHang ct = new CTPhieuNhapHang(mapnh, masach, sl, dongia, thanhtien);
			dsctpnh.themChiTietPNH(ct);
			dssach.capNhatSL(masach, sl);
		}

		PhieuNhapHang pnh = new PhieuNhapHang(mapnh, manv, mancc, ngaylap);
		pnh.setTongTien(tongtien);
		dspnhLocal.themPNH(pnh);
	}
}