package DAO;

import ConnectSQL.ConnectDB;
import DTO.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class NHANVIEN_DAO  {
    public NHANVIEN_DAO(){};
    public ArrayList<NhanVien> readData(){
        ArrayList<NhanVien> nhanvien = new ArrayList<NhanVien>();
        Connection c = ConnectDB.getConnection();
        String sql = "select * from nhan_vien";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("ma_nv"));
                nv.setMaViTri(rs.getInt("ma_vi_tri"));
                nv.setPassword(rs.getString("password"));
                nv.setHoLot(rs.getString("ho_lot"));
                nv.setTen(rs.getString("ten"));
                nv.setSdt(rs.getString("sdt"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("dia_chi"));
                nv.setNgaylam(rs.getString("ngay_lam"));
                nv.setNgayNghi(rs.getString("ngay_nghi"));

                nhanvien.add(nv);
            }
            ConnectDB.closeConnection(c);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return nhanvien;


    }
    public void insertData(NhanVien nhanvien){
        Connection c = ConnectDB.getConnection();
        String sql = "insert into nhan_vien () values (?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1,nhanvien.getMaNV());
            stmt.setInt(2,nhanvien.getMaViTri());
            stmt.setString(3,nhanvien.getPassword());
            stmt.setString(4,nhanvien.getHoLot());
            stmt.setString(5,nhanvien.getTen());
            stmt.setString(6,nhanvien.getSdt());
            stmt.setString(7,nhanvien.getEmail());
            stmt.setString(8,nhanvien.getDiaChi());
            stmt.setString(9,nhanvien.getNgaylam());
            stmt.setString(10,nhanvien.getNgayNghi());
            stmt.executeUpdate();
            ConnectDB.closeConnection(c);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
    public void delData(NhanVien nv){
        Connection c = ConnectDB.getConnection();
        String sql = "DELETE from nhan_vien where ma_nv = ?";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1,nv.getMaNV());
            stmt.executeUpdate();
            ConnectDB.closeConnection(c);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
    public void updateData(NhanVien nhanvien){
        Connection c = ConnectDB.getConnection();
        String sql = "update nhan_vien "+
                "set ma_vi_tri = ?, password = ?, ho_lot = ?, ten=?, sdt=?,email=?,dia_chi=?,ngay_lam=?,ngay_nghi=?"+" " +
                "where ma_nv = ?";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1,nhanvien.getMaViTri());
            stmt.setString(2,nhanvien.getPassword());
            stmt.setString(3,nhanvien.getHoLot());
            stmt.setString(4,nhanvien.getTen());
            stmt.setString(5,nhanvien.getSdt());
            stmt.setString(6,nhanvien.getEmail());
            stmt.setString(7,nhanvien.getDiaChi());
            stmt.setString(8,nhanvien.getNgaylam());
            stmt.setString(9,nhanvien.getNgayNghi());
            stmt.setString(10,nhanvien.getMaNV());

            stmt.executeUpdate();
            ConnectDB.closeConnection(c);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }




}