package BUS;

import DAO.TheLoaiDAO;
import DTO.TheLoai;

import java.sql.SQLException;
import java.util.ArrayList;

public class theLoai_bus {
    private static ArrayList<TheLoai> dsTheLoai;

    TheLoaiDAO dao = new TheLoaiDAO();

    public theLoai_bus(){
        dsTheLoai = dao.readData();
    }
    public void addData(TheLoai theLoai){
        dsTheLoai.add(theLoai);
        dao.insertData(theLoai);
        return;
    }
    public void updateData(TheLoai theLoai){
        for (int i = 0;i<dsTheLoai.size();i++){
            if (dsTheLoai.get(i).getMaLoai()==theLoai.getMaLoai()){
                dsTheLoai.set(i,theLoai);
                dao.insertData(theLoai);
                break;
            }
        }
        return;
    }
    public void delData(TheLoai theLoai){
        for (int i = 0;i<dsTheLoai.size();i++){
            if (dsTheLoai.get(i).getMaLoai()== theLoai.getMaLoai()){
                dsTheLoai.remove(i);
                dao.deleteData(theLoai);
                return;
            }
        }
    }
    public static ArrayList<TheLoai> getdsTheLoai() {
        return dsTheLoai;
    }
}
