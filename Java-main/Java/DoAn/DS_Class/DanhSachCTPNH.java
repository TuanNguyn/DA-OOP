package Java.DoAn.DS_Class;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import Java.DoAn.Class_chinh.CTPhieuNhapHang;

public class DanhSachCTPNH {
    private CTPhieuNhapHang[] dsctPNH;
    private int n;

    //Đọc file:
    public void docFile(String filePath) {
        dsctPNH = new CTPhieuNhapHang[0];
        n = 0;
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length < 5) continue;

                String maPNH = parts[0].trim();
                String maSach = parts[1].trim();
                int soluong = Integer.parseInt(parts[2].trim());
                double donGia = Double.parseDouble(parts[3].trim());
                double thanhTien = Double.parseDouble(parts[4].trim());

                CTPhieuNhapHang ctPNH = new CTPhieuNhapHang(maPNH, maSach, soluong, donGia, thanhTien);
                themChiTietPNH(ctPNH);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void themChiTietPNH(CTPhieuNhapHang ctPNH) {
        dsctPNH = Arrays.copyOf(dsctPNH, n + 1);
        dsctPNH[n] = ctPNH;
        n++;
    }

    public int size() {
        return n;
    }

    //get:
    public CTPhieuNhapHang getCTPNH(int i) {
        if (i >= 0 && i < n) return dsctPNH[i];
        return null;
    }
}