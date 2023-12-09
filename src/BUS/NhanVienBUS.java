package BUS;

import java.util.ArrayList;

import DAO.NHANVIEN_DAO;
import DTO.CT_PhanQuyen;
import DTO.NhanVien;
import DTO.ViTri;

public class NhanVienBUS
{
    private  ArrayList<NhanVien> lstNv = new ArrayList<>();

    public NhanVienBUS()
    {
        NHANVIEN_DAO dao = new NHANVIEN_DAO();
        lstNv = dao.readData();
    }

    public ArrayList<NhanVien> getLst()
    {
        return lstNv;
    }

    public void insertData(NhanVien nv)
    {
        NHANVIEN_DAO dao = new NHANVIEN_DAO();
        lstNv.add(nv);
        dao.insertData(nv);
    }

    public void updateData(NhanVien nv)
    {
        NHANVIEN_DAO dao = new NHANVIEN_DAO();
        for (int i = 0;i<lstNv.size();i++)
        {
            if (lstNv.get(i).getMaNV().equals(nv.getMaNV()))
            {
                lstNv.set(i,nv);
                dao.updateData(nv);
                break;
            }
        }
    }

    //Kiểm tra mã nhân viên có trùng không
    //Trung tra ve false
    //ko trung tra true
    public Boolean checkID(String ma)
    {
        for(NhanVien nhanVien: lstNv)
        {
            if(nhanVien.getMaNV().equals(ma)) return false;
        }
        return true;
    }
    public String getTenViTri (int maVitri){
        ViTriBUS viTriBUS = new ViTriBUS();
        String s ="";
        for (ViTri viTri: viTriBUS.getdsViTri()){
            if (viTri.getMaViTri() == maVitri){
                s= viTri.getTenViTri();
                return s;
            }
        }
        return s;
    }
    //Tim nhan vien theo ma
    public NhanVien getNVByID(String maNV){
        NhanVien nv = new NhanVien();
        for (NhanVien nhanVien:lstNv){
            if (maNV.equals(nhanVien.getMaNV())){
                nv = nhanVien;
            }
        }
        return nv;
    }
    //Tim kiem nhan vien
    public ArrayList<NhanVien> timNhanVien(String item,String data){
        ArrayList<NhanVien> lstFound = new ArrayList<>();

        switch (item){
            case "Mã nhân viên":
                for (NhanVien nv:lstNv){
                    if (nv.getMaNV().contains(data)){
                        lstFound.add(nv);
                    }
                }
                break;
            case "Mã vị trí":
                for (NhanVien nv:lstNv){
                    if (data.equals(String.valueOf(nv.getMaViTri()))){
                        lstFound.add(nv);
                        break;
                    }
                }
                break;
            case "Tên nhân viên":
                String name;
                for (NhanVien nv:lstNv){
                    name = nv.getHoLot() + " " + nv.getTen();
                    if (name.contains(data)){
                        lstFound.add(nv);
                    }
                }
                break;
        }
        return lstFound;
    }
}