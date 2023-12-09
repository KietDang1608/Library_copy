package DAO;

import ConnectSQL.ConnectDB;
import DTO.Sach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public LoginDAO(){}
    public String getUsername(){
        Connection c =null;
        c= ConnectDB.getConnection();
        String username = "";
        String sql = "Select * from login";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                username = rs.getString("username");
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return username;
    }
    public void deleteData(){
        Connection c = null;
        c = ConnectDB.getConnection();
        String sql = "DELETE from login";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    }
    public void insertData(String username){
        Connection c = null;
        c = ConnectDB.getConnection();
        String sql = "INSERT into login values (?)";
        try{
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        ConnectDB.closeConnection(c);
    }
}
