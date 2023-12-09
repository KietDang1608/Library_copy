package BUS;

import java.util.ArrayList;
import DAO.CT_PhieuNhapDAO;
import DTO.CT_PhanQuyen;
import DTO.CT_PhieuNhap;
import DTO.PhieuNhap;
import DTO.Sach;

public class CT_PhieuNhapBUS
{
    private static ArrayList<CT_PhieuNhap> lstCT;
    private CT_PhieuNhapDAO dao = new CT_PhieuNhapDAO();
    public CT_PhieuNhapBUS()
    {
        lstCT = dao.readData();
    }

    public ArrayList<CT_PhieuNhap> getLst()
    {
        return lstCT;
    }

    public void insertLst(CT_PhieuNhap ct)
    {
        lstCT.add(ct);
        dao.insertData(ct);
    }

    //Kiểm tra mã phiếu nhập có tồn tại chưa
    public static Boolean checkMaPhieu(int ma)
    {
        PhieuNhapBUS busPn=new PhieuNhapBUS();
        for(PhieuNhap Pn: busPn.getLst())
        {
            if(Pn.getPhieuNhap()==ma) return true;
        }
        return false;
    }

    //Kiểm tra mã sách có tồn tại chưa
    public static Boolean checkMaSach(int ma)
    {
        SachBUS busSach=new SachBUS();
        for(Sach sa:busSach.getLst())
        {
            if(sa.getMaSach()==ma) return true;
        }
        return false;
    }
}
