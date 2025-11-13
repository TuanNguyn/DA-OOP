package Java.DoAn.DS_Class;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import Java.DoAn.Class_chinh.KhachHang;

public class DanhSachKH {
    private KhachHang[] dskh;
    private int n;

    // Hàm thiết lập
    public DanhSachKH() {
        n = 0;
    }

    public DanhSachKH(KhachHang[] dskh, int n) {
        this.n = n;
        this.dskh = dskh;
    }

    // Nhập, xuất
    public void nhapdskh() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong khach hang: ");
        n = sc.nextInt();
        sc.nextLine();
        dskh = new KhachHang[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin khach hang thu " + (i + 1) + ":");
            dskh[i] = new KhachHang();
            dskh[i].nhap();
        }
    }

    public void xuatdskh() {
        System.out.printf("%-10s %-15s %-10s %-15s %-30s\n", "Ma KH", "Ho", "Ten", "SDT", "Dia Chi");
        for (int i = 0; i < n; i++) {
            dskh[i].xuat();
        }
    }

    // Thêm
    public void themKhachHang() {
        n = dskh.length;
        dskh = Arrays.copyOf(dskh, n + 1);
        dskh[n] = new KhachHang();
        dskh[n].nhap();
        n++;
    }

    public void themKhachHang(KhachHang kh) {
        dskh = Arrays.copyOf(dskh, n + 1);
        dskh[n] = kh;
        n++;
    }

    // Tìm
    public void timKhachHang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khach hang can tim: ");
        String ma = sc.nextLine();
        timKhachHang(ma);
    }

    public KhachHang timKhachHang(String ma) {
        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKH().equals(ma)) {
                // Không xuất thông tin khách hàng, chỉ trả về đối tượng
                return dskh[i];
            }
        }
        // System.out.println("Khong tim thay khach hang co ma " + ma);
        return null;
    }

    // Xóa
    public void xoaKhachHang(String ma) {
        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKH().equals(ma)) {
                for (int j = i; j < n - 1; j++) {
                    dskh[j] = dskh[j + 1];
                }
                dskh = Arrays.copyOf(dskh, n - 1);
                n--;
                System.out.println("Da xoa khach hang co ma " + ma);
                return;
            }
        }
        System.out.println("Khong tim thay khach hang co ma " + ma);
    }

    // Sửa
    public void suaKhachHang(String makh) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKH().equals(makh)) {
                System.out.println("Chon thong tin can sua:");
                System.out.println("1. Ho");
                System.out.println("2. Ten");
                System.out.println("3. SDT");
                System.out.println("4. Dia chi");
                System.out.println("0. Thoat");

                int choice;
                do {
                    System.out.print("Nhap lua chon: ");
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.print("Nhap ho moi: ");
                            String ho = sc.nextLine();
                            dskh[i].setHo(ho);
                            break;
                        case 2:
                            System.out.print("Nhap ten moi: ");
                            String ten = sc.nextLine();
                            dskh[i].setTen(ten);
                            break;
                        case 3:
                            System.out.print("Nhap SDT moi: ");
                            String sdt = sc.nextLine();
                            dskh[i].setSDT(sdt);
                            break;
                        case 4:
                            System.out.print("Nhap dia chi moi: ");
                            String diachi = sc.nextLine();
                            dskh[i].setDiaChi(diachi);
                            break;
                    }
                } while (choice != 0);
                return;
            }
        }
        System.out.println("Khong tim thay khach hang co ma " + makh);
    }

    // Đọc file
    public void docFile(String filePath) {
        this.dskh = new KhachHang[0];
        n = 0;
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty())
                    continue;

                String[] parts = line.split(",");
                if (parts.length < 5)
                    continue;

                String makh = parts[0].trim();
                String ho = parts[1].trim();
                String ten = parts[2].trim();
                String sdt = parts[3].trim();
                String diachi = parts[4].trim();

                KhachHang kh = new KhachHang(makh, ho, ten, sdt, diachi);
                themKhachHang(kh);
            }
            // System.out.println("Da doc file " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
}
