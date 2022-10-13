/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DTO_ChiTietNhapKho;
import HELPER.HELPER_ConnectSQL;
import java.sql.ResultSet;

/**
 *
 * @author CherryCe
 */
public class DAL_ChiTietNhapKho {
    
    public static void add(DTO_ChiTietNhapKho chiTietNhapKho) {
        String sqlInsert = "INSERT INTO chiTietNhapKho VALUES (?, ?, ?, ?, ?)";
        HELPER_ConnectSQL.executeUpdate(sqlInsert, chiTietNhapKho.getMaChiTietNhapKho(), chiTietNhapKho.getMaNhapKho(), chiTietNhapKho.getMaSanPham(), chiTietNhapKho.getSoLuong(), chiTietNhapKho.getGiaNhap());
    }

    public static void delete(String maNhapKho, String maSanPham) {
        String sqlDelete = "DELETE FROM ChiTietNhapKho WHERE MaNhapKho = ? AND MaSanPham = ?";
        HELPER_ConnectSQL.executeUpdate(sqlDelete, maNhapKho, maSanPham);
    }

    public static ResultSet select(String maNhapKho) {
        String sqlSelect = "SELECT * FROM ChiTietNhapKho WHERE MaNhapKho = ? ORDER BY MaChiTietNhapKho";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, maNhapKho);
    }
    
    public static ResultSet count() {
        String sqlSelect = "SELECT COUNT(*) FROM ChiTietNhapkho";
        return HELPER_ConnectSQL.executeQuery(sqlSelect);
    }
    
    public static ResultSet count(String thoiGian) {
        String sqlSelect = "SELECT COUNT(*) FROM ChiTietNhapkho WHERE MaNhapKho LIKE ?";
        return HELPER_ConnectSQL.executeQuery(sqlSelect, "%" + thoiGian + "%");
    }
}
