package BUS;

import DAO.CT_PhanQuyenDAO;
import DTO.CT_PhanQuyen;

import java.util.ArrayList;

public class CT_PhanQuyenBUS {
    private  ArrayList<CT_PhanQuyen> lstCT;
    public CT_PhanQuyenBUS(){
        CT_PhanQuyenDAO dao = new CT_PhanQuyenDAO();
        lstCT = dao.readData();
    }

    public ArrayList<Integer> getLstQuyen(int maViTri){
        ArrayList<Integer> lstQuyenTheoViTri = new ArrayList<>();
        for (CT_PhanQuyen phanQuyen : lstCT){
            if (maViTri == phanQuyen.getMaViTri()){
                lstQuyenTheoViTri.add(phanQuyen.getMaQuyen());
            }
        }
        if (lstQuyenTheoViTri.size() == 0)
            return null;
        else return lstQuyenTheoViTri;
    }
    public  ArrayList<CT_PhanQuyen> getLstCT() {
        return lstCT;
    }

//    public static void setLstCT(ArrayList<CT_PhanQuyen> lstCT) {
//        CT_PhanQuyenBUS.lstCT = lstCT;
//    }
    public void xoaPhanQuyenViTri(int viTri){
        CT_PhanQuyenDAO dao = new CT_PhanQuyenDAO();
        for (CT_PhanQuyen ct_phanQuyen:lstCT){
            if (ct_phanQuyen.getMaViTri() == viTri){
                dao.deleteData(ct_phanQuyen);
            }
        }
    }
    public void resetPhanQuyen(int viTri,ArrayList<Integer> quyens){
        CT_PhanQuyenDAO dao = new CT_PhanQuyenDAO();
        for (int i=0;i< quyens.size();i++){
            CT_PhanQuyen ct = new CT_PhanQuyen();
            ct.setMaQuyen(quyens.get(i));
            ct.setMaViTri(viTri);

            dao.insertData(ct);
        }
    }
}
