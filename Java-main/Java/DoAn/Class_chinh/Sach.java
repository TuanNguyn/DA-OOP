package Java.DoAn.Class_chinh;

public class Sach {
    // Thuộc tính:
    private String masach, tensach, tacgia, matl, manxb;
    private int soLuong;
    private double dongia;

    // Phương thức:

    //Hàm thiết lập:
    public Sach() {
    }
    public Sach(String masach, String tensach, String tacgia, String matl, String manxb, int soLuong, double dongia) {
        this.masach = masach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.matl = matl;
        this.manxb = manxb;
        this.soLuong = soLuong;
        this.dongia = dongia;
    }
    public Sach(Sach s) {
        this.masach = s.masach;
        this.tensach = s.tensach;
        this.tacgia = s.tacgia;
        this.matl = s.matl;
        this.manxb = s.manxb;
        this.soLuong = s.soLuong;
        this.dongia = s.dongia;
    }

    // Nhập, xuất:
    public void nhap() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        masach = sc.nextLine();
        System.out.print("Nhap ten sach: ");
        tensach = sc.nextLine();
        System.out.print("Nhap tac gia: ");
        tacgia = sc.nextLine();
        System.out.print("Nhap ma the loai: ");
        matl = sc.nextLine();
        System.out.print("Nhap ma nha xuat ban: ");
        manxb = sc.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();
        System.out.print("Nhap don gia: ");
        dongia = sc.nextDouble();
    }
    public void xuat() {
        System.out.printf("%-10s %-20s %-20s %-10s %-10s %-10d %-10.2f", masach, tensach, tacgia, matl, manxb, soLuong, dongia);
    }

    // Get, set:
    public String getMaSach() {
        return masach;
    }
    public void setMaSach(String masach) {
        this.masach = masach;
    }
    public String getTenSach() {
        return tensach;
    }
    public void setTenSach(String tensach) {
        this.tensach = tensach;
    }
    public String getTacGia() {
        return tacgia;
    }
    public void setTacGia(String tacgia) {
        this.tacgia = tacgia;
    }
    public String getMaTL() {
        return matl;
    }
    public void setMaTL(String matl) {
        this.matl = matl;
    }
    public String getMaNXB() {
        return manxb;
    }
    public void setMaNXB(String manxb) {
        this.manxb = manxb;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public double getDonGia() {
        return dongia;
    }
    public void setDonGia(double dongia) {
        this.dongia = dongia;
    }
}
