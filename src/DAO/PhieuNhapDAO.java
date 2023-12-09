package DAO;

import ConnectSQL.ConnectDB;
import DTO.PhieuNhap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhieuNhapDAO {
    public PhieuNhapDAO(){}
    //Lay arraylist PhieuNhap
    public ArrayList<PhieuNhap> readData(){
        Connection c = null;
        c = ConnectDB.getConnection();
        ArrayList<PhieuNhap> lst = new ArrayList<>();
        String sql = "select * from phieu_nhap";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
            	PhieuNhap ct = new PhieuNhap();
                ct.setPhieuNhap(rs.getInt("ma_phieu"));
                ct.setMaNCC(rs.getInt("ma_ncc"));
                ct.setMaNV(rs.getString("ma_nv"));
                ct.setNgayNhap(rs.getString("ngay_nhap"));
                lst.add(ct);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
        return lst;
    }

    //Them Phieu nhap
    public void insertData(PhieuNhap ct){
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "INSERT into phieu_nhap values (?,?,?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getPhieuNhap());
            stmt.setInt(2, ct.getMaNCC());
            stmt.setString(3, ct.getMaNV());
            stmt.setString(4, ct.getNgayNhap());
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
    public void deleteData(PhieuNhap ct){
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "delete from phieu_nhap where ma_phieu = ?";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getPhieuNhap());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
    public void updateData(PhieuNhap ct)
    {
         Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "update  phieu_nhap set ma_ncc = ?,ma_nv = ?,ngay_nhap = ? where ma_phieu = ?";
         try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaNCC());
            stmt.setString(2, ct.getMaNV());
            stmt.setString(3, ct.getNgayNhap());
            stmt.setInt(4, ct.getPhieuNhap());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    } 
}