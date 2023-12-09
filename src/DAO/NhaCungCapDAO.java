package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectSQL.ConnectDB;
import DTO.NhaCungCap;

public class NhaCungCapDAO 
{
   public NhaCungCapDAO(){}
    //Lay arraylist NhaCungCap
    public ArrayList<NhaCungCap> readData()
    {
        Connection c = null;
        c = ConnectDB.getConnection();
        ArrayList<NhaCungCap> lst = new ArrayList<>();
        String sql = "select * from nha_cung_cap";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                NhaCungCap ct = new NhaCungCap();
                ct.setMaNCC(rs.getInt("ma_ncc"));
                ct.setTenNCC(rs.getString("ten"));
                ct.setDiaChi(rs.getString("dia_chi"));
                ct.setSdt(rs.getString("dien_thoai"));
                ct.setEmail(rs.getString("email"));
                lst.add(ct);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
        return lst;
    }

    //Them nha cung cap
    public void insertData(NhaCungCap ct)
    {
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "INSERT into nha_cung_cap values (?,?,?,?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaNCC());
            stmt.setString(2, ct.getTenNCC());
            stmt.setString(3, ct.getDiaChi());
            stmt.setString(4, ct.getSdt());
            stmt.setString(5, ct.getEmail());
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
    public void deleteData(NhaCungCap ct)
    {
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "delete from nha_cung_cap where ma_ncc = ?";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaNCC());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }

    public void updateData(NhaCungCap ct)
    {
         Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "update  nha_cung_cap set ten = ?,dia_chi = ?,dien_thoai = ?,email = ? where ma_ncc = ?";
         try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, ct.getTenNCC());
            stmt.setString(2, ct.getDiaChi());
            stmt.setString(3, ct.getSdt());
            stmt.setString(4, ct.getEmail());
            stmt.setInt(5, ct.getMaNCC());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    } 
}
