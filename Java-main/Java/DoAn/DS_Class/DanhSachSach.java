package Java.DoAn.DS_Class;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Java.DoAn.Class_chinh.Sach;
import Java.DoAn.Class_chinh.SachNuocNgoai;
import Java.DoAn.Class_chinh.TapChi;

public class DanhSachSach {
    private Sach[] ds;
    private int n;

    //Hàm thiết lập:
    public DanhSachSach() {
        n = 0;
    }
    public DanhSachSach(Sach[] ds, int n) {
        this.ds = ds;
        this.n = n;
    }
    public DanhSachSach(DanhSachSach s) {
        this.n = s.n;
        this.ds = new Sach[n];
        for (int i = 0; i < n; i++) {
            this.ds[i] = s.ds[i];
        }
    }

    //Nhập, xuất:
    public void nhap() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap so luong sach: ");
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin sach thu " + (i + 1) + ":");
            System.out.println("Nhap sach binh thuong (1) hay sach nuoc ngoai (2) hay tap chi (3): ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                ds[i] = new Sach();
                ds[i].nhap();
            } else if (choice == 2) {
                ds[i] = new SachNuocNgoai();
                ds[i].nhap();
            } else if (choice == 3) {
                ds[i] = new TapChi();
                ds[i].nhap();
            } else {
                System.out.println("Lua chon khong hop le. Mac dinh nhap sach binh thuong.");
                ds[i] = new Sach();
            }
            ds[i].nhap();
        }
    }
    public void xuat() {
        for (int i = 0; i < n; i++) {
            ds[i].xuat();
            System.out.println();
        }
    }

    // Thêm:
    public void themSach() {
        n = ds.length;
        ds = java.util.Arrays.copyOf(ds, n + 1);
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Nhap sach binh thuong (1) hay sach nuoc ngoai (2) hay tap chi (3): ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            ds[n] = new Sach();
            ds[n].nhap();
        } else if (choice == 2) {
            ds[n] = new SachNuocNgoai();
            ds[n].nhap();
        } else if (choice == 3) {
            ds[n] = new TapChi();
            ds[n].nhap();
        } else {
            System.out.println("Lua chon khong hop le. Mac dinh nhap sach binh thuong.");
            ds[n] = new Sach();
            ds[n].nhap();
        }
        n++;
    }
    public void themSach(String maSach) {
        n = ds.length;
        ds = java.util.Arrays.copyOf(ds, n + 1);
        ds[n] = new Sach();
        ds[n].setMaSach(maSach);
        n++;
    }
    public void themSach(Sach sach) {
        n = ds.length;
        ds = java.util.Arrays.copyOf(ds, n + 1);
        ds[n] = new Sach(sach);
        n++;
    }

    //Tìm:
    public void timSach() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap ma sach can tim: ");
        String ma = sc.nextLine();
        timSach(ma);
    }
    public Sach timSach(String ma) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaSach().equals(ma)) {
                ds[i].xuat();
                return ds[i];
            }
        }
        System.out.println("Khong tim thay sach co ma " + ma);
        return null;
    }

    //Xóa:
    public void xoaSach() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap ma sach can xoa: ");
        String ma = sc.nextLine();
        xoaSach(ma);
    }
    public void xoaSach(String ma) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaSach().equals(ma)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, n-1);
                n--;
                System.out.println("Da xoa sach co ma " + ma);
                return;
            }
        }
        System.out.println("Khong tim thay sach co ma " + ma);
    }

    //Sửa:
    public void suaSach() {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Nhap ma sach can sua: ");
        String ma = sc.nextLine();
        suaSach(ma);
    }
    public void suaSach(String masach) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaSach().equals(masach)) {               
                System.out.println("Chon thong tin can sua:");
                System.out.println("1. Ten sach");
                System.out.println("2. Tac gia");
                System.out.println("3. Ma the loai");
                System.out.println("4. Ma nha xuat ban");
                System.out.println("5. So luong");
                System.out.println("6. Don gia");
                if (ds[i] instanceof SachNuocNgoai) {
                    System.out.println("7. Quoc gia");
                    System.out.println("8. Ngon ngu");
                } else if (ds[i] instanceof TapChi) {
                    System.out.println("7. So phat hanh");
                    System.out.println("8. Chuyen muc");
                }
                System.out.println("0. Thoat");
                java.util.Scanner sc = new java.util.Scanner(System.in);
                int choice;
                sc.nextLine();
                do {
                    System.out.print("Nhap lua chon: ");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.print("Nhap ten sach moi: ");
                            String tensach = sc.nextLine();
                            ds[i].setTenSach(tensach);
                            break;
                        case 2:
                            System.out.print("Nhap tac gia moi: ");
                            String tacgia = sc.nextLine();
                            ds[i].setTacGia(tacgia);
                            break;
                        case 3:
                            System.out.print("Nhap ma the loai moi: ");
                            String maTL = sc.nextLine();
                            ds[i].setMaTL(maTL);
                            break;
                        case 4:
                            System.out.print("Nhap ma nha xuat ban moi: ");
                            String maNXB = sc.nextLine();
                            ds[i].setMaNXB(maNXB);
                            break;
                        case 5:
                            System.out.print("Nhap so luong moi: ");
                            int soLuong = sc.nextInt();
                            ds[i].setSoLuong(soLuong);
                            break;
                        case 6:
                            System.out.print("Nhap don gia moi: ");
                            double donGia = sc.nextDouble();
                            ds[i].setDonGia(donGia);
                            break;
                        case 7:
                            if (ds[i] instanceof SachNuocNgoai) {
                                System.out.print("Nhap quoc gia moi: ");
                                String quocgia = sc.nextLine();
                                ((SachNuocNgoai) ds[i]).setQuocGia(quocgia);
                            } else if (ds[i] instanceof TapChi) {
                                System.out.print("Nhap so phat hanh moi: ");
                                int sophathanh = sc.nextInt();
                                ((TapChi) ds[i]).setSoPhatHanh(sophathanh);
                            }
                            break;
                        case 8:
                            if (ds[i] instanceof SachNuocNgoai) {
                                System.out.print("Nhap ngon ngu moi: ");
                                String ngonngu = sc.nextLine();
                                ((SachNuocNgoai) ds[i]).setNgonNgu(ngonngu);
                            } else if (ds[i] instanceof TapChi) {
                                System.out.print("Nhap chuyen muc moi: ");
                                String chuyenmuc = sc.nextLine();
                                ((TapChi) ds[i]).setChuyenMuc(chuyenmuc);
                            }
                            break;
                    }
                } while (choice != 0);
                return;
            }
        }
        System.out.println("Khong tim thay sach co ma " + masach);  
    }

    //Cập nhật số lượng:
    public void capNhatSL(String masach, int soluong) {
        for (int i=0;i<n;i++) {
            if (ds[i].getMaSach().equals(masach)) {
                int slmoi = ds[i].getSoLuong() + soluong;
                ds[i].setSoLuong(slmoi);
                return;
            }
        }
    }

        //Thống kê:
    public Map<String, Integer> thongKeTheLoai() {
        Map<String, Integer> theloaiMap = new HashMap<>();
        for (int i=0; i<n; i++) {
            String tl = ds[i].getMaTL();
            if (theloaiMap.containsKey(tl)) {
                theloaiMap.put(tl, theloaiMap.get(tl) + 1);
            }
            else {
                theloaiMap.put(tl, 1);
            }
        }
        System.out.println("The Loai:");
        for (Map.Entry<String, Integer> entry : theloaiMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + "quyen");
        }
        return theloaiMap;
    }

    //Đoc file:
    public void docFile(String filePath) {
        ds = new Sach[0];
        n = 0;
        DanhSachNXB dsnxb = new DanhSachNXB();
        dsnxb.docFile("Java/DoAn/input/inputNhaXuatBan.txt");
        try (Scanner sc = new Scanner(new java.io.File(filePath))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length < 7) continue;

                String masach = parts[0].trim();
                String tensach = parts[1].trim();
                String tacgia = parts[2].trim();
                String matl = parts[3].trim();
                String manxb = parts[4].trim();
                
                // Validate mã NXB
                if (dsnxb.timNXB(manxb) == null) {
                    System.out.println("Ma nha xuat ban " + manxb + " khong ton tai. Bo qua sach " + masach);
                    continue;
                }
                
                int soLuong = Integer.parseInt(parts[5].trim());
                double donGia = Double.parseDouble(parts[6].trim());
                Sach s;

                // Kiểm tra xem có loại sách hay không
                if (parts.length == 7) { 
                    s = new Sach(masach, tensach, tacgia, matl, manxb, soLuong, donGia);
                } 
                else if (parts[7].trim().equalsIgnoreCase("SachNN")) {
                    String ngonNgu = parts[8].trim();
                    String quocGia = parts[9].trim();
                    s = new SachNuocNgoai(masach, tensach, tacgia, matl, manxb, soLuong, donGia, ngonNgu, quocGia);
                } 
                else if (parts[7].trim().equalsIgnoreCase("TapChi")) {
                    int soPhatHanh = Integer.parseInt(parts[9].trim());
                    String chuyenMuc = parts[10].trim();
                    s = new TapChi(masach, tensach, tacgia, matl, manxb, soLuong, donGia, soPhatHanh, chuyenMuc);
                } 
                else {
                    continue; // bỏ dòng lỗi
                }
                themSach(s);
            }
            // System.out.println("Da doc file " + filePath);
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Khong tim thay file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }
}
                

