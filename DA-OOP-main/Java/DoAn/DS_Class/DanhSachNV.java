package Java.DoAn.DS_Class;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import Java.DoAn.Class_chinh.NhanVien;

public class DanhSachNV {
    // Thuộc tính:
    private NhanVien[] dsnv;
    private int n;

    // Phương thức:

    // Hàm thiết lập:
    public DanhSachNV() {
        n = 0;
    }
    public DanhSachNV(NhanVien[] dsnv, int n) {
        this.n = n;
        this.dsnv = dsnv;
    }

    // Nhập, xuất:
    public void nhapdsnv() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap so luong nhan vien: ");
        n = sc.nextInt();
        sc.nextLine();
        dsnv = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin nhan vien thu " + (i + 1) + ":");
            dsnv[i] = new NhanVien();
            dsnv[i].nhap();
        }
    }
    public void xuatdsnv() {
        System.out.printf("%-10s %-15s %-10s %-15s %-15s %-10s %-10s\n", "Ma NV", "Ho", "Ten", "SDT", "Ngay Sinh", "Gioi Tinh", "Luong");
        for (int i = 0; i < n; i++) {
            dsnv[i].xuat();
        }
    }

    // them
    public void themNhanVien() {
        n = dsnv.length;
        dsnv = Arrays.copyOf(dsnv, n+1);
        dsnv[n] = new NhanVien();
        dsnv[n].nhap();
        n++;
    }
    public void themNhanVien(String manv) {
        n = dsnv.length;
        dsnv = Arrays.copyOf(dsnv, n+1);
        dsnv[n] = new NhanVien();
        n++;
    }
    public void themNhanVien(NhanVien nv) {
        dsnv = Arrays.copyOf(dsnv, n + 1);
        dsnv[n] = nv;
        n++;
    }

    // tim:
    public void timNhanVien() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap ma nhan vien can tim: ");
        String ma = sc.nextLine();
        timNhanVien(ma);
    }
    public NhanVien timNhanVien(String ma) {
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(ma)) {
        
                return dsnv[i];
            }
        }
       
        return null;
    }

    public void timHoNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho nhan vien can tim: ");
        String ho = sc.next();
        timHoNhanVien(ho);
    }
    public NhanVien[] timHoNhanVien(String ho) {
        NhanVien[] timho = new NhanVien[0];
        int m=0;
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getHo().contains(ho)) {
                timho = Arrays.copyOf(timho, m + 1);
                timho[m] = new NhanVien(dsnv[i]);
                m++;
            }
        }
        if (m > 0) {
            System.out.println("Cac nhan vien co ho " + ho + ":");
            for (int i = 0; i < m; i++) {
                timho[i].xuat();
            }
            return timho;
        }
        else System.out.println("Khong tim thay nhan vien nao co ho " + ho);
        return null;
    }
    public void timTenNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten nhan vien can tim: ");
        String ten = sc.next();
        timTenNhanVien(ten);
    }
    public NhanVien[] timTenNhanVien(String ten) {
        NhanVien[] timten = new NhanVien[0];
        int m=0;
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getTen().contains(ten)) {
                timten = Arrays.copyOf(timten, m + 1);
                timten[m] = new NhanVien(dsnv[i]);
                m++;
            }
        }
        if (m > 0) {
            System.out.println("Cac nhan vien co ten " + ten + ":");
            for (int i = 0; i < m; i++) {
                timten[i].xuat();
            }
            return timten;
        }
        else System.out.println("Khong tim thay nhan vien nao co ten " + ten);
        return null;
    }

    // xoa:
    public void xoaNhanVien() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap ma nhan vien can xoa: ");
        String ma = sc.nextLine();
        xoaNhanVien(ma);
    }
    public void xoaNhanVien(String ma) {
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(ma)) {
                for (int j = i; j < n - 1; j++) {
                    dsnv[j] = dsnv[j + 1];
                }
                dsnv = Arrays.copyOf(dsnv, n-1);
                n--;
                System.out.println("Da xoa nhan vien co ma " + ma);
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien co ma " + ma);
    }

    // sua:
    public void suaNhanVien() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap ma nhan vien can sua: ");
        String ma = sc.nextLine();
        suaNhanVien(ma);
    }
    public void suaNhanVien(String manv) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getMaNV().equals(manv)) {               
                System.out.println("Chon thong tin can sua:");
                System.out.println("1. Ho");
                System.out.println("2. Ten");
                System.out.println("3. SDT");
                System.out.println("4. Ngay sinh");
                System.out.println("5. Gioi tinh");
                System.out.println("6. Luong");
                System.out.println("0. Thoat");

                int choice;
                do {
                    System.out.print("Nhap lua chon: ");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.print("Nhap ho moi: ");
                            String ho = sc.nextLine();
                            dsnv[i].setHo(ho);
                            break;
                        case 2:
                            System.out.print("Nhap ten moi: ");
                            String ten = sc.nextLine();
                            dsnv[i].setTen(ten);
                            break;
                        case 3:
                            System.out.print("Nhap SDT moi: ");
                            String sdt = sc.nextLine();
                            dsnv[i].setSDT(sdt);
                            break;
                        case 4:
                            System.out.print("Nhap ngay sinh moi: ");
                            String ngaysinh = sc.nextLine();
                            dsnv[i].setNgaySinh(ngaysinh);
                            break;
                        case 5:
                            System.out.print("Nhap gioi tinh moi: ");
                            String gioitinh = sc.nextLine();
                            dsnv[i].setGioiTinh(gioitinh);
                            break;
                        case 6:
                            System.out.print("Nhap luong moi: ");
                            double luong = sc.nextDouble();
                            dsnv[i].setLuong(luong);
                            break;
                    }
                } while (choice != 0);
                return;
            }
        }
        System.out.println("Khong tim thay nhan vien co ma " + manv);
    }

    //Thống kê:
    public int[] thongKeGioiTinh() {
        int nam = 0, nu = 0;
        for (int i = 0; i < n; i++) {
            if (dsnv[i].getGioiTinh().equals("nam") || dsnv[i].getGioiTinh().equals( "Nam")) {
                nam++;
            }
            else nu++;
        }
        System.out.println("Nam: " + nam);
        System.out.println("Nu: " + nu);
        return new int[]{nam, nu};
    }

    //Đọc file:
    public void docFile(String filePath) {
        dsnv = new NhanVien[0];
        n = 0;
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length < 5) continue;

                String manv = parts[0].trim();
                String ho = parts[1].trim();
                String ten = parts[2].trim();
                String sdt = parts[3].trim();
                String ngaysinh = parts[4].trim();
                String gioitinh = parts[5].trim();
                double luong = Double.parseDouble(parts[6].trim());

                NhanVien nv = new NhanVien(manv, ho, ten, sdt, ngaysinh, gioitinh, luong);
                themNhanVien(nv);

            }
            // System.out.println("Da doc file " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    //Ghi File:
    public void ghiFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Java/DoAn/input/inputNhanVien.txt", true))) {
            for (int i=0;i<n;i++) {
                writer.print(dsnv[i].getMaNV());
                writer.print(", " + dsnv[i].getHo());
                writer.print(", " + dsnv[i].getTen());
                writer.print(", " + dsnv[i].getSDT());
                writer.print(", " + dsnv[i].getNgaySinh());
                writer.print(", " + dsnv[i].getGioiTinh());
                writer.println(", " + dsnv[i].getLuong());
            }
        }
        catch (IOException e) {}
    }
}
