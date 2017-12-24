package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectAccess {
//    public static void main(String[] args) throws Exception {
//        ConnectAccess ca = new ConnectAccess();
//        ca.ConnectAccessFile();
//    }
	  public Connection conn;
	  public PreparedStatement stmt;
      public ResultSet rs;

///**
// * 直接连接access文件。
// * @throws Exception
// */
    public void ConnectAccessFile() throws Exception {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=university_A5.mdb";
        conn = DriverManager.getConnection(dbur1, "username", "password");

//        rs.close();
//        stmt.close();
//        conn.close();
    }
}