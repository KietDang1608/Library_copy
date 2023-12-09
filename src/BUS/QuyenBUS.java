package BUS;

import java.util.ArrayList;

import DAO.QuyenDao;
import DTO.CT_PhanQuyen;
import DTO.Quyen;

public class QuyenBUS
{
    private static ArrayList<Quyen> lstQu;
    private QuyenDao dao = new QuyenDao();

    public QuyenBUS()
    {
        lstQu = dao.readData();
    }

    public ArrayList<Quyen> getLst()
    {
        return lstQu;
    }

    public void setLst(Quyen q)
    {
        for (int i = 0;i<lstQu.size();i++)
        {
            if (lstQu.get(i).getMaQuyen()==(q.getMaQuyen()))
            {
                lstQu.set(i,q);
                dao.updateData(q);
                break;
            }
        }
    }

    //Kiểm tra mã quyền có bị trùng không
    public static Boolean checkID(int ma)
    {
        for(Quyen ct: lstQu)
        {
            if(ct.getMaQuyen()==ma) return false;
        }
        return true;
    }
}