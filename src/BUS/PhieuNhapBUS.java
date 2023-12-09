package BUS;

import java.util.ArrayList;

import DAO.PhieuNhapDAO;
import DTO.CT_PhanQuyen;
import DTO.NhaCungCap;
import DTO.NhanVien;
import DTO.PhieuNhap;
import DTO.ThanhVien;

public class PhieuNhapBUS
{
    private static ArrayList<PhieuNhap> lstPn;
    private PhieuNhapDAO dao = new PhieuNhapDAO();

    public PhieuNhapBUS()
    {
        lstPn = dao.readData();
    }

    public ArrayList<PhieuNhap> getLst()
    {
        return lstPn;
    }

    public void insertLst(PhieuNhap ct)
    {
        lstPn.add(ct);
        dao.insertData(ct);
    }

    //Kiểm tra mã phiếu nhập có bị trùng không
    public static Boolean checkID(int ma)
    {
        for(PhieuNhap ct: lstPn)
        {
            if(ct.getPhieuNhap()==ma) return false;
        }
        return true;
    }

    //Kiểm tra mã nhân viên có tồn tại chưa
    public static Boolean checkMaNv(String ma)
    {
        NhanVienBUS busNv=new NhanVienBUS();
        for(NhanVien Nv:busNv.getLst())
        {
            if(Nv.getMaNV().equals(ma)) return true;
        }
        return false;
    }

    //Kiểm tra mã nhà cung cấp có tồn tại chưa
    public static Boolean checkMaNcc(int ma)
    {
        NhaCungCapBUS busNcc=new NhaCungCapBUS();
        for(NhaCungCap Ncc:busNcc.getLst())
        {
            if(Ncc.getMaNCC()==ma) return true;
        }
        return false;
    }
    public PhieuNhap getPNByID(int id){
        PhieuNhap pn = new PhieuNhap();
        for (PhieuNhap phieuNhap : lstPn){
            if (id == phieuNhap.getPhieuNhap()){
                pn = phieuNhap;
            }
        }
        return pn;
    }
    public ArrayList<PhieuNhap> timPN(String item, String data){
        ArrayList<PhieuNhap> foundList = new ArrayList<>();
        switch (item){
            case "Mã phiếu":
                for (PhieuNhap pn : lstPn){
                    if (String.valueOf(pn.getPhieuNhap()).equals(data)){
                        lstPn.add(pn);
                        break;
                    }
                }
                break;
            case "Mã nhà cung cấp":
                for (PhieuNhap pn : lstPn){
                    if (String.valueOf(pn.getMaNCC()).equals(data)){
                        lstPn.add(pn);
                        break;
                    }
                }
                break;
            case "Mã nhân viên":
                for (PhieuNhap pn : lstPn){
                    if (pn.getMaNV().contains(data)){
                        lstPn.add(pn);
                    }
                }
                break;
        }

        return foundList;
    }
}