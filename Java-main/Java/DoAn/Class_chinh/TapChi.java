package Java.DoAn.Class_chinh;

public class TapChi  extends Sach {
    // Thuộc tính:
    private int sophathanh;
    private String chuyenmuc;

    // Phương thức:

    //Hàm thiết lập:
    public TapChi() {
        super();
    }
    public TapChi(String masach, String tensach, String tacgia, String maTL, String maNXB, int soLuong, double donGia, int sophathanh, String chuyenmuc) {
        super(masach, tensach, tacgia, maTL, maNXB, soLuong, donGia);
        this.sophathanh = sophathanh;
        this.chuyenmuc = chuyenmuc;
    }
    public TapChi(TapChi t) {
        super(t);
        this.sophathanh = t.sophathanh;
        this.chuyenmuc = t.chuyenmuc;
    }

    // Nhập, xuất:
    @Override
    public void nhap() {
        super.nhap();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap so phat hanh: ");
        sophathanh = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap chuyen muc: ");
        chuyenmuc = sc.nextLine();
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-10d ", sophathanh);
        System.out.printf("%-10s\n", chuyenmuc);
    }

    // Get, set:
    public int getSoPhatHanh() {
        return sophathanh;
    } 
    public void setSoPhatHanh(int sophathanh) {
        this.sophathanh = sophathanh;
    }
    public String getChuyenMuc() {
        return chuyenmuc;
    }
    public void setChuyenMuc(String chuyenmuc) {
        this.chuyenmuc = chuyenmuc;
    }

}
