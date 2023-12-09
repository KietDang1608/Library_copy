package BUS;

import DTO.CT_PhanQuyen;
import DTO.NhanVien;

import java.util.ArrayList;

public class TrangChuBUS {
    public TrangChuBUS(){}

    public ArrayList<String> getLstPermisson(String username){
        int viTri=0;
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        for (NhanVien nhanVien:nhanVienBUS.getLst()){
            if (nhanVien.getMaNV().equals(username)) {
                viTri = nhanVien.getMaViTri();
                break;
            }
        }
        //Lay danh sach cac quyen cua nguoi dang nhap

        ArrayList<String> quyens = new ArrayList<>();
        CT_PhanQuyenBUS ct_phanQuyenBUS = new CT_PhanQuyenBUS();
        System.out.println(ct_phanQuyenBUS.getLstCT().toString());
        for (CT_PhanQuyen ct_phanQuyen: ct_phanQuyenBUS.getLstCT()){
            if (viTri == ct_phanQuyen.getMaViTri()){
                quyens.add(String.valueOf(ct_phanQuyen.getMaQuyen()));
            }
        }
        System.out.println(quyens.toString());
        return quyens;
    }
}
