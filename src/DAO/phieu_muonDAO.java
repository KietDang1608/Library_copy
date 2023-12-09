package DAO;
import ConnectSQL.ConnectDB;
import DTO.PhieuMuon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class phieu_muonDAO {
    public phieu_muonDAO(){};
    public ArrayList<PhieuMuon> readData(){
        ArrayList<PhieuMuon> phieu_muon = new ArrayList<PhieuMuon>();
        Connection c = ConnectDB.getConnection();
        String sql = "select * from phieu_muon";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                PhieuMuon pm = new PhieuMuon();
                pm.setMaPhieu(rs.getInt("ma_phieu"));
                pm.setMaThanhVien(rs.getInt("ma_thanh_vien"));
                pm.setMaNV(rs.getString("ma_nv"));
                pm.setNgayMuon(rs.getString("ngay_muon"));
                pm.setNgayTra(rs.getString("ngay_tra"));
                pm.setNgayHan(rs.getString("ngay_han"));


                phieu_muon.add(pm);
            }
            ConnectDB.closeConnection(c);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return phieu_muon;


    }
    public void insertData(PhieuMuon phieumuon){
        Connection c = ConnectDB.getConnection();
        String sql = "insert into phieu_muon () values (?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1,phieumuon.getMaPhieu());
            stmt.setInt(2,phieumuon.getMaThanhVien());
            stmt.setString(3,phieumuon.getMaNV());
            stmt.setString(4,phieumuon.getNgayMuon());
            stmt.setString(5,phieumuon.getNgayTra());
            stmt.setString(6,phieumuon.getNgayHan());
            stmt.executeUpdate();
            ConnectDB.closeConnection(c);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
    public void delData(PhieuMuon pm){
        Connection c = ConnectDB.getConnection();
        String sql = "DELETE from phieu_muon where ma_phieu = ?";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1,pm.getMaPhieu());
            stmt.executeUpdate();
            ConnectDB.closeConnection(c);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
    public void updateData(PhieuMuon pm){
        Connection c = ConnectDB.getConnection();
        String sql = "update phieu_muon "+
                "set ma_thanh_vien = ?, ma_nv = ?, ngay_muon = ?, ngay_tra=?, ngay_han=?  "+"" +
                "where ma_phieu = ?";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1,pm.getMaThanhVien());
            stmt.setString(2,pm.getMaNV());
            stmt.setString(3,pm.getNgayMuon());
            stmt.setString(4,pm.getNgayTra());
            stmt.setString(5,pm.getNgayHan());
            stmt.setInt(6,pm.getMaPhieu());

            stmt.executeUpdate();
            ConnectDB.closeConnection(c);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}