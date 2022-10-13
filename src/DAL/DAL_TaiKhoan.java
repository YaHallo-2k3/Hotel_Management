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
        String sqlInsert = "INSERT INTO taiKhoan VALUES (?, ?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, taiKhoan.getMaTaiKhoan(), taiKhoan.getMaNhanVien(), taiKhoan.getTenDangNhap(), taiKhoan.getMatKhau(), taiKhoan.getCauHoi(), taiKhoan.getTraLoi());
    }

    public static void delete(String maNhanVien) {
        String sqlDelete = "DELETE FROM TaiKhoan WHERE MaNhanVien = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maNhanVien);
    }

    public static ResultSet select(String tenDangNhap, String matKhau) {
        String sqlSelect = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, tenDangNhap, matKhau);
    }

    public static ResultSet select(String maNhanVien) {
        String sqlSelect = "SELECT * FROM NhanVien LEFT JOIN TaiKhoan ON TaiKhoan.MaNhanVien = NhanVien.MaNhanVien WHERE NhanVien.MaNhanVien = ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maNhanVien);
    }

    public static void edit(DTO_TaiKhoan taiKhoan) {
        String sqlUpdate = "UPDATE TaiKhoan SET MaTaiKhoan = ?, TenDangNhap = ?, MatKhau = ?, CauHoi = ?, TraLoi = ? WHERE MaNhanVien = ?";
        HELPER_ConnectSQL.executeUpdate(sqlUpdate, taiKhoan.getMaTaiKhoan(), taiKhoan.getTenDangNhap(), taiKhoan.getMatKhau(), taiKhoan.getCauHoi(), taiKhoan.getTraLoi(), taiKhoan.getMaNhanVien());
    }
}
