/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DTO_TaiKhoan;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_TaiKhoan {

    public static void add(DTO_TaiKhoan taiKhoan) {
        String sqlInsert = "INSERT INTO taiKhoan VALUES (?, ?, ?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, taiKhoan.getMaTaiKhoan(), taiKhoan.getMaNhanVien(), taiKhoan.getTenDangNhap(), taiKhoan.getMatKhau(), taiKhoan.getCauHoi(), taiKhoan.getTraLoi(), taiKhoan.getCheckDangNhap());
    }

    public static void delete(String maNhanVien) {
        String sqlDelete = "DELETE FROM TaiKhoan WHERE MaNhanVien = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maNhanVien);
    }

    public static void edit(DTO_TaiKhoan taiKhoan) {
        String sqlUpdate = "UPDATE TaiKhoan SET MaTaiKhoan = ?, TenDangNhap = ?, MatKhau = ?, CauHoi = ?, TraLoi = ?, CheckDangNhap = ? WHERE MaNhanVien = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, taiKhoan.getMaTaiKhoan(), taiKhoan.getTenDangNhap(), taiKhoan.getMatKhau(), taiKhoan.getCauHoi(), taiKhoan.getTraLoi(), taiKhoan.getCheckDangNhap(), taiKhoan.getMaNhanVien());
    }

    public static void editMatKhau(String matKhau, String tenDangNhap, String cauHoi, String traLoi) {
        String sqlUpdate = "UPDATE TaiKhoan SET MatKhau = ? WHERE TenDangNhap = ? AND CauHoi = ? AND TraLoi = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, matKhau, tenDangNhap, cauHoi, traLoi);
    }

    public static void editCheckDangNhap() {
        String sqlUpdate = "UPDATE TaiKhoan SET CheckDangNhap = 0";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate);
    }

    public static void editCheckDangNhap(String tenDangNhap) {
        String sqlUpdate = "UPDATE TaiKhoan SET CheckDangNhap = 1 WHERE TenDangNhap = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, tenDangNhap);
    }

    public static ResultSet selectTaiKhoan(String tenDangNhap, String matKhau) {
        String sqlSelect = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tenDangNhap, matKhau);
    }
    
    public static ResultSet selectTenDangNhap(String tenDangNhap) {
        String sqlSelect = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tenDangNhap);
    }

    public static ResultSet selectMaNhanVien(String maNhanVien) {
        String sqlSelect = "SELECT * FROM NhanVien LEFT JOIN TaiKhoan ON TaiKhoan.MaNhanVien = NhanVien.MaNhanVien WHERE NhanVien.MaNhanVien = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maNhanVien);
    }

    public static ResultSet select() {
        String sqlSelect = "SELECT * FROM TaiKhoan ORDER BY MaTaiKhoan";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
    
    public static ResultSet checkDangNhap() {
        String sqlSelect = "SELECT * FROM TaiKhoan WHERE CheckDangNhap = 1";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
    
    public static ResultSet auThenTiCaTion(String auThen) {
        String sqlSelect = "SELECT * FROM TaiKhoan JOIN NhanVien ON NhanVien.MaNhanVien = TaiKhoan.MaNhanVien WHERE TenDangNhap = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, auThen);
    }

    public static ResultSet count() {
        String sqlSelect = "SELECT COUNT(*) FROM TaiKhoan";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
}
