package Java.DoAn.DS_Class;

import Java.DoAn.Class_chinh.CTPhieuNhapHang;
import Java.DoAn.Class_chinh.PhieuNhapHang;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DanhSachPNH {
    private PhieuNhapHang dsPNH[];
    private int n;

    Scanner sc = new Scanner(System.in);

    public DanhSachPNH() {
        n = 0;
        dsPNH = new PhieuNhapHang[0];
    }
    public DanhSachPNH( PhieuNhapHang[] dsPNH,int n){
        this.dsPNH=dsPNH;
        this.n=n;
    }
    public DanhSachPNH(DanhSachPNH dsPNH){
        this.n = dsPNH.n;
        this.dsPNH = new PhieuNhapHang[n];
        for (int i=0;i<n;i++){
            this.dsPNH[i] = new PhieuNhapHang(dsPNH.dsPNH[i]);
        }
    }

    public void nhap() {
        System.out.print("Nhap so luong Phieu Nhap Hang: ");
        n = sc.nextInt();
        sc.nextLine();
        dsPNH = new PhieuNhapHang[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin Phieu Nhap Hang thu " + (i + 1) + ":");
            dsPNH[i] = new PhieuNhapHang();
            dsPNH[i].nhap();
        }
    }
    public void xuat() {
        System.out.printf("%-10s %-10s %-10s %-15s %15s\n", "Ma PNH", "Ma NV", "Ma NCC", "Ngay Lap", "Tong Tien");
        for (int i = 0; i < n; i++) {
            dsPNH[i].xuat();
        }   
    }

    public void DSPNH() {
        n = 0;
        dsPNH = new PhieuNhapHang[0];

}
// Thêm
            public void themPNHFile() {
                DanhSachCTPNH dsctPNH = new DanhSachCTPNH();
                dsctPNH.docFile("Java/DoAn/input/inputChiTietPNH.txt");
                for (int i = 0; i < dsctPNH.size(); i++) {
                    CTPhieuNhapHang ctPNH = dsctPNH.getCTPNH(i);
                    String maPNH = ctPNH.getmaPNH();
                    PhieuNhapHang pnh = this.timPNH(maPNH);
                    if (pnh != null) {
                        double thanhtien = ctPNH.thanhTien();
                        pnh.setTongTien(pnh.getTongTien() + thanhtien);
                    }
                }
            }

            public PhieuNhapHang themPNH() {
                n = dsPNH.length;
                dsPNH = Arrays.copyOf(dsPNH, n + 1);
                dsPNH[n] = new PhieuNhapHang();
                dsPNH[n].nhap();
                n++;
                return dsPNH[n - 1];
            }

            public void themPNH(PhieuNhapHang pnh) {
                dsPNH = Arrays.copyOf(dsPNH, n + 1);
                dsPNH[n] = new PhieuNhapHang(pnh);
                n++;
            }

            // Tìm
            public void timPNH() {
                System.out.print("Nhap ma Phieu Nhap Hang can tim: ");
                String ma = sc.nextLine();
                timPNH(ma);
            }

            public PhieuNhapHang timPNH(String ma) {
                for (int i = 0; i < n; i++) {
                    if (dsPNH[i].getMaPNH().equals(ma)) {
                        dsPNH[i].xuat();
                        return dsPNH[i];
                    }
                }
                System.out.println("Khong tim thay Phieu Nhap Hang co ma " + ma);
                return null;
            }

            // Sửa
            public void suaPNH() {
                System.out.print("Nhap ma phieu nhap can sua: ");
                String ma = sc.nextLine();
                suaPNH(ma);
            }

            public void suaPNH(String ma) {
                for (int i = 0; i < n; i++) {
                    if (dsPNH[i].getMaPNH().equals(ma)) {
                        System.out.println("Chon thong tin can sua:");
                        System.out.println("1.Ma phieu nhap");
                        System.out.println("2.Ma nhan vien");
                        System.out.println("3.Ma nha cung cap");
                        System.out.println("4.Ngay lap");
                        System.out.println("5.Tong tien");
                        System.out.println("0.Thoat");

                        int choice;
                        do {
                            System.out.print("Nhap lua chon: ");
                            choice = sc.nextInt();
                            sc.nextLine();
                            switch (choice) {
                                case 1:
                                    System.out.print("Nhap ma phieu nhap moi: ");
                                    String mapnh = sc.nextLine();
                                    dsPNH[i].setMaPNH(mapnh);
                                    break;
                                case 2:
                                    System.out.print("Nhap ma nhan vien moi: ");
                                    String manv = sc.nextLine();
                                    dsPNH[i].setMaNV(manv);
                                    break;
                                case 3:
                                    System.out.print("Nhap ma nha cung cap moi: ");
                                    String mancc = sc.nextLine();
                                    dsPNH[i].setMaNCC(mancc);
                                    break;
                                case 4:
                                    System.out.print("Nhap ngay lap moi: ");
                                    String ngay = sc.nextLine();
                                    dsPNH[i].setNgayLapPhieu(ngay);
                                    break;
                                case 5:
                                    System.out.print("Nhap tong tien moi: ");
                                    double tong = sc.nextDouble();
                                    dsPNH[i].setTongTien(tong);
                                    break;
                            }
                        } while (choice != 0);
                        return;
                    }
                }
                System.out.println("Khong tim thay phieu nhap co ma " + ma);
            }

            // Xóa
            public void xoaPNH() {
                System.out.print("Nhap ma phieu nhap can xoa: ");
                String ma = sc.nextLine();
                xoaPNH(ma);
            }

            public void xoaPNH(String ma) {
                for (int i = 0; i < n; i++) {
                    if (dsPNH[i].getMaPNH().equals(ma)) {
                        for (int j = i; j < n - 1; j++) {
                            dsPNH[j] = dsPNH[j + 1];
                        }
                        dsPNH = Arrays.copyOf(dsPNH, n - 1);
                        n--;
                        System.out.println("Da xoa phieu nhap co ma " + ma);
                        return;
                    }
                }
                System.out.println("Khong tim thay phieu nhap co ma " + ma);
            }

            // Thống kê
            public Map<Integer, Double> thongKeTheoNam() {
                Map<Integer, Double> map = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    try {
                        LocalDate ngaylap = LocalDate.parse(dsPNH[i].getNgayLapPhieu());
                        int nam = ngaylap.getYear();
                        double tong = dsPNH[i].getTongTien();
                        map.put(nam, map.getOrDefault(nam, 0.0) + tong);
                    } catch (Exception e) {
                        // bo qua dong loi format
                    }
                }
                return map;
            }

            public double tongTienTatCa() {
                double sum = 0.0;
                for (int i = 0; i < n; i++) {
                    sum += dsPNH[i].getTongTien();
                }
                return sum;
            }

            public int tongSoPhieu() {
                return n;
            }

            // Doc File
            public void docFile(String filePath) {
                this.dsPNH = new PhieuNhapHang[0];
                n = 0;
                DanhSachNV dsnv = new DanhSachNV();
                dsnv.docFile("Java/DoAn/input/inputNhanVien.txt");
                DanhSachNCC dsncc = new DanhSachNCC();
                dsncc.docFile("Java/DoAn/input/inputNhaCungCap.txt");
                try (Scanner fileScanner = new Scanner(new File(filePath))) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine().trim();
                        if (line.isEmpty())
                            continue;

                        String[] parts = line.split(",");
                        if (parts.length < 4)
                            continue;

                        String mapnh = parts[0].trim();
                        String manv = parts[1].trim();
                        if (dsnv.timNhanVien(manv) == null) {
                            System.out.println("Ma nhan vien " + manv + " khong ton tai. Bo qua phieu " + mapnh);
                            continue;
                        }
                        String mancc = parts[2].trim();
                        if (dsncc.timNCC(mancc) == null) {
                            System.out.println("Ma nha cung cap " + mancc + " khong ton tai. Bo qua phieu " + mapnh);
                            continue;
                        }
                        String ngaylap = parts[3].trim();

                        PhieuNhapHang pnh = new PhieuNhapHang(mapnh, manv, mancc, ngaylap);
                        themPNH(pnh);
                    }
                    // System.out.println("Da doc file " + filePath);
                } catch (FileNotFoundException e) {
                    System.out.println("Khong tim thay file: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Loi doc file: " + e.getMessage());
                }
            }

    public void xuatChiTietTheoMa(String maPNH) {

        PhieuNhapHang pnh = timPNH(maPNH);
        if (pnh == null) {
            System.out.println("Khong tim thay phieu nhap hang voi ma: " + maPNH);
            return; 
        }

 
    DanhSachCTPNH dsctPNH = new DanhSachCTPNH();
        dsctPNH.docFile("Java/DoAn/input/inputChiTietPNH.txt");

        System.out.println("THONG TIN PHIEU NHAP HANG: " + maPNH);

        pnh.xuat(); 

    System.out.println("\n--- CHI TIET PHIEU NHAP HANG ---");
        System.out.printf("%-10s %-15s %-10s %12s %12s\n", 
                         "Ma PNH", "Ma Sach", "So Luong", "Don Gia", "Thanh Tien");
        System.out.println("--------------------------------------------------------------");

        boolean coChiTiet = false; 
        for (int i = 0; i < dsctPNH.size(); i++) {
            CTPhieuNhapHang ct = dsctPNH.getCTPNH(i);
 
            if (ct.getmaPNH().equals(maPNH)) {
                ct.xuat(); 
                coChiTiet = true; 
            }
        }

        if (!coChiTiet) {
            System.out.println("Khong co chi tiet nao cho phieu nhap hang nay.");
        }
      
    }

    public PhieuNhapHang layPNHCuoi() {
        if (n <= 0 || dsPNH == null || dsPNH.length == 0) return null;
        return dsPNH[n - 1];
    }
}