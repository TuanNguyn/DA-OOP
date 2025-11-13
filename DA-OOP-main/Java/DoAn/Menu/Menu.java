package Java.DoAn.Menu;

import Java.DoAn.DS_Class.DanhSachHoaDon;
import Java.DoAn.DS_Class.DanhSachNCC;
import Java.DoAn.DS_Class.DanhSachNV;
import Java.DoAn.DS_Class.DanhSachSach;
import Java.DoAn.DS_Class.DanhSachCTHD;

public class Menu {
    //Thuôc tính:
    private DanhSachCTHD dscthd;
    private DanhSachHoaDon dshd;
    private DanhSachNCC dsncc;
    private DanhSachNV dsnv;
    private DanhSachSach dssach;

    //Phương thức:
    public void MenuChinh() {
    }

    public void docFile() {
        dscthd.docFile("input/inputChiTietHD.txt");
    }
}
