package BUS;

import java.util.ArrayList;

import DAO.NhaCungCapDAO;
import DTO.CT_PhanQuyen;
import DTO.NhaCungCap;
import DTO.QuyDinh;

public class NhaCungCapBUS
{
    private ArrayList<NhaCungCap> lstNcc;
    private NhaCungCapDAO dao = new NhaCungCapDAO();
    public NhaCungCapBUS()
    {
        lstNcc = dao.readData();
    }

    public ArrayList<NhaCungCap> getLst()
    {
        return lstNcc;
    }

    public void insertData(NhaCungCap ncc)
    {
        lstNcc.add(ncc);
        dao.insertData(ncc);
    }

    public void updateData(NhaCungCap ncc)
    {
        for (int i = 0;i<lstNcc.size();i++)
        {
            if (lstNcc.get(i).getMaNCC()==(ncc.getMaNCC()))
            {
                lstNcc.set(i,ncc);
                dao.updateData(ncc);
                break;
            }
        }
    }

    public  Boolean checkID(int ma)
    {
        for(NhaCungCap ct: lstNcc)
        {
            if(ct.getMaNCC()==ma) return false;
        }
        return true;
    }
    public ArrayList<NhaCungCap> timNCC(String item, String data){
        ArrayList<NhaCungCap> lstFound = new ArrayList<>();

        switch (item){
            case "Mã NCC":
                for (NhaCungCap nhaCungCap : lstNcc){
                    if (String.valueOf(nhaCungCap.getMaNCC()).equals(data)){
                        lstFound.add(nhaCungCap);
                        break;
                    }
                }
                break;
            case "Tên NCC":
                for (NhaCungCap nhaCungCap : lstNcc){
                    if (nhaCungCap.getTenNCC().contains(data))
                        lstFound.add(nhaCungCap);
                }
                break;
            case "SĐT":
                for (NhaCungCap nhaCungCap : lstNcc){
                    if (nhaCungCap.getSdt().contains(data))
                        lstFound.add(nhaCungCap);
                }
                break;
            case "Địa chỉ":
                for (NhaCungCap nhaCungCap : lstNcc){
                    if (nhaCungCap.getDiaChi().contains(data))
                        lstFound.add(nhaCungCap);
                }
                break;
            case "Email":
                for (NhaCungCap nhaCungCap : lstNcc){
                    if (nhaCungCap.getEmail().contains(data))
                        lstFound.add(nhaCungCap);
                }
                break;
        }
        return lstFound;
    }
    public NhaCungCap getNCCByID(int id){
        NhaCungCap ncc = new NhaCungCap();
        for (NhaCungCap nhaCungCap:lstNcc){
            if (id == nhaCungCap.getMaNCC()){
                ncc = nhaCungCap;
            }
        }
        return ncc;
    }
}