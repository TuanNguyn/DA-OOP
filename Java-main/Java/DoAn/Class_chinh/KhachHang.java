package Java.DoAn.Class_chinh;

import java.util.Scanner;

public class KhachHang {
    // Thuộc tính
    private String makh, ho, ten, sdt, diachi;

    // Hàm thiết lập
    public KhachHang() {
    }

    public KhachHang(String makh, String ho, String ten, String sdt, String diachi) {
        this.makh = makh;
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public KhachHang(KhachHang kh) {
        this.makh = kh.makh;
        this.ho = kh.ho;
        this.ten = kh.ten;
        this.sdt = kh.sdt;
        this.diachi = kh.diachi;
    }

    // Nhập, xuất
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma khach hang: ");
        makh = sc.nextLine();
        System.out.print("Nhap ho: ");
        ho = sc.nextLine();
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        sdt = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diachi = sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s %-15s %-10s %-15s %-30s\n", makh, ho, ten, sdt, diachi);
    }

    // Get, set
    public String getMaKH() {
        return makh;
    }

    public void setMaKH(String makh) {
        this.makh = makh;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSDT() {
        return sdt;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diachi;
    }

    public void setDiaChi(String diachi) {
        this.diachi = diachi;
    }
}
