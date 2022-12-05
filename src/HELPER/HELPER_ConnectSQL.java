/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HELPER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author CherryCe
 */
public class HELPER_ConnectSQL {

    public static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String Url = "jdbc:sqlserver://localhost:1433;database=Hotel_Management";
    public static String User = "sa";
    public static String Pass = "64647428";
    public static Connection conn;

    static {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static PreparedStatement prepareStatement(String sql, Object... args) throws SQLException {
        conn = DriverManager.getConnection(Url, User, Pass);
        PreparedStatement pst = null;
        if (sql.trim().startsWith("{")) {
            pst = conn.prepareCall(sql);
        } else {
            pst = conn.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pst.setObject(i + 1, args[i]);
        }
        return pst;
    }

    public static void executeUpdate(String sql, Object... args) {
        try {
            PreparedStatement pst = prepareStatement(sql, args);
            try {
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cập Nhật Hoàn Tất !!!");
            } catch (Exception e) {
                if (e.getMessage().contains("PRIMARY KEY") || e.getMessage().contains("UNIQUE KEY")) {
                    JOptionPane.showMessageDialog(null, "Giá Trị Đã Tồn Tại ???");
                } else {
                    e.printStackTrace();
                }
            } finally {
                pst.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void executeUpdateNoMessage(String sql, Object... args) {
        try {
            PreparedStatement pst = prepareStatement(sql, args);
            try {
                pst.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                pst.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement pst = prepareStatement(sql, args);
            return pst.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
