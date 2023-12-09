package DAO;
import ConnectSQL.ConnectDB;
import DTO.CT_PhanQuyen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CT_PhanQuyenDAO {
    public CT_PhanQuyenDAO(){}
    //Lay arraylist CT_PhanQuyen
    public ArrayList<CT_PhanQuyen> readData(){
        Connection c = null;
        c = ConnectDB.getConnection();
        ArrayList<CT_PhanQuyen> lst = new ArrayList<>();

        String sql = "select * from ct_phan_quyen";

        try {
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CT_PhanQuyen ct = new CT_PhanQuyen();
                ct.setMaViTri(rs.getInt("ma_vi_tri"));
                ct.setMaQuyen(rs.getInt("ma_quyen"));
                lst.add(ct);
                // Tìm xem có CT_PhanQuyen đã tồn tại với mã vị trí này trong danh sách chưa
//                boolean found = false;
//                for (CT_PhanQuyen ct : lst) {
//                    if (ct.getMaViTri() == maViTri) {
//                        ct.addMaQuyen(maQuyen);
//                        found = true;
//                        break;
//                    }
//                }
//
//                // Nếu không tìm thấy, tạo mới CT_PhanQuyen và thêm vào danh sách
//                if (!found) {
//                    CT_PhanQuyen ct = new CT_PhanQuyen();
//
//                    ct.setMaViTri(maViTri);
//                    ct.addMaQuyen(maQuyen);
//                    lst.add(ct);
//                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        ConnectDB.closeConnection(c);
        return lst;
    }


    //Them chi tiet phan quyen
    public void insertData(CT_PhanQuyen ct){
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "INSERT into ct_phan_quyen values (?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaQuyen());
            stmt.setInt(2, ct.getMaViTri());
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
    public void deleteData(CT_PhanQuyen ct){
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "delete from ct_phan_quyen where ma_quyen = ? and ma_vi_tri = ?";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaQuyen());
            stmt.setInt(2, ct.getMaViTri());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }

}
