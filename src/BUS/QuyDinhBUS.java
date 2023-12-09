package BUS;

import java.util.ArrayList;

import DAO.QuyDinhDAO;
import DTO.CT_PhanQuyen;
import DTO.QuyDinh;

public class QuyDinhBUS
{
    private static ArrayList<QuyDinh> lstQd;
    private QuyDinhDAO dao = new QuyDinhDAO();

    public QuyDinhBUS()
    {
        lstQd = dao.readData();
    }

    public ArrayList<QuyDinh> getLst()
    {
        return lstQd;
    }

    public void insertLst(QuyDinh ct)
    {
        lstQd.add(ct);
        dao.insertData(ct);
    }

    public void updateData(QuyDinh qd)
    {
        for (int i = 0;i<lstQd.size();i++)
        {
            if (lstQd.get(i).getMaQuyDinh()==(qd.getMaQuyDinh()))
            {
                lstQd.set(i,qd);
                dao.updateData(qd);
                break;
            }
        }
    }

    //Kiểm tra mã có bị trùng không
    public static Boolean checkID(int ma)
    {
        for(QuyDinh ct: lstQd)
        {
            if(ct.getMaQuyDinh()==ma) return false;
        }
        return true;
    }
    public QuyDinh getQuyDinhByID(int id){
        QuyDinh quyDinh = new QuyDinh();
        for (QuyDinh qd:lstQd){
            if(qd.getMaQuyDinh() == id){
                quyDinh = qd;
            }
        }
        return quyDinh;
    }
}