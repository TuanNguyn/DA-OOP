package Java.DoAn.Menu;

import java.util.Scanner;
import Java.DoAn.DS_Class.DanhSachSach;

public class MenuSach extends Menu {
    @Override
    public void MenuChinh() {
        DanhSachSach dsSach = new DanhSachSach();
        dsSach.docFile("Java/DoAn/input/inputSach.txt");
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===== MENU QUAN LY SACH =====");
            System.out.println("1. Nhap danh sach sach");
            System.out.println("2. Xuat danh sach sach");
            System.out.println("3. Them sach");
            System.out.println("4. Tim kiem sach");
            System.out.println("5. Xoa sach");
            System.out.println("6. Sua thong tin sach");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    dsSach.nhap();
                    break;
                case 2:
                    dsSach.xuat();
                    System.out.println();
                    break;
                case 3:
                    dsSach.themSach();
                    break;
                case 4:
                    dsSach.timSach();
                    break;
                case 5:
                    System.out.println("Nhap ma sach can xoa: ");
                    String maXoa = sc.nextLine();
                    dsSach.xoaSach(maXoa);
                    break;
                case 6:
                    System.out.println("Nhap ma sach can sua: ");
                    String maSua = sc.nextLine();
                    dsSach.suaSach(maSua);
                    break;
                case 0:
                    System.out.println("Thoat khoi menu quan ly sach.");
                    break;
            }
        } while (choice != 0);
    }
}
