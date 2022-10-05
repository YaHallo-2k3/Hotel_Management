/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_MaTenLoai {

    public static ResultSet selectTenTang() {
        String sqlSelect = "SELECT * FROM Tang ORDER BY MaTang";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet findTenTang(String maTang) {
        String sqlSelect = "SELECT * FROM Tang WHERE MaTang = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maTang);
    }

    public static ResultSet findMaTang(String tenTang) {
        String sqlSelect = "SELECT * FROM Tang WHERE TenTang = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tenTang);
    }

    public static ResultSet selectTenLoaiPhong() {
        String sqlSelect = "SELECT * FROM LoaiPhong ORDER BY MaLoaiPhong";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet findTenLoaiPhong(String maLoaiPhong) {
        String sqlSelect = "SELECT * FROM LoaiPhong WHERE MaLoaiPhong = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maLoaiPhong);
    }

    public static ResultSet findMaLoaiPhong(String tenLoaiPhong) {
        String sqlSelect = "SELECT * FROM LoaiPhong WHERE TenLoaiPhong = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tenLoaiPhong);
    }

    public static ResultSet selectTenTrangThaiPhong() {
        String sqlSelect = "SELECT * FROM TrangThaiPhong ORDER BY MaTrangThaiPhong";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }

    public static ResultSet findTenTrangThaiPhong(String maTrangThaiPhong) {
        String sqlSelect = "SELECT * FROM TrangThaiPhong WHERE MaTrangThaiPhong = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maTrangThaiPhong);
    }

    public static ResultSet findMaTrangThaiPhong(String tenTrangThaiPhong) {
        String sqlSelect = "SELECT * FROM TrangThaiPhong WHERE TenTrangThaiPhong = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tenTrangThaiPhong);
    }

    public static ResultSet findTenPhong(String maPhong) {
        String sqlSelect = "SELECT * FROM Phong WHERE MaPhong = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maPhong);
    }

    public static ResultSet findMaPhong(String tenPhong) {
        String sqlSelect = "SELECT * FROM Phong WHERE TenPhong = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tenPhong);
    }
}
