package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectSQL.ConnectDB;
import DTO.Sach;

public class SachDao {
	public SachDao() {
	}
	//Lay arraylist Sach
	public ArrayList<Sach> readData(){
        Connection c = null;
        c = ConnectDB.getConnection();
        ArrayList<Sach> lst = new ArrayList<>();
        String sql = "select * from sach";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
            	Sach ct = new Sach();
                ct.setMaSach(rs.getInt("ma_sach"));
                ct.setMaLoai(rs.getInt("ma_loai"));
                ct.setTenSach(rs.getString("ten_sach"));
                ct.setImgPath(rs.getString("img"));
                ct.setTacGia(rs.getString("tac_gia"));
                ct.setNhaXuatBan(rs.getString("nha_xuat_ban"));
                ct.setNgayXuatBan(rs.getString("ngay_xuat_ban"));
                ct.setSoLuong(rs.getInt("so_luong"));
                lst.add(ct);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
        return lst;
    }
	
	//Them Sach
    public void insertData(Sach ct){
        Connection c = null;
        c = ConnectDB.getConnection();     
        String sql = "INSERT into sach values (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaSach());
            stmt.setInt(2, ct.getMaLoai());
            stmt.setString(3, ct.getTenSach());
            stmt.setString(4, ct.getImgPath());
            stmt.setString(5, ct.getTacGia());
            stmt.setString(6, ct.getNhaXuatBan());
            stmt.setString(7, ct.getNgayXuatBan());
            stmt.setInt(8, ct.getSoLuong());
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    }
    
    //Xoa Sach
    public void deleteData(Sach ct){
        Connection c = null;
        c = ConnectDB.getConnection();
        String sql = "DELETE from sach where ma_sach = ?";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaSach());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    }
    
    //Sua Sach
    public void updateData(Sach ct){
        Connection c = null;
        c = ConnectDB.getConnection();
        String sql = "UPDATE sach SET ma_loai = ?, ten_sach = ?, img = ?, tac_gia = ?, nha_xuat_ban = ?, ngay_xuat_ban = ?, so_luong = ? where ma_sach = ?";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);	            
            stmt.setInt(1, ct.getMaLoai());
            stmt.setString(2, ct.getTenSach());
            stmt.setString(3, ct.getImgPath());
            stmt.setString(4, ct.getTacGia());
            stmt.setString(5, ct.getNhaXuatBan());
            stmt.setString(6, ct.getNgayXuatBan());
            stmt.setInt(7, ct.getSoLuong());
            stmt.setInt(8, ct.getMaSach());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
}
