package DAO;

import ConnectSQL.ConnectDB;
import DTO.QuyDinh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuyDinhDAO {
    public QuyDinhDAO(){}

    public ArrayList<QuyDinh> readData(){
        Connection c = null;
        c = ConnectDB.getConnection();
        ArrayList<QuyDinh> lst = new ArrayList<>();
        String sql = "select * from quy_dinh";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
            	QuyDinh ct = new QuyDinh();
                ct.setMaQuyDinh(rs.getInt("ma_quy_dinh"));
                ct.setTenQuyDinh(rs.getString("ten_quy_dinh"));
                ct.setTienPhat(rs.getInt("tien_phat"));
                lst.add(ct);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
        return lst;
    }


    public void insertData(QuyDinh ct){
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "INSERT into quy_dinh values (?,?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaQuyDinh());
            stmt.setString(2, ct.getTenQuyDinh());
            stmt.setInt(3, ct.getTienPhat());
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
    public void deleteData(QuyDinh ct){
        Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "delete from quy_dinh where ma_quy_dinh = ?";

        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaQuyDinh());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
    public void updateData(QuyDinh ct)
    {
         Connection c = null;
        c = ConnectDB.getConnection();

        String sql = "update  quy_dinh set ten_quy_dinh = ?,tien_phat = ? where ma_quy_dinh = ?";
         try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, ct.getTenQuyDinh());
            stmt.setInt(2, ct.getTienPhat());
            stmt.setInt(3, ct.getMaQuyDinh());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    } 
}