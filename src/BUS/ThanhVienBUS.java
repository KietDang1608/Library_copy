package BUS;

import java.util.ArrayList;

import DAO.ThanhVienDao;
import DTO.CT_PhanQuyen;
import DTO.ThanhVien;

public class ThanhVienBUS
{
    private static ArrayList<ThanhVien> lstTv;
    private ThanhVienDao dao = new ThanhVienDao();

    public ThanhVienBUS()
    {
        lstTv = dao.readData();
    }

    public ArrayList<ThanhVien> getLst()
    {
        return lstTv;
    }

    public void insertLst(ThanhVien ct)
    {
        lstTv.add(ct);
        dao.insertData(ct);
    }

    public void updateData(ThanhVien tv)
    {
        for (int i = 0;i<lstTv.size();i++)
        {
            if (lstTv.get(i).getMaThanhVien()==(tv.getMaThanhVien()))
            {
                lstTv.set(i,tv);
                dao.updateData(tv);
                break;
            }
        }
    }

    //Kiểm tra mã có bị trùng không
    public static Boolean checkID(int ma)
    {
        for(ThanhVien ct: lstTv)
        {
            if(ct.getMaThanhVien()==ma) return false;
        }
        return true;
    }
    public ThanhVien getTVByID(int id){
        ThanhVien thanhVien = new ThanhVien();
        for (ThanhVien thanhVien1 : lstTv){
            if (thanhVien1.getMaThanhVien()==id){
                thanhVien = thanhVien1;
            }
        }
        return thanhVien;
    }

    public ArrayList<ThanhVien> timThanhVien(String item, String data) {

        ArrayList<ThanhVien> foundList = new ArrayList<>();
        switch (item){
            case "Mã thành viên":
                for (ThanhVien thanhVien : lstTv){
                    if (String.valueOf(thanhVien.getMaThanhVien()).equals(data)){
                        foundList.add(thanhVien);
                        break;
                    }
                }
                break;
            case "Tên thành viên":
                String name;
                for (ThanhVien thanhVien : lstTv){
                    name = thanhVien.getHoLot() + " " + thanhVien.getTen();
                    if (name.contains(data)){
                        foundList.add(thanhVien);
                    }
                }
                break;
            case "Số điện thoại":
                for (ThanhVien thanhVien : lstTv){
                    if (thanhVien.getSdt().contains(data)){
                        foundList.add(thanhVien);
                    }
                }
                break;
            case "Email":
                for (ThanhVien thanhVien : lstTv){
                    if (thanhVien.getEmail().contains(data)){
                        foundList.add(thanhVien);
                    }
                }
                break;
            case "Địa chỉ":
                for (ThanhVien thanhVien : lstTv){
                    if (thanhVien.getDiaChi().contains(data)){
                        foundList.add(thanhVien);
                    }
                }
                break;

        }
        return foundList;

    }
}