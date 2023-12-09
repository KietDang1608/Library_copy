package ConnectSQL;

import java.sql.*;

public class ConnectDB {
    public static Connection getConnection() {
        Connection c = null;

        try {
            // ĐĂNG KÝ DRIVER

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //CÁC THÔNG SỐ

            String url ="jdbc:mySQL://localhost:3306/sgu_qltv";
            String userName ="root";
            String password ="";

            c=DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return c;
    }
    public static void closeConnection(Connection c) {
        try {
            if(c!=null) {
                c.close();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}