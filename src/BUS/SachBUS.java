package BUS;

import java.util.ArrayList;

import DAO.SachDao;
import DTO.CT_PhanQuyen;
import DTO.QuyDinh;
import DTO.Sach;
import DTO.TheLoai;

public class SachBUS
{
    private static ArrayList<Sach> lstSa;
    private SachDao dao = new SachDao();

    public SachBUS()
    {
        lstSa = dao.readData();
    }

    public ArrayList<Sach> getLst()
    {
        return lstSa;
    }

    public void insertLst(Sach ct)
    {
        lstSa.add(ct);
        dao.insertData(ct);
    }
    public void updateData(Sach sach)
    {
        for (int i = 0;i<lstSa.size();i++)
        {
            if (lstSa.get(i).getMaSach()==(sach.getMaSach()))
            {
                lstSa.set(i,sach);
                dao.updateData(sach);
                break;
            }
        }
    }
    //Kiểm tra mã có bị trùng không
    public static Boolean checkID(int ma) {
        for(Sach ct: lstSa)
        {
            if(ct.getMaSach()==ma) return false;
        }
        return true;
    }

    public ArrayList<Sach> timKiem(String item, String find){
        ArrayList<Sach> lstTim = new ArrayList<>();
        switch (item){
            case "Mã sách":
                for (Sach sach:lstSa){
                    if (find.equals(String.valueOf(sach.getMaSach()))){
                        lstTim.add(sach);
                        break;
                    }
                }
                break;
            case "Tên sách":
                for (Sach sach:lstSa){
                    if (sach.getTenSach().contains(find)){
                        lstTim.add(sach);
                    }
                }
                break;
            case "Tác giả":
                for (Sach sach:lstSa){
                    if (sach.getTacGia().contains(find)){
                        lstTim.add(sach);
                    }
                }
                break;
            case "Nhà xuất bản":
                for (Sach sach:lstSa){
                    if (sach.getNhaXuatBan().contains(find)){
                        lstTim.add(sach);
                    }
                }
                break;

        }
        return lstTim;
    }
    public Sach getSachByID(int id){
        Sach book = new Sach();
        for (Sach sach:lstSa){
            if (sach.getMaSach() == id){
                book = sach;
            }
        }
        return book;
    }
    public String getTenTL(int id){
        int maTl = 0;
        String tl = "";
        for (Sach sach : lstSa){
            if (sach.getMaSach() == id)
                maTl = sach.getMaLoai();
        }
        for (TheLoai theLoai:theLoai_bus.getdsTheLoai()){
            if (theLoai.getMaLoai() == maTl){
                tl = theLoai.getTenLoai();
            }
        }
        return tl;
    }
}