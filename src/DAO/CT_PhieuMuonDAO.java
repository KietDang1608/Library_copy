package DAO;
import ConnectSQL.ConnectDB;
import DTO.CT_PhieuMuon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class CT_PhieuMuonDAO 
{
    public CT_PhieuMuonDAO(){}
    //Lay arraylist CT_PhieuMuon
    public ArrayList<CT_PhieuMuon> readData()
    {
        Connection c = null;
        c = ConnectDB.getConnection();
        ArrayList<CT_PhieuMuon> lst = new ArrayList<>();
        String sql = "select * from ct_phieu_muon";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                CT_PhieuMuon ct = new CT_PhieuMuon();
                ct.setMaPhieu(rs.getInt("ma_phieu"));
                ct.setMaSach(rs.getInt("ma_sach"));
                lst.add(ct);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
        return lst;
    }

    //Them chi tiet phieu muon
    public void insertData(CT_PhieuMuon ct)
    {
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "INSERT into ct_phieu_muon values (?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaPhieu());
            stmt.setInt(2, ct.getMaSach());
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
    public void deleteData(CT_PhieuMuon ct)
    {
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "delete from ct_phieu_muon where ma_phieu = ? and ma_sach = ?";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaPhieu());
            stmt.setInt(2, ct.getMaSach());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }

    public void updateData(CT_PhieuMuon ct)
    {
         Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "update  ct_phieu_muon set ma_sach = ? where ma_phieu = ?";
         try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaSach());
            stmt.setInt(2, ct.getMaPhieu());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    }
}
