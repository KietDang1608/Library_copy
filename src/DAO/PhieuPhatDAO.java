package DAO;

import ConnectSQL.ConnectDB;
import DTO.PhieuPhat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhieuPhatDAO {
    public PhieuPhatDAO(){}
    public ArrayList<PhieuPhat> readData(){
        Connection c = null;
        c = ConnectDB.getConnection();
        ArrayList<PhieuPhat> lst = new ArrayList<>();
        String sql = "select * from phieu_phat";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                PhieuPhat ct = new PhieuPhat();
                ct.setMaPhieuPhat(rs.getInt("ma_phieu_phat"));
                ct.setMaSach(rs.getInt("ma_sach"));
                ct.setMaThanhVien(rs.getInt("ma_thanh_vien"));
                ct.setMaPhieuMuon(rs.getInt("ma_phieu_muon"));
                ct.setMaQuyDinh(rs.getInt("ma_quy_dinh"));
                ct.setNgayPhat(rs.getString("ngay_phat"));
                ct.setTrangThai(rs.getString("trang_thai"));
                ct.setMoTa(rs.getString("mo_ta"));
                lst.add(ct);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
        return lst;
    }

    public void insertData(PhieuPhat ct){
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "INSERT into phieu_phat values (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaPhieuPhat());
            stmt.setInt(2, ct.getMaSach());
            stmt.setInt(3, ct.getMaThanhVien());
            stmt.setInt(4, ct.getMaPhieuMuon());
            stmt.setInt(5 ,ct.getMaQuyDinh());
            stmt.setString(6, ct.getNgayPhat());
            stmt.setString(7, ct.getTrangThai());
            stmt.setString(8, ct.getMoTa());
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
    public void deleteData(PhieuPhat ct){
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "delete from phieu_phat where ma_phieu_phat = ?";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaPhieuPhat());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }

    public void updateData(PhieuPhat ct)
    {
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "update  phieu_phat set ma_sach = ?,ma_thanh_vien = ?,ma_phieu_muon = ?,ma_quy_dinh = ?,ngay_phat = ?,trang_thai = ?,mo_ta = ? where ma_phieu_phat = ?";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaSach());
            stmt.setInt(2, ct.getMaThanhVien());
            stmt.setInt(3, ct.getMaPhieuMuon());
            stmt.setInt(4, ct.getMaQuyDinh());
            stmt.setString(5, ct.getNgayPhat());
            stmt.setString(6, ct.getTrangThai());
            stmt.setString(7, ct.getMoTa());
            stmt.setInt(8, ct.getMaPhieuPhat());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    }
}