package Java.DoAn.Menu;

import java.util.Scanner;
import Java.DoAn.DS_Class.DanhSachTonKho;

public class MenuTonKho extends Menu {
	@Override
	public void MenuChinh() {
		DanhSachTonKho dsTonKho = new DanhSachTonKho();
		dsTonKho.docFile("Java/DoAn/input/inputSach.txt");
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("===== MENU QUAN LY TON KHO =====");
			System.out.println("1. Hien thi thong ke so luong ton kho");
			System.out.println("0. Thoat");
			System.out.print("Nhap lua chon cua ban: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
				case 1:
					dsTonKho.thongKeTonKho();
					break;
				case 0:
					System.out.println("Thoat khoi menu ton kho.");
					break;
				default:
					System.out.println("Lua chon khong hop le. Vui long chon lai.");
			}
		} while (choice != 0);
	}
}
