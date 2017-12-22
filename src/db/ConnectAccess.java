package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectAccess {
    public static void main(String[] args) throws Exception {
        ConnectAccess ca = new ConnectAccess();
        ca.ConnectAccessFile();
    }

   
    public Connection ConnectAccessFile() throws Exception {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=university_A5.mdb";
        return DriverManager.getConnection(dbur1, "username", "password");
    }
}

///**
// * 直接连接access文件。
// * @throws Exception
// */
//public void ConnectAccessFile() throws Exception {
//    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//    String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=university_A5.mdb";
//    Connection conn = DriverManager.getConnection(dbur1, "username", "password");
//    Statement stmt = conn.createStatement();
//    ResultSet rs = stmt.executeQuery("SELECT * FROM  enroll");
//    while (rs.next()) {
//        System.out.println(rs.getString(2));
//    }
//    rs.close();
//    stmt.close();
//    conn.close();
//}