package BUS;
import DAO.CT_PhanQuyenDAO;
import DTO.CT_PhanQuyen;

import java.util.ArrayList;

public class phanQuyen_Bus {
    private  ArrayList<CT_PhanQuyen> dsPhanQuyen;

    CT_PhanQuyenDAO dao = new CT_PhanQuyenDAO();

    public phanQuyen_Bus(){
        dsPhanQuyen = dao.readData();
    }
    public void addData(CT_PhanQuyen phanQuyen){
        dsPhanQuyen.add(phanQuyen);
        dao.insertData(phanQuyen);
        return;
    }
    public void updateData(CT_PhanQuyen phanQuyen){
        for (int i = 0;i<dsPhanQuyen.size();i++){
            if (dsPhanQuyen.get(i).getMaQuyen()==phanQuyen.getMaQuyen()){
                dsPhanQuyen.set(i,phanQuyen);
                dao.insertData(phanQuyen);
                break;
            }
        }
        return;
    }
    public void delData(CT_PhanQuyen phanQuyen){
        for (int i = 0;i<dsPhanQuyen.size();i++){
            if (dsPhanQuyen.get(i).getMaQuyen()== phanQuyen.getMaQuyen()){
                dsPhanQuyen.remove(i);
                dao.deleteData(phanQuyen);
                return;
            }
        }
    }
    public void dsTenViTri()
    {

    }
    public  ArrayList<CT_PhanQuyen> getdsPhanQuyen() {
        return dsPhanQuyen;
    }
}
