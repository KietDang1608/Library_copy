package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectSQL.ConnectDB;
import DTO.ThanhVien;

public class ThanhVienDao {
    public ThanhVienDao() {
    }
    //Lay arraylist ThanhVien
    public ArrayList<ThanhVien> readData(){
        Connection c = null;
        c = ConnectDB.getConnection();
        ArrayList<ThanhVien> lst = new ArrayList<>();
        String sql = "select * from thanh_vien";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                ThanhVien ct = new ThanhVien();
                ct.setMaThanhVien(rs.getInt("ma_thanh_vien"));
                ct.setHoLot(rs.getString("ho_lot"));
                ct.setTen(rs.getString("ten"));
                ct.setSdt(rs.getString("sdt"));
                ct.setEmail(rs.getString("email"));
                ct.setDiaChi(rs.getString("dia_chi"));
                ct.setNgayTao(rs.getString("ngay_tao"));
                ct.setHanThe(rs.getString("han_su_dung"));
                lst.add(ct);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
        return lst;
    }
    //Them ThanhVien
    public void insertData(ThanhVien ct){
        Connection c = null;
        c = ConnectDB.getConnection();
        String sql = "INSERT into thanh_vien values (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaThanhVien());
            stmt.setString(2, ct.getHoLot());
            stmt.setString(3, ct.getTen());
            stmt.setString(4, ct.getSdt());
            stmt.setString(5, ct.getEmail());
            stmt.setString(6, ct.getDiaChi());
            stmt.setString(7, ct.getNgayTao());
            stmt.setString(8, ct.getHanThe());
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    }

    //Xoa ThanhVien
    public void deleteData(ThanhVien ct){
        Connection c = null;
        c = ConnectDB.getConnection();
        String sql = "DELETE from thanh_vien where ma_thanh_vien = ?";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaThanhVien());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    }

    //Sua ThanhVien
    public void updateData(ThanhVien ct){
        Connection c = null;
        c = ConnectDB.getConnection();
        String sql = "UPDATE thanh_vien SET ho_lot = ?, ten = ?, sdt = ?, email = ?, dia_chi = ?, ngay_tao = ?,han_su_dung = ? where ma_thanh_vien = ?";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, ct.getHoLot());
            stmt.setString(2, ct.getTen());
            stmt.setString(3, ct.getSdt());
            stmt.setString(4, ct.getEmail());
            stmt.setString(5, ct.getDiaChi());
            stmt.setString(6, ct.getNgayTao());
            stmt.setString(7, ct.getHanThe());
            stmt.setInt(8, ct.getMaThanhVien());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
}
