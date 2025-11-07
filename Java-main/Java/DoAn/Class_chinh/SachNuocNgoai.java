package Java.DoAn.Class_chinh;

public class SachNuocNgoai extends Sach {
    // Thuộc tính:
    String ngonngu, quocgia;

    // Phương thức:

    //Hàm thiết lập:
    public SachNuocNgoai() {
        super();
    }  
    public SachNuocNgoai(String masach, String tensach, String tacgia, String maTL, String maNXB, int soLuong, double donGia, String ngonngu, String quocgia) {
        super(masach, tensach, tacgia, maTL, maNXB, soLuong, donGia);
        this.ngonngu = ngonngu;
        this.quocgia = quocgia;
    }
    public SachNuocNgoai(SachNuocNgoai s) {
        super(s);
        this.ngonngu = s.ngonngu;
        this.quocgia = s.quocgia;
    }

    // Nhập, xuất:
    @Override
    public void nhap() {
        super.nhap();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap ngon ngu: ");
        ngonngu = sc.nextLine();
        System.out.print("Nhap quoc gia: ");
        quocgia = sc.nextLine();
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-10s ", ngonngu);
        System.out.printf("%-10s\n", quocgia);
    }

    // Get, set:
    public String getNgonNgu() {
        return ngonngu;
    }
    public void setNgonNgu(String ngonngu) {
        this.ngonngu = ngonngu;
    }
    public String getQuocGia() {
        return quocgia;
    }
    public void setQuocGia(String quocgia) {
        this.quocgia = quocgia;
    }
    
}
