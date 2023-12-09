package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectSQL.ConnectDB;
import DTO.CT_PhieuNhap;

public class CT_PhieuNhapDAO 
{
    public CT_PhieuNhapDAO(){}
    //Lay arraylist CT_PhieuNhap
    public ArrayList<CT_PhieuNhap> readData()
    {
        Connection c = null;
        c = ConnectDB.getConnection();
        ArrayList<CT_PhieuNhap> lst = new ArrayList<>();
        String sql = "select * from ct_phieu_nhap";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                CT_PhieuNhap ct = new CT_PhieuNhap();
                ct.setMaPhieu(rs.getInt("ma_phieu"));
                ct.setMaSach(rs.getInt("ma_sach"));
                ct.setSoLuong(rs.getInt("so_luong"));
                ct.setDonGia(rs.getInt("don_gia"));
                lst.add(ct);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
        return lst;
    }

    //Them chi tiet phieu nhap
    public void insertData(CT_PhieuNhap ct)
    {
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "INSERT into ct_phieu_nhap values (?,?,?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaPhieu());
            stmt.setInt(2, ct.getMaSach());
            stmt.setInt(3, ct.getSoLuong());
            stmt.setInt(4, ct.getDonGia());
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
    public void deleteData(CT_PhieuNhap ct)
    {
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "delete from ct_phieu_nhap where ma_phieu = ? and ma_sach = ? and so_luong = ? and don_gia = ?";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaPhieu());
            stmt.setInt(2, ct.getMaSach());
            stmt.setInt(3, ct.getSoLuong());
            stmt.setInt(4, ct.getDonGia());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }

    public void updateData(CT_PhieuNhap ct,int ma_phieu,int ma_sach,int so_luong,int don_gia)
    {
         Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "update  ct_phieu_nhap set ma_sach = ?,so_luong=?,don_gia=? where ma_phieu = ? and ma_sach = ? and so_luong = ? and don_gia = ?";
         try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaSach());
            stmt.setInt(2, ct.getSoLuong());
            stmt.setInt(3, ct.getDonGia());
            stmt.setInt(4, ma_phieu);
            stmt.setInt(5, ma_sach);
            stmt.setInt(6, so_luong);
            stmt.setInt(7, don_gia);
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    }
}
