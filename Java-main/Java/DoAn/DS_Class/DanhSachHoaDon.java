package Java.DoAn.DS_Class;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import Java.DoAn.DS_Class.DanhSachCTHD;
import Java.DoAn.DS_Class.DanhSachKH;
import Java.DoAn.DS_Class.DanhSachNV;

import Java.DoAn.Class_chinh.ChiTietHoaDon;
import Java.DoAn.Class_chinh.HoaDon;

public class DanhSachHoaDon {
    private HoaDon dshd[];
    private int n;

    java.util.Scanner sc = new java.util.Scanner(System.in);

    //Hàm thiết lập:
    public DanhSachHoaDon() {
        n = 0;
    }
    public DanhSachHoaDon(HoaDon[] dshd, int n) {
        this.dshd = dshd;
        this.n = n;
    }
    public DanhSachHoaDon(DanhSachHoaDon dshd) {
        this.n = dshd.n;
        this.dshd = new HoaDon[n];
        for (int i = 0; i < n; i++) {
            this.dshd[i] = new HoaDon(dshd.dshd[i]);
        }
    }

    //Nhập, xuất:
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong hoa don: ");
        n = sc.nextInt();
        sc.nextLine();
        dshd = new HoaDon[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin hoa don thu " + (i + 1) + ":");
            dshd[i] = new HoaDon();
            dshd[i].nhap();
        }
    }
    public void xuat() {
        System.out.printf("%-10s %-10s %-10s %-15s %15s\n", "Ma HD", "Ma NV", "Ma KH", "Ngay Lap", "Tong Tien");
        for (int i = 0; i < n; i++) {
            dshd[i].xuat();
        }   
    }

    public void DSHD() {
        n = 0;
        dshd = new HoaDon[0];
    }

    //Thêm:
    public void themHDFile() {  
        DanhSachCTHD dscthd = new DanhSachCTHD();
        dscthd.docFile("Java/DoAn/input/inputChiTietHD.txt");
        for (int i = 0; i < dscthd.size(); i++) {
            ChiTietHoaDon cthd = dscthd.getCTHD(i);
            String mahd = cthd.getMaHD();
            HoaDon hd = this.timHoaDon(mahd);
            if (hd != null) {
                double thanhtien = cthd.getThanhTien();
                hd.setTongTien(hd.getTongTien() + thanhtien);
            }
        }
    }
    public void themHoaDon() {
        n = dshd.length;
        dshd = Arrays.copyOf(dshd, n+1);
        dshd[n] = new HoaDon();
        dshd[n].nhap();
        n++;
    }
    public void themHoaDon(HoaDon hd) {
        n = dshd.length;
        dshd = Arrays.copyOf(dshd, n+1);
        dshd[n] = new HoaDon(hd);
        n++;
    }

    //Tìm
    public void timHoaDon() {
        System.out.print("Nhap ma hoa don can tim: ");
        String ma = sc.nextLine();
        timHoaDon(ma);
    }
    public HoaDon timHoaDon(String ma) {
        for (int i=0; i<n;i++) {
            if (dshd[i].getMaHD().equals(ma)) {
                dshd[i].xuat();
                return dshd[i];
            }
        }
        System.out.print("Khong tim thay hoa don co ma " + ma);
        return null;
    }

    //Sửa
    public void suaHoaDon() {
        System.out.print("Nhap ma hoa don can sua");
        String ma = sc.nextLine();
        suaHoaDon(ma);
    }
    public void suaHoaDon(String ma) {
        for (int i=0;i<n;i++) {
            if (dshd[i].getMaHD().equals(ma)) {
                System.out.println("Chon thong tin can sua:");
                System.out.println("1.Ma hoa don");
                System.out.println("2.Ma nhan vien");
                System.out.println("3.Ma khach hang");
                System.out.println("4.Ngay lap");
                System.out.println("5.Tong tien");
                System.out.println("0.Thoat");

                int choice;
                do {
                    System.out.println("Nhap lua chon");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.print("Nhap ma hoa don moi");
                            String mahd = sc.nextLine();
                            dshd[i].setMaHD(mahd);
                            break;
                        case 2:
                            System.out.print("Nhap ma nhan vien moi");
                            String manv = sc.nextLine();
                            dshd[i].setMaNV(manv);
                            break;
                        case 3:
                            System.out.print("Nhap ma khach hang moi");
                            String makh = sc.nextLine();
                            dshd[i].setMaKH(makh);
                            break;
                        case 4:
                            System.out.print("Nhap ngay lap moi");
                            String ngaylap = sc.nextLine();
                            dshd[i].setNgayLap(ngaylap);
                            break;
                        case 5:
                            System.out.print("Nhap tong tien moi");
                            Double tongtien = sc.nextDouble();
                            dshd[i].setTongTien(tongtien);
                            break;
                    }
                } while (choice != 0);
            }
        }
    }

    //Xóa
    public void xoaHoaDon() {
        System.out.print("Nhap ma hoa don can xoa");
        String ma = sc.nextLine();
        xoaHoaDon(ma);
    }
    public void xoaHoaDon(String ma) {
        for (int i=0;i<n;i++) {
            if (dshd[i].getMaHD().equals(ma)) {
                for (int j=i;j<n-1;j++) {
                    dshd[j] =dshd[j+1];
                }
                dshd = Arrays.copyOf(dshd, n-1);
                n--;
                System.out.println("Da xoa hoa don co ma" +  ma);
                return;
            }
        }
        System.out.println("Khong tim thay hoa don co ma" + ma);
    }

    //Thống kê:
    public Map<Integer, Double> thongKeTongThu() {
        Map<Integer, Double> tongthuMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            LocalDate ngaylap = LocalDate.parse(dshd[i].getNgayLap());
            int nam = ngaylap.getYear();
            double tongtien = dshd[i].getTongTien();
            if (tongthuMap.containsKey(nam)) {
                tongthuMap.put(nam, tongthuMap.get(nam) + tongtien);
            } 
            else {
                tongthuMap.put(nam, tongtien);
            }
        }
        System.out.println("Tong thu tung nam:");
        for (Map.Entry<Integer, Double> entry : tongthuMap.entrySet()) {
            System.out.println("Nam" + entry.getKey() + " : " + entry.getValue());
        }
        return tongthuMap;
    }

    //Đọc File
    public void docFile(String filePath) {
        this.dshd = new HoaDon[0];
        n = 0;
        DanhSachNV dsnv = new DanhSachNV();
        dsnv.docFile("Java/DoAn/input/inputNhanVien.txt");
        DanhSachKH dskh = new DanhSachKH();
        dskh.docFile("Java/DoAn/input/inputKhachHang.txt");
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length < 4) continue;

                String mahd = parts[0].trim();
                String manv = parts[1].trim();
                if (dsnv.timNhanVien(manv) == null) {
                    System.out.println("Ma nhan vien " + manv + " khong ton tai. Bo qua hoa don " + mahd);
                    continue;
                }
                String makh = parts[2].trim();
                if (dskh.timKhachHang(makh) == null) {
                    System.out.println("Ma khach hang " + makh + " khong ton tai. Bo qua hoa don " + mahd);
                    continue;
                }
                String ngaylap = parts[3].trim();

                HoaDon hd = new HoaDon(mahd, manv, makh, ngaylap, 0.0);
                themHoaDon(hd);

            }
            // System.out.println("Da doc file " + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    // Phương thức mới: Xuất chi tiết hóa đơn theo mã
    // Giải thích: Hàm này nhận vào mã hóa đơn (maHD)
    // Nó sẽ tìm trong file chi tiết và in ra tất cả dòng chi tiết có cùng mã đó
    public void xuatChiTietTheoMa(String maHD) {
        // Bước 1: Kiểm tra xem mã hóa đơn có tồn tại không
        HoaDon hd = timHoaDon(maHD);
        if (hd == null) {
            System.out.println("Khong tim thay hoa don voi ma: " + maHD);
            return; // Dừng hàm nếu không tìm thấy
        }

        // Bước 2: Đọc file chi tiết hóa đơn
        DanhSachCTHD dscthd = new DanhSachCTHD();
        dscthd.docFile("Java/DoAn/input/inputChiTietHD.txt");

        // Bước 3: In tiêu đề thông tin hóa đơn
        System.out.println("\n========================================");
        System.out.println("THONG TIN HOA DON: " + maHD);
        System.out.println("========================================");
        hd.xuat(); // In thông tin hóa đơn

        // Bước 4: In tiêu đề bảng chi tiết
        System.out.println("\n--- CHI TIET HOA DON ---");
        System.out.printf("%-10s %-15s %-10s %12s %12s\n", 
                         "Ma HD", "Ma Sach", "So Luong", "Don Gia", "Thanh Tien");
        System.out.println("--------------------------------------------------------------");

        // Bước 5: Duyệt qua tất cả chi tiết và chỉ in những dòng có mã trùng
        boolean coChiTiet = false; // Biến đánh dấu có chi tiết hay không
        for (int i = 0; i < dscthd.size(); i++) {
            ChiTietHoaDon ct = dscthd.getCTHD(i);
            // So sánh mã hóa đơn: nếu trùng thì in ra
            if (ct.getMaHD().equals(maHD)) {
                ct.xuat(); // Gọi phương thức xuat() của ChiTietHoaDon
                coChiTiet = true; // Đánh dấu đã có chi tiết
            }
        }

        // Bước 6: Thông báo nếu không có chi tiết nào
        if (!coChiTiet) {
            System.out.println("Khong co chi tiet nao cho hoa don nay.");
        }
        System.out.println("========================================\n");
    }
}
