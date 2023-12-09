package DAO;

import ConnectSQL.ConnectDB;
import DTO.TheLoai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TheLoaiDAO {
    public TheLoaiDAO(){}

    public ArrayList<TheLoai> readData(){
        Connection c = null;
        c = ConnectDB.getConnection();
        ArrayList<TheLoai> lst = new ArrayList<>();
        String sql = "select * from the_loai";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                TheLoai tl = new TheLoai();
                tl.setMaLoai(rs.getInt("ma_loai"));
                tl.setTenLoai(rs.getString("ten_loai"));
                lst.add(tl);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
        return lst;
    }

    //Them chi tiet phan quyen
    public void insertData(TheLoai tl){
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "INSERT into the_loai values (?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, tl.getMaLoai());
            stmt.setString(2, tl.getTenLoai());
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
    public void deleteData(TheLoai tl){
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "delete from the_loai where ma_loai = ? and ten_loai = ?";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, tl.getMaLoai());
            stmt.setString(2, tl.getTenLoai());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
    
    public boolean update(TheLoai tl) {
        Connection c = null;
        c = ConnectDB.getConnection();
        
        String sqlUpdate = "UPDATE the_loai"
                    + "\nSET \nma_loai= ?,ten_loai = ? "
                    + "\nWHERE ma_loai = ?";
        
        try {
            PreparedStatement pstmt = c.prepareStatement(sqlUpdate);
            pstmt.setInt(1, tl.getMaLoai());
            pstmt.setString(2, tl.getTenLoai());
            if (pstmt.executeUpdate() >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}