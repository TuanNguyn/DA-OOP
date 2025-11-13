package Java.DoAn.DS_Class;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import Java.DoAn.Class_chinh.TheLoai;

public class DanhSachTheLoai {
	private TheLoai[] ds;
	private int n;

	// Hàm thiết lập
	public DanhSachTheLoai() {
		n = 0;
		ds = new TheLoai[0];
	}

	public DanhSachTheLoai(TheLoai[] ds, int n) {
		this.ds = ds;
		this.n = n;
	}

	public DanhSachTheLoai(DanhSachTheLoai d) {
		this.n = d.n;
		this.ds = new TheLoai[n];
		for (int i = 0; i < n; i++) {
			this.ds[i] = new TheLoai(d.ds[i]);
		}
	}

	// Nhập, xuất
	public void nhapDSTL() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong the loai: ");
		n = sc.nextInt();
		sc.nextLine();
		ds = new TheLoai[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Nhap thong tin the loai thu " + (i + 1) + ":");
			ds[i] = new TheLoai();
			ds[i].nhap();
		}
	}

	public void xuatDSTL() {
		System.out.printf("%-10s %-20s%n", "MaTL", "TenTheLoai");
		for (int i = 0; i < n; i++) {
			ds[i].xuat();
		}
	}

	// Thêm
	public void themTheLoai() {
		if (ds == null || ds.length <= n) {
			ds = Arrays.copyOf(ds == null ? new TheLoai[0] : ds, n + 1);
		}
		ds[n] = new TheLoai();
		ds[n].nhap();
		n++;
	}

	public void themTheLoai(TheLoai tl) {
		ds = Arrays.copyOf(ds, n + 1);
		ds[n] = tl;
		n++;
	}

	// Tìm
	public void timTheLoai() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma the loai can tim: ");
		String ma = sc.nextLine();
		timTheLoai(ma);
	}

	public TheLoai timTheLoai(String ma) {
		for (int i = 0; i < n; i++) {
			if (ds[i].getMaTheLoai().equals(ma)) {
				ds[i].xuat();
				return ds[i];
			}
		}
		System.out.println("Khong tim thay the loai co ma " + ma);
		return null;
	}

	// Xóa
	public void xoaTheLoai() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma the loai can xoa: ");
		String ma = sc.nextLine();
		xoaTheLoai(ma);
	}

	public void xoaTheLoai(String ma) {
		for (int i = 0; i < n; i++) {
			if (ds[i].getMaTheLoai().equals(ma)) {
				for (int j = i; j < n - 1; j++) {
					ds[j] = ds[j + 1];
				}
				ds = Arrays.copyOf(ds, n - 1);
				n--;
				System.out.println("Da xoa the loai co ma " + ma);
				return;
			}
		}
		System.out.println("Khong tim thay the loai co ma " + ma);
	}

	// Sửa
	public void suaTheLoai() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma the loai can sua: ");
		String ma = sc.nextLine();
		suaTheLoai(ma);
	}

	public void suaTheLoai(String ma) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			if (ds[i].getMaTheLoai().equals(ma)) {
				System.out.println("Chon thong tin can sua:");
				System.out.println("1. Ten the loai");
				System.out.println("2. Ma the loai");
				System.out.println("0. Thoat");
				int choice;
				do {
					System.out.print("Nhap lua chon: ");
					choice = sc.nextInt();
					sc.nextLine();
					switch (choice) {
						case 1:
							System.out.print("Nhap ten the loai moi: ");
							String ten = sc.nextLine();
							ds[i].setTenTheLoai(ten);
							break;
						case 2:
							System.out.print("Nhap ma the loai moi: ");
							String maMoi = sc.nextLine();
							ds[i].setMaTheLoai(maMoi);
							break;
					}
				} while (choice != 0);
				return;
			}
		}
		System.out.println("Khong tim thay the loai co ma " + ma);
	}

	// Đọc file
	public void docFile(String filePath) {
		this.ds = new TheLoai[0];
		n = 0;
		try (Scanner sc = new Scanner(new File(filePath))) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine().trim();
				if (line.isEmpty())
					continue;

				String[] parts = line.split(",");
				if (parts.length < 2)
					continue;

				String ma = parts[0].trim();
				String ten = parts[1].trim();
				TheLoai tl = new TheLoai(ma, ten);
				themTheLoai(tl);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Khong tim thay file: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Loi doc file: " + e.getMessage());
		}
	}
}
