package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectSQL.ConnectDB;
import DTO.Quyen;

public class QuyenDao {
	public QuyenDao() {	
	}
	
	//Lay arraylist Quyen
	public ArrayList<Quyen> readData(){
        Connection c = null;
        c = ConnectDB.getConnection();
        ArrayList<Quyen> lst = new ArrayList<>();
        String sql = "select * from quyen";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
            	Quyen ct = new Quyen();
                ct.setMaQuyen(rs.getInt("ma_quyen"));
                ct.setTenQuyen(rs.getString("ten_quyen"));
                lst.add(ct);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
        return lst;
    }
	
	//Them Quyen
    public void insertData(Quyen ct){
        Connection c = null;
        c = ConnectDB.getConnection();     
        String sql = "INSERT into quyen values (?,?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaQuyen());
            stmt.setString(2, ct.getTenQuyen());
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    }
    
    //Xoa Quyen
    public void deleteData(Quyen ct){
        Connection c = null;
        c = ConnectDB.getConnection();
        String sql = "DELETE from quyen where ma_quyen = ?";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, ct.getMaQuyen());           
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    }
    
    //Sua quyen
    public void updateData(Quyen ct){
        Connection c = null;
        c = ConnectDB.getConnection();
        String sql = "UPDATE quyen SET ten_quyen = ? where ma_quyen = ?";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, ct.getTenQuyen());
            stmt.setInt(2, ct.getMaQuyen());
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);

    }
}
