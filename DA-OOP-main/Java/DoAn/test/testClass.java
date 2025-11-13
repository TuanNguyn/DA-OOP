package Java.DoAn.test;

import java.util.Scanner;

import Java.DoAn.DS_Class.DanhSachCTHD;
import Java.DoAn.DS_Class.DanhSachHoaDon;
import Java.DoAn.DS_Class.DanhSachPNH;
import Java.DoAn.DS_Class.DanhSachCTPNH;
import Java.DoAn.DS_Class.DanhSachNXB;
import Java.DoAn.DS_Class.DanhSachTheLoai;
import Java.DoAn.DS_Class.DanhSachNCC;
import Java.DoAn.Menu.MenuHoaDon;
import Java.DoAn.Menu.MenuNhanVien;
import Java.DoAn.Menu.MenuSach;
import Java.DoAn.Menu.MenuPhieuNhapHang;
import Java.DoAn.Menu.MenuNXB;
import Java.DoAn.Menu.MenuNCC;
import Java.DoAn.Menu.MenuTheLoai;
import Java.DoAn.Menu.MenuKho;

public class testClass {
    private static MenuNhanVien menuNV;
    private static MenuSach menuSach;
    private static MenuNXB menuNXB;
    private static MenuHoaDon menuHD;
    private static MenuPhieuNhapHang menuPNH;
    private static MenuNCC menuNCC;
    private static MenuTheLoai menuTheLoai;
    private static MenuKho menuKho;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("         --- Xin Chao ---                 ");

        menuNV = new MenuNhanVien();
        menuSach = new MenuSach();
        menuKho = new MenuKho();

        System.out.println("    ========== NHA XUAT BAN ==========                  ");

        DanhSachNXB dsnxb = new DanhSachNXB();
        dsnxb.docFile("Java/DoAn/input/inputNhaXuatBan.txt");
        dsnxb.xuatDSNXB();
        menuNXB = new MenuNXB(dsnxb);

        System.out.println("    ========== NHA CUNG CAP ==========                  ");

        DanhSachNCC dsncc = new DanhSachNCC();
        dsncc.docFile("Java/DoAn/input/inputNhaCungCap.txt");
        dsncc.xuatDSNCC();
        menuNCC = new MenuNCC(dsncc);

        DanhSachCTHD dscthd = new DanhSachCTHD();
        dscthd.docFile("Java/DoAn/input/inputChiTietHD.txt");

        System.out.println("     ========== HOA DON ==========                      ");

        DanhSachHoaDon dshd = new DanhSachHoaDon();
        dshd.docFile("Java/DoAn/input/inputHoaDon.txt");
        dshd.themHDFile();
        menuHD = new MenuHoaDon(dshd);

        DanhSachCTPNH dsctpnh = new DanhSachCTPNH();
        dsctpnh.docFile("Java/DoAn/input/inputChiTietPNH.txt");

        System.out.println("     ========== PHIEU NHAP HANG ==========              ");

        DanhSachPNH dspnh = new DanhSachPNH();
        dspnh.docFile("Java/DoAn/input/inputPhieuNhapHang.txt");
        dspnh.themPNHFile();
        menuPNH = new MenuPhieuNhapHang(dspnh);

        System.out.println("    ========== THE LOAI ==========                  ");

        DanhSachTheLoai dsTheLoai = new DanhSachTheLoai();
        dsTheLoai.docFile("Java/DoAn/input/inputTheLoai.txt");
        dsTheLoai.xuatDSTL();
        menuTheLoai = new MenuTheLoai(dsTheLoai);

        int choice;
        do {
            System.out.println("\n========== MENU CHINH - QUAN LY SACH ==========");
            System.out.println("1. Quan ly Nhan Vien");
            System.out.println("2. Quan ly Sach");
            System.out.println("3. Quan ly Hoa Don");
            System.out.println("4. Quan ly Phieu Nhap Hang");
            System.out.println("5. Quan ly Nha Xuat Ban");
            System.out.println("6. Quan ly Nha Cung Cap");
            System.out.println("7. Quan ly The Loai");
            System.out.println("8. Quan ly Kho");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    menuNV();
                    break;
                case 2:
                    menuSach();
                    break;
                case 3:
                    menuHD();
                    break;
                case 4:
                    menuCtPNH();
                    break;
                case 5:
                    menuNXB();
                    break;
                case 6:
                    menuNCC();
                    break;
                case 7:
                    menuTheLoai();
                    break;
                case 8:
                    MenuKho.main(new String[0]);
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung chuong trinh. Hen gap lai!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);

        sc.close();
    }

    private static void menuNV() {
        if (menuNV == null) {
            System.out.println("MenuNhanVien chua duoc khoi tao.");
            return;
        }
        menuNV.MenuChinh();
    }

    private static void menuSach() {
        if (menuSach == null) {
            System.out.println("MenuSach chua duoc khoi tao.");
            return;
        }
        menuSach.MenuChinh();
    }

    private static void menuHD() {
        if (menuHD == null) {
            System.out.println("MenuHoaDon chua duoc khoi tao.");
            return;
        }
        menuHD.MenuChinh();
    }

    private static void menuCtPNH() {
        if (menuPNH == null) {
            System.out.println("MenuPhieuNhapHang chua duoc khoi tao.");
            return;
        }
        menuPNH.MenuChinh();
    }

    private static void menuNXB() {
        if (menuNXB == null) {
            System.out.println("MenuNXB chua duoc khoi tao.");
            return;
        }
        menuNXB.MenuChinh();
    }

    private static void menuNCC() {
        if (menuNCC == null) {
            System.out.println("MenuNCC chua duoc khoi tao.");
            return;
        }
        menuNCC.MenuChinh();
    }

    private static void menuTheLoai() {
        if (menuTheLoai == null) {
            System.out.println("MenuTheLoai chua duoc khoi tao.");
            return;
        }
        menuTheLoai.MenuChinh();
    }
}
