package BUS;

import java.util.ArrayList;

import DAO.CT_PhieuMuonDAO;
import DTO.CT_PhanQuyen;
import DTO.CT_PhieuMuon;
import DTO.PhieuMuon;
import DTO.Sach;

public class CT_PhieuMuonBUS
{
    private static ArrayList<CT_PhieuMuon> lstCT;
    private CT_PhieuMuonDAO dao = new CT_PhieuMuonDAO();
    public CT_PhieuMuonBUS()
    {

        lstCT = dao.readData();
    }

    public ArrayList<CT_PhieuMuon> getLst()
    {
        return lstCT;
    }

    public void insertLst(CT_PhieuMuon ct)
    {
        lstCT.add(ct);
        dao.insertData(ct);
    }

    //kiểm tra mã phiếu có tồn tại chưa
    public static Boolean checkMaPhieu(int ma)
    {
        PhieuMuonBUS busPm=new PhieuMuonBUS();
        for(PhieuMuon Pm:busPm.getLst())
        {
            if(Pm.getMaPhieu()==ma) return true;
        }
        return false;
    }

    //kiểm tra mã sách có tồn tại chưa
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