package Java.DoAn.Menu;

import java.util.Map;
import java.util.Scanner;

import Java.DoAn.Class_chinh.PhieuNhapHang;
import Java.DoAn.DS_Class.DanhSachPNH;
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
			System.out.println("7. Xem chi tiet phieu nhap hang theo ma");
			System.out.println("0. Thoat");
			System.out.print("Nhap lua chon cua ban: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
					dspnh.xuat();
					System.out.println();
					break;
				case 2: {
					PhieuNhapHang pMoi = dspnh.themPNH();
					if (pMoi == null) {
						System.out.println("Khong the tao phieu nhap");
						break;
					}
					DanhSachCTPNH dsct = new DanhSachCTPNH();
					double tong = dsct.themDanhSachChoPNH(pMoi.getMaPNH());
					pMoi.setTongTien(tong);
					System.out.println("Them phieu nhap thanh cong");
					break;
				}
				case 3:
					dspnh.timPNH();
					break;
				case 4:
					System.out.print("Nhap ma Phieu Nhap Hang can xoa: ");
					String maXoa = sc.nextLine();
					dspnh.xoaPNH(maXoa);
					break;
				case 5:
					System.out.print("Nhap ma Phieu Nhap Hang can sua: ");
					String maSua = sc.nextLine();
					dspnh.suaPNH(maSua);
					break;
				case 6: {
					Map<Integer, Double> theoNam = dspnh.thongKeTheoNam();
					System.out.println("=== THONG KE PHIEU NHAP HANG ===");
					System.out.println("Tong so phieu: " + dspnh.tongSoPhieu());
					System.out.printf("Tong tien tat ca: %.2f\n", dspnh.tongTienTatCa());
					System.out.println("Tien theo nam:");
					for (Map.Entry<Integer, Double> e : theoNam.entrySet()) {
						System.out.printf("Nam %d : %.2f\n", e.getKey(), e.getValue());
					}
					DanhSachCTPNH dsct = new DanhSachCTPNH("Java/DoAn/input/inputChiTietPNH.txt");
					System.out.println("Tong so chi tiet: " + dsct.tongSoCT());
					System.out.println("Tong so luong sach nhap: " + dsct.tongSoLuongNhap());
					System.out.printf("Tong thanh tien chi tiet: %.2f\n", dsct.tongThanhTien());
					break;
				}
				case 7:
					System.out.print("Nhap ma phieu nhap hang can xem chi tiet: ");
					String maChiTiet = sc.nextLine();
					dspnh.xuatChiTietTheoMa(maChiTiet); 
					break;
				case 0:
					System.out.println("Thoat khoi menu quan ly phieu nhap hang.");
					break;
				default:
					System.out.println("Lua chon khong hop le. Vui long chon lai.");
			}
		} while (choice != 0);
	}
}