package DAO;
import ConnectSQL.ConnectDB;
import DTO.ViTri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViTriDAO {
    public ViTriDAO(){}
    //Lay arraylist CT_PhanQuyen
    public ArrayList<ViTri> readData(){
        ArrayList<ViTri> viTri = new ArrayList<ViTri>();
        Connection c = ConnectDB.getConnection();
        String sql = "select * from vi_tri";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ViTri vt = new ViTri();
                vt.setMaViTri(rs.getInt("ma_vi_tri"));
                vt.setTenViTri(rs.getString("ten_vi_tri"));



                viTri.add(vt);
            }
            ConnectDB.closeConnection(c);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return viTri;


    }

    //Them chi tiet phan quyen
    public void insertData(ViTri vt){
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "INSERT into vi_tri values (?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, vt.getMaViTri());
            stmt.setString(2, vt.getTenViTri());
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
    public void deleteData(ViTri vt){
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "delete from ct_phan_quyen where ma_vi_tri = ? and ten_vi_tri = ?";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, vt.getMaViTri());
            stmt.setString(2, vt.getTenViTri());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }

    public boolean update(ViTri vt) {
        Connection c = null;
        c = ConnectDB.getConnection();

        String sqlUpdate = "UPDATE vi_tri"
                + "\nSET \nma_vi_tri= ?,ten_vi_tri = ? "
                + "\nWHERE ma_vi_tri = ?";

        try {
            PreparedStatement pstmt = c.prepareStatement(sqlUpdate);
            pstmt.setInt(1, vt.getMaViTri());
            pstmt.setString(2, vt.getTenViTri());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
